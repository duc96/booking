<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/libs/pristine/dist/pristine.js" type="text/javascript"></script>
<script src="js/users/Slogin.js"></script>
</head>
<body>

	<center>
		<div class="loginform">
			<h1>LOGIN FORM</h1>
			<table>
				<tr>
					<td><label>User name :</label></td>
					<td><input id="input-1" placeholder="your login name"
						type="text" name="username" /></td>
				</tr>
				<tr>
					<td><label>Email :</label></td>
					<td><input id="input-2" placeholder="your email" type="text" /></td>
				</tr>
				<tr>
					<td><label>Password :</label></td>
					<td><input type="password" placeholder="your password"
						name="password"></td>
				</tr>
				<tr>
					<td><label>Repassword :</label></td>
					<td><input type="password" placeholder="your password again"></td>
				</tr>
			</table>
			<button type="submit" id="butlogin">DONE</button>
		</div>
	</center>
</body>
</html>