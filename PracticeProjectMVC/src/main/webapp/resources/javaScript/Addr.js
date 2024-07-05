// 주소록 메인화면 검색창 빈칸확인
function searchBlankAddr(){
	var form = document.listMain;
	var id= form.id.value;
	var name= form.name.value;
	if(name==null||name==""){
		alert("검색할 이름을 입력해주세요");
		return;
	} else {
		form.action="/myapp/addr/search";
		form.method ="get";
		form.submit();
	}
}

//연락처 추가
function addAddr(){
	var form = document.insertAddr;
	var id = form.id.value;
	var name = form.name.value;
	var phone = form.phone.value;
	var email = form.email.value;
	var address = form.address.value;
	var addrGroup = form.addrGroup.value;
	if(name==null||name==""){
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
	} else if(addrGroup==null||addrGroup==""){
		alert("그룹을 입력해주세요");
		return;
	} else{
		form.action ="/myapp/addr/insert";
		form.method="post";
		form.submit();
	}
}