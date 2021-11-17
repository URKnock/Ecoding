<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../view/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/post.css'/>"/>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
	<form name="post" method="post" action="<c:url value='/board/view'/>">
	<table id="posting" align="center">
		<tr>
			<td></td>
			<td>
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
			<td><input type="file" name="file" value="파일첨부"/></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="summernote"></div>
			  	<script>
				    $(document).ready(function() {
				        $('#summernote').summernote();
				    });
			 	 </script>
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>