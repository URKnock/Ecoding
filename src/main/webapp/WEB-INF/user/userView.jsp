<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../view/header.jsp"%>

<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>사용자 관리 - 정보 조회</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
function userRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
</script>
</head>
<body>

	<div class="container">
		<br>
		<h4>사용자 정보 조회</h4>
		<br>
		<table class="table table-sm table-striped">
			<tbody>
				<tr>
					<th>사용자 ID</th>
					<td>${ecoer.ecoerId}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${ecoer.name}</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${ecoer.phone}</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${ecoer.address}</td>
				</tr>
				<tr>
					<th>이메일 주소</th>
					<td>${ecoer.email}</td>
				</tr>
			</tbody>
		</table>
		<br> <a class="btn btn-primary"
			href="<c:url value='/user/update' >
     		     <c:param name='ecoerId' value='${ecoer.ecoerId}'/>
		 	  </c:url>">수정</a>
		<a class="btn btn-warning"
			href="<c:url value='/user/delete'>
		     	 <c:param name='ecoerId' value='${ecoer.ecoerId}'/>
	 	      </c:url>"
			onclick="return userRemove();">삭제</a><br>

		<!-- 수정 또는 삭제가  실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
		<c:if test="${updateFailed || deleteFailed}">
			<h6 class="text-danger">
				<c:out value="${exception.getMessage()}" />
			</h6>
		</c:if>
	</div>
</body>
</html>