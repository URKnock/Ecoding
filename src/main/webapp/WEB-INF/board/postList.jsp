<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<%@ include file="../view/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/post.css'/>"/>
</head>
<body>
	<div id="communitys" class="left">
		<p><button type="button" class="btn btn-outline-primary btn-lg" onClick="location.href='<c:url value='/board/list?cid=0'/>'">자유게시판</button></p>
		<p><button type="button" class="btn btn-outline-info btn-lg" onClick="location.href='<c:url value='/board/list?cid=1'/>'">후기게시판</button></p>
	</div>
	<div class="right">
		<form name="search_post" action="">
			<select name="type">
				<option value="title">제목</option>
				<option value="ecoer_id">작성자</option>
			</select>
			<input type="text" name="keyword"/>
			<button type="submit" class="btn btn-outline-primary">검색</button>
			<button type="button" class="btn btn-primary" onClick="location.href='<c:url value='/board/form'/>'">글쓰기</button>
		</form>
		<br/>
	<table id="posts">
		<caption>
				<a href="">◀</a> &nbsp; 1 &nbsp; <a href="">▶</a>
		</caption>
		<tr>
			<td>No</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
			<td>댓글수</td>
			<td>좋아요</td>
		</tr>
		<c:forEach var="p" items="${postList}">
			<tr>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.postId}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.title}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.ecoerId}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.postDate}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.views}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.likes}</a></td>
				<td><a href="<c:url value='/board/view?pid=${p.postId}'/>">${p.reports}</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>