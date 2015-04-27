var connector = connector || {},
	editor = editor || {};

var testInt;
var interfacer = (function(con) {
	var ed,
		isFetching = false,
		isRunning = false,

		logging = true,
		c = (logging ? console : {log : function(){}}),

		$navbar,
		$editor,
		$console,
		$btnRun,
		$test,
		$tabs;

	function initialize() {
		$navbar = $('#tabs');
		$test = $('#tests');
		$editor = $('#main_editor');
		$console = $('#console').children()[0];
		$btnRun = $('#btn_run');

		// Handle navbar
		$tabs = $navbar.find('a');
		$tabs.on('click', function(event) {
			if (isFetching)
				event.preventDefault();
		});

		// Handle 'run'-button
		$btnRun.on('click', function() {
			c.log('run clicked', isRunning);
			if (isRunning) {
				event.preventDefault();
			} else {
				ed.run();
				isRunning = true;
			}
		});

		// Handle resizing
		$('#dragbar').mousedown(function(e){       
			e.preventDefault();
			$(document).mousemove(function(e){
				$('#editor_wrapper').css("width",e.pageX+2);
				$('#tests').css("left",e.pageX+2);
			})
	    });
	    $(document).mouseup(function(e){
	       $(document).unbind('mousemove');
	    });

	};

	function handleMessage(message) {
		var data = JSON.parse(message.data);
		if (!(data instanceof Array)) {			
			var type = data.type;
			switch(type) {
				case 'run':
					isRunning = false;
					if (data.error === "") {
						$console.val(data.console);
					} else {
						$console.val(data.error);
					}
					break;
				case 'refresh':
					isFetching = false;
					$editor.css({'opacity': '1'});
					break;
				case 'test':
					// TODO
					break;
				case 'ready':
					var currentId = ed.getCurrentIndex();
					window.location.hash = "#" + currentId;
					switchEditor(currentId); 
					break;
			}
		}
	};

	function switchEditor(id) {
		if (isFetching)
			return;

		$editor.css({'opacity': '0.8'});
		isFetching = true;
		ed.switchEditor(id);
		for (var i = $tabs.length - 1; i >= 0; i--) {
			if (i != id) {
				$($tabs[i]).parent().removeClass('active');
			} else {
				$($tabs[i]).parent().addClass('active');
			}
		}
	}

	function getHashId() {
		return window.location.hash.substr(1);
	};

	return {
		init : function(editor) {
			ed = editor;
			connector.subscribe(this);

			$(window).on('hashchange', function() {
				var hashId = getHashId();
				c.log('hash changed to ' + hashId);
				switchEditor(hashId);
			});

			initialize();
		},

		notify : function(message) {
			handleMessage(message);
		}
	};

})(connector);

