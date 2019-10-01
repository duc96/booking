<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="styles/admin/service_type.css" rel="stylesheet" />
<script src="js/libs/pristine/dist/pristine.js" type="text/javascript"></script>

<div id="appservicetype" class="modal">
	<form:form id="appservicetypecontent">
		<form id="servicetype-form" class="modal-content animate" novalidate>
			<div class="imgcontainer">
				<span
					class="close" title="Close Modal">&times;</span>
				<span style="font-size: 30px;font-weight: 500;">Tạo Mới Dịch Vụ</span>
			</div>

			<div class="container">
				<div class="form-group">
					<label for="service_name"><b>Tên Dịch Vụ</b></label> 
					<input type="text"
						minlength="6"
						title="<div>Tên dịch vụ phải lớn hơn 6 ký tự</div>"
						placeholder="Dịch vụ" name="service_name" required />
				</div>
				<div class="form-group">
					<label for="service_description"><b>Mô Tả</b></label> 
					<textarea
					minlength="6"
					data-toggle="tooltip" data-html="true"
					title="<div>Mô tả lớn hơn 6 ký tự</div>"
						placeholder="Mô tả" name="service_description" required>
						</textarea>
				</div>
				<button id="postbtn" type="button">Tạo Mới</button>
			</div>
		</form>
	</form:form>
</div>