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
      <div class="right">
      	<form name="form" method="post" action="<c:url value='/project/register/form' />">
			<h3>Q1. ������Ʈ ��ǥ ������ ÷�����ּ���.</h3>
			<input type="file" name="thumbnailVideo">
			<h3>Q2. ���� ������Ʈ ������ �ۼ����ּ���.</h3>
			<textarea rows="15" cols="100"></textarea>
			<h3>Q3. ������ ������ �Է����ּ���.</h3>
			<input type="text" name="reward" placeholder="������ ����">
			<input type="text" name="rewardPrice" placeholder="�ݾ� ����">
			<p></p>
			<input type="text" name="reward" placeholder="������ ����">
			<input type="text" name="rewardPrice" placeholder="�ݾ� ����">
			<h3>Q4. ���� ��� �� ���� ��ȹ�� �ۼ����ּ���.</h3>
			<textarea rows="15" cols="100"></textarea>
			<h3>Q5. ��ȯ �� ȯ�� �ȳ� ������ �ۼ����ּ���.</h3>
			<textarea rows="15" cols="100"></textarea>
			<h3>Q6. ������Ʈ�� ���õ� ���� ���� ���� �� ��Ÿ ������ ÷�����ּ���.</h3>
			<input type="file" name="projectFile">
			<p></p>
			<button name="step" class="goNext" value="step1">Step 01</button>
			<button name="step" class="goNext" value="step3">Step 03</button>
		</form>
      </div>
    </div>
    <div class="main">
		�ϴܹ�
	</div>
</body>
</html>