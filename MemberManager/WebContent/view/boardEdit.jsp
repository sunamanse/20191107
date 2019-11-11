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
			<h1>게시글 수정</h1>
		</div>
		<div>
			<form action="boardEditOk.do" id="frm" name="frm" method="post"
				onsubmit="return formUpdateCheck()">
				<div>
					<table border="1">
						<tr>
							<th width="30">No.</th>
							<td align="center" width="30" id="id"><input type="hidden"
								id="id" name="id" value="${dto.id }"></td>
							<th width="70">작성자</th>
							<td align="center" width="70">${dto.writer}</td>
							<th width="70">작성일자</th>
							<td align="center" width="70">${dto.wdate}</td>
							<th width="70">조회수</th>
							<td align="center" width="70">${dto.hit}</td>
						</tr>
						<tr>
							<th colspan="3">제목</th>
							<td colspan="5"><input type="text" id="title" name="title"
								size="70">${dto.title}</td>
						</tr>
						<tr>
							<th colspan="3">내용</th>
							<td colspan="5" height="70"><textarea rows="7" cols="65"
									name="content"></textarea>${dto.content}</td>
						</tr>
					</table>
				</div>
				<div>
					<br> <input type="submit" value="submit"> <input
						type="reset" value="reset">
					<button type="button" onclick="location.href='boardList.do'">목록</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>