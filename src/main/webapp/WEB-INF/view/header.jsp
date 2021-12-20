<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">

<style>
* {
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

<script>
function userCreate(targetUri) {
	console.log("버튼 눌림");
	form.action = targetUri;
	form.method="GET"; // register form 요청
	form.submit();
}

function menuClicked(obj) {
	//alert($(obj).attr('class'));
	const menu_list = document.getElementsByClassName('nav-link')
	for(let i = 0; i < menu_list.length - 1; i++)  { //다른 엘리먼트의 active 해제
	    menu_list[i].setAttribute('class', 'nav-link');
	}
	var clickedId = document.getElementById(obj.getAttribute('id')).getAttribute('id');
	if(clickedId != 'category'){ //카테고리는 클래스 수정을 하지 않음
		$(obj).attr('class', 'nav-link active');	//현재 엘리먼트에 active 설정
		if(clickedId == 'home')
			location.href='<c:url value='/home/main'/>';
		else if(clickedId == 'funding')
			location.href='<c:url value='/home/list'/>';
		else if(clickedId == 'board')
			location.href='<c:url value='/board/list'/>';
	}
}  

function interest() {
	form.method="POST";
	location.href='<c:url value='/project/interest' />';
}
</script>
<body>
	<div id="header">
		<div id="top">
			<img style="float: left;" id="logo"
				src="<c:url value='/resources/img/logo.png'/>">
			<div style="text-align: center;">
				<div style="float: left; margin-left: 100px; margin-top: 30px;">
					<!-- 세로 정렬좀... -->
					<form name="search_project" action="">
						<input size=50 type="text" placeholder="다양한 프로젝트를 검색해보세요." /> <input
							type="submit" value="검색" />
					</form>
				</div>
				<div style="float: right; margin-top: 25px;">
					<button id="project" type="button" class="btn btn-success"
						onClick="location.href='<c:url value='/project/view'/>';">프로젝트 등록하기</button>
					<c:if test="${ecoerId == null}">
						<button id="login" type="button" class="btn btn-primary"
							onClick="location.href='<c:url value='/user/loginform'/>';">로그인</button>
						<button id="register" type="button" class="btn btn-primary"
							onClick="location.href='<c:url value='/user/register'/>';">회원가입</button>
					</c:if>
					<c:if test="${ecoerId ne null}">
						<a class="btn btn-primary"
							href="<c:url value='/user/view' >
			     		     <c:param name='ecoerId' value='${ecoerId}'/>
					 	  </c:url>">마이페이지</a>
					 	<button id="myInterest" type="button" class="btn btn-primary"
			 		 		onClick="location.href='<c:url value='/user/interest/listView' />'">&#10084;</button>
			 		 	<button id="mySupport" type="button" class="btn btn-primary"
			 		 		onClick="location.href='<c:url value='/user/project/support/listView' />'">후원 내역</button>
			 		 	<button id="mySupport" type="button" class="btn btn-primary"
			 		 		onClick="location.href='<c:url value='/user/post/listView' />'">작성한 글</button>
			 		 	<button id="myProject" type="button" class="btn btn-primary"
			 		 		onClick="location.href='<c:url value='/user/project/listView' />'">내 프로젝트</button>
					 	<button id="login" type="button" class="btn btn-primary"
							onClick="location.href='<c:url value='/user/logout'/>';">로그아웃</button>
					</c:if>
				</div>
				<div style="float: left; margin-left: 30px; margin-top: 35px;">
					<c:if test="${ecoerId ne null}">
						<a>${ecoerId}님 환영합니다.</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<div class="clear: both"></div>
	<div style="padding-top: 10px">
		<ul class="nav nav-tabs justify-content-center">
			<li class="nav-item"><a id="home" class="nav-link" href="#"
				onclick="menuClicked(this)">홈</a></li>
			<li class="nav-item"><a id="funding" class="nav-link" href="#"
				onclick="menuClicked(this)">펀딩</a></li>
			<li class="nav-item"><a id="board" class="nav-link" href="#"
				onclick="menuClicked(this)">게시판</a></li>
			<li class="nav-item dropdown"><a id="category"
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">카테고리</a> <!-- board에 있을 때 말고는 nav-link가 해제됨... -->
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">항목1</a> <a class="dropdown-item"
						href="#">항목2</a> <a class="dropdown-item" href="#">항목3</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">분리된 항목</a>
				</div></li>
		</ul>
	</div>
	<br />
</body>