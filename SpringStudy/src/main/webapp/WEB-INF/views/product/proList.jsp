<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
</head>
<body>
<div align="center">
	<jsp:include page="../nav.jsp"></jsp:include>
	<h1>상품 리스트</h1>
	<table border="1" align="center">
		<tr><th>pid</th><th>pname</th><th>pprice</th></tr>
		<c:forEach items="${pros }" var="pro">
		<tr>
		<td><a href="<c:url value='/pro/proview?pid=${pro.pid }' />">${pro.pid }</a></td>
		<td>${pro.pname }</td>
		<td>${pro.pprice }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>