<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
			document.currentpage = "${currentPage}";
		</script>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<jsp:include page="${currentPage}" flush="true" />
</div>