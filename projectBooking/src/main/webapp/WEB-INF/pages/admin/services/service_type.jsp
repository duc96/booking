<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="js/admin/service_type.js" type="text/javascript"></script>
<h1 class="page-header">Quản Lý Loại Dịch Vụ</h1>
<div class="action-bar btn-group">
	<button id="servicetype-action-add" class="btn btn-default">Tạo Mới<i class="fas fa-plus"></i></button>
</div>

<table id="grid-data-api" class="table table-condensed table-hover table-striped" data-toggle="bootgrid" data-ajax="true" data-url="${pageContext.request.contextPath}/api/service/types">
    <thead>
        <tr>
            <th data-column-id="index" data-type="numeric" class="column-id">STT</th>
            <th data-column-id="service_type_name" cssClass="column-dichvu">Loại Dịch Vụ</th>
            <th data-column-id="service_type_description" cssClass="column-dichvu">Mô Tả</th>
            <th data-column-id="cretatedate" cssClass="column-date">Ngày Tạo</th>
            <th data-column-id="commands" data-formatter="commands" data-sortable="false"></th>
        </tr>
    </thead>
</table>

<jsp:include page="/WEB-INF/pages/admin/services/service_type_edit.jsp"></jsp:include>
