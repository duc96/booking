<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="styles/NavigationHeader.css" rel="stylesheet" />
<nav class="navbar navbar-default app-header">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Booking Online</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active menu-item1 menu-item"><a href="${pageContext.request.contextPath}"> <i class='fas fa-hotel'
						style='font-size: 24px'></i> Khách Sạn
				</a></li>
				<li class="menu-item2 menu-item"><a href="${pageContext.request.contextPath}/flight"> <i class='fas fa-plane'
						style='font-size: 24px'></i> Chuyến Bay
				</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a id="app-signin" href="#">Đăng Nhập</a></li>
				<li><a href="#">Đăng Ký</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<script>
$(document).ready(function() {
	var locationPath = location.pathname;//"/projectBooking/flight"
	$(".app-header .menu-item").removeClass("active");
	console.log(document.ctx+"/flight")
	if(locationPath == document.ctx+"/flight") {
		$(".app-header .menu-item2").addClass("active");
	}else {
		$(".app-header .menu-item1").addClass("active");
	}
})
</script>