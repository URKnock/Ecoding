<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	div {
		border:1px black solid;
		text-align:center;
		width:1000;
		margin-left:auto;
		margin-right:auto;
	}
	table {
		margin-left:auto;
		margin-right:auto;
	}
	h3 {
		text-align:left;
		padding-left:20;
	}
</style>
</head>
<body>
<div>
	<h3 style>�Ŀ�����</h3>
	<form action="<c:url value='/project/support/confirm' />" method="POST">
	<table border="1" style="width:800; text-align:center;">
		<tr style="height:100;">
			<td width="300">
				<input type="radio" name="option" value="none">
				�Ŀ��� �ϱ�<br>
				- ��ǰ ����
			</td>
			<td rowspan="3">
				<h2 style="text-align:left; padding-left:10;">������ �ɼ�</h2>
				<h4 style="text-align:left; padding-left:10;">�߰� �ݾ� �Ŀ��ϱ�</h4>
				<input type="text" name="addPrice" value="0"/ style="width:90%; height:50;"><br>
				<br>
				<input type="submit" name="�Ŀ��ϱ�" value="�Ŀ��ϱ�" style="width:90%; height:50;">
			</td>
		</tr>
		<tr style="height:100;">
			<td>
				<input type="radio" name="option" value="1">
				�ɼ�A<br>
				- ��ǰ A<br>
			</td>
		</tr>
		<tr style="height:100;">
			<td>
				<input type="radio" name="option" value="2">
				�ɼ�B<br>
				- ��ǰ B<br>
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>