$(document).ready(function(){
	$('#butlogin').on('click', function(eve){
		if(!signInValidate()) {
			return;
		}
		var postData = {
				username: $("input[name='username']").val(),
				password: $("input[name='password']").val(),
			};
		clientRequest.post("/api/user/login", postData)
		.then(function(res) {
		
			if(res.status == "Success") {
				window.localStorage.setItem("token", res.content);
				window.location.href=document.ctx+"/list";
			}
		})
	});
})