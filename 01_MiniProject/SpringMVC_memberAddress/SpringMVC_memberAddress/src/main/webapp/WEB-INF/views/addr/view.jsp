<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택한 연락처</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/addrView.css' />">
</head>
<body>
    <div class="addr-page">
		<h3>연락처</h3>
	<h5>이름</h5><input type="search" name="name" value="${addr.name}" readonly="readonly">
	<h5>전화번호</h5><input type="text" name="phone" value="${addr.phone}" readonly="readonly">
	<h5>이메일</h5><input type="email" name="email" value="${addr.email}" readonly="readonly">
	<h5>주소</h5><input type="search" name="address" value="${addr.address}" readonly="readonly">
	<h5>그룹</h5><input type="search" name="addrGroup" value="${addr.addrGroup}" readonly="readonly">
	
		<a href="<c:url value='/addr/update?phone=${addr.phone}&&id=${addr.id}'/>" class="button">수정</a>
		<a href="<c:url value='/addr/delete?phone=${addr.phone}&&id=${addr.id}'/>" class="button">삭제</a>
		<a href="<c:url value='/addr/list?id=${addr.id}'/>" class="button">메인</a>
		</div>
</body>
</html>