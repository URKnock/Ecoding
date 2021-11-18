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
	
<title>사용자 등록</title> 
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<style>
*{
	font-family: 'Nanum Gothic', sans-serif;
}
</style>

<script>
function userCreate() {
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
	if (form.password.value != form.password2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.name.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.email.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if(phoneExp.test(form.phone.value)==false) {
		alert("전화번호 형식이 올바르지 않습니다.");
		form.phone.focus();
		return false;
	}
	form.submit();
}
</script>
<script>

/*
$(document).ready(function() {	
	// Ajax를 통해 커뮤니티 목록 정보를 요청 (jQuery 이용)
	$.ajax({			// 비동기적인 Ajax request 발생 및 결과 처리
		type: "GET",
		url: "<c:url value='/community/list/json'/>",
		cache: false,
		dataType: "json",	// 결과는 JSON 형식의 data (Console에 출력되는 log 참조)
		success:  function(commList) {  // 요청에 대한 응답 수신 시 호출되는 callback function
					// commList는 JSON text로부터 생성된 JS 객체						
			// 전송된 커뮤니티 목록 정보를 이용하여 Select 메뉴 생성
			$("#commSelect").empty().append("<option value='0'>없음</option>");
			for (var i = 0; i < commList.length; i++) {				
				$("#commSelect").append(document.createElement("option"));	
				$("#commSelect option:last-child").attr("value", commList[i].id);	
				$("#commSelect option:last-child").append(commList[i].name);
			}	
		},
		error: function(jqXHR, textStatus, errorThrown) {
			var message = jqXHR.getResponseHeader("Status");
			if ((message == null) || (message.length <= 0)) {
				alert("Error! Request status is " + jqXHR.status);
			} else {
				alert(message);	
			}
		}
	});
});

var request = new XMLHttpRequest();

function getCommunityList() {
	// Ajax를 이용하여 커뮤니티 목록 정보를 요청
	request.open("GET", "${pageContext.request.contextPath}/community/list/json?t=" + new Date().getTime(), true);
	request.onreadystatechange = showCommunityList;
	request.send(null);
}

function showCommunityList() {
	// 전송된 커뮤니티 목록 정보를 이용하여 Select 메뉴 생성
	if (request.readyState == 4 && request.status == 200) {
		// Get the response from the server 
		var commList = JSON.parse(request.responseText);
		var select = document.getElementById("commSelect");
		var i;
		for (i = 0; i < commList.length; i++) {				
			var option = document.createElement("option");
			option.setAttribute("value", commList[i].id)
			var name = document.createTextNode(commList[i].name);
			option.appendChild(name);
			select.appendChild(option);			    	
		}				 
	}
}
*/

</script>
</head>
<body>
	<!-- onload="getCommunityList()"> --> <!-- 필요 없어서 제외시킴 -->
	<br>
	<!-- registration form  -->
	<form name="form" method="POST"
		action="<c:url value='/user/register' />">
		<table style="width: 100%">
			<tr>
				<td width="20"></td>
				<td>
					<table>
						<tr>
							<td class="title">&nbsp;&nbsp;<b>사용자 관리 - 회원 가입</b>&nbsp;&nbsp;
							</td>
						</tr>
					</table> <!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 --> <c:if
						test="${registerFailed}">
						<font color="red"><c:out value="${exception.getMessage()}" /></font>
					</c:if> <br>
					<table class="uTable">
						<tr height="40">
							<td width="150" align="center" bgcolor="E6ECDE">사용자 ID</td>
							<td width="250" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240;" name="userId">
								<span style="color:red; font-size: 10px;"> 필수</span></td>
						</tr>
						<tr height="40">
							<td width="150" align="center" bgcolor="E6ECDE">비밀번호</td>
							<td width="250" bgcolor="ffffff" style="padding-left: 10"><input
								type="password" style="width: 240" name="password">
								<span style="color:red; font-size: 10px;"> 필수</span></td>
						</tr>
						<tr height="40">
							<td width="150" align="center" bgcolor="E6ECDE">비밀번호 확인</td>
							<td width="250" bgcolor="ffffff" style="padding-left: 10"><input
								type="password" style="width: 240" name="password2"></td>
						</tr>
						<tr height="40">
							<td width="150" align="center" bgcolor="E6ECDE">이름</td>
							<td width="250" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="name"
								<c:if test="${registerFailed}">value="${user.name}"</c:if>>
							</td>
						</tr>
						<tr height="40">
							<td width="150" align="center" bgcolor="E6ECDE">전화번호</td>
							<td width="250" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="phone"
								<c:if test="${registerFailed}">value="${user.phone}"</c:if>>
							</td>
						</tr>
						<tr height="40">
							<td width="150" align="center" bgcolor="E6ECDE">주소</td>
							<td width="250" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="address"
								<c:if test="${registerFailed}">value="${user.address}"</c:if>>
							</td>
						</tr>
						<tr height="40">
							<td width="150" align="center" bgcolor="E6ECDE">이메일 주소</td>
							<td width="250" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="email"
								<c:if test="${registerFailed}">value="${user.email}"</c:if>>
							</td>
						</tr>
						
					</table> <br>
					<table style="width: 100%">
						<tr>
							<td align="left"><input type="button" value="가입하기"
								onClick="userCreate()"> &nbsp; 
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>