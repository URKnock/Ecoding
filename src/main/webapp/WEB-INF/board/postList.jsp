<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../view/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/post.css'/>"/>
</head>
<body>
	<div id="communitys" class="left">
		<div><a href="">자유게시판</a></div>
		<div><a href="">후기게시판</a></div>
	</div>
	<div class="right">
		<form name="search_post" action="">
			<select>
				<option value="title">제목</option>
				<option value="writer">작성자</option>
			</select>
			<input type="text"/>
			<input type="submit" value="검색"/>
			<input type="button" value="글쓰기" onClick="location.href='postForm.jsp'"/>
		</form>
		<br/>
	<table id="posts">
		<caption>
				<a href="">◀</a> &nbsp; 1 &nbsp; <a href="">▶</a>
		</caption>
		<tr>
			<td>No</td>
			<td>제목</td>
			<td>작성일</td>
			<td>조회수</td>
			<td>댓글수</td>
			<td>좋아요</td>
		</tr>
		<tr>
			<td><a href="<c:url value='postView.jsp'/>">글글글</a></td>
			<td><a href="<c:url value='postView.jsp'/>">글글글</a></td>		
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>	
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>											
		</tr>
		<tr>
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>		
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>	
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>
			<td><a href="<c:url value='post.jsp'/>">글글글</a></td>		
		</tr>
	</table>
	</div>
</body>
</html>