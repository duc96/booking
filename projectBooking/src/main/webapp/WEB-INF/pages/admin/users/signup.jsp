<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="styles/admin/users.css" rel="stylesheet" />
<script src="js/libs/pristine/dist/pristine.js" type="text/javascript"></script>

<div id="appsignup" class="modal">
	<form:form id="appsigupcontent">
		<form id="signup-form" class="modal-content animate" novalidate>
			<div class="imgcontainer">
				<span
					class="close" title="Close Modal">&times;</span>
				<span style="font-size: 30px;font-weight: 500;">Tạo Tài Khoản</span>
			</div>

			<div class="container">
				<div class="form-group">
					<label for="email"><b>Email</b></label> <input type="email"
						placeholder="Email" name="email" required />
				</div>
				<div class="form-group">
					<label for="username"><b>Tên Tài Khoản</b></label> 
					<input type="text"
					minlength="6"
					data-toggle="tooltip" data-html="true"
					title="<div>Tên tài phải lớn hơn 6 ký tự</div>"
						placeholder="Tên tài khoản" name="fullname" required>
				</div>
				<div class="form-group">
					<label for="password"><b>Mật Khẩu</b></label> 
					<div style="width:100%;display:inline-flex;">
					<input
						style="width:50%;margin-right:3px;"
						minlength="6"
						type="password" placeholder="Nhập mật khẩu" name="password"
						data-toggle="tooltip" data-html="true"
						title="<div>Mật khẩu phải lớn hơn 6 ký tự</div>"
						class="input-password"
						required>
					<input
					style="width:50%;margin-left:3px;"
					minlength="6"
					type="password" placeholder="Nhập lại mật khẩu" name="repassword"
					data-toggle="tooltip" data-html="true"
					title="<div>Mật khẩu phải lớn hơn 6 ký tự</div>"
					 class="input-password" 
					required>
					</div>
				</div>
				
				<button id="postbtn" type="button">Tạo Mới</button>
			</div>
		</form>
	</form:form>
</div>