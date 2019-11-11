<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/myJavaScript.js"></script>

</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<h1>W R I T E</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="boardWriteOk.do" method="post"
				onsubmit="return formCheck()">
				<div>
					<table border="1">
						<tr>
							<th width="70">작성자</th>
							<td align="center" width="70"><input type="text" id="writer"
								name="writer"><input type="hidden" id="userID"
								name="userID"></td>
							<th width="70">작성일자</th>
							<td align="center" width="70" colspan="2"><input type="date"
								id="date" name="date" size="30"></td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="4"><input type="text" id="title" name="title"
								size="70"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="4" height="70"><textarea rows="7" cols="65"
									name="content"></textarea></td>
						</tr>
					</table>
				</div>
				<div>
					<br> <input type="submit" value="저장"> <input
						type="reset" value="취소">
					<button type="button" onclick="location.href='boardList.do'">목록</button>
				</div>
			</form>
		</div>
		<script type="text/javascript">
			document.getElementById('date').value = new Date().toISOString()
					.substring(0, 10);
		</script>
	</div>
</body>
</html>