function LoginFormCheck() {
	if (frm.id.value == "") {
		alert("아이디를 입력하세요");
		frm.id.forus();
		return false;
	}
	if (frm.pw.value == "") {
		alert("비밀번호를 입력하세요.");
		frm.id.forus();
		return false;
	}
	return true;
}