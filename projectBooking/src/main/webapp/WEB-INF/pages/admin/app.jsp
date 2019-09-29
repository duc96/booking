<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="js/libs/jquery.js" type="text/javascript"></script>
<script src="js/request.js" type="text/javascript"></script>
<script src="js/admin/admin.js" type="text/javascript"></script>

<script src="js/libs/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/libs/bootgrid/jquery.bootgrid.min.js" type="text/javascript"></script>
<script src="js/libs/toast/dist/jquery.toast.min.js" type="text/javascript"></script>
<script src="js/utils.js" type="text/javascript"></script>

<link href="styles/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="styles/libs/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
<link href="styles/libs/bootgrid/jquery.bootgrid.min.css" rel="stylesheet" />
<link href="styles/libs/fontawesome/css/fontawesome.min.css" rel="stylesheet" />
<link href="styles/libs/fontawesome/css/brands.css" rel="stylesheet">
  <link href="styles/libs/fontawesome/css/solid.css" rel="stylesheet">
  <link href="styles/libs/jquery.toast.min.css" rel="stylesheet">
  
<link href="styles/admin.css" rel="stylesheet" />
<form:form>
	<script>
			document.ctx = "${pageContext.request.contextPath}"
				document.currentpage = "${currentPage}";
		</script>
</form:form>

<jsp:include page='/WEB-INF/pages/defaults/Confirm.jsp'></jsp:include>
<jsp:include page='/WEB-INF/pages/admin/header.jsp'></jsp:include>

<div class="container-fluid">
	<div class="row">
		<jsp:include page='/WEB-INF/pages/admin/navside.jsp'></jsp:include>
		<jsp:include page='/WEB-INF/pages/admin/content.jsp'></jsp:include>
	</div>
</div>