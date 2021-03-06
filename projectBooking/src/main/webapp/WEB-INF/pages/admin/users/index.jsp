<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="js/admin/users.js" type="text/javascript"></script>
<h1 class="page-header">Dashboard</h1>
<div class="action-bar btn-group">
	<button id="user-action-add" class="btn btn-default">Tạo Mới<i class="fas fa-plus"></i></button>
</div>
<table id="grid-data-api" class="table table-condensed table-hover table-striped" data-toggle="bootgrid" data-ajax="true" data-url="${pageContext.request.contextPath}/api/user/list">
    <thead>
        <tr>
            <th data-column-id="index" data-type="numeric">STT</th>
            <th data-column-id="fullname">Người Dùng</th>
            <th data-column-id="email">Email</th>
            <th data-column-id="">Trạng Thái</th>
            <th data-column-id="cretatedate">Ngày Tạo</th>
            <th data-column-id="commands" data-formatter="commands" data-sortable="false">Commands</th>
        </tr>
    </thead>
</table>
<jsp:include page="/WEB-INF/pages/admin/users/signup.jsp"></jsp:include>
