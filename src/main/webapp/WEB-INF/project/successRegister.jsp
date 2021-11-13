<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������Ʈ ��� �Ϸ�</title>
<script>
    function searchData() {
        alert("Enter Key�� ����\n������Ʈ ��ȸ.");
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
		��ܹ�
		<input type="search" name="projectsearch" size="50" placeholder="�پ��� ������Ʈ�� �˻��غ�����." onkeyup="if(window.event.keyCode==13){searchData();}">
   		<span>
			<button type="button"><img src="������ �׸�(?)" alt="">��ư</button>
      	</span>
    </div>
    <div class="main">
    	<a href="enrollStart.jsp" target="_self">������Ʈ ���</a>
    	> ������Ʈ ��� �Ϸ�
    </div>
    <div class="contents">
    	<p>�����մϴ�. ��û�Ͻ� ������Ʈ�� ������ ��ϵǾ����ϴ�!</p>
		<p>�ɻ� ������ ���� �����ڰ� ������Ʈ�� �����ϸ� ���� ������Ʈ�� ��ȯ�˴ϴ�.</p>
    </div>
    <div class="goList">
    	<button onclick="location='������Ʈ ��ȸ.jsp'">�ϼ��� ������Ʈ �ѷ�����</button>
    </div>
    <div class="main">
		�ϴܹ�
	</div>
</body>
</html>