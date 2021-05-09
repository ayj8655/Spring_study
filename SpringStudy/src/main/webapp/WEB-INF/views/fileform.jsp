<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. 전송하고자 하는 입력 폼을 <form>과 </form>사이에 위치해놓는다. 
	2. action 값은 데이터를 전송받아서 처리할 Controller url로 설정한다. 
	3. method를 반드시 post로 설정해준다. get으로 설정시 parameter들이 url에 따라간다. 
	4. enctype을 multipart/form-data로 설정한다. 
	5. <form>과 </form>사이에 input type submit버튼을 위치시킨다. -->
	<div align="center">
		<jsp:include page="nav.jsp"></jsp:include>
		<form action="fileUpload" id="fileUpload" name="fileUpload"
			method="post" enctype="multipart/form-data">
			파일 : <input type="file" name="upfile" multiple="multiple"> <input
				id="upfile" type="submit" name="업로드" value="제출"><br>
		</form>
		<hr>
		<table border="1" align="center">
			<c:if test="${not empty files }">
				<tr>
					<th>fid</th>
					<th>name</th>
					<th>path</th>
				</tr>

				<c:forEach items="${files }" var="file">
					<tr>
						<td><a href="<c:url value='/filedownload?fid=${file.fid }' />">${file.fid }</a></td>
						<td>${file.name }</td>
						<td>${file.path }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty files }">
				<h3>다운로드 파일 없음</h3>
			</c:if>
		</table>
	</div>
</body>
</html>


