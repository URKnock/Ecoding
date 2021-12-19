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
	<h3 style="padding-left:20px">후원 프로젝트</h3>
	<hr>
	<div class="card-columns" id="cards-box">
		<c:forEach var="project" items="${supportList}" varStatus="i">
			<div class="card">
				<img class="card-img-top"
					src="https://d2ur7st6jjikze.cloudfront.net/offer_photos/29590/185689_medium_1525763241.jpg?1525763241"
					alt="Card imagecap">
				<div class="card-body">
					<a href="<c:url value='/project/support/view?projectId=${project.projectId}' />" class="card-title">${project.title}</a>
					<p class="card-text">${project.simpleInfo}
					<p class="card-text comment">프로젝트 달성도: ${project.pricePercent}%</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>