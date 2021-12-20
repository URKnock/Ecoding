<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/view/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>후원 프로젝트</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

<style>

*{
	font-family: 'Nanum Gothic', sans-serif;
}

.wrap {
	margin: auto;
	width: 900px;
}

.comment {
	font-weight: bold;
	color: blue;
}
.d1 {
	width:900px;
	margin-left:auto;
	margin-right:auto;
}
hr {
	border:0;
	height:1px;
	background-color:#97e6e4;
}
#info {
	border:1px #4179b0 solid;
	font-size:15px;
	color:#4179b0;
	background-color:white;
	border-radius:3px;
	float: right;
}
#info:hover {
	color:white;
	background-color:#5696d6;
}
</style>
<title>후원 프로젝트</title>
</head>
<body>
<div class="d1">
	<h3 style="padding-left:20px">후원 프로젝트</h3>
	<hr>
	<div class="card-columns" id="cards-box">
		<c:forEach var="project" items="${supportList}" varStatus="i">
			<div class="card">
				<img class="card-img-top"
					src="<c:url value='${project.image}' />"
					alt="Card imagecap">
				<div class="card-body">
					<a href="<c:url value='/project/support/view?projectId=${project.projectId}' />" class="card-title">${project.title}</a>
					<p class="card-text">${project.simpleInfo}
					<p class="card-text comment">프로젝트 달성도: ${project.pricePercent}%</p>
				</div>
				<button type="button" id="info" onClick="location.href='<c:url value='/user/project/support/view?projectId=${project.projectId}' />'">후원 정보</button>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>