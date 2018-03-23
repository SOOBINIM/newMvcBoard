<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 리스트</title>
<style>
</style>
</head>
<body>


	<h3>회원 리스트</h3>

<!-- 회원 정보 출력 반복 시작 -->
	<table border ="1">
	<tr>
	<td>Idx</td>
	<td>Id</td>
	<td>Name</td>
	<td>Photo</td>
	</tr>
	
	
	<c:forEach var="member" items="${members}">
		<tr>
			<td>${member.idx}</td> <!-- getIdx() -->
			<td>${member.member_id}</td>
			<td>${member.member_name}</td>
			<td>
			<c:if test="${member.photo != null}">
			<img src="../uploadfile/memberphoto/${member.photo}" width="100">
			</c:if></td>
		</tr>
		</c:forEach>
	</table>
<!-- 회원 정보 출력 반복 끝 -->


	<%-- <h3>리스트 뷰</h3>

	<ul>
		<c:forEach var="id" items="${member}">
			<li>${member.member_id}</li>
		</c:forEach>
	</ul> --%>
	<%-- </ul>

${member.member_id} / ${member.member_name} / ${member.photo}

 --%>
</body>
</html>