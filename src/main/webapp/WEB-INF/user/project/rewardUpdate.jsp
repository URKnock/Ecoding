<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../view/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리워드 변경</title>
<style>
	.d {
		text-align:center;
		width:1000px;
		margin-left:auto;
		margin-right:auto;
	}
	.t {
		margin-left:auto;
		margin-right:auto;
	}
	h3 {
		text-align:left;
		padding-left:20px;
	}
	.t {
		width:500px;
		text-align:center;
	 	border-top:0.5px solid #6495ED;
	 	border-collapse:collapse;
	}
	#support {
		border:0;
		width:90%;
		height:50px;
		font-size:18px;
		font-weight:bold;
		color:white;
		background-color:#87e2f5;
		border-radius:5px;
	}
	#support:hover {
		background-color:#70b3ff;
	}
	input[type=text] {
		width:85%;
		height:40px;
		text-align:right;
		font-size:15pt;
		padding-right:20px;
		border:none;
		border-bottom:3px solid #96D5D7;
	}
</style>
</head>
<body>
<div class="d">
	<h3>리워드 변경</h3>
	<form action="<c:url value='/support/update/reward?projectId=${projectId}' />" method="POST">
	<table class="t">
		<c:forEach var="reward" items="${rewardList}">
			<tr style="height:150px;">
				<td style="border-bottom:1px solid #6495ED;">
					<input type="radio" name="reward" value="${reward.rewardId}" required>
					${reward.name}<br>
					- ${reward.rewardPrice}원<br>
					- ${reward.rewardInfo}<br>
				</td>
			</tr>
		</c:forEach>
		<tr style="height:100px;">
			<td>
				<h2 style="text-align:left; padding-left:20px;">선택한 옵션</h2>
				<h4 style="text-align:left; padding-left:20px;">추가 금액 후원하기</h4>
				<input type="text" name="addPrice" value="0" required><br>
				<br>
				<input id="support" type="submit" name="support" value="리워드 변경">
			</td>
		</tr>
	</table>
	<input type="hidden" name="supportId" value="${supportId}">
	</form>
</div>
</body>
</html>