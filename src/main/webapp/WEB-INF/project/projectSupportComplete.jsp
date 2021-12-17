<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후원 완료 - ${project.title}</title>
<style>
	div {
		text-align:center;
		width:1000px;
		margin-left:auto;
		margin-right:auto;
	}
	button {
		height:50px;
		border:0;
		width:250px;
		height:50px;
		font-size:15px;
		font-weight:normal;
		color:white;
		background-color:#C8D7FF;
		border-radius:5px;
	}
	button:hover {
		background-color:#6495ED;
	}
</style>
</head>
<body>
	<div style="text-align:center">
		<h1>후원 완료</h1>
		<h3>${project.title}</h3>
		<img src="<c:url value='${project.image}' />" width="200px" height="200px"> <!-- 이미지 **********-->
		<h3>프로젝트 참여해주셔서 감사합니다!</h3>
		<button type="button" onclick="location.href='<c:url value='/home/main' />'">홈으로 돌아가기</button>
	</div>
</body>
</html>