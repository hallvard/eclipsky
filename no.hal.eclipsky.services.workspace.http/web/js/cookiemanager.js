var cookieManager = {
	setCookie : function(cname, cvalue, exdays) {
		var d = new Date(), daySec = 24*60*60*1000;
		d.setTime(d.getTime() + (exdays*daySec));
		
		var expires = "expires="+d.toUTCString();		
		cookie = cname + "=" + cvalue + "; " + expires;
	},
	
	getCookie : function(cname) {
		var name = cname + "=";
		var ca = cookie.split(';');
		for(var i=0; i<ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0)==' ') c = c.substring(1);
			if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
		}
		return "";
	}
};