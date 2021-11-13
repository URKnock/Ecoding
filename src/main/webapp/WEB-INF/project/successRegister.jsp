<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>프로젝트 등록 완료</title>
<script>
    function searchData() {
        alert("Enter Key로 제출\n프로젝트 조회.");
    }
</script>
<style>
	a {
		text-decoration-line: none;
		color: inherit;
	}
	
	a:hover { text-decoration: underline; }
	
	.contents { 
		padding: 13% 0%;
		text-align: center;
	}
	
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
	<div class="main">
		상단바
		<input type="search" name="projectsearch" size="50" placeholder="다양한 프로젝트를 검색해보세요." onkeyup="if(window.event.keyCode==13){searchData();}">
   		<span>
			<button type="button"><img src="돋보기 그림(?)" alt="">버튼</button>
      	</span>
    </div>
    <div class="main">
    	<a href="enrollStart.jsp" target="_self">프로젝트 등록</a>
    	> 프로젝트 등록 완료
    </div>
    <div class="contents">
    	<p>축하합니다. 신청하신 프로젝트가 무사히 등록되었습니다!</p>
		<p>심사 과정을 거쳐 관리자가 프로젝트를 승인하면 정식 프로젝트로 전환됩니다.</p>
    </div>
    <div class="goList">
    	<button onclick="location='프로젝트 조회.jsp'">완성된 프로젝트 둘러보기</button>
    </div>
    <div class="main">
		하단바
	</div>
</body>
</html>