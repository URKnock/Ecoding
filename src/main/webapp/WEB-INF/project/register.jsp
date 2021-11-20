<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/projectRegister.css'/>"/>
<script>
    function searchData() {
        alert("Enter Key로 제출\n프로젝트 조회.");
    }
</script>
<style>
</style>
</head>
<body>
	    <div class="stepList">
	    	<div id="step01">
	    		&nbspStep 01
	    		<p>&nbsp프로젝트 정보 작성</p>
	    	</div>
	    	<div id="step02">
	    		&nbspStep 02
	    		<p>&nbsp프로젝트 상세 정보 작성</p>
	    	</div>
	    	<div id="step03">
	    		&nbspStep 03
	    		<p>&nbsp프로젝트 창작자 정보 작성</p>
	    	</div>
	    	<div id="step04">
	    		&nbspStep 04
	    		<p>&nbsp서약서 제출</p>
	    	</div>
	    	<div style="height: 175px;">
	    	</div>
</body>
</html>