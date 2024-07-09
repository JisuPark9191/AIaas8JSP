// 주소록 메인화면 검색창 빈칸확인
function searchBlankAddr(){
	var form, id, name;
	form = document.listMain;
	id= form.id.value;
	name= form.name.value;
	if(name == null || name == ""){
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
	var form, id, name, phone, email, address, addrGroup;
	form = document.insertAddr;
	id = form.id.value;
	name = form.name.value;
	phone = form.phone.value;
	email = form.email.value;
	address = form.address.value;
	addrGroup = form.addrGroup.value;
	if(name == null || name == ""){
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
	} else if(addrGroup == null || addrGroup == ""){
		alert("그룹을 입력해주세요");
		return;
	} else{
		form.action ="/myapp/addr/insert";
		form.method="post";
		form.submit();
	}
}