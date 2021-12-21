<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../view/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 정보 수정</title>
<style>
	.d {
		text-align:center;
		width:1000px;
		margin-left:auto;
		margin-right:auto;
	}
	.t {
		width:500px;
		margin-left:auto;
		margin-right:auto;
		border-top:1px solid #6495ED;
		border-bottom:1px solid #6495ED;
	}
	tr {
		height:35px;
	}
	th {
		width:40%;
		text-align:center;
	}
	#btn {
		text-align:right;
		padding-right:20px;
	}
	h5 {
		text-align:left;
		padding-left:20px;
	}
	#change {
		border:0;
		width:80px;
		height:30px;
		font-size:15px;
		font-weight:bold;
		color:white;
		background-color:#87e2f5;
		border-radius:5px;
	}
	#change:hover {
		background-color:#70b3ff;
	}
</style>
</head>
<body>
<div class="d">
	<form action="<c:url value='/support/update?projectId=${projectId}' />" method="POST">
	<table class="t">
		<tr class="top">
			<td colspan="2"><h5>결제 정보 수정</h5></td>
		</tr>
		<tr>
			<th>결제 카드</th>
			<td><input type="text" name="bank" size="10px" required></td>
		</tr>
		<tr>
			<th>카드 번호</th>
			<td><input type="text" name="card" size="20px" required></td>
		</tr>
		<tr>
			<td colspan="2" id="btn"><input id="change" type="submit" value="변경하기"></td>
		</tr>
	</table>
	<input type="hidden" name="supportId" value="${supportId}" />
	</form>
</div>
</body>
</html>