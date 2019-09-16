$(document).ready(function() {
	$(".registerbtn").click(function(event){
		var ctx = "${pageContext.request.contextPath}";
		var data = {
				email: $("input[name='email']").val(),
				password: $("input[name='psw']").val(),
		};
		clientRequest.post("/api/user/signup", data);
	})
	alert('Dang ki thanh cong !!!');
})