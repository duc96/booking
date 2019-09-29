<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="styles/confirmmodal.css" rel="stylesheet" />

<div id="appconfirm" class="modal">
	<form:form id="appconfirmcontent">
		<form id="signup-form" class="modal-content animate" novalidate>
			<div class="imgcontainer">
				<span
					class="close" title="Close Modal">&times;</span>
				<span style="font-size: 30px;font-weight: 500;">Xác Nhận</span>
			</div>

			<div class="container">
				<div class="form-group confirm-message">
					fuck you!
				</div>
				<div style="display: inline-flex;width:100%">
					<button style="width: 50%;margin-right:3px;" id="btn-ok" type="button">Đồng Ý</button>
					<button style="width: 50%;margin-left:3px;" id="btn-cancel" type="button">Thoát</button>
				</div>
			</div>
		</form>
	</form:form>
</div>