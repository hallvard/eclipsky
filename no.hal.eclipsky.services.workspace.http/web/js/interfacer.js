var connector = connector || {},
	editor = editor || {};

var testInt;
var interfacer = (function(con) {
	var ed,
		isFetching = false,
		isRunning = false,
		startId = 0,

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

	function handleMessage(data) {
		if (!(data instanceof Array)) {			
			var type = data.type;
			switch(type) {
				case 'run':
					isRunning = false;
					if (data.error === "") {
						$($console).removeClass('error');
						$console.innerHTML = data.console;
					} else {
						$($console).addClass('error');
						$console.innerHTML = data.error;
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
					startId = getHashId() || startId;
					window.location.hash = "#" + startId;
					switchResource(startId, true);
					break;
			}
		}
	};

	function switchResource(id, isFirst) {
		var correctedId = id;
		if (isFetching)
			return;

		$editor.css({'opacity': '1.0'});
		isFetching = true;

		if (isNaN(id)) {
			var tabName;
			for (var i = $tabs.length - 1; i >= 0; i--) {
				tabName = $tabs[i].innerHTML;
				if (tabName != id) {
					$($tabs[i]).parent().removeClass('active');
				} else {
					correctedId = i;
					$($tabs[i]).parent().addClass('active');
				}
			}
		} else {
			correctedId = parseInt(id);
			for (var i = $tabs.length - 1; i >= 0; i--) {
				if (i != correctedId) {
					$($tabs[i]).parent().removeClass('active');
				} else {
					$($tabs[i]).parent().addClass('active');
				}
			}
		}

		if (isFirst) {
			ed.setFirstResource(correctedId);
		} else {
			ed.switchResource(correctedId);
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
				switchResource(hashId);
			});

			initialize();

			// Force first connection if no websocket.
			if (!connector.usesWebSocket()) {
				handleMessage({type: 'ready'});
			}
		},

		notify : function(message) {
			handleMessage(message);
		},

		getHash : function() {
			return getHashId();
		}
	};

})(connector);

