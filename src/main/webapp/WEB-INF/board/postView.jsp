<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../view/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/post.css'/>"/>
	<script type="text/javascript">
		function move() { location.href="<c:url value='/board/delete?pid=${post.postId}'/>"; }
	</script>
</head>
<body>
	<table id="post" align="center">
		<tr>
			<td>${post.title}</td>
			<td class="align_right">
				<!-- input type="button" value="수정"/ -->
				<input type="button" value="삭제" onClick="move();"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">작성자 ${post.ecoerId} | 작성일 ${post.postDate} | 조회수 ${post.views} | 좋아요수 ${post.likes}</td>
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
				<form name="comment" action="<c:url value='/board/view'/>" method="post">
					<input type="text" name="reply_content" placeholder="댓글을 입력하세요">
					<input type="submit" value="등록"/>
					<input type="hidden" name="_method" value="post"/>
					<input type="hidden" name="pid" value="${post.postId}"/>
				</form>
			</td>
		</tr>
		<c:forEach var="c" items="${comment}">
		<tr>
			<td>${c.ecoerId}</td>
			<td class="align_right">
				<!-- input type="button" value="수정" -->
				<form name="comment_delete" action="<c:url value='/board/view'/>" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<input type="hidden" name="pid" value="${post.postId}"/>
					<input type="hidden" name="rid" value="${c.replyId}"/>
					${c.replyDate}&nbsp;
					<input type="submit" value="삭제"/>
					<input type="button" value="좋아요"/>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">${c.replyContent}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
