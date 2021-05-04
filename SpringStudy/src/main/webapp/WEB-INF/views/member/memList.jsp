<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
<div align="center">
	<jsp:include page="../nav.jsp"></jsp:include>
	<h1>회원 리스트</h1>
	<table border="1" align="center">
		<tr><th>num</th><th>pw</th><th>name</th><th>tel</th></tr>
		<c:forEach items="${mems }" var="mem">
		<tr>
		<td><a href="<c:url value='/mem/memview?num=${mem.num }' />">${mem.num }</a></td>
		<td>${mem.pw }</td>
		<td>${mem.name }</td>
		<td>${mem.tel }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>