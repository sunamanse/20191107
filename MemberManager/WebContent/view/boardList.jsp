<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr:hover {
	background-color: pink;
}
</style>
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<h1>자유게시판 목록</h1>
		</div>
		<div>
			<div>
				<table border="1">
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Content</th>
						<th>Writer</th>
						<th>Date</th>
						<th>Hit</th>
					</tr>
					<c:forEach var="i" items="${list }">
						<tr onclick="location.href='boardRead.do?id='+${i.id}">
							<td>${i.id }</td>
							<td>${i.title }</td>
							<td>${i.content }</td>
							<td>${i.writer }</td>
							<td>${i.wdate }</td>
							<td>${i.hit }</td>

						</tr>
					</c:forEach>
				</table>
			</div>
			<c:if test="${id !=null }">
				<div>
					<br>
					<button type="button" onclick="location.href='boardWrite.do'">WRITE</button>
				</div>
			</c:if>

		</div>
	</div>

</body>
</html>