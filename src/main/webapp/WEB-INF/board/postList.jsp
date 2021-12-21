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
	<div>
		<form name="search_post" action="<c:url value='/board/list'/>">
			<select name="type">
				<option value="title">제목</option>
				<option value="ecoer_id">작성자</option>
			</select>
			<input type="text" name="keyword"/>
			<button type="submit" class="btn btn-outline-primary">검색</button>
			<button type="button" class="btn btn-primary" onClick="location.href='<c:url value='/board/form'/>'">글쓰기</button>
		</form>
		<br/>
	</div>
	<div>
		<table id="posts" style="margin : auto;">
		<c:choose>
			<c:when test="${not empty postList}">
				<caption>
						<a href="">◀</a> &nbsp; 1 &nbsp; <a href="">▶</a>
				</caption>
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
	</div>
</body>
</html>