<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<h1>N O T I C E</h1>
		</div>
		<div>
			<c:choose>
				<c:when test="${empty list }">
					<h3>등록된 게시글이 없습니다.</h3>
				</c:when>
				<c:otherwise>
					<div>
						<table border="1">
							<tr>
								<th>No</th>
								<th>Title</th>
								<th>Content</th>
								<th>DATE</th>
								<th>Hit</th>
							</tr>
							<c:forEach var="i" items="list">
								<tr>
									<td>${i.nId }</td>
									<td>${i.nTitle }</td>
									<td>${i.nCon }</td>
									<td>${i.nDate }</td>
									<td>${i.nHit }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:otherwise>
			</c:choose>



		</div>


	</div>

</body>
</html>