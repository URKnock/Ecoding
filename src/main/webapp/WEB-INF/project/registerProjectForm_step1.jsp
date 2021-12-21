<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="/WEB-INF/view/header.jsp"></c:import>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/projectRegister.css'/>"/>
<meta charset="utf-8">
<title>Step1</title>
<script>
	var is_empty = false;
	$('#form').find('input[type!="hidden"]').each(function(){
	    if(!$(this).val()) {
	        is_empty = true;
	    }
	});
	 
	if(is_empty) {
	    alert('값을 전부 입력하시오');
	}
    function projectCreate(targetUri) {
    	form.action = targetUri; 
    	form.submit();
    }
    
    function addReward() {
    	var form = document.getElementById('rewardDiv');
    	
    	var text = document.createTextNode("\u00a0");
    	form.appendChild(text);
    	
    	var rewardName = document.createElement('input');
    	rewardName.type = 'text';
    	rewardName.name = 'name';
    	rewardName.placeholder = '리워드 이름';
    	form.appendChild(rewardName);
    	
    	var text = document.createTextNode("\u00a0\u00a0");
    	form.appendChild(text);
    	
    	var rewardPrice = document.createElement('input');
    	rewardPrice.type = 'text';
    	rewardPrice.name = 'reward_price';
    	rewardPrice.placeholder = '금액 범위';
    	rewardPrice.style = 'text-align:right';
    	form.appendChild(rewardPrice);
    	
    	var won = document.createTextNode("원");
    	form.appendChild(won);
    	
    	var text = document.createTextNode("\u00a0\u00a0");
    	form.appendChild(text);
    	
    	var rewardInfo = document.createElement('input');
    	rewardInfo.type = 'text';
    	rewardInfo.name = 'reward_info';
    	rewardInfo.placeholder = '리워드 정보';
    	form.appendChild(rewardInfo);
    	
    	var next = document.createElement('p');
    	form.appendChild(next);
    	
    	var text = document.createTextNode("\u00a0\u00a0\u00a0");
    	form.appendChild(text);
    }
</script>
<style>
#step01 {
   	background-color: #87CEFA;
   	color: white;
   }
</style>
</head>
<body>
 <div class="main">
    	<a href="<c:url value='/project/view' />" target="_self">&nbspSTART</a>
    	<span class="step"> > Step 01</span>
    </div>
	<c:import url="/WEB-INF/project/register.jsp">
		<c:param name="main"></c:param>
	</c:import>
	<div id="enrollProgress">
	    		진행도 <progress value="0.2"></progress>
	    	</div>
	    </div>
     <div class="right">
     	<form name="form" method="post" action="<c:url value='/project/register/form' />">
     		<input type="hidden" name="projectId" value="${project.projectId}">
			<p>Q1. 프로젝트 제목을 입력해주세요.</p>
			&nbsp&nbsp<input type="text" name="title" value="${project.title}">
			<br><br>
			<p>Q2. 간단한 프로젝트 설명을 작성해주세요.</p>
			&nbsp&nbsp<input type="text" name="simpleInfo" value="${project.simpleInfo}">
			<br><br>
			<p>Q3. 프로젝트 카테고리를 선택해주세요.</p>
			&nbsp&nbsp<input type="radio" name="category" value="식품" <c:if test="${project.category eq '식품'}"> checked </c:if>>식품
			&nbsp&nbsp<input type="radio" name="category" value="패션" <c:if test="${project.category eq '패션'}"> checked </c:if>>패션
			&nbsp&nbsp<input type="radio" name="category" value="생활" <c:if test="${project.category eq '생활'}"> checked </c:if>>생활
			&nbsp&nbsp<input type="radio" name="category" value="건강" <c:if test="${project.category eq '건강'}"> checked </c:if>>건강
			&nbsp&nbsp<input type="radio" name="category" value="문구" <c:if test="${project.category eq '문구'}"> checked </c:if>>문구
			&nbsp&nbsp<input type="radio" name="category" value="인테리어" <c:if test="${project.category eq '인테리어'}"> checked </c:if>>인테리어
			<br>
			&nbsp&nbsp<input type="radio" name="category" value="반려동물" <c:if test="${project.category eq '반려동물'}"> checked </c:if>>반려동물
			&nbsp&nbsp<input type="radio" name="category" value="미용" <c:if test="${project.category eq '미용'}"> checked </c:if>>미용
			&nbsp&nbsp<input type="radio" name="category" value="식물" <c:if test="${project.category eq '식물'}"> checked </c:if>>식물
			&nbsp&nbsp<input type="radio" name="category" value="도서" <c:if test="${project.category eq '도서'}"> checked </c:if>>도서
			&nbsp&nbsp<input type="radio" name="category" value="도서" <c:if test="${project.category eq '테크'}"> checked </c:if>>테크
			<br><br>
			<p>Q4. 프로젝트와 관련된 해시태그를 입력해주세요.</p>
			&nbsp&nbsp#<input type="text" name="hashtag" value="${project.hashTag}">
			<br><br>
			<p>Q5. 환경과 관련된 태그를 체크해주세요.</p>
			&nbsp&nbsp<input type="radio" name="ecotag" value="비건" <c:if test="${project.ecoTag eq '비건'}"> checked </c:if>>비건
			&nbsp&nbsp<input type="radio" name="ecotag" value="친환경" <c:if test="${project.ecoTag eq '친환경'}"> checked </c:if>>친환경
			&nbsp&nbsp<input type="radio" name="ecotag" value="재활용" <c:if test="${project.ecoTag eq '재활용'}"> checked </c:if>>재활용
			<br><br>
			<p>Q6. 프로젝트 목표 금액을 작성해주세요.</p>
			&nbsp&nbsp<input type="text" name="targetAmount" style = "text-align:right" value="${project.targetPrice}">원
			<br><br>
			<p>Q7. 프로젝트 기간을 설정해주세요.</p>
			&nbsp&nbsp시작일 설정: <input type="date" name="startDate" value="${project.startDate}">
			&nbsp&nbsp마감일 설정: <input type="date" name="endDate" value="${project.endDate}">
			<br><br>
			&nbsp&nbsp결제일 설정: <input type="date" name="payDate" value="${project.paymentDate}">
			&nbsp&nbsp배송 시작일 설정: <input type="date" name="deliveryDate" value="${project.deliveryDate}">
			<br><br>
			<c:if test="${project.projectId == -1}">
				&nbspQ8. 리워드 정보를 입력해주세요.
				<p>&nbsp<input type="text" name="name" placeholder="리워드 이름">
				&nbsp<input type="text" name="reward_price" style = "text-align:right" placeholder="금액 범위">원
				&nbsp<input type="text" name="reward_info" placeholder="리워드 정보"></p>
				<div id="rewardDiv"></div>
				<span style="width:100px;"></span>
				<div style="background-color:lightblue; position: relative; left: 25px; width:100px; text-align:center;">
					<a href="javascript:addReward()" style="color:white">리워드 추가</a>
				</div>
				<br>
			</c:if>
			&nbsp<button name="step" class="goNext" value="step2">Step 02</button>
		</form>
     </div>
</body>
</html>