<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<c:import url="/WEB-INF/view/header.jsp"></c:import>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/projectRegister.css'/>"/>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<script>
	    function projectCreate(targetUri) {
	    	form.action = targetUri; 
	    	form.submit();
	    }
	    document.getElementById( 'pro' ).value = '50';
	</script>
	<style>     
	    #step02 {
	    	background-color: #87CEFA;
	    	color: white;
	    }
	</style>
</head>
<body>
 <div class="main">
    	<a href="<c:url value='/project/view' />" target="_self">프로젝트 등록</a>
    	<span class="step"> > Step 02</span>
    </div>
	<c:import url="/WEB-INF/project/register.jsp">
		<c:param name="main"></c:param>
	</c:import>
		<div id="enrollProgress">
	    		진행도 <progress value="0.4"></progress>
	    	</div>
	    </div>
     <div class="right">
     	<form name="form" method="post" action="<c:url value='/project/register/form' />">
			<p>Q1. 프로젝트 대표 영상을 첨부해주세요.</p>
			&nbsp<input type="file" name="thumbnailVideo">
			<p>Q2. 상세한 프로젝트 설명을 작성해주세요.</p>
			&nbsp<textarea rows="5" cols="100" name="detailInfo"></textarea>
			<p>&nbspQ3. 리워드 정보를 입력해주세요.</p>
			&nbsp<input type="text" name="name" placeholder="리워드 이름">
			&nbsp<input type="text" name="reward_price" placeholder="금액 범위">
			&nbsp<input type="text" name="reward_info" placeholder="리워드 정보">
			<p>Q4. 예산 사용 및 일정 계획을 작성해주세요.</p>
			&nbsp<textarea rows="5" cols="100" name="planInfo"></textarea>
			<p>Q5. 교환 및 환불 안내 사항을 작성해주세요.</p>
			&nbsp<textarea rows="5" cols="100" name="exchangeInfo"></textarea>
			<p>Q6. 프로젝트와 관련된 각종 인증 정보 및 기타 서류를 첨부해주세요.</p>
			&nbsp<input type="file" name="projectFile">
			<p></p>
			&nbsp<button name="step" class="goNext" value="step1">Step 01</button>
			<button name="step" class="goNext" value="step3">Step 03</button>
		</form>
     </div>
</body>
</html>