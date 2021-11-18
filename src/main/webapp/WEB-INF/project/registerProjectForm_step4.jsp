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
	<c:import url="/WEB-INF/project/register.jsp">
		<c:param name="main"></c:param>
	</c:import>
      <div class="right">
      	<h2>���༭</h2>
      	<p>1. ��⸦ ġ�� �ʰڽ��ϴ�.</p>
      	<p>2. �׷����� ��⸦ �ļ� ���������� ������ �Ǵ� ��� �ݾ��� 200%�� ��� �Ŀ��� �е鲲 �����ϰڽ��ϴ�.</p>
      	<p>���� ��⸦ ġ�� �ʰ� �������̰� �ùٸ��鼭 ������ �ݵ� ��ȭ�� ����ڴٴ� ����</p>
		<form name="form" method="post" action="<c:url value='/project/register/form' />">
			<button name="step" class="goNext" value="step3" onClick="userCreate('<c:url value='/project/start' />')">Step 03</button>
			<button name="step" class="goNext" value="final" onClick="userCreate('<c:url value='/project/start' />')">����ϱ�</button>
		</form>     
      </div>
    </div>
    <div class="main">
		�ϴܹ�
	</div>
</body>
</html>