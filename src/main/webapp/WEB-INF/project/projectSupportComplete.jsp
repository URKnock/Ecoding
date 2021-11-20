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
		border:1px black solid;
		text-align:center;
		width:1000;
		margin-left:auto;
		margin-right:auto;
	}
</style>
</head>
<body>
	<div style="text-align:center">
		<h1>후원완료</h1>
		<h3>${project.title}</h3>
		<img src="image.jpg" width="200" height="200"> <!-- 이미지 **********-->
		<h3>프로젝트 참여해주셔서 감사합니다</h3>
		<button type="button" onclick="location.href='<c:url value='/home/main' />'"
			style="width:200; height:50;">홈으로 돌아가기</button>
	</div>
</body>
</html>