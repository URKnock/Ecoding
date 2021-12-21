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
</style>
</head>
<body>
    <div class="main">
    	<a href="enrollStart.jsp" target="_self">프로젝트 등록</a>
    	&nbsp> 프로젝트 등록 시작
    </div>
    <div class="contents">
    	<p>세상엔 종강을 하지 못한</p>
    	<p>힘든 친구들이 많습니다</p>
		<p>지금도 힘들어하고 있을</p>
		<p>친구들을 위해</p>
		<p>노래를 부릅니다</p>
		<p>힘내라 얘들아</p>
    </div>
    <div class="goList">
    	<form name="form" method="post" action="<c:url value='/project/register/form' />">
    		<button name="step" class="goNext" value="step1">START</button>
   		</form>
	</div>
</html>