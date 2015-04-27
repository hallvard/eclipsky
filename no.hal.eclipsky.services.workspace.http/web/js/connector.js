var connector = (function() {
	var webSocket = null,
		
		// Set logging
		logging = false,
		c = (logging ? console : {log : function(){}});
		
		// All subscribers need to implement a 'notify()'-function
		subscribers = [], 

		url = null,
		postfix = "&format=json",
		
		queue = [];
	
	// Publish to all listeners
	function publish(data) {
		c.log('publishing: ', data);
		for (var i = subscribers.length - 1; i >= 0; i--) {
			subscribers[i].notify(data);
		}
	};
	
	// Add to the queue of requests to send
	function push(data) {
		if (queue.length === 0) {
			queue.push(data);
			pop();
		} else {
			queue.push(data);
		}
		
	};
	
	// Pop from the queue and perform a send request
	function pop() {
		var data;
		if (queue.length > 0) {
			data = queue.shift();
		} else {
			return;
		}
		
		c.log('Sending data: ', data);
		if (webSocket.readyState === webSocket.OPEN) {
			sendWSdata(data);
		} else {
			sendXHRdata(data);
		}
	};
	
	function sendWSdata(data) {
		var wsData = data.op + (data.body !== undefined ? 
								"\n" + data.body : '');
		webSocket.send(wsData);
	};
	
	// Private function for sending XHR requests
	function sendXHRdata(data) {
		var xmlHttp = getXmlHTTP();
		xmlHttp.open("POST", url + postfix, true);
		var startTime = new Date();
		xmlHttp.onreadystatechange = function () {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				pop();
				publish(xmlHttp.responseText);
			}
		}
		xmlHttp.send(data);
	};
	
	// Compatibility
	function getXmlHTTP() {
        if (window.XMLHttpRequest) {
            return new XMLHttpRequest();
        } else {
            return new ActiveXObject('Microsoft.XMLHTTP');
        }
    };
	
	function initializeWebsocket(url) {
		var link = document.createElement('a');
		
		link.href = url;
		link.protocol = "ws";
	    webSocket = new WebSocket(link.href, "json");

	    webSocket.onerror = function(event) {
			// TODO: Reconnect?
	    	c.log('ws error', event);
	    	// publish(event);
	    };

	    webSocket.onclose = function(event) {
	    	// TODO: Notify?
	        c.log('ws close', event);
	        // publish(event);
	    };

	    webSocket.onmessage = function(event) {
			pop();
	    	publish(event);
	    }
	};
	
	
	return {
		init : function(config) {
			url = config.url;
			initializeWebsocket(url);
		},

		send : function(operation, content) {
			push({op: operation, body: content});
		},
		
		subscribe : function(subscriber) {
			subscribers.push(subscriber);
		},
		
		unsubscribe : function(subscriber) {
			for (var i = subscribers.length - 1; i >= 0; i--) {
				if (subscribers[i] === subscriber) {
					subscribers.splice(i, 1);
					return;
				}
			}
		},
		
		// Emptying the queue
		invalidate : function() {
			queue = [];
		}
	};
	
})();