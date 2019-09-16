$(document).ready(function(){
	$('#butlogin').on('click', function(eve){
		console.log(123123)
		if(!signInValidate()) {
			return;
		}
		console.log(789789)
		var postData = {
			usernamekhachhang: $("input[name='username']").val(),
			passwordkhachhang: $("input[name='password']").val(),
			};
		clientRequest.post("/api/user/login", postData)
		.then(function(res) {
		console.log(1111, res)
			if(res.status == "Success") {
//				window.localStorage.setItem("token", res.content);
//				window.location.href=document.ctx+"/list";
			}
		})
	});
	
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