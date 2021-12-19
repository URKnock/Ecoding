<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>나의 게시글</title>
	<%@ include file="../view/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/my.css'/>"/>
</head>
<body>
<div class="d1">
	<h3 style="padding-left:20px">나의 게시글</h3>
	<hr>
</div>
<table id="posts">
<c:choose>
	<c:when test="${not empty postList}">
		<tr>
			<td>No</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
			<td>좋아요</td>
		</tr>
		<c:forEach var="p" items="${postList}">
		<tr>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.postId}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.title} [${p.replyCnt}]</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.ecoerId}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.postDate}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.views}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.likes}</a></td>
		</tr>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<tr>
			<td>글이 없습니다.</td>
		</tr>
	</c:otherwise>
	</c:choose>
</table>
</body>
</html>