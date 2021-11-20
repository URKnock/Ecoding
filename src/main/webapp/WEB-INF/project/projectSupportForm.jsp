<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Support Option Form</title>
<style>
	div {
		border:1px black solid;
		text-align:center;
		width:1000;
		margin-left:auto;
		margin-right:auto;
	}
	table {
		margin-left:auto;
		margin-right:auto;
	}
	h3 {
		text-align:left;
		padding-left:20;
	}
</style>
</head>
<body>
<div>
	<h3>후원선택</h3>
	<form action="<c:url value='/project/support/confirm?projectId=${projectId}' />" method="POST"> <!-- ?projectId=${projectId} -->
	<table border="1" style="width:800; text-align:center;">
		<tr style="height:100;">
			<td width="300">
				<input type="radio" name="reward" value="0">
				후원만 하기<br>
				- 작품 없음
			</td>
		</tr>
		<c:forEach var="reward" items="${rewardList}">
			<tr style="height:100;">
				<td>
					<input type="radio" name="reward" value="${reward.rewardId}">
					${reward.name}<br>
					${reward.rewardInfo}<br>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<h2 style="text-align:left; padding-left:10;">선택한 옵션</h2>
				<h4 style="text-align:left; padding-left:10;">추가 금액 후원하기</h4>
				<input type="text" name="addPrice" value="0" style="width:90%; height:50;"><br>
				<br>
				<input type="submit" name="support" value="후원하기" style="width:90%; height:50;">
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>