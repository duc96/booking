<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
    	<ul class="nav nav-sidebar">
        <li class="active"><a href="${pageContext.request.contextPath}/admin?page=dashboard">Dashboard <span class="sr-only">(current)</span></a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="${pageContext.request.contextPath}/admin?page=users"><i class="fas fa-users"></i>Quản Lý Người Dùng</a></li>
      </ul>
       <ul class="nav nav-sidebar">
       	<span>Quản Lý Dịch Vụ</span>
        <li><a href="${pageContext.request.contextPath}/admin?page=service_type"><i class="fab fa-servicestack"></i>Loại Dịch Vụ</a></li>
      </ul>
    </div>
  </div>
    