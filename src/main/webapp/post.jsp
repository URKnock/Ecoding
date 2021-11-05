<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="header.jsp" %>
	<style type="text/css">
		table {
			width: 80%;
		}
		td {
			height: 30px;
		}
		form[name=post] input[type=text] {
			width: 100%;
		}
		caption {
			padding: 10px;
			caption-side:bottom;
		}
		.align_right {
			text-align:right;
		}
		form[name=comment] input[type=text] {
			width:90%;
		}
	</style>
</head>
<body>
	<table align="center">
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
