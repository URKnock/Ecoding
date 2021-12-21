<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>후원 프로젝트</title>
	<%@ include file="../view/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/my.css'/>"/>
</head>
<body>
<div class="d1">
	<h3 style="padding-left:20px">내 프로젝트</h3>
	<hr>
	<div class="card-columns" id="cards-box">
		<c:forEach var="project" items="${myProjectList}" varStatus="i">
			<div class="card">
				<img class="card-img-top"
					src="<c:url value='/upload/${project.image}' />"
					alt="Card imagecap">
				<div class="card-body">
					<a href="<c:url value='/project/support/view?projectId=${project.projectId}' />" class="card-title">${project.title}</a>
					<p class="card-text">${project.simpleInfo}
					<p class="card-text comment">프로젝트 달성도: ${project.pricePercent}%</p>
				</div>
				<div class="card-bottom">
					<form name="form" method="post" action="<c:url value='/project/register/form' />">
						<input type="hidden" name="projectId" value="${project.projectId}">
			    		<button name="step" class="goNext" value="step1">수정</button>
			    		<button name="step" class="goNext" value="delete">삭제</button>
			   		</form>
			   		<button type="button" class="goNext"
			   			onClick="location.href='<c:url value='/project/notice?projectId=${project.projectId}' />'">공지</button>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>