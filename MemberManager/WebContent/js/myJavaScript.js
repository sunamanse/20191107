function LoginFormCheck() {
	if (frm.id.value == "") {
		alert("아이디를 입력하세요");
		frm.id.focus();
		return false;
	}
	if (frm.pw.value == "") {
		alert("비밀번호를 입력하세요.");
		frm.id.focus();
		return false;
	}
	return true;
}

function updateFormCheck() {
	if (!frm.name.value) {
		alert("이름을 입력하세요");
		frm.name.focus();
		return false;
	}
	if (!frm.pw.value) {
		alert("비밀번호를 입력하세요");
		frm.pw.focus();
		return false;
	}
	if (!frm.addr.value) {
		alert("주소를 입력하세요");
		frm.addr.focus();
		return false;
	}
	if (!frm.tel.value) {
		alert("전화번호를 입력하세요");
		frm.tel.focus();
		return false;
	}
	return true;

}

function memberformCheck() {
	if (frm.id.value == "") {
		alert("사용할 아이디를 입력하세요.");
		frm.id.focus();
		return false;
	}
	if (frm.idck.value == "unCheck") {
		alert("아이디 중복을 확인해주세요.");
		return false;
	}
	if (frm.pw.value == "") {
		alert("사용할 패스워드를 입력하세요.");
		frm.pw.focus();
		return false;
	}
	if (frm.pwck.value == "") {
		alert("패스워드를 다시 한번 입력하세요.");
		frm.pwck.focus();
		return false;
	}
	if (frm.pw.value != frm.pwck.value) {
		alert("패스워드 값이 일치하지 않습니다.");
		frm.pwck.focus();
		return false;
	}
	if (frm.tel.value == "") {
		alert("전화번호를 입력하세요.");
		frm.tel.focus();
		return false;
	}
	return true;
}

function idCheck() {
	var id = frm.id.value;
	window.open("idCheck.do?id=" + id, "idCheck.do",
			"width=500, height=400, top=50 left=50");
}

function openFormClose(n) {
	if (n == 1) {
		opener.document.frm.idck.value = "checked";
		window.close();
	} else {
		opener.document.frm.idck.value = "";
		window.close();
	}

}
