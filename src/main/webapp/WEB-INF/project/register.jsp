<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
</body>
</html>