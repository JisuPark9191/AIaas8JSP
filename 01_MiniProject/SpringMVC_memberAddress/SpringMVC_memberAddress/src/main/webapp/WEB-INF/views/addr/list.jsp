<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored = "false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 메인</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/list.css' />">
<script type="text/javascript" src="<c:url value='/javaScript/address.js'/>"></script>
</head>
<body>
<div class="addrMain-page">
		<form action="<c:url value='/addr/orderby' />" method="get">
			<div id="top-menu">
			<h5>${id} 님의 주소록입니다</h5>
			<a href="<c:url value='/member/user?id=${id}'/>" class="button">회원정보</a>
				<div id="top-menu-option">
			<input type="hidden" name="id" value="${id}">
			<select name="value">
				<option selected value="date">날짜</option>
				<option value="name">이름</option>
				<option value="addrGroup">그룹</option>
			</select>
				<select name="orderby">
				<option selected value="ascend">오름차순</option>
				<option value="descend">내림차순</option>
			</select>
			<input type="submit" value="적용" id="orderbyButton">
			</form>
				</div>
			</div>
			<form action="<c:url value='/addr/deleteAll' />" method="post"> 
		<table>
			<tr id="head-table">
			<td>이름</td><td>전화번호</td><td>이메일</td><td>주소</td><td>그룹</td><td colspan=2>Option</td>
			</tr>
			<c:forEach var="list" items ="${list}">
				<tr>
				<td>${list.name}</td><td>${list.phone}</td><td>${list.email}</td>
				<td>${list.address}</td><td>${list.addrGroup}</td>
				<td><a href="<c:url value='/addr/${list.phone}?id=${list.id}'/>" id="viewButton">상세정보</a></td>
				<td><input type="checkbox" value = "${list.phone}" name = "checkbox"></td>
				</tr>
			</c:forEach>
		</table>
	<div id="bottom-menu">
			<input type="hidden" name="id" value="${id}">
		<div class="bottomRight-menu">
			<input type ="submit" value="선택된 주소 삭제">
			</form>
			<form action ="<c:url value='/addr/insert'/>" method="get" class="bottomRight-menu">
			<input type ="submit" value="연락처 추가">
			<input type="hidden" name="id" value="${id}">
		</div>
			</form>
		<form name="listMain" action="address.js">
			<div id="bottomLeft-menu">
			<input type="search" name="name">
			<input type="button" value ="이름검색" onclick="searchBlankAddr()">
			<h4>${searchFail==0?"검색한 이름을 찾지 못 했습니다.":""}</h4>
			</div>
		<input type="hidden" name="id" value="${id}">
	</div>
</form>
</div>
</body>
</html>