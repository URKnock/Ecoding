<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../view/header.jsp"%>

<html lang="ko-kr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원 가입</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>

</script>
</head>
<body>
	<div class="container">
		<br>
		<h4>가입이 완료되었습니다.</h4>
		<br>
		
		<div>
			<a href="<c:url value='/user/loginform' />" class="btn btn-link">로그인하기</a>
			<a href="<c:url value='../home/main' />" class="btn btn-link">돌아가기</a>
		</div>
		
	</div>
</body>
</html>