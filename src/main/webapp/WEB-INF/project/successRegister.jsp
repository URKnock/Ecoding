<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������Ʈ ��� �Ϸ�</title>
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
    	<p>�����մϴ�. ��û�Ͻ� ������Ʈ�� ������ ��ϵǾ����ϴ�!</p>
		<p>�ɻ� ������ ���� �����ڰ� ������Ʈ�� �����ϸ� ���� ������Ʈ�� ��ȯ�˴ϴ�.</p>
    </div>
    <div class="goList">
    	<button onclick="location='home.jsp'">�ϼ��� ������Ʈ �ѷ�����</button>
    </div>
    <div class="main">
		�ϴܹ�
	</div>
</body>
</html>