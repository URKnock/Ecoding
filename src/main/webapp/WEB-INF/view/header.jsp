<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/header.css'/>"/>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script>
function userCreate(targetUri) {
	console.log("버튼 눌림");
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}
</script>

<div id="header">
	<div id="top">
		<img id="logo" src="../../resources/img/logo.png"/>
		<div>
			<button type="button" onClick="location.href='../project/view';">프로젝트 등록하기</button>
			<button type="button" onClick="location.href='../user/loginform';">로그인</button>
			<button type="button" onClick="location.href='../user/register';">회원가입</button>
		</div>
		<div>
			<form name="search_project" action="">
				<input type="text" placeholder="다양한 프로젝트를 검색해보세요."/>
				<input type="submit" value="검색"/>
			</form>
		</div>
	</div>
	<div id="menu">
		<ul>
			<li><a href="index.jsp">홈</a></li>
			<li><a href="">둘러보기</a></li>
			<li><a href="">펀딩</a></li>
			<li><a href="../board/view">게시판</a></li>
			<li><a href="">카테고리</a></li>
		</ul>
	</div>
	<div class="clear"></div>
</div>
<br/>