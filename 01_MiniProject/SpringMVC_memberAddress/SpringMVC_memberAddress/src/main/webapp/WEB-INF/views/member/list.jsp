<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored = "false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/adminMain.css' />">
<script type="text/javascript" src="<c:url value='/javaScript/member.js'/>"></script>
</head>
<body>
<div class="adminMain-page">
	<form action="<c:url value = '/member/orderby'/>" method="get">
		<div id="top-menu">
		<h5>관리자 메인</h5>
			<div id="top-menu-option">
		<select name="value">
			<option selected value="date">기본</option>
			<option value="name">이름</option>
			<option value="rDate">날짜</option>
		</select>
		<select name="orderby">
			<option selected value="ascend">오름차순</option>
			<option value="descend">내림차순</option>
		</select>
			<input type ="submit" value="적용">
			</div>
		</div>
		</form>
		<table>
			<tr id="head-table">
				<td>아이디</td><td>이름</td><td>전화번호</td>
				<td>이메일</td><td>주소</td><td>가입일</td><td>Option</td>
			</tr>
			<c:forEach var="list" items ="${list}">
				<tr>
				<td>${list.id}</td><td>${list.name}</td><td>${list.phone}</td>
				<td>${list.email}</td><td>${list.address}</td><td>${list.RDate}</td>
				<td><a href="<c:url value='/member/${list.id}'/>" id="viewButton">상세정보</a></td>
				</tr>
			</c:forEach>
		</table>
		<form name = "searchAdmin" action="member.js">
		<div id="bottom-menu">
		<input type="search" name="name">
		<input type="button" value ="이름검색" onclick="searchBlankClient()">
		<h4>${searchFail==0?"검색한 이름을 찾지 못 했습니다.":""}</h4>
		</div>
	</form>
</div>
</body>
</html>