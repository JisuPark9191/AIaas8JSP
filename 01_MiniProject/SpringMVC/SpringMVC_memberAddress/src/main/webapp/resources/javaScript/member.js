//로그인
function loginCheck(){
	var form, id, pw;
	form = document.loginForm;
	id = form.id.value;
	pw = form.pw.value;
	if(id == null || id == ""){
		alert("아이디를 입력해주세요");
		form.id.focus();
		return;
	} else if(pw == null || pw == ""){
		alert("비밀번호를 입력해주세요");
		form.pw.focus();
		return;
	} else {
		form.action = "/myapp/member/login";
		form.method = "post";
		form.submit();
	}
}

//회원가입
function signUp() {
	var form, id, pw, pw_re, name, phone, email, address, memo;
	form = document.registerForm;
	id = form.id.value;
	pw = form.pw.value;
	pw_re = form.pw_re.value;
	name = form.name.value;
	phone = form.phone.value;
	email = form.email.value;
	address = form.address.value;
	memo = form.memo.value;
	if(id== null || id== ""){
		alert("회원가입 할 아이디를 입력해주세요");
		form.id.focus();
		return;
	} else if(pw == null || pw == ""){
		alert("비밀번호를 입력해주세요");
		form.pw.focus();
		return;
	} else if(pw != pw_re){
		alert("비밀번호가 일치하지 않습니다");
		form.pw_re.focus();
		return;
	} else if(name == null || name == ""){
		alert("이름을 입력해주세요");
		form.name.focus();
		return;
	} else if(phone == null || phone == ""){
		alert("전화번호를 입력해주세요");
		form.phone.focus();
		return;
	} else if(email == null || email == ""){
		alert("이메일을 입력해주세요");
		form.email.focus();
		return;
	} else if(address == null || address == ""){
		alert("주소를 입력해주세요");
		form.address.focus();
		return;
	} else {
		form.action="/myapp/member/signup";
		form.method="post";
		form.submit();
	}
}


//고객정보 수정(사용자)
function modifyUser(){
	var form, id, pw, pw_re, name, phone, email, address, rDate, memo;
	form = document.modifyUserForm;
	id = form.id.value;
	pw = form.pw.value;
	pw_re=form.pw_re.value;
	name = form.name.value;
	phone = form.phone.value;
	email = form.email.value;
	address = form.address.value;
	rDate = form.rDate.value;
	memo = form.memo.value;
	 if(pw == null || pw == ""){
		alert("비밀번호를 입력해주세요");
		return;
	} else if(pw != pw_re){
		alert("비밀번호가 일치하지 않습니다");
		return;
	} else if(name == null || name == ""){
		alert("이름을 입력해주세요");
		return;
	} else if(phone == null || phone == ""){
		alert("전화번호를 입력해주세요");
		return;
	} else if(email == null || email == ""){
		alert("이메일을 입력해주세요");
		return;
	} else if(address == null || address == ""){
		alert("주소를 입력해주세요");
		return;
	} else {
		form.action ="/myapp/member/updateUser";
		form.method="post";
		form.submit();
	}
}

//관리자 메인화면 검색창 빈칸확인
function searchBlankClient(){
	var form, name;
	form = document.searchAdmin;
	name = form.name.value;
	if(name == null || name == ""){
		alert("검색할 이름을 입력해주세요");
		return;
	} else {
		form.action="/myapp/member/search";
		form.method ="get";
		form.submit();
	}
}