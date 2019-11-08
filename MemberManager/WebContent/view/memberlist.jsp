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
			<h1>회 원 정 보</h1>
		</div>
		<div>
			<form action="">
				<div>
					<table border="1">
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>DATE</th>
							<th>ADDR</th>
							<th>TEL</th>
						</tr>
						<c:forEach var="i" items="${dto }">
							<tr>
								<td>${i.id }</td>
								<td>${i.name }</td>
								<td>${i.eDate }</td>
								<td>${i.addr }</td>
								<td>${i.tel }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div>
					<button type="button" onclick="location.href='index.do'">HOME</button>
				</div>



			</form>

		</div>
	</div>

</body>
</html>