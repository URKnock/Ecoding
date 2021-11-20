<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</script>
<style>
    #step03 {
    	background-color: #87CEFA;
    	color: white;
    }
</style>
</head>
<body>
 <div class="main">
    	<a href="<c:url value='/project/view' />" target="_self">프로젝트 등록</a>
    	<span class="step"> > Step 03</span>
    </div>
	<c:import url="/WEB-INF/project/register.jsp">
		<c:param name="main"></c:param>
	</c:import>
	<div id="enrollProgress">
	    		진행도 <progress value="0.6"></progress>
	    	</div>
	    </div>
      <div class="right">
      	<form name="form" method="post" action="<c:url value='/project/register/form' />">
      		<input type="hidden" name="title" value="${project['title']}">
      		<input type="hidden" name="simpleInfo" value="${project['simpleInfo']}">
      		<input type="hidden" name="category" value="${project['category']}">
      		<input type="hidden" name="hashtag" value="${project['hashTag']}">
      		<input type="hidden" name="ecotag" value="${project['ecoTag']}">
      		<input type="hidden" name="targetAmount" value="${project['targetPrice']}">
      		<input type="hidden" name="startDate" value="${project['startDate']}">
      		<input type="hidden" name="endDate" value="${project['endDate']}">
      		<input type="hidden" name="payDate" value="${project['paymentDate']}">
      		<input type="hidden" name="deliveryDate" value="${project['deliveryDate']}">
      		<input type="hidden" name="detailInfo" value="${project['detailInfo']}">
      		<input type="hidden" name="planInfo" value="${project['planInfo']}">
      		<input type="hidden" name="exchangeInfo" value="${project['exchangeInfo']}">
      		<input type="hidden" name="name" value="${reward['rewardName']}">
      		<input type="hidden" name="reward_price" value="${reward['rewardPrice']}">
      		<input type="hidden" name="ecoerId" value="${ecoer.ecoerId}">
			<p>Q1. 창작자(팀) 이름을 입력해주세요.</p>
			<input type="text" name="teamName">
			<p>Q2. 창작자(팀) 이미지를 첨부해주세요.</p>
			<input type="file" name="teamImage">
			<p>Q3. 창작자(팀) 소개를 작성해주세요.</p>
			<textarea rows="15" cols="100" name="teamDetail"></textarea>
			<p>Q4. 입금 계좌 정보를 입력해주세요.</p>
			<input type="text" name="account">
			<p></p>
			<button name="step" class="goNext" value="step2">Step 02</button>
			<button name="step" class="goNext" value="step4">Step 04</button>
		</form>
      </div>
</body>
</html>