$(document).ready(function() {
	var clientRequest = {};
	clientRequest.post = function(_url, _data) {
		return $.when($.ajax({
			type : "POST",
			contentType : "application/json",
			url : (document.ctx||"") + _url,
			data : JSON.stringify(_data),
			dataType : 'json',
			timeout : 600000
		}));
	}
	clientRequest.put = function(_url, _data) {
		return $.when($.ajax({
			type : "PUT",
			contentType : "application/json",
			url : (document.ctx||"") + _url,
			data : JSON.stringify(_data),
			dataType : 'json',
			timeout : 600000
		}));
	}
	clientRequest.remove = function(_url, _data) {
		return $.when($.ajax({
			type : "DELETE",
			contentType : "application/json",
			url : (document.ctx||"") + _url,
			data : JSON.stringify(_data),
			dataType : 'json',
			timeout : 600000
		}));
	}
	clientRequest.get = function(_url, _data) {
		return $.when($.ajax({
			type : "GET",
			contentType : "application/json",
			url : (document.ctx||"") + _url,
			data : _data,
			dataType : 'json',
			timeout : 600000
		}));
	}
	window.clientRequest = clientRequest;
});