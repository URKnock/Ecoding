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
	<table id="post" align="center">
		<tr>
			<td>${post.title}</td>
			<td class="align_right">
				<input type="button" value="수정"/>
				<input type="button" value="삭제"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">${post.postDate} | 조회수 ${post.views} | 좋아요수 ${post.likes}</td>
		</tr>
		<tr>
			<td colspan="2">${post.postContent}<br/><br/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="좋아요"/>
				<input type="button" value="신고"/>
			</td>
		</tr>
		<tr>
			<td colspan="2"><br/></td>
		</tr>
		<tr>
			<td colspan="2">
				<form name="comment" action="" method="post">
					<input type="text" placeholder="댓글을 입력하세요">
					<input type="submit" value="등록"/>
				</form>
			</td>
		</tr>
		<c:forEach var="c" items="${comment}">
		<tr>
			<td>${c.ecoerId}</td>
			<td class="align_right">
				${c.replyDATE}&nbsp;
				<!-- input type="button" value="수정"/ -->
				<input type="button" value="삭제" onClick="location.href=<c:url value='/board/delete?pid=${post.postId}'/>"/>
				<input type="button" value="좋아요"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">${c.replyContent}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
