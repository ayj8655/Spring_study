<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
		<table>
			<tr>
				<td><a href="<c:url value='/mem/memlist' />">회원리스트</a></td>
				<td><a href="<c:url value='/mem/regpage' />">회원등록</a></td>
				<td><a href="<c:url value='/pro/prolist' />">상품리스트</a></td>
				<td><a href="<c:url value='/pro/regpage' />">상품등록</a></td>
				<td><a href="<c:url value='/uploadform'/>">파일업로드</a></td>
			</tr>
		</table>
		<h3>ID : ${currentId } <a href="<c:url value='/mem/memlogout' />">로그아웃</a></h3>
</body>
</html>