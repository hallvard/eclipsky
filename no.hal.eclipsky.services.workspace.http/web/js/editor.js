var connector = connector || {};

var test;
var editor = (function(ace, con, cookies) {
	var _editor,
		editors,
		projectId,
		editorName,
		currentId = 0,

		RUN_KEY = 'R',
	   
		completionCallback = null,
		saveDelay = 500,
		saveTimer = null,
		
		logging = true,
		c = (logging ? console : {log : function(){}});
   
	function initialize(editorId, editorPrefs) {
		// Configure the basics
		ace.require("ace/ext/language_tools"); // Required for auto completion
		_editor = ace.edit(editorId);
		_editor.setTheme("ace/theme/monokai");
	   
		// Enable auto completion
		_editor.completers = [createCompleter()];
		_editor.setOptions({
		  enableBasicAutocompletion: true,
		});
	   
		// Add run command
		_editor.commands.addCommand({
			name: 'run',
			readOnly: false,
			bindKey: { win: 'Ctrl-'+RUN_KEY, mac: 'Command-'+RUN_KEY },
			exec: run
		});
	   
		// Custom event for when contents change
		_editor.getSession().on('change', function(ev) {
			if (ev.data.action === "insertText" && ev.data.text.length < 3 || ev.data.action === 'removeText') {
				ev.delay = true;
				changed(ev);
			}
		});
		
		return _editor;
	};
       
	// Handles the changes in the editor
	function changed(ev) {
		/*
		 * Update on a '.', in order for auto completion
		 * to (maybe) be able to respond with the correct
		 * suggestion derived from a correct, local document
		 */
		if (ev.type === 'textEvent' && ev.text === '.') {
			clearTimeout(saveTimer);
			sendAllContent();
			return;
			   
		/*
		 * Sets a delay of 'saveDelay' after last typing
		 * before sending all content to the connector
		 */
		} else {
			if (ev.delay) {
				if (saveTimer != null) {
					clearTimeout(saveTimer);
				}
				ev.delay = false;
				con.invalidate();
				saveTimer = setTimeout(function() {changed(ev);}, saveDelay);
			} else {
				saveTimer = null;
				sendAllContent();
			}
		}
	};

	function sendAllContent() {
		var content = _editor.getSession().getValue();
		con.send('update ' + editorName, content);
	};
   
   
	function run(ev) {		
		con.send('run ' + editorName);
	};

	function test(ev) {		
		con.send('test ' + editorName);
	};
   
   
	/**
	*	Creates the completer that will return proposals
	*/
	function createCompleter(){
		return {
			getCompletions: function(currEditor, session, pos, prefix, callback) {
				var offset = calculateOffset(session.getValue(), pos);
				con.send('completion ' + editorName, offset);
									   
				completionCallback = callback;
			}
		};
	};
   
	/**
	*	Handling responses from requests to the server
	*/
	function handleResponse(event) {
		var data = JSON.parse(event.data);
		if (data instanceof Array) {
			if (data.length === 0) {
				_editor.getSession().clearAnnotations();
				return;
			}
			var type = data[0].type;
			switch(type) {
				case 'problem':
					updateMarkers(data);
					break;
				case 'completion':
					completionCallback(null, data);
					break;
			}
		} else {			
			var type = data.type;
			switch(type) {
				case 'run':
					_editor.getSession().clearAnnotations();
					if (data.error === "") {
						alert(data.console);
					} else {
						alert(data.error);
					}
					break;
				case 'refresh':
					var session = _editor.getSession();
					session.setValue(data.code);
					session.setMode("ace/mode/" + editors[currentId].language);
					_editor.moveCursorToPosition(editors[currentId].pos);
					_editor.focus();
					break;
				case 'close':
					con.send('run');
			}
		}
	};
   
	function calculateOffset(code, position){
		var lines = code.split("\n");
		var offset = 0;
		for(var i = 0; i < position.row; i++){
			offset += lines[i].length + 1;
		}
		offset += position.column;
		return offset;
	};
   
	function updateMarkers(problems) {
		if (typeof problems == "string") {
			problems = JSON.parse(problems);
		}
		
		var annotations = problems.map(function(problem) {
		return new Annotation(convertProblemSeverity(problem.severity),
								problem.message, 
								problem.lineNumber - 1);
		});
		_editor.getSession().setAnnotations(annotations);
	};

	function Annotation(type, message, lineNumber) {
		this.type = type; // "error", "warning", "info"
		this.text = message;
		this.row = lineNumber;
	};

	function convertProblemSeverity(type) {
		switch (type) {
			case 'Warning': return 'warning';
			case 'Info':    return 'info';
			default:        return 'error';
		}
	};
   
	function refreshEditor() {
		con.send('refresh ' + editorName);
	};

	function getNamedEditors() {
		var namedEditors = [];
		for (var i = 0; i < editors.length; i++) {
			var fileName = editors[i].resourceRef.split('/')[1];
			namedEditors[i] = {id: i, name: fileName};
		}
		
		return namedEditors;
	}
   
	return {
		init : function(el, baseUrl, id, editorArray, startIndex) {
			// Configure current editor
			editors = editorArray;
			projectId = id;
			
			// Check if user had a previous editor in this project
			currentId = startIndex;

			initialize(el, editors[currentId]);
			editorName = editors[currentId].resourceRef;
		   
			// Set up connector
			var connectionConfig = {
				url : baseUrl + "?projectName=" + projectId
			};
			con.init(connectionConfig);
			con.subscribe(this);
		   
			// Refresh editor content 
			return this;
		},
	   
		notify : function(event) {
			handleResponse(event);
		},
	   
	   	// Store info by closing current editor, and refresh with new content
		switchEditor : function(id) {
			// Store current position
			editors[currentId].pos = _editor.getCursorPosition();

			// Close current editor before finding the new editor name
			con.send('close ' + editorName);
			if (isNaN(id)) {
				var namedEditors = getNamedEditors();
				for (var i = namedEditors.length - 1; i >= 0; i--) {
					if (id === namedEditors[i].name) {
						currentId = i;
					}
				}
			} else {
				currentId = id;
			}
			editorName = editors[currentId].resourceRef;
			cookies.setCookie(projectId, id, 180);
			refreshEditor();
		},
		
		getEditors : function() {
			return getNamedEditors();
		},

		getCurrentIndex : function() {
			return currentId;
		},
		
		refresh : function() {
			refreshEditor();
		},

		run : function() {
			con.send('run');
		},

		getAce : function() {
			return _editor;
		}
		   
	};
})(ace, connector, cookieManager);