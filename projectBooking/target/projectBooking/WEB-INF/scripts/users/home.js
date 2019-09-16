$(document).ready(function() {
	$('#app-signin').on("click", function(event) {
		$('#loginform').css({display: "block"});
	});
	
	window.onclick = function(event) {
	    if (event.target == document.getElementById('loginform')) {
	    	$('#loginform').css({display: "none"});
	    }
	}
	
	$('#signbtn1').on("click", function(event) {
		$('.register-form').css({display: "block"});
	});
})