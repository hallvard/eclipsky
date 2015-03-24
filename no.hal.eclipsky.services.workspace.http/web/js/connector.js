var connector = (function() {
	var webSocket = null,
		
		// Set logging
		logging = true,
		c = (logging ? console : {log : function(){}});
		
		// All subscribers need to implement a 'notify()'-function
		subscribers = [], 

		XHRpostfix = "&format=json",
		
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
		// Empty array, pop right away
		queue.push(data);
		if (queue.length === 0) {
			pop();
		} 	
	};
	
	// Pop from the queue and perform a send request
	function pop() {
		var data;
		if (queue.length > 0) {
			data = queue.pop();
		} else {
			return;
		}
		
		if (webSocket.readyState === webSocket.OPEN) {
			webSocket.send(data);
		} else {
			sendXHRdata(data);
		}
	};
	
	// Private function for sending XHR requests
	function sendXHRdata(data) {
		var xmlHttp = getXmlHTTP();
		xmlHttp.open("POST", url + XHRPostfix, true);
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
		c.log('Connecting with link: ');
		c.log(link);
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

		send : function(data) {
			push(data);
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
		}
	};
	
})();
