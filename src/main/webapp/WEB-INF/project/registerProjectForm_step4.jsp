<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/view/header.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/projectRegister.css'/>"/>
<meta charset="utf-8">
<title>Step4</title>
<script>
    function projectCreate(targetUri) {
    	form.action = targetUri; 
    	form.submit();
    }
</script>
<style>
    #step04 {
    	background-color: #87CEFA;
    	color: white;
    }
</style>
</head>
<body>
 <div class="main">
    	<a href="<c:url value='/project/view' />" target="_self">&nbspSTART</a>
    	<span class="step"> > Step 01 > Step 02 > Step 03 > Step 04</span>
    </div>
	<c:import url="/WEB-INF/project/register.jsp">
		<c:param name="main"></c:param>
	</c:import>
		<div id="enrollProgress">
	    		&nbsp진행도 <progress value="0.8"></progress>
	    	</div>
	    </div>
      <div class="right">
      	<h2>서약서</h2>
      	<p>1. 사기를 치지 않겠습니다.</p>
      	<p>2. 그럼에도 사기를 쳐서 경찰서에서 만나게 되는 경우 금액의 200%를 모든 후원자 분들께 보상하겠습니다.</p>
      	<p>암튼 사기를 치지 않고 윤리적이고 올바르면서 깨끗한 펀딩 문화를 만들겠다는 다짐</p>
		<form name="form" method="post" action="<c:url value='/project/register/form' />">
			&nbsp<button name="step" class="goNext" value="final">FINISH</button>
		</form>     
      </div>
</body>
</html>