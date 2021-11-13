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
    
    #step01 {
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
			<h3>Q1. ������Ʈ ������ �Է����ּ���.</h3>
			<input type="text" name="projectName">
			<h3>Q2. ������Ʈ ��ǥ �̹����� ÷�����ּ���.</h3>
			<input type="file" name="thumbnailImage">
			<h3>Q3. ������ ������Ʈ ������ �ۼ����ּ���.</h3>
			<input type="text" name="projectBrief">
			<h3>Q4. ������Ʈ ī�װ��� �������ּ���.</h3>
			<input type="radio" name="category" value="1">1�� ī�װ�
			<input type="radio" name="category" value="2">2�� ī�װ�
			<input type="radio" name="category" value="3">3�� ī�װ�
			<input type="radio" name="category" value="4">4�� ī�װ�
			<h3>Q5. ������Ʈ�� ���õ� �ؽ��±׸� �Է����ּ���.</h3>
			<input type="text" name="hashtag">
			<h3>Q6. ȯ��� ���õ� �±׸� ��� üũ���ּ���.</h3>
			<input type="checkbox" name="ecotag" value="1">1�� �±�
			<input type="checkbox" name="ecotag" value="2">2�� �±�
			<input type="checkbox" name="ecotag" value="3">3�� �±�
			<input type="checkbox" name="ecotag" value="4">4�� �±�
			<h3>Q7. ������Ʈ ��ǥ �ݾ��� �ۼ����ּ���.</h3>
			<input type="text" name="targetAmount">
			<h3>Q8. ������Ʈ �Ⱓ�� �������ּ���.</h3>
			������ ����: <input type="date" name="startDate">
			������ ����: <input type="date" name="endDate">
			<p></p>
			���� �ð� ����: <input type="time" name="startTime">
			���� �ð� ����: <input type="time" name="endTime">
			<p></p>
			������ ����: <input type="date" name="payDate">
			��� ������ ����: <input type="date" name="deliveryDate">
			<p></p>
			<button name="step" class="goNext" value="step2">Step 02</button>
		</form>
      </div>
    </div>
    <div class="main">
		�ϴܹ�
	</div>
</body>
</html>