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
			<li class="nav-item"><a class="nav-link" href="../home.jsp">홈</a></li>
			<li class="nav-item"><a class="nav-link active" href="#">둘러보기</a></li>
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
		</ul>
		<!-- 옵션 선택?? ==> 다중 선택 가능? -->
		<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
			<li class="nav-item">
			<a class="nav-link"
				id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab"
				aria-controls="pills-home" aria-selected="true">달성률 순</a></li>
			<li class="nav-item">
			<a class="nav-link active" id="pills-profile-tab"
				data-toggle="pill" href="#pills-profile" role="tab"
				aria-controls="pills-profile" aria-selected="false">모인 금액 순</a></li>
			<li class="nav-item">
			<a class="nav-link" id="pills-contact-tab"
				data-toggle="pill" href="#pills-contact" role="tab"
				aria-controls="pills-contact" aria-selected="false">#해시태그1</a></li>
			<li class="nav-item">
			<a class="nav-link" id="pills-contact-tab"
				data-toggle="pill" href="#pills-contact" role="tab"
				aria-controls="pills-contact" aria-selected="false">#해시태그2</a></li>
		</ul>
		<!-- 상품 리스트 -->
		<div class="card-columns" id="cards-box">
			<div class="card">
				<img class="card-img-top"
					src="https://d2ur7st6jjikze.cloudfront.net/offer_photos/29590/185689_medium_1525763241.jpg?1525763241"
					alt="Card imagecap">
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