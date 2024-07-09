<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 수정</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/modifyAddr.css' />">
</head>
<body>
    <div class="modifyAddr-page">
		<h3>주소 상세정보/수정</h3>
	<form action="<c:url value='/addr/update' />" method="post" id="modifyAddr-form">
	<input type = "hidden" name="id" value="${addr.id}">
	<h5>이름</h5><input type="search" name="name" value="${addr.name}">
	<h5>전화번호</h5><input type="text" name="phone" value="${addr.phone}" readonly="readonly">
	<h5>이메일</h5><input type="email" name="email" value="${addr.email}">
	<h5>주소</h5><input type="search" name="address" value="${addr.address}">
	<h5>그룹</h5><input type="search" name="addrGroup" value="${addr.addrGroup}">
		<div id="bottom-menu">
			<input type="submit" value="연락처 수정">
			<a href="<c:url value='/addr/list?id=${addr.id}'/>" class="button">메인으로</a>
		</div>	
	</form>
    </div>
</body>
</html>