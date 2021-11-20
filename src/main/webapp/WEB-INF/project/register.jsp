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
    <div class="main">
    	<a href="<c:url value='/project/view' />" target="_self">프로젝트 등록</a>
    	<span class="step">Step 01</span>
    </div>
	    <div class="stepList">
	    	<div id="step01">
	    		Step 01
	    		<p>프로젝트 정보 작성</p>
	    	</div>
	    	<div id="step02">
	    		Step 02
	    		<p>프로젝트 상세 정보 작성</p>
	    	</div>
	    	<div id="step03">
	    		Step 03
	    		<p>프로젝트 창작자 정보 작성</p>
	    	</div>
	    	<div id="step04">
	    		Step 04
	    		<p>서약서 제출</p>
	    	</div>
	    	<div style="height: 150px;">
	    	</div>
	    	<div id="enrollProgress">
	    		진행도 <progress value="0.25" id="pro"></progress>
	    	</div>
	    </div>
</body>
</html>