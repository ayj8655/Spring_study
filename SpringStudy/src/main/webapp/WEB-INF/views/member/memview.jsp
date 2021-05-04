<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#delete').on('click', function(){
			$('#memform').attr('action', "<c:url value='/mem/memdelete' />");
			$('#memform').submit();
		});
		
		$('#update').on('click', function(){
			$('#memform').attr('action', "<c:url value='/mem/memupdate' />");
			$('#memform').submit();
		});
	})
</script>
</head>
<body>
<div align="center">
	<jsp:include page="../nav.jsp"></jsp:include>
	<h1>회원 정보</h1>
	<form id="memform">
	<table border="1" align="center">
		<tr><td>num</td><td><input type="text" id="num" name="num" value="${mem.num }" /></td></tr>
		<tr><td>pw</td><td><input type="password" id="pw" name="pw" value="${mem.pw }" /></td></tr>
		<tr><td>name</td><td><input type="text" id="name" name="name" value="${mem.name }" /></td></tr>
		<tr><td>tel</td><td><input type="text" id="tel" name="tel" value="${mem.tel }" /></td></tr>
		<tr><td colspan="2"><button id="delete" type="button" value = "삭제">삭제</button>
			<button id="update" type="button" value="수정">수정</button></tr>
	</table>
	</form>
</div>	
</body>
</html>