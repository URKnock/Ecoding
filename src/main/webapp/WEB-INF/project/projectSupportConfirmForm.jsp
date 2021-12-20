<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후원 확인 - ${project.title}</title>
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
		text-align:center;
	}
	h4 {
		text-align:left;
		padding-left:20px;
	}
	hr {
		border:0;
		height:1px;
		background-color:#97e6e4;
	}
	.t {
		height:100px;
		text-align:center;
		width:480px;
	 	border-top:1px solid #6495ED;
	 	border-bottom:1px solid #6495ED;
	}
	#support {
		height:50px;
		border:0;
		width:380px;
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
	#change {
		width:50px;
		height:25px;
		border:0;
		color:white;
		background-color:#d2d2d2;
		border-radius:3px;
	}
	#change:hover {
		background-color:#6EDCDC;
	}
</style>
</head>
<body>
	<div>
		<table style="width:1000px">
			<tr>
				<td width="25%">
					<img src="image.jpg" width="150px" height="150px">
				</td>
				<td style="font-size:20pt">${project.title}</td>
				<td width="5%" style="text-align:center;">
					<img src="${dir}/${project.image}" width="30px" height="30px"> <!-- 이미지 수정 **** -->
				</td>
				<td width="20%" style="text-align:left;">${project.creatorName}</td>
			</tr>
		</table>
	</div>
	<hr>
	<div>	
	<form action="<c:url value='/project/support/complete' />" method="POST">
		<table style="width:1000px">
			<tr>
				<td style="width:55%">
					<h4>후원정보</h4>
					<table class="t" style="width:480px; height:100px;">
						<tr>
							<td>${reward.name}</td>
							<td><button id="change" type="button" onclick="location.href='<c:url value='/project/support?projectId=${project.projectId}' />'">
									변경
							</button></td>
						</tr>
						<tr>
							<td>${reward.rewardPrice} + ${add} =</td>
							<td style="font-weight:bold">${reward.rewardPrice + add}</td>
						</tr>
					</table>
				</td>
				<td rowspan="4">
					<table style="width:450px; height:220px; border-left:3px solid #6495ED;">
						<tr>
							<td>최종 후원 금액</td>
							<td style="font-weight:bold">${reward.rewardPrice + add}원</td>
						</tr>
						<tr>
							<td colspan="2">
								프로젝트 목표 달성 시, ${project.paymentDate}에 결제됩니다.<br>
								프로젝트가 무산될 경우 결제는 자동으로 취소됩니다.
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="radio"> 개인정보 제 3자 제공 동의
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input id="support" type="submit" value="후원하기">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h4>후원자 정보</h4>
					<table class="t">
						<tr>
							<td>이름</td>
							<td>${ecoer.name}</td>
						</tr>
						<tr>
							<td>연락처</td>
							<td>${ecoer.phone}</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>${ecoer.email}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h4>배송지 정보</h4>
					<table class="t">
						<tr>
							<td>우편번호</td>
							<td>${ecoer.code}</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>${ecoer.address}</td>
						</tr>
						<tr>
							<td>상세 주소</td>
							<td>${ecoer.detailAddress}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h4>결제 수단</h4>
					<table class="t">
						<tr>
							<td>카드</td>
							<td><input type="text" name="bank" size="10px"></td>
						</tr>
						<tr>
							<td>카드 번호</td>
							<td><input type="text" name="card" size="20px"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<input type="hidden" id="ecoerId" name="ecoerId" value="${ecoer.ecoerId}" />
		<input type="hidden" id="projectId" name="projectId" value="${project.projectId}" />
		<input type="hidden" id="rewardId" name="rewardId" value="${reward.rewardId}" />
		<input type="hidden" id="amount" name="amount" value="${reward.rewardPrice + add}" />
	</form>	
	</div>
</body>
</html>