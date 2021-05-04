<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#delete').on('click', function(){
			$('#proform').attr('action', "<c:url value='/pro/prodelete' />");
			$('#proform').submit();
		});
		
		$('#update').on('click', function(){
			$('#proform').attr('action', "<c:url value='/pro/proupdate' />");
			$('#proform').submit();
		});
	})
</script>
</head>
<body>
<div align="center">
	<jsp:include page="../nav.jsp"></jsp:include>
	<h1>상품 정보</h1>
	<form id="proform">
	<table border="1" align="center">
		<tr><td>pid</td><td><input type="text" id="pid" name="pid" value="${pro.pid }" /></td></tr>
		<tr><td>pname</td><td><input type="password" id="pname" name="pname" value="${pro.pname }" /></td></tr>
		<tr><td>pprice</td><td><input type="text" id="pprice" name="pprice" value="${pro.pprice }" /></td></tr>
		<tr><td colspan="2"><button id="delete" type="button" value = "삭제">삭제</button><button id="update" type="button" value="수정">수정</button></tr>
	</table>
	</form>
	</div>
</body>
</html>