<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Register Page</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="styles/libs/bootstrap/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="styles/libs/bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="js/libs/bootstrap/js/bootstrap.min.js"></script>

<link href="styles/RegisterPage.css" rel="stylesheet" />
<script src="js/users/RegisterPage.js" type="text/javascript"></script>



</head>
<body>

	<form:form class="register-form">

		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>
			
			<div class="form-group">
				<label for="username">UserName</label> <input type="text"
					class="form-control" name="username" id="username" placeholder="User Name"
					required>
			</div>
			
			<div class="form-group">
				<label for="email">Email address</label> <input type="email"
					class="form-control" name="email" id="email" placeholder="Email"
					required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" name="psw" id="password"
					placeholder="Password" required>
			</div>

			<div class="form-group">
				<label for="psw-repeat">Password</label> <input type="password"
					class="form-control" id="psw-repeat" name="psw-repeat"
					placeholder="Repeat Password" required>
			</div>
			<hr>
			<p>
				By creating an account you agree to our <a href="#">Terms &
					Privacy</a>.
			</p>

			<button type="button" class="registerbtn">Register</button>
		</div>

		<div class="container signin">
			<p>
				Already have an account? <a href="#">Sign in</a>.
			</p>
		</div>
	</form:form>

</body>
</html>