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
    
    #step02 {
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
      	<form name="form" method="post" action="<c:url value='/project/register/form' />">
			<h3>Q1. 프로젝트 대표 영상을 첨부해주세요.</h3>
			<input type="file" name="thumbnailVideo">
			<h3>Q2. 상세한 프로젝트 설명을 작성해주세요.</h3>
			<textarea rows="15" cols="100"></textarea>
			<h3>Q3. 리워드 정보를 입력해주세요.</h3>
			<input type="text" name="reward" placeholder="리워드 정보">
			<input type="text" name="rewardPrice" placeholder="금액 범위">
			<p></p>
			<input type="text" name="reward" placeholder="리워드 정보">
			<input type="text" name="rewardPrice" placeholder="금액 범위">
			<h3>Q4. 예산 사용 및 일정 계획을 작성해주세요.</h3>
			<textarea rows="15" cols="100"></textarea>
			<h3>Q5. 교환 및 환불 안내 사항을 작성해주세요.</h3>
			<textarea rows="15" cols="100"></textarea>
			<h3>Q6. 프로젝트와 관련된 각종 인증 정보 및 기타 서류를 첨부해주세요.</h3>
			<input type="file" name="projectFile">
			<p></p>
			<button name="step" class="goNext" value="step1">Step 01</button>
			<button name="step" class="goNext" value="step3">Step 03</button>
		</form>
      </div>
    </div>
    <div class="main">
		하단바
	</div>
</body>
</html>