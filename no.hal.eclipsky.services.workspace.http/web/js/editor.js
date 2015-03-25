var connector = connector || {};

var test;
var editor = (function(ace, con, cookies) {
	var _editor,
		editors,
		projectId,
		editorName,
		currentId = 0,

		RUN_KEY = 'F9',
	   
		completionCallback = null,
		saveDelay = 500,
		saveTimer = null,
		
		logging = false,
		c = (logging ? console : {log : function(){}});
   
	function initialize(editorId, editorPrefs) {
		// Configure the basics
		ace.require("ace/ext/language_tools"); // Required for auto completion
		_editor = ace.edit(editorId);
		_editor.setTheme("ace/theme/monokai");
		_editor.getSession().setMode("ace/mode/" + editorPrefs.language);
	   
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
			if (ev.data.action === "insertText" && ev.data.text.length < 3) {
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
					session.setMode(editors[currentId].language);
					session.setValue(data.code);
					break;
				case 'ready':
					refreshEditor();
					break;
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
   
	return {
		init : function(el, baseUrl, id, editorArray) {
			// Configure current editor
			editors = editorArray;
			projectId = id;
			
			// Check if user had a previous editor in this project
			var storedId = cookies.getCookie(projectId);
			if (storedId) {
				currentId = storedId;
			}
			
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
	   
		switchEditor : function(id) {
			// Store info and refresh editor
			currentId = id;
			editorName = editors[currentId].resourceRef;
			cookies.setCookie(projectId, id, 180);
			refreshEditor();
		},
		
		getEditors : function() {
			var namedEditors = [];
			for (var i = 0; i < editors.length; i++) {
				var fileName = editors[i].projectRef.split('/')[1];
				namedEditors[i] = {id: i, name: fileName};
			}
			
			return namedEditors;
		},
		
		refresh : function() {
			refreshEditor();
		}
		   
	};
})(ace, connector, cookieManager);