<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="root" value="${pageContext.request.contextPath }"></c:set>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
<div align="center">
	<h1>${msg }</h1>
	
	
	<a href="${root }/mem/regpage">회원등록</a>
	<a href="${root }/pro/regpage">상품등록</a>
	<a href="<c:url value='/mem/loginpage'/>">로그인</a>
	<a href="<c:url value='/mem/memlist'/>">회원리스트</a>
	<a href="<c:url value='/pro/prolist'/>">상품리스트</a>
	<a href="<c:url value='/uploadform'/>">파일업로드</a>
	</div>
</body>
</html>