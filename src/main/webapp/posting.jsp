<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="header.jsp" %>
	
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

	<style type="text/css">
		table {
			width: 80%;
			text-align: right;
		}
		form[name=post] input[type=text] {
			width: 100%;
		}
	</style>
</head>
<body>
	<form name="post" method="post" action="">
	<table align="center">
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