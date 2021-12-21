<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.time.temporal.ChronoUnit, model.Project" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../view/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${project.title}</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/projectSupportView.css'/>"/>
<script>
	var ecoerId = '<%=session.getAttribute("ecoerId")%>';
	function support() {
		if (ecoerId == 'null') {
			location.href="<c:url value='/user/loginform' />";
		} else {
			location.href="<c:url value='/project/support?projectId=${project.projectId}' />";
		}
	}
	function interest() {
		if (ecoerId == 'null') {
			location.href="<c:url value='/user/loginform' />";
		} else {
			location.href="<c:url value='/project/interest?projectId=${project.projectId}' />";
		}
	}
	function notice() {
		if(confirm('현재 존재하지 않는 프로젝트입니다.')) {
			location.href = "<c:url value='/home/main'/>"
		} else {
			location.href = "<c:url value='/home/main'/>"	
		}
	}	
</script>
</head>
<body>
	<c:if test="${no_project ne null}">
		<script type="text/javascript">
			notice();
		</script>
	</c:if>
	<div class="d">
		<table style="width:1000px">
			<tr>
				<td style="font-size:30pt">${project.title}</td>
				<td width="5%" style="text-align:center;">
					<img src="<c:url value='/upload/${projectDTO.creatorImage}' />" width="30px" height="30px"> <!-- 창작자 이미지 -> 후에 수정 ***-->
				</td>
				<td width="10%" style="text-align:center;">${projectDTO.creatorName}</td>
				<td width="15%" style="text-align:right;">${project.category}</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:left; padding-left:150px;">
					<c:forEach var="hashTag" items="${project.hashTag}">
						#${hashTag}
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:left; padding-left:150px;">
					<c:forEach var="ecoTag" items="${project.ecoTag}">
						#${ecoTag}
					</c:forEach>
				</td>
			</tr>
		</table>
	</div>
	<hr>
	<div class="d">
		<table style="width:1000px; height:450px; text-align:center;">
			<tr>
				<td width="55%">
					<img src="<c:url value='/upload/${project.image}' />" width="400px" height="400px"> <!-- 프로젝트 이미지 *** -->
				</td>
				<td>
					<c:if test="${isInterest eq 'false'}">
						<button id="noInterest" type="button" onclick="interest();">&#10084;</button>
					</c:if>
					<c:if test="${isInterest eq 'true'}">
						<button id="interest" type="button" onclick="interest();">&#10084;</button>
					</c:if>
					<c:if test="${isSupport eq 'false'}">
						<button id="support" type="button" onclick="support();">프로젝트 후원하기</button>
					</c:if>
					<c:if test="${isSupport eq 'true'}">
						<button id="supportDone" type="button">후원 완료</button>
					</c:if>
					<br><br>
					<table id="t1" style="width:380px; height:160px; text-align:center;">
						<tr>
							<td>모인 금액</td>
							<td>${project.currentPrice}원</td>
							<td style="color:red; font-weight:bold;">${projectDTO.pricePercent}%</td>
						</tr>
						<tr>
							<td>남은 시간</td>
							<td>${projectDTO.remainTime}일</td>
						</tr>
						<tr>
							<td>후원자</td>
							<td>${projectDTO.countSupporter}명</td>
						</tr>
					</table>
					&nbsp;
					<table id="t2">
						<tr>
							<td>목표 금액</td>
							<td>${project.targetPrice}원</td>
						</tr>
						<tr>
							<td>펀딩 종료일</td>
							<td>${project.endDate}</td>
						</tr>
						<tr>
							<td>결제일</td>
							<td>${project.paymentDate}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<hr>
	<div class="d">
		<div class="d">
			<h3>프로젝트 소개</h3>
			${project.simpleInfo}<br>
			${project.detailInfo}
		</div>
		<div class="d">
			<h3>프로젝트 예산 사용</h3>
			${project.planInfo}
		</div>
		<div class="d">
			<h3>프로젝트 일정</h3>
			<table id="t3">
				<!-- <tr>
					<td>펀딩 예고</td>
					<td>21년9월20일</td>
				</tr>-->
				<tr>
					<td>펀딩 시작</td>
					<td>${project.startDate}</td>
				</tr>
				<tr>
					<td>펀딩 종료</td>
					<td>${project.endDate}</td>
				</tr>
				<tr>
					<td>결제</td>
					<td>${project.paymentDate}</td>
				</tr>
				<tr>
					<td>배송</td>
					<td>${project.deliveryDate}</td>
				</tr>
			</table>
		</div>
		<div class="d">
			<h3>교환 안내</h3>
			${project.exchangeInfo}
		</div>
		<div class="d">
			문의사항은 이메일 ${projectDTO.creatorEmail}로 문의
		</div>
		<div class="d">
			<h3>공지사항</h3>
			<table id="t4">
				<c:forEach var="notice" items="${noticeList}">
					<tr><td>${notice.noticeContent}</td></tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<hr>
	<div class="d">
		<h4 style="text-align:left; padding-left:20px; font-size:20px;">다른 프로젝트 둘러보기</h4>
		<table style="width:800px; height:180px; text-align:center;">
			<tr>
				<td><img src="image.jpg" width="130px" height="130px"></td>
				<td><img src="image.jpg" width="130px" height="130px"></td>
				<td><img src="image.jpg" width="130px" height="130px"></td>
				<td><img src="image.jpg" width="130px" height="130px"></td>
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