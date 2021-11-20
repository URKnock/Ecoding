<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
    function projectCreate(targetUri) {
    	form.action = targetUri; 
    	form.submit();
    }
</script>
<style>
    div.right {
      	width: 80%;
        float: right;
        box-sizing: border-box;
        border: none;
        overflow-y:auto; 
        overflow-x:hidden;
    }
    
    .stepList > div {
    	height: 80px;
    	border-top: none;
    	border-left: none;
    	border-right: none;
    	margin: -1px;
    }
    
    #step04 {
    	background-color: #87CEFA;
    }
    
    .enrollProgress {
    	 height: 55px;
    	 text-align: center;
    }
    
    .goNext{
		background-color: #87CEFA;
		width: 10%;
		height: 80px;
		border: 0;
		outline: 0;
		color: white;
	}
</style>
</head>
<body>
	<c:import url="/WEB-INF/project/register.jsp">
		<c:param name="main"></c:param>
	</c:import>
      <div class="right">
      	<h2>서약서</h2>
      	<p>1. 사기를 치지 않겠습니다.</p>
      	<p>2. 그럼에도 사기를 쳐서 경찰서에서 만나게 되는 경우 금액의 200%를 모든 후원자 분들께 보상하겠습니다.</p>
      	<p>대충 사기를 치지 않고 윤리적이고 올바르면서 깨끗한 펀딩 문화를 만들겠다는 다짐</p>
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
      		<input type="hidden" name="reward_info" value="${reward['rewardInfo']}">
      		<input type="hidden" name="ecoerId" value="${creator['ecoerId']}">
      		<input type="hidden" name="teamName" value="${creator['nickName']}">
      		<input type="hidden" name="teamDetail" value="${creator['creatorInfo']}">
      		<input type="hidden" name="account" value="${creator['account']}">
			<button name="step" class="goNext" value="step3" onClick="userCreate('<c:url value='/project/start' />')">Step 03</button>
			<button name="step" class="goNext" value="final" onClick="userCreate('<c:url value='/project/start' />')">등록하기</button>
		</form>     
      </div>
    </div>
    <div class="main">
		하단바
	</div>
</body>
</html>