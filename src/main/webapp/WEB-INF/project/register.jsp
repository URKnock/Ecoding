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
		��ܹ�
		<input type="search" name="projectsearch" size="50" placeholder="�پ��� ������Ʈ�� �˻��غ�����." onkeyup="if(window.event.keyCode==13){searchData();}">
   		<span>
			<button type="button"><img src="������ �׸�(?)" alt="">��ư</button>
      	</span>
    </div>
    <div class="main">
    	<a href="enrollStart.jsp" target="_self">������Ʈ ���</a>
    	> <span class="step">Step 01</span>
    </div>
    <div>
      <div class="stepList">
      	<div id="step01">
      		Step 01
      		<p>������Ʈ ���� �ۼ�</p>
      	</div>
      	<div id="step02">
      		Step 02
      		<p>������Ʈ �� ���� �ۼ�</p>
      	</div>
      	<div id="step03">
      		Step 03
      		<p>������Ʈ â���� ���� �ۼ�</p>
      	</div>
      	<div id="step04">
      		Step 04
      		<p>���༭ ����</p>
      	</div>
      	<div style="height: 260px;">
      	</div>
      	<div id="enrollProgress">
      		���൵ <progress value="0.25"></progress>
      	</div>
      </div>
</body>
</html>