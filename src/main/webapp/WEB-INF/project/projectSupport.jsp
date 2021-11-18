<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.time.temporal.ChronoUnit, model.Project" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Support</title>
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
		<table border="1" style="width:1000">
			<tr>
				<td style="font-size:30pt">${project.title}</td>
				<td width="5%" style="text-align:center;">
					<img src="image.jpg" width="30" height="30"> <!-- 창작자 이미지 -> 후에 수정 ***-->
				</td>
				<td width="10%" style="text-align:center;">${projectDTO.creatorName}</td> <!-- 창작자 이름 -> DTO 생성해서 가져오기 -> 후에 수정 *** -->
				<td width="15%" style="text-align:center;">
					<c:forEach var="category" items="${project.category}">
						${hashTag}
					</c:forEach>
				</td> <!-- 카테고리 하나만? -> 후에 수정 *** -->
			</tr>
			<tr>
				<td colspan="4">
					<c:forEach var="hashTag" items="${project.hashTag}">
						${hashTag}
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<c:forEach var="ecoTag" items="${project.ecoTag}">
						${ecoTag}
					</c:forEach>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<table  border="1" style="width:1000; height:450; text-align:center;">
			<tr>
				<td width="55%">
					<img src="image.jpg" width="400" height="400"> <!-- 프로젝트 이미지 *** -->
				</td>
				<td>
					<button style="width:70; height:70;">찜</button>
					<button style="width:300; height:70;" type="button"
						onclick="location.href='<c:url value='/project/support' />'">프로젝트 후원하기</button>
					<br><br>
					<table border="1" style="width:380; height:160; text-align:center;">
						<tr>
							<td>모인 금액</td>
							<td>${project.currentPrice}원</td> <!-- 여기까지 수정함 -->
							<td style="color:red; font-weight:bold;">${projectDTO.pricePercent}%</td>
						</tr>
						<tr>
							<td>남은 시간</td>
							<td>${projectDTO.remainTime}원</td> <!-- DTO 묶을수도 -->
						</tr>
						<tr>
							<td>후원자</td> <!--DTO -->
							<td>${projectDTO.countSupporter}명</td>
						</tr>
					</table>
					<br>
					<table border="1" style="width:380; height:100; text-align:center;">
						<tr>
							<td>목표 금액</td>
							<td>${project.targetPrice}원</td>
						</tr>
						<tr>
							<td>펀딩 종료일</td>
							<td>${endDate}</td>
						</tr>
						<tr>
							<td>결제일</td>
							<td>${paymentDate}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<div>
			<h3>프로젝트 소개</h3>
			${porject.simpleInfo}<br>
			${porject.datailInfo}
		</div>
		<div>
			<h3>프로젝트 예산 사용</h3>
			${porject.planInfo}
		</div>
		<div>
			<h3>프로젝트 일정</h3>
			<table border="1" style="width:300; text-align:center;">
				<tr>
					<td>펀딩 예고</td>
					<td>21년9월20일</td>
				</tr>
				<tr>
					<td>펀딩 시작</td>
					<td>${porject.startDate}</td>
				</tr>
				<tr>
					<td>펀딩 종료</td>
					<td>${porject.endDate}</td>
				</tr>
				<tr>
					<td>결제</td>
					<td>${porject.paymentDate}</td>
				</tr>
				<tr>
					<td>배송</td>
					<td>${porject.deliverDate}</td>
				</tr>
			</table>
		</div>
		<div>
			<h3>교환 안내</h3>
			${porject.exchangeInfo}
		</div>
		<div>
			문의사항은 이메일 creator@dongduk.ac.kr로 문의
		<div>
		<div>
			<h3>공지사항</h3>
			<table border="1" style="width:800; text-align:center;">
				<c:forEach var="notice" items="${noticeList}">
					<tr><td>${notice}</td></tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div>
		<h4 style="text-align:left; padding-left:20;">다른 프로젝트 둘러보기</h4>
		<table border="1" style="width:800; height:180; text-align:center;">
			<tr>
				<td><img src="image.jpg" width="130" height="130"></td>
				<td><img src="image.jpg" width="130" height="130"></td>
				<td><img src="image.jpg" width="130" height="130"></td>
				<td><img src="image.jpg" width="130" height="130"></td>
			</tr>
			<tr>
				<td>프로젝트 이름</td>
				<td>프로젝트 이름</td>
				<td>프로젝트 이름</td>
				<td>프로젝트 이름</td>
			</tr>
		</table>
	</div>
</body>
</html>