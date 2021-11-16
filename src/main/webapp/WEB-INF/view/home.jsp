<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<style>
* {
	font-family: 'Jua', sans-serif;
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
	<!-- 상단 메뉴바 -->
		<ul class="nav nav-tabs justify-content-center">
			<li class="nav-item"><a class="nav-link active" href="#">홈</a></li>
			<li class="nav-item"><a class="nav-link" href="#" onclick="location.href='/home/list'">둘러보기</a></li>
			<li class="nav-item"><a class="nav-link" href="#">펀딩</a></li>
			<li class="nav-item"><a class="nav-link" href="#">게시판</a></li>
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">카테고리</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">항목1</a> <a
						class="dropdown-item" href="#">항목2</a> <a
						class="dropdown-item" href="#">항목3</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">분리된 항목</a>
				</div></li>
			</li>
		</ul>
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
					<img class="d-block w-100" style="width:1120px; height: 400px" src="https://postfiles.pstatic.net/MjAyMTExMDVfMTQ4/MDAxNjM2MTE5OTU3MDc4.aV8KduvwtNtR6LaHhIa3SbMTIOjrFnEHpllr7dDRk3kg.5hmdWf61L-TPhWowUPeATNi6Q6GPixTd_hNSyr5BZlgg.JPEG.ironfurniture/classroom-2787754_1920.jpg?type=w966" alt="First slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="width:1120px; height: 400px" src="https://postfiles.pstatic.net/MjAyMTExMDVfMTMg/MDAxNjM2MTE5OTc1MTk5.420bZR2xAgPge2R7wMgMsWy6TXjnHEsHMoQptCpq0W0g.CD8Q0rkZPso-eWvnHoRkKkEaWA09JIoMP6qoZDmqJQ8g.JPEG.ironfurniture/sunflower-3792914_1920.jpg?type=w966" alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" style="width:1120px; height: 400px" src="https://postfiles.pstatic.net/MjAyMTExMDVfMTM3/MDAxNjM2MTE5OTg1Mzc0.t3gL2C1sdWjKmmtIaJTT2YorJ-SNKLy4Nr4sJiXCOIMg.CT67rnl7g5ffIObDdfzhW-bw8sVsTigX9eFV8-hACBwg.JPEG.ironfurniture/wave-2211925_1920.jpg?type=w966" alt="Third slide">
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
		</div>
	</div>
</body>


</html>