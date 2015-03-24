var connector = connector || {};
 
var editor = (function(ace, con, cookies) {
	var _editor,
		editors,
		projectId,
		currentId = 0,

		RUN_KEY = 'F9',
	   
		completionCallback = null,
		saveDelay = 500,
		saveTimer = null;
   
	function initialize(editorId, mode) {
		// Configure the basics
		ace.require("ace/ext/language_tools"); // Required for auto completion
		_editor = ace.edit(editorId);
		_editor.setTheme("ace/theme/monokai");
		_editor.getSession().setMode("ace/mode/" + mode);
	   
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
			ev.delay = true;
			changed(ev);
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
				saveTimer = setTimeout(function() {changed(ev);}, saveDelay);
			} else {
				saveTimer = null;
				sendAllContent();
			}
		}
	};
   
	function sendAllContent() {
		var content = _editor.getSession().getValue();
		var message = 'update\n' + content;
		con.send(message);
	};
   
   
	function run(ev) {
		var message = 'run';
		con.send(message);
	};
   
   
	/**
	*	Creates the completer that will return proposals
	*/
	function createCompleter(){
		return {
			getCompletions: function(currEditor, session, pos, prefix, callback) {
				var offset = calculateOffset(session.getValue(), pos);
				var message = 'codeCompletion\n' + offset;
				con.send(message);
									   
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
				case 'refresh':
					var session = _editor.getSession();
					session.setMode(editors[currentId].lang);
					session.setValue(data[0]);
				default:
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
		var editorName = editors[currentId].resourceRef,
			message = 'refresh\n' + editorName;
			
		con.send(message);
	};
   
	return {
		init : function(el, baseUrl, id, editorArray) {
			// Configure current editor
			editors = editorArray;
			projectId = id;
			
			// Check if user had a previous editor in this project
			var storedId = cookies.getCookie(projectId);
			if (storedId !== '') {
				currentId = storedId;
			}
			
			initialize(el, editors[currentId]);
		   
			// Set up connector
			con.init({url : baseUrl});
			con.subscribe(this);
		   
			// Refresh editor content
			refreshEditor();
			return this;
		},
	   
		notify : function(event) {
			handleResponse(event);
		},
	   
		switchEditor : function(id) {
			// Store info and refresh editor
			currentId = id;
			cookies.setCookie(projectId, id, 180);
			refreshEditor();
		}
		   
	};
})(ace, connector, cookieManager);