<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.service.ProjectManager, model.service.dto.ProjectDTO, model.Project" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>

<html>

<head>
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
<title>프로젝트 둘러보기</title>
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

</style>

</head>
<%
int projectId = 1130;
ProjectManager manager = ProjectManager.getInstance();
Project project = manager.findProject(projectId);
ProjectDTO projectDTO = manager.findProjectInfo(project);
request.setAttribute("project", project); // 임시로 프로젝트 하나 넘김
request.setAttribute("percent", projectDTO.getPricePercent());
%>
<body>
	<div class="wrap">
		<!-- 캐러셀 -->
		<div id="carouselExampleControls" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" style="margin: 20px 0px 20px 0px;">
				<div class="carousel-item active">
					<img class="d-block w-100" style="width:1120px; height: 400px" 
					src="<c:url value='/resources/img/first.png'/>" alt="First slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="width:1120px; height: 400px" 
					src="<c:url value='/resources/img/second.png'/>" alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="width:1120px; height: 400px" 
					src="<c:url value='/resources/img/third.png'/>" alt="Third slide">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>

		<h3>에코딩에서 다양한 환경보호 프로젝트를 만나보세요.</h3>
		<!-- 상품 리스트 -->
		<div class="card-columns" id="cards-box">
			<div class="card">
				<img class="card-img-top"
					src="https://d2ur7st6jjikze.cloudfront.net/offer_photos/29590/185689_medium_1525763241.jpg?1525763241"
					alt="Card imagecap">
				<span class="badge badge-success" style="margin: 5px 5px 5px 5px;">목표 금액 달성</span>
				<span class="badge badge-info" style="margin: 5px 5px 5px 5px;">인기</span>
				<div class="card-body">
					<a href="http://naver.com" class="card-title">프로젝트 명</a>
					<p class="card-text">상품 한줄 설명
					<p class="card-text comment">프로젝트 달성도: n%</p>
				</div>
			</div>
			<div class="card">
				<img class="card-img-top"
					src="https://d2ur7st6jjikze.cloudfront.net/offer_photos/29590/185689_medium_1525763241.jpg?1525763241"
					alt="Card imagecap">
				<span class="badge badge-info" style="margin: 5px 5px 5px 5px;">인기</span>
				<div class="card-body">
					<a href="http://naver.com" class="card-title">프로젝트 명</a>
					<p class="card-text">상품 한줄 설명
					<p class="card-text comment">프로젝트 달성도: n%</p>
				</div>
			</div>
			<div class="card">
				<img class="card-img-top"
					src="https://d2ur7st6jjikze.cloudfront.net/offer_photos/29590/185689_medium_1525763241.jpg?1525763241"
					alt="Card imagecap">
				<span class="badge badge-info" style="margin: 5px 5px 5px 5px;">인기</span>
				<div class="card-body">
					<a href="http://naver.com" class="card-title">프로젝트 명</a>
					<p class="card-text">상품 한줄 설명
					<p class="card-text comment">프로젝트 달성도: n%</p>
				</div>
			</div>
			
			
			<div class="card">
				<img class="card-img-top"
					src="https://d2ur7st6jjikze.cloudfront.net/offer_photos/29590/185689_medium_1525763241.jpg?1525763241"
					alt="Card imagecap">
				<span class="badge badge-info" style="margin: 5px 5px 5px 5px;">인기</span>
				<div class="card-body">
					<a href="<c:url value='/project/support/view?projectId=${project.projectId}' />" class="card-title">${project.title}</a>
					<p class="card-text">${project.simpleInfo}
					<p class="card-text comment">${percent}n%</p>
				</div>
			</div>
		</div>
	</div>
</body>


</html>