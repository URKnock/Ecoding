<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<button type="button" onclick="location.href='projectSupport.jsp'"
			style="width:200; height:50;">홈으로 돌아가기</button>
	</div>
</body>
</html>