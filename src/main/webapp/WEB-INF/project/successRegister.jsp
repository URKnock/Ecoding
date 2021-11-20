<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/view/header.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/projectRegister.css'/>"/>
<meta charset="utf-8">
<title>프로젝트 등록 완료</title>
<style>
.contents {
	padding: 12%;
}
</style>
</head>
<body>
 <div class="main">
    	<a href="<c:url value='/project/view' />" target="_self">프로젝트 등록</a>
    	<span class="step"> > 프로젝트 등록 완료</span>
    </div>
    <div class="contents">
    	<p>축하합니다. 신청하신 프로젝트가 무사히 등록되었습니다!</p>
		<p>심사 과정을 거쳐 관리자가 프로젝트를 승인하면 정식 프로젝트로 전환됩니다.</p>
    </div>
    <div class="goList">
    	<button class="goNext" onclick="location.href='<c:url value='/home/list' />'">프로젝트 둘러보기</button>
    </div>
</body>
</html>