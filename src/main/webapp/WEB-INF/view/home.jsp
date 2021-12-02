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
<title>에코딩 홈</title>
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
					<img class="d-block w-100" style="width: 1120px; height: 400px"
						src="<c:url value='/resources/img/first.png'/>" alt="First slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="width: 1120px; height: 400px"
						src="<c:url value='/resources/img/second.png'/>"
						alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="width: 1120px; height: 400px"
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

			<c:forEach var="project" items="${projectList}">
				<div class="card">
					<c:if test="${project.image == null}">
						<img class="card-img-top" src="/resources/img/noImage.png"
							alt="Card imagecap">
					</c:if>
					<c:if test="${project.image ne null}">
						<img class="card-img-top" src="${project.image}"
							alt="Card imagecap">
					</c:if>
					<span class="badge badge-info" style="margin: 5px 5px 5px 5px;">인기</span>
					<div class="card-body">
						<a
							href="<c:url value='/project/support/view?projectId=${project.projectId}' />"
							class="card-title" style="font-size: 20px">${project.title}</a>
						<p class="card-text">${project.simpleInfo}
						<!-- DAO에 있는 퍼센트를 읽어오려면 DAO도 List째로 받아와야 함 -->
						<p class="card-text comment">프로젝트 달성도: ${(project.currentPrice / project.targetPrice) * 100}%</p>
						<div class="progress">
							<div class="progress-bar success" role="progressbar"
								style="width: ${(project.currentPrice / project.targetPrice) * 100}%" aria-valuenow="50" aria-valuemin="0"
								aria-valuemax="100">${(project.currentPrice / project.targetPrice) * 100}%</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<!-- 반복문 끝 -->			
		</div>
	</div>
</body>


</html>