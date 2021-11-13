<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>프로젝트 등록 시작</title>
<script>
    function searchData() {
        alert("Enter Key로 제출\n프로젝트 조회.");
    }
    
    function projectCreate(targetUri) {
    	form.action = targetUri; 
    	form.submit();
    }
</script>
<style>
	a {
		text-decoration-line: none;
		color: inherit;
	}
	
	a:hover { text-decoration: underline; }
	
	.contents { 
		padding: 14% 0%;
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
    	> 프로젝트 등록 시작
    </div>
    <div class="contents">
    	<p>에코딩 서비스를 사용해야 하는 이유 소개글</p>
    </div>
    <div class="goList">
    	<form name="form" method="post" action="<c:url value='/project/start' />">
    		<input type="button" class="goNext" value="등록하기" onClick="projectCreate('<c:url value='/project/start' />')">
   		</form>
	</div>
    <div class="main">
		하단바
	</div>
</body>
</html>