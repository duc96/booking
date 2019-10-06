$(document).ready(function() {
	
	//Đăng ký sự kiện onkeyup của input, khi nhấn phím Enter ==> Login
	$('#app-signin input').on("keyup", function(event){
		if(event.keyCode == 13) {
			doLogin(event);
		}
	});
	
	//Đăng ký sự kiện click button "Đăng Nhập"
	$('#signbtn').on("click", doLogin);
	
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
	
	function doLogin(event){
		if(!signInValidate()) {
			return;
		}
		var postData = {
			email: $("input[name='email']").val(),
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