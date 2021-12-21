<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../view/header.jsp"%>

<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>사용자 관리 - 회원 정보 수정</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
function userModify() {
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
	//var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/; ==> 정규식 X
	//if(phoneExp.test(form.phone.value)==false) {
	//	alert("전화번호 형식이 올바르지 않습니다.");
	//	form.phone.focus();
	//	return false;
	//}
	form.submit();
}
</script>
</head>
<body>
	<div class="container">
		<br>
		<h4>회원 정보 수정</h4>
		<br>
		<!-- Update Form  -->
		<form name="form" method="POST"
			action="<c:url value='../user/update' />">
			<input type="hidden" name="ecoerId" value="${ecoer.ecoerId}" />
			<div class="form-group row">
				<label class="col-lg-2 col-form-label">사용자 ID</label>
				<div class="col-lg-10">
					<p class="form-control-static">${ecoer.ecoerId}</p>
				</div>
			</div>
			<div class="form-group row">
				<label for="password" class="col-lg-2 col-form-label">비밀번호</label>
				<div class="col-lg-10">
					<input type="password" name="password" class="form-control"
						value="${ecoer.password}">
				</div>
			</div>
			<div class="form-group row">
				<label for="password2" class="col-lg-2 col-form-label">비밀번호
					확인</label>
				<div class="col-lg-10">
					<input type="password" name="password2" class="form-control"
						value="${ecoer.password}">
				</div>
			</div>
			<div class="form-group row">
				<label for="name" class="col-lg-2 col-form-label">이름</label>
				<div class="col-lg-10">
					<input type="text" name="name" class="form-control"
						value="${ecoer.name}">
				</div>
			</div>
			<div class="form-group row">
				<label for="phone" class="col-lg-2 col-form-label">전화번호</label>
				<div class="col-lg-10">
					<input type="text" name="phone" class="form-control"
						value="${ecoer.phone}">
				</div>
			</div>
			<div class="form-group row">
				<label for="code" class="col-lg-2 col-form-label">우편번호</label>
				<div class="col-lg-10">
					<input type="text" name="code" class="form-control"
						value="${ecoer.code}">
				</div>
			</div>
			<div class="form-group row">
				<label for="address" class="col-lg-2 col-form-label">주소</label>
				<div class="col-lg-10">
					<input type="text" name="address" class="form-control"
						value="${ecoer.address}">
				</div>
			</div>
			<div class="form-group row">
				<label for="detailAddress" class="col-lg-2 col-form-label">상세주소</label>
				<div class="col-lg-10">
					<input type="text" name="detailAddress" class="form-control"
						value="${ecoer.detailAddress}">
				</div>
			</div>
			<div class="form-group row">
				<label for="email" class="col-lg-2 col-form-label">이메일 주소</label>
				<div class="col-lg-10">
					<input type="text" name="email" class="form-control"
						value="${ecoer.email}">
				</div>
			</div>
			<input type="hidden" name="isCreator" value="${ecoer.isCreator}">
			<c:if test="${ecoer.isCreator}">
				<div class="form-group row">
					<label for="email" class="col-lg-2 col-form-label">창작자명</label>
					<div class="col-lg-10">
						<input type="text" name="teamName" class="form-control"
							value="${creator.nickName}">
					</div>
				</div>
				<div class="form-group row">
					<label for="email" class="col-lg-2 col-form-label">창작자 정보</label>
					<div class="col-lg-10">
						<input type="text" name="teamInfo" class="form-control"
							value="${creator.creatorInfo}">
					</div>
				</div>
				<div class="form-group row">
					<label for="email" class="col-lg-2 col-form-label">창작자 계좌</label>
					<div class="col-lg-10">
						<input type="text" name="account" class="form-control"
							value="${creator.account}">
					</div>
				</div>
				창작자 이미지 수정은 프로젝트 수정 Step3에서 가능합니다.<p>
				<input type="hidden" name="teamImage" value="${creator.image}">
			</c:if>
			
			<br>
			<div class="form-group">
				<input type="button" class="btn btn-primary" value="수정"
					onClick="userModify()"> <a
					href="<c:url value='../user/view'>
					   <c:param name='ecoerId' value='${ecoerId}'/>
			 		 </c:url>" class="btn btn-link">돌아가기
				</a>
			</div>
		</form>
	</div>
</body>
</html>