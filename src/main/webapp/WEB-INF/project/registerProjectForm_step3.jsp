<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/view/header.jsp"></c:import>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/projectRegister.css'/>"/>
<meta charset="utf-8">
<title>Step3</title>
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
    
    #creatorForm {
    	display:none;
    }
</style>
</head>
<body>
 <div class="main">
    	<a href="<c:url value='/project/view' />" target="_self">&nbspSTART</a>
    	<span class="step"> > Step 01 > Step 02 > Step 03</span>
    </div>
	<c:import url="/WEB-INF/project/register.jsp">
		<c:param name="main"></c:param>
	</c:import>
	<div id="enrollProgress">
	    		진행도 <progress value="0.6"></progress>
	    	</div>
	    </div>
      <div class="right">
      	<p></p>
      	<form name="form" method="post" enctype="multipart/form-data" action="<c:url value='/project/register/creator' />">
			<p>Q1. 창작자(팀) 이름을 입력해주세요.</p>
			&nbsp&nbsp<input type="text" name="teamName" value="${creator.nickName}">
			<p>Q2. 창작자(팀) 이미지를 첨부해주세요.<c:if test="${isCre}">(수정을 원하는 경우에만 첨부해주세요)</c:if></p>
			&nbsp&nbsp<input type="file" name="teamImage">
			<p>Q3. 창작자(팀) 소개를 작성해주세요.</p>
			&nbsp&nbsp<textarea rows="15" cols="100" name="teamDetail">${creator.creatorInfo}</textarea>
			<p>Q4. 입금 계좌 정보를 입력해주세요.</p>
			&nbsp&nbsp<input type="text" name="account" value="${creator.account}">
			<p></p>
			&nbsp&nbsp<button name="step" class="goNext">Step 04</button>
			<p></p>
		</form>
      </div>
</body>
</html>