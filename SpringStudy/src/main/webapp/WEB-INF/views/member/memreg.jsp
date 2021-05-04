<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
<div align="center">
	<jsp:include page="../nav.jsp"></jsp:include>
	<h1>회원 등록</h1>
	<form action="<c:url value='/mem/meminsert' />" method="post">
	<table border="1" align="center">
		<tr><td>num</td><td><input type="text" id="num" name="num" /></td></tr>
		<tr><td>pw</td><td><input type="password" id="pw" name="pw" /></td></tr>
		<tr><td>name</td><td><input type="text" id="name" name="name" /></td></tr>
		<tr><td>tel</td><td><input type="text" id="tel" name="tel" /></td></tr>
		<tr><td colspan="2"><button type="submit">등록</button></td></tr>
	</table>
	</form>
	</div>
</body>
</html>