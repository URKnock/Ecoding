<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글</title>
	<%@ include file="../view/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/post.css'/>"/>
	<script type="text/javascript">
		function move() { location.href="<c:url value='/board/delete?pid=${post.postId}'/>"; }
	</script>
</head>
<body>
	<table id="post" align="center" cellpadding="5px">
		<tr>
			<td><h2>${post.title}</h2></td>
			<td class="align_right">
				<!-- input type="button" value="수정"/ -->
				<!-- input type="button" value="삭제" onClick="move();"/-->
				<button type="button" class="btn btn-outline-primary" onClick="move();">삭제</button>
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
				<button type="button" class="btn btn-outline-primary">좋아요</button>
				<button type="button" class="btn btn-outline-primary">신고</button>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<form name="comment" action="<c:url value='/board/view'/>" method="post">
					<input type="text" name="reply_content" placeholder="댓글을 입력하세요">
					<button type="submit" class="btn btn-primary">등록</button>
					<input type="hidden" name="_method" value="post"/>
					<input type="hidden" name="pid" value="${post.postId}"/>
				</form>
			</td>
		</tr>
		<c:forEach var="c" items="${comment}">
		<tr>
			<td><b>${c.ecoerId}</b></td>
			<td class="align_right">
				<!-- input type="button" value="수정" -->
				<form name="comment_delete" action="<c:url value='/board/view'/>" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<input type="hidden" name="pid" value="${post.postId}"/>
					<input type="hidden" name="rid" value="${c.replyId}"/>
					${c.replyDate}&nbsp;
					<button type="submit" class="btn btn-outline-primary">삭제</button>
					<button type="button" class="btn btn-outline-primary">좋아요</button>
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
