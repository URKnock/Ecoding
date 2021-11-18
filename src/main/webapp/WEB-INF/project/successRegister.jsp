<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>프로젝트 등록 완료</title>
<style>
	div {
		border: 1px solid #87CEFA;
	}
	
	.main {
		height: 35px;
	}
	
	.goList > button{
		background-color: #87CEFA;
		width: 300px;
		height: 80px;
		border: 0;
		outline: 0;
		color: white;
	}

	.goList {
		 padding: 25px;
		 text-align: center;
	}
</style>
</head>
<body>
	<c:import url="/WEB-INF/project/register.jsp">
		<c:param name="main"></c:param>
	</c:import>
    <div class="contents">
    	<p>축하합니다. 신청하신 프로젝트가 무사히 등록되었습니다!</p>
		<p>심사 과정을 거쳐 관리자가 프로젝트를 승인하면 정식 프로젝트로 전환됩니다.</p>
    </div>
    <div class="goList">
    	<button onclick="location='home.jsp'">완성된 프로젝트 둘러보기</button>
    </div>
    <div class="main">
		하단바
	</div>
</body>
</html>