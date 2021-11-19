<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
    
    #step03 {
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
      	<form name="form" method="post" action="<c:url value='/project/register/form' />">
			<h3>Q1. 창작자(팀) 이름을 입력해주세요.</h3>
			<input type="text" name="teamName">
			<h3>Q2. 창작자(팀) 이미지를 첨부해주세요.</h3>
			<input type="file" name="teamImage">
			<h3>Q3. 창작자(팀) 소개를 작성해주세요.</h3>
			<textarea rows="15" cols="100" name="teamDetail"></textarea>
			<h3>Q4. 입금 계좌 정보를 입력해주세요.</h3>
			<input type="text" name="account">
			<p></p>
			<button name="step" class="goNext" value="step2" onClick="userCreate('<c:url value='/project/start' />')">Step 02</button>
			<button name="step" class="goNext" value="step4" onClick="userCreate('<c:url value='/project/start' />')">Step 04</button>
		</form>
      </div>
    </div>
    <div class="main">
		하단바
	</div>
</body>
</html>