$(document).ready(function() {
	$('#signbtn').on("click", function(evebt){
		if(!signInValidate()) {
			return;
		}
		var postData = {
			loginname: $("input[name='username']").val(),
			password: $("input[name='password']").val(),
		};
		
		clientRequest.post("/api/user/login", postData)
		.then(function(res) {
		
			if(res.status == "Success") {
				window.localStorage.setItem("token", res.content);
				window.location.href=document.ctx+"/admin";
			} else {
				$("#appsignin .error-message").css({display: "block"})
			}
		})
	});
	
	//Hiển thị màn hình SignIn khi click vào menu 
	$('#app-signin').on("click", function(event) {
		$('#appsignin').css({display: "block"});
	});

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == document.getElementById('appsigincontent')) {
	    	$('#appsignin').css({display: "none"});
	    }
	}
	
	function signInValidate() {
		 var pristine = new Pristine($("#appsigincontent form")[0]);
		 if(!pristine.validate()) {
			 var eles = $("#appsigincontent .has-danger input");
			 if(eles.length) {
				 $(eles[0]).focus();
			 }
			 return false;
		 }
		 return true;
	}

})