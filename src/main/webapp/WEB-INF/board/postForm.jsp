<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../view/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/post.css'/>"/>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script>
	$(document).ready(function() {
		$('#summernote').summernote({lang: 'ko-KR', minHeight: 500, maxHeight: null});
		$('#post').onSubmit = function() {
			request.setAttribute("post_content", $('#summernote').summernote('code'));
			$('#summernote').summernote('destroy');
			return true;
		}
	});
</script>
</head>
<body>
	<form id="post" name="post" method="post" action="<c:url value='/board/create'/>">
	<table id="posting" align="center">
		<tr>
			<td></td>
			<td class="align_right">
				<input type="submit" value="등록"/>
				<input type="reset" value="취소"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="text" name="title"/>
			</td>
		</tr>
		<tr>
			<td>게시판:
				<select name="community_id">
					<option value="0">자유게시판</option>
					<option value="1">후기게시판</option>
				</select>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>파일첨부: <input type="file" name="post_file"/></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="summernote"></div>
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>