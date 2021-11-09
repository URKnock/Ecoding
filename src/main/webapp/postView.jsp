<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="header.jsp" %>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/post.css'/>"/>
</head>
<body>
	<table id="post" align="center">
		<caption>
			<a href="">◀</a> &nbsp; 1 &nbsp; <a href="">▶</a>
		</caption>
		<tr>
			<td>제목</td>
			<td class="align_right">
				<input type="button" value="수정"/>
				<input type="button" value="삭제"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">게시글 정보</td>
		</tr>
		<tr>
			<td colspan="2">본문<br/><br/></td>
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
		<tr>
			<td>댓글 정보</td>
			<td class="align_right">
				<input type="button" value="수정"/>
				<input type="button" value="삭제"/>
				<input type="button" value="좋아요"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">댓글 본문</td>
		</tr>
	</table>
</body>
</html>
