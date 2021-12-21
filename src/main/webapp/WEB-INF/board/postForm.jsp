<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<%@ include file="../view/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/post.css'/>"/>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script>
	$(document).ready(function() {
		$('#summernote').summernote({lang: 'ko-KR', minHeight: 500, maxHeight: null});
	});
	function submitPost() {
		var content = $('#summernote').summernote('code');
		document.forms['post']['post_content'].value = content;
		return true;
	}
</script>
</head>
<body>
	<form id="post" name="post" method="post" action="<c:url value='/board/create'/>" onSubmit="submitPost();">
	<table id="posting" align="center">
		<tr>
			<td></td>
			<td class="align_right">
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="reset" class="btn btn-outline-primary" onClick="location.href='<c:url value='/board/list'/>';">취소</button>
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
			<td>관련 프로젝트:
				<select name="project_info">
					<option value="null">없음</option>
					<c:forEach var="p" items="${projectList}">
						<option value="${p.projectId}:${p.title}">${p.title}</option>
					</c:forEach>
				</select>
			</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="summernote"></div><br/>
				<input type="hidden" name="post_content"/>
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>