<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
	a {
		text-decoration-line: none;
		color: inherit;
	}
	
	a:hover { text-decoration: underline; }
	
	div {
		border: 1px solid #87CEFA;
        width: 100%;
        height: 624px;
    }
      
    .main {
		height: 35px;
	}
      
    div.stepList {
      	width: 20%;
        float: left;
        box-sizing: border-box;
    }
      
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
	<div class="main">
		상단바
		<input type="search" name="projectsearch" size="50" placeholder="다양한 프로젝트를 검색해보세요." onkeyup="if(window.event.keyCode==13){searchData();}">
   		<span>
			<button type="button"><img src="돋보기 그림(?)" alt="">버튼</button>
      	</span>
    </div>
    <div class="main">
    	<a href="enrollStart.jsp" target="_self">프로젝트 등록</a>
    	> <span class="step">Step 01</span>
    </div>
    <div>
      <div class="stepList">
      	<div id="step01">
      		Step 01
      		<p>프로젝트 정보 작성</p>
      	</div>
      	<div id="step02">
      		Step 02
      		<p>프로젝트 상세 정보 작성</p>
      	</div>
      	<div id="step03">
      		Step 03
      		<p>프로젝트 창작자 정보 작성</p>
      	</div>
      	<div id="step04">
      		Step 04
      		<p>서약서 제출</p>
      	</div>
      	<div style="height: 260px;">
      	</div>
      	<div id="enrollProgress">
      		진행도 <progress value="0.25"></progress>
      	</div>
      </div>
      <div class="right">
      	<h2>서약서</h2>
      	<p>1. 사기를 치지 않겠습니다.</p>
      	<p>2. 그럼에도 사기를 쳐서 경찰서에서 만나게 되는 경우 금액의 200%를 모든 후원자 분들께 보상하겠습니다.</p>
      	<p>대충 사기를 치지 않고 윤리적이고 올바르면서 깨끗한 펀딩 문화를 만들겠다는 다짐</p>
		<form name="form" method="post" action="<c:url value='/project/register/form' />">
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