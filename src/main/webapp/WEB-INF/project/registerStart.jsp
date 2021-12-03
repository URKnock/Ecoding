<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/view/header.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/projectRegister.css'/>"/>
<meta charset="utf-8">
<title>프로젝트 등록 시작</title>
<script>
    function searchData() {
        alert("Enter Key로 제출\n프로젝트 조회.");
    }
    
    function projectCreate(targetUri) {
    	form.action = targetUri; 
    	form.submit();
    }
</script>
<style>
	img {
		width: 500px;
	}
</style>
</head>
<body>
    <div class="main">
    	<a href="enrollStart.jsp" target="_self">프로젝트 등록</a>
    	&nbsp> 프로젝트 등록 시작
    </div>
    <div class="contents">
    	<p>착한 사람에게만 보이는 에코딩 서비스를 사용해야 하는 이유 소개글</p>
    	<img src="<c:url value='/resources/img/kai.jpg'/>">
    </div>
    <div class="goList">
    	<form name="form" method="post" action="<c:url value='/project/register/form' />">
    		<button name="step" class="goNext" value="step1">START</button>
   		</form>
	</div>
</html>