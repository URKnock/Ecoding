<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../view/header.jsp" %>

<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	
<title>로그인 화면</title> 
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

<style>

*{
	font-family: 'Nanum Gothic', sans-serif;
}
</style>

<script>
function login() {
	if (form.userId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}		
	form.submit();
}

function userCreate(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}
</script>
</head>
<body>
	<br>
	<!-- login form  -->
	<form name="form" method="POST" action="<c:url value='/user/login' />">
		<table style="width: 100%">
			<tr>
				<td width="20"></td>
				<td><b>로그인 화면</b><br>
				<br>
					<table>
						<tr>
							<td class="title">&nbsp;&nbsp;사용자 관리 - 로그인&nbsp;&nbsp;</td>
						</tr>
					</table> <!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 --> <c:if
						test="${loginFailed}">
						<br>
						<font color="red"><c:out value="${exception.getMessage()}" /></font>
						<br>
					</c:if> <br>
					<table class="uTable">
						<tr height="40">
							<td width="150" align="center" bgcolor="E6ECDE">사용자 ID</td>
							<td width="250" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="userId"></td>
						</tr>
						<tr height="40">
							<td width="150" align="center" bgcolor="E6ECDE">비밀번호</td>
							<td width="250" bgcolor="ffffff" style="padding-left: 10"><input
								type="password" style="width: 240" name="password"></td>
						</tr>
					</table> <br>
					<table style="width: 100%">
						<tr>
							<td align=left><input type="button" value="로그인"
								onClick="login()"> &nbsp; <input type="button"
								value="회원가입"
								onClick="userCreate(
								'<c:url value='/user/register'/>')">
							</td>
						</tr>
						<tr height="40">
							<td>(관리자 로그인: admin/admin)</td>
						</tr>
					</table></td>
			</tr>
			<tr height="100">
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>