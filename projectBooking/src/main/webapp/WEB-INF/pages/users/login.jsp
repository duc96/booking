<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="styles/login.css" rel="stylesheet" />
<script src="js/libs/pristine/dist/pristine.js" type="text/javascript"></script>
<script src="js/users/login.js"></script>
<div id="appsignin" class="modal">
	<form:form id="appsigincontent">
		<form class="modal-content animate" novalidate method="post">
			<div class="imgcontainer">
				<span
					onclick="document.getElementById('appsignin').style.display='none'"
					class="close" title="Close Modal">&times;</span>
				<span style="font-size: 30px;font-weight: 500;">Booking Online</span>
			</div>

			<div class="container">
				<div class="form-group">
					<label for="username"><b>Tài Khoản</b></label> <input type="text"
						placeholder="Tài khoản/Email" name="username" required>
				</div>
				<div class="form-group">
					<label for="password"><b>Mật Khẩu</b></label> <input
						type="password" placeholder="Nhập mật khẩu" name="password"
						required>
				</div>
				<div class="error-message">Tài khoản hoặc mật khẩu không đúng.</div>
				<button id="signbtn" type="button">Đăng Nhập</button>
				<label> <input type="checkbox" name="remember"> Ghi
					nhớ tài khoản
				</label>
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<span class="psw"><a href="#">Quên mật khẩu?</a></span>
			</div>
		</form>
	</form:form>
</div>