<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Project Support Form</title>
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
				<td style="font-size:30pt">프로젝트 이름</td>
				<td width="5%" style="text-align:center;">
					<img src="image.jpg" width="30" height="30">
				</td>
				<td width="10%" style="text-align:center;">창작자</td>
				<td width="15%" style="text-align:center;">카테고리</td>
			</tr>
			<tr>
				<td colspan="4">#해시태그</td>
			</tr>
		</table>
	</div>
	<div>
		<table  border="1" style="width:1000; height:450; text-align:center;">
			<tr>
				<td width="55%">
					<img src="image.jpg" width="400" height="400">
				</td>
				<td>
					<button style="width:70; height:70;">찜</button>
					<button style="width:300; height:70;" type="button"
						onclick="location.href='<c:url value='/project/support' />'">프로젝트 후원하기</button>
					<br><br>
					<table border="1" style="width:380; height:160; text-align:center;">
						<tr>
							<td>모인 금액</td>
							<td>10,000,000원</td>
							<td style="color:red; font-weight:bold;">120%</td>
						</tr>
						<tr>
							<td>남은 시간</td>
							<td>30일</td>
						</tr>
						<tr>
							<td>후원자</td>
							<td>300명</td>
						</tr>
					</table>
					<br>
					<table border="1" style="width:380; height:100; text-align:center;">
						<tr>
							<td>목표 금액</td>
							<td>8,000,000원</td>
						</tr>
						<tr>
							<td>펀딩 종료일</td>
							<td>21년 10월 31일</td>
						</tr>
						<tr>
							<td>결제일</td>
							<td>21년 11월 1일</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<div>
			<h3>프로젝트 소개</h3>
			프로젝트 정보
		</div>
		<div>
			<h3>프로젝트 예산 사용</h3>
			예산 사용 내역
		</div>
		<div>
			<h3>프로젝트 일정</h3>
			<table border="1" style="width:300; text-align:center;">
				<tr>
					<td>펀딩 예고</td>
					<td>21년 9월 18일</td>
				</tr>
				<tr>
					<td>펀딩 시작</td>
					<td>21년 10월 1일</td>
				</tr>
				<tr>
					<td>펀딩 종료</td>
					<td>21년 10월 31일</td>
				</tr>
				<tr>
					<td>결제</td>
					<td>21년 11월 1일</td>
				</tr>
				<tr>
					<td>배송</td>
					<td>21년 21월 17일</td>
				</tr>
			</table>
		</div>
		<div>
			<h3>교환 안내</h3>
			교환 관련 내용
		</div>
		<div>
			문의사항은 이메일 creator@dongduk.ac.kr로 문의
		<div>
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