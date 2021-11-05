<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="header.jsp" %>
	<!-- link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css" -->
	<style type="text/css">
		.left {
			float: left;
		}
		.right {
		 	float: right;
		}
		.clear {
			clear: both;
		}
		#communitys div {
			margin-left:25px;
			margin-bottom:50px;
		}
		td {
			padding-left:40px;
			padding-right:40px;
			padding-bottom:40px;
		}
		caption {
			padding: 10px;
			caption-side:bottom;
		}
		form {
			text-align:right;
		}
	</style>
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
		</form>
		<br/>
	<table>
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
			<td>1</td>
			<td>1</td>
			<td>1</td>
			<td>1</td>
			<td>1</td>
			<td>1</td>
		</tr>
		<tr>
			<td>2</td>
			<td>2</td>
			<td>2</td>
			<td>2</td>
			<td>2</td>
			<td>2</td>
		</tr>
	</table>
	</div>
</body>
</html>