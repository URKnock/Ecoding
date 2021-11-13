<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	div {
		border:1px black solid;
		text-align:center;
		width:1000;
		margin-left:auto;
		margin-right:auto;
	}
	table {
		border:1px black solid;
		margin-left:auto;
		margin-right:auto;
		text-align:center;
	}
	h4 {
		text-align:left;
		padding-left:20;
	}
</style>
</head>
<body>
	<div>
		<table border="1" style="width:1000">
			<tr>
				<td width="25%">
					<img src="image.jpg" width="150" height="150">
				</td>
				<td style="font-size:20pt">프로젝트 이름</td>
				<td width="5%" style="text-align:center;">
					<img src="image.jpg" width="30" height="30">
				</td>
				<td width="20%" style="text-align:left;">창작자</td>
			</tr>
		</table>
	</div>
	<div>	
	<form action="<c:url value='/project/support/complete' />" method="POST">
		<table border="1" style="width:1000">
			<tr>
				<td style="width:55%">
					<h4>후원정보</h4>
					<table style="width:480; height:100;">
						<tr>
							<td>옵션 종류</td>
							<td><button type="button" onclick="location.href='projectSupportForm.html'">
									변경
							</button></td>
						</tr>
						<tr>
							<td>후원금액 + 추가 후원 금액 =</td>
							<td style="font-weight:bold">최종 금액</td>
						</tr>
					</table>
				</td>
				<td rowspan="4">
					<table style="width:400; height:200;">
						<tr>
							<td>최종 후원 금액</td>
							<td style="font-weight:bold">80,000원</td>
						</tr>
						<tr>
							<td colspan="2">
								프로젝트 목표 달성 시, 21년 11월 1일에 결제됩니다.<br>
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
								<input type="submit" value="후원하기" style="width:380; height:50;">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h4>후원자 정보</h4>
					<table style="width:480; height:100;">
						<tr>
							<td>이름</td>
							<td>김솜솜</td>
						</tr>
						<tr>
							<td>연락처</td>
							<td>010-1234-5678</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>somsom@dongduk.ac.kr</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h4>배송지 정보</h4>
					<table style="width:480; height:100;">
						<tr>
							<td>우편번호</td>
							<td>02748</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>서울시 성북고 화랑로 13길 60</td>
						</tr>
						<tr>
							<td>상세 주소</td>
							<td>동덕여자대학교 인문관 B312호</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h4>결제 수단</h4>
					<table style="width:480; height:100;">
						<tr>
							<td>카드</td>
							<td><input type="text" size="10"></td>
						</tr>
						<tr>
							<td>카드 번호</td>
							<td><input type="text" size="20"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
	</form>	
	</div>
</body>
</html>