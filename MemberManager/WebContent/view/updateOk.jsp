<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h1>${id }님개인정보</h1>
		</div>
		<div>
			<div>
				<table border="1">
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>PASSWORD</th>
						<th>DATE</th>
						<th>ADDR</th>
						<th>TEL</th>
					</tr>

					<tr>
						<td>${id}</td>
						<td>${param.name }</td>
						<td>${param.pw }</td>
						<td>${param.edate }</td>
						<td>${param.addr }</td>
						<td>${param.tel }</td>
					</tr>
				</table>
			</div>
			<div>
				<button type="button" onclick="location.href='index.do'">HOME</button>
			</div>

		</div>
	</div>
</body>
</html>