<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../view/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후원 정보</title>
<style>
	.d {
		text-align:center;
		width:1000px;
		margin-left:auto;
		margin-right:auto;
	}
	table {
		margin-left:auto;
		margin-right:auto;
	}
	h5 {
		text-align:left;
		padding-left:20px;
	}
	hr {
		border:0;
		height:1px;
		background-color:#97e6e4;
	}
	.top {
	 	border-top:1px solid #6495ED;
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
	th {
		width:40%;
		text-align:center;
	}
	tr {
		height:35px;
	}
	.change {
		border:0;
		width:50px;
		height:25px;
		font-size:15px;
		font-weight:bold;
		color:white;
		background-color:#d2d2d2;
		border-radius:3px;
	}
	.change:hover {
		background-color:#6EDCDC;
	}
	.buttonTd {
		text-align:right;
		padding-right:20px;
	}
	#btn {
		text-align:right;
		padding-right:20px;
		padding-top:10px;
	}
	.delete {
		border:0;
		width:110px;
		height:30px;
		font-size:20px;
		font-weight:bold;
		color:#b3b3b3;
		background-color:white;
		border-radius:3px;
		border-bottom:1px solid #b3b3b3;
	}
	.delete:hover {
		color:white;
		background-color:#fa8c8c;
		border-bottom:0;
	}
</style>
<script>
function userRemove() {
	return confirm("정말로 탈퇴하시겠습니까? 탈퇴 후에는 복구할 수 없습니다.");		
}

function addUpdateForm() {
	
}
</script>
</head>
<body>
 	<div class="d">
 		<table style="width:900px">
 			<tr>
 				<td width="25%"><img src="image.jpg" width="150px" height="150px"></td>
 				<td style="font-size:30px;">${project.title}</td>
 				<td width="20%" style="text-align:left;">${project.creatorName}</td>
 		</table>
 		<hr>
 		<table style="width:800px;">
			<tr class="top">
				<td><h5>후원 정보</h5></td>
				<td class="buttonTd">
					<button class="change"
						onClick="location.href='<c:url value='/support/update/reward?supportId=${support.supportId}&projectId=${project.projectId}' />'">
						변경
					</button>
				</td>
			</tr>	
			<tr>
				<th>후원 번호</th>
				<td>${support.supportId}</td>
			</tr>
			<tr>
				<th>리워드</th>
				<td>${reward.name}</td>
			</tr>
			<tr>
				<th>리워드 정보</th>
				<td>${reward.rewardInfo}</td>
			</tr>
			<tr>
				<th>후원 금액</th>
				<td>${support.amount}</td>
			</tr>
			<tr class="top"><td colspan="2"><h5>후원자 정보</h5></td></tr>
			<tr>
				<th>이름</th>
				<td>${ecoer.name}</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${ecoer.phone}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${ecoer.email}</td>
			</tr>
			<tr class="top"><td colspan="2"><h5>배송지 정보</h5></td></tr>
			<tr>
				<th>우편번호</th>
				<td>${ecoer.code}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${ecoer.address}</td>
			</tr>
			<tr>
				<th>상세 주소</th>
				<td>${ecoer.detailAddress}</td>
			</tr>
			<tr class="top">
				<td><h5>결제 정보</h5></td>
				<td class="buttonTd">
					<button class="change"
						onClick="location.href='<c:url value='/support/update?supportId=${support.supportId}&projectId=${project.projectId}' />'">
						변경
					</button>
				</td>
			</tr>
			<tr>
				<th>결제 카드</th>
				<td>${support.bank}</td>
			</tr>
			<tr>
				<th>카드 번호</th>
				<td>${support.card}</td>
			</tr>
			<tr class="top">
				<td colspan="2" id="btn">
					<button class="delete" onClick="location.href='<c:url value='/support/delete?supportId=${support.supportId}' />'">
						후원 취소
					</button>
				</td>
			</tr>
		</table>
 	</div>
</body>
</html>