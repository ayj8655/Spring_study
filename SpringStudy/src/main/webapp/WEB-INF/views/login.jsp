<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div align="center">
	
	<h1>로그인</h1>
	<form action="<c:url value='/mem/memlogin' />" method="post">
	<table>
		<tr><td>id</td><td><input type="text" id="num" name="num" /></td></tr>
		<tr><td>pw</td><td><input type="password" id="pw" name="pw" /></td></tr>
		<tr><td colspan="2"><button type="submit">로그인</button></td></tr>
	</table>
	</form>
	</div>
</body>
</html>