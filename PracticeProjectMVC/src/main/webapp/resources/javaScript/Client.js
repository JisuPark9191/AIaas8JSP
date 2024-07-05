//로그인
function loginCheck(){
	var form = document.loginForm;
	var id = form.id.value;
	var pw = form.pw.value;
	if(id==null||id==""){
		alert("아이디를 입력해주세요");
		form.id.focus();
		return;
	} else if(pw==null||pw==""){
		alert("비밀번호를 입력해주세요");
		form.pw.focus();
		return;
	} else {
		form.action = "./login";
		form.method = "post";
		form.submit();
	}
}

//회원가입
function signUp() {
	var form = document.registerForm;
	var id = form.id.value;
	var pw = form.pw.value;
	var pw_re = form.pw_re.value;
	var name = form.name.value;
	var phone = form.phone.value;
	var email = form.email.value;
	var address = form.address.value;
	if(id==null||id==""){
		alert("회원가입 할 아이디를 입력해주세요");
		form.id.focus();
		return;
	} else if(pw==null||pw==""){
		alert("비밀번호를 입력해주세요");
		form.pw.focus();
		return;
	} else if(pw!=pw_re){
		alert("비밀번호가 일치하지 않습니다");
		form.pw_re.focus();
		return;
	} else if(name==null||name==""){
		alert("이름을 입력해주세요");
		form.name.focus();
		return;
	} else if(phone==null||phone==""){
		alert("전화번호를 입력해주세요");
		form.phone.focus();
		return;
	} else if(email==null||email==""){
		alert("이메일을 입력해주세요");
		form.email.focus();
		return;
	} else if(address==null||address==""){
		alert("주소를 입력해주세요");
		form.address.focus();
		return;
	} else {
		form.action="./signup";
		form.method="post";
		form.submit();
	}
}


//고객정보 수정(사용자)
function modifyUser(){
	var form = document.modifyUserForm;
	var id = form.id.value;
	var pw = form.pw.value;
	var pw_re=form.pw_re.value;
	var name = form.name.value;
	var phone = form.phone.value;
	var email = form.email.value;
	var address = form.address.value;
	var rDate = form.rDate.value;
	var memo = form.memo.value;
	 if(pw==null||pw==""){
		alert("비밀번호를 입력해주세요");
		return;
	} else if(pw!=pw_re){
		alert("비밀번호가 일치하지 않습니다");
		return;
	} else if(name==null||name==""){
		alert("이름을 입력해주세요");
		return;
	} else if(phone==null||phone==""){
		alert("전화번호를 입력해주세요");
		return;
	} else if(email==null||email==""){
		alert("이메일을 입력해주세요");
		return;
	} else if(address==null||address==""){
		alert("주소를 입력해주세요");
		return;
	} else {
		form.action ="./updateUser";
		form.method="post";
		form.submit();
	}
}

//관리자 메인화면 검색창 빈칸확인
function searchBlankClient(){
	var form = document.searchAdmin;
	var name= form.name.value;
	if(name==null||name==""){
		alert("검색할 이름을 입력해주세요");
		return;
	} else {
		form.action="/myapp/client/search";
		form.method ="get";
		form.submit();
	}
}