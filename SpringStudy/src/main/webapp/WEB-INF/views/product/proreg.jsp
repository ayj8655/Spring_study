<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<div align="center">
	<jsp:include page="../nav.jsp"></jsp:include>
	<h1>상품 등록</h1>
	<form action="<c:url value='/pro/proinsert' />">
	<table border="1" align="center">
		<tr><td>pid</td><td><input type="text" id="pid" name="pid" /></td></tr>
		<tr><td>pname</td><td><input type="text" id="pname" name="pname" /></td></tr>
		<tr><td>pprice</td><td><input type="text" id="pprice" name="pprice" /></td></tr>
		<tr><td colspan="2"><button type="submit">등록</button></td></tr>
	</table>
	</form>
	</div>
</body>
</html>