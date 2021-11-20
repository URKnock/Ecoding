<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리워드 선택 - ${title}</title>
<style>
	div {
		text-align:center;
		width:1000px;
		margin-left:auto;
		margin-right:auto;
	}
	table {
		margin-left:auto;
		margin-right:auto;
	}
	h3 {
		text-align:left;
		padding-left:20px;
	}
	table {
		width:800px;
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
<div>
	<h3>후원선택</h3>
	<form action="<c:url value='/project/support/confirm?projectId=${projectId}' />" method="POST"> <!-- ?projectId=${projectId} -->
	<table>
		<tr style="height:100px;">
			<td width="300px" style="border-bottom:1px solid #6495ED;">
				<input type="radio" name="reward" value="0">
				후원만 하기<br>
				- 작품 없음
			</td>
			<td rowspan="3" style="border-left:1px solid #6495ED; border-bottom:1px solid #6495ED;">
				<h2 style="text-align:left; padding-left:20px;">선택한 옵션</h2>
				<h4 style="text-align:left; padding-left:20px;">추가 금액 후원하기</h4>
				<input type="text" name="addPrice" value="0"><br>
				<br>
				<input id="support" type="submit" name="support" value="후원하기">
			</td>
		</tr>
		<c:forEach var="reward" items="${rewardList}">
			<tr style="height:100px;">
				<td style="border-bottom:1px solid #6495ED;">
					<input type="radio" name="reward" value="${reward.rewardId}">
					${reward.name}<br>
					${reward.rewardInfo}<br>
				</td>
			</tr>
		</c:forEach>
	</table>
	</form>
</div>
</body>
</html>