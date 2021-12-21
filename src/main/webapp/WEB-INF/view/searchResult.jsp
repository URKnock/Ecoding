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
<title>프로젝트 검색 결과</title>
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
		<!-- 상품 리스트 -->
		<div class="card-columns" id="cards-box">
			<c:if test="${projectMap.value == null}"> <!-- 검색 결과가 없다면 -->
				검색 결과가 없습니다. 
			</c:if>
			<c:if test="${projectMap ne null}"> <!-- 검색 결과가 있다면 -->
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
			</c:if>	
		</div>
	</div>
</body>


</html>