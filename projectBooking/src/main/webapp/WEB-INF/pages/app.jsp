<%@ page language="java" contentType="text/html; charset = UTF-8"%>
<script src="js/libs/jquery.js" type="text/javascript"></script>
<script src="js/request.js" type="text/javascript"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="styles/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="styles/libs/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
<form:form>
	<script>
			document.ctx = "${pageContext.request.contextPath}"
		</script>
</form:form>
<jsp:include page='/WEB-INF/pages/defaults/NavigationHeader.jsp'></jsp:include>
<jsp:include page='/WEB-INF/pages/users/login.jsp'></jsp:include>