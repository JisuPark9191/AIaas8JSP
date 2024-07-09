<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 추가</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/addAddr.css' />">
<script type="text/javascript" src="<c:url value='/javaScript/address.js'/>"></script>
</head>
<body>
	<div class="addAddr-page">
	<form name="insertAddr" action="address.js" id="addAddr-form">
	<h3>연락처 추가</h3>
	<input type="hidden" name="id" value="${id}">
	<h5>이름</h5> <input type="search" name="name">
	<h5>전화번호</h5> <input type="search" name="phone" placeholder="중복되지 않는 전화번호를 입력해주세요 '-'문자 포함">
	<h5>이메일</h5> <input type="email" name="email" placeholder="'@'를 포함하여 입력해주세요">
	<h5>주소</h5> <input type="search" name="address">
	<h5>그룹</h5> <input type="search" name="addrGroup">
	
	<div id="bottom-menu">
	<input type="button" value="연락처 추가" onclick="addAddr()"/>
	<a href="<c:url value='/addr/list?id=${id}'/>" class="button">메인으로</a>
	</div>
	</form>
	</div>
</body>
</html>