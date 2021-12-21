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
			<c:forEach var="project" items="${projectMap}">
				<div class="card">
					<c:if test="${project.key.image == null}">
						<img class="card-img-top" src="/resources/img/noImage.png"
							alt="Card imagecap">
					</c:if>
					<c:if test="${project.key.image ne null}">
						<img class="card-img-top" src="<c:url value='/upload/${project.key.image}' />"
							alt="Card imagecap">
					</c:if>
					<span class="badge badge-info" style="margin: 5px 5px 5px 5px;">인기</span>
					<div class="card-body">
						<a
							href="<c:url value='/project/support/view?projectId=${project.key.projectId}' />"
							class="card-title" style="font-size: 20px">${project.key.title}</a>
						<p class="card-text">${project.key.simpleInfo}
						<!-- DAO에 있는 퍼센트를 읽어오려면 DAO도 List째로 받아와야 함 -->
						<p class="card-text comment">프로젝트 달성도: ${project.value}%</p>
						<div class="progress">
							<div class="progress-bar success" role="progressbar"
								style="width: ${project.value}%" aria-valuenow="50" aria-valuemin="0"
								aria-valuemax="100">${project.value}%</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<!-- 반복문 끝 -->			
		</div>
	</div>
</body>


</html>