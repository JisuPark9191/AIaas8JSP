<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/clientView.css' />">
</head>
<body>
	<div class="client-page">
		<h3>회원상세정보</h3>
		<h5>회원ID</h5><input type="text" name="id" value="${mem.id}" readonly="readonly">
        <h5>이름</h5><input type="search" name="name" value="${mem.name}" readonly="readonly">
        <h5>전화번호</h5><input type="search" name="phone" value="${mem.phone}" readonly="readonly">
        <h5>이메일</h5><input type="email" name="email" value="${mem.email}" readonly="readonly">
        <h5>주소</h5><input type="search" name="address" value="${mem.address}" readonly="readonly">
		<h5>가입일</h5><input type="text" name="rDate" value="${mem.RDate}" readonly="readonly">
		<h5>메모</h5><input type="text" name ="memo" value="${mem.memo}">

		<a href="<c:url value='/member/update?id=${mem.id}'/>" class="button">수정</a>
		<a href="<c:url value='/member/delete?id=${mem.id}'/>" class="button">삭제</a>
		<a href="<c:url value='/member/list'/>" class="button">메인으로</a>
	</div>
</body>
</html>