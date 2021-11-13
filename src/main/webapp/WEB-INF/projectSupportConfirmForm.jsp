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
		border:1px black solid;
		margin-left:auto;
		margin-right:auto;
		text-align:center;
	}
	h4 {
		text-align:left;
		padding-left:20;
	}
</style>
</head>
<body>
	<div>
		<table border="1" style="width:1000">
			<tr>
				<td width="25%">
					<img src="image.jpg" width="150" height="150">
				</td>
				<td style="font-size:20pt">������Ʈ �̸�</td>
				<td width="5%" style="text-align:center;">
					<img src="image.jpg" width="30" height="30">
				</td>
				<td width="20%" style="text-align:left;">â����</td>
			</tr>
		</table>
	</div>
	<div>	
	<form action="<c:url value='/project/support/complete' />" method="POST">
		<table border="1" style="width:1000">
			<tr>
				<td style="width:55%">
					<h4>�Ŀ�����</h4>
					<table style="width:480; height:100;">
						<tr>
							<td>�ɼ� ����</td>
							<td><button type="button" onclick="location.href='projectSupportForm.html'">
									����
							</button></td>
						</tr>
						<tr>
							<td>�Ŀ��ݾ� + �߰� �Ŀ� �ݾ� =</td>
							<td style="font-weight:bold">���� �ݾ�</td>
						</tr>
					</table>
				</td>
				<td rowspan="4">
					<table style="width:400; height:200;">
						<tr>
							<td>���� �Ŀ� �ݾ�</td>
							<td style="font-weight:bold">80,000��</td>
						</tr>
						<tr>
							<td colspan="2">
								������Ʈ ��ǥ �޼� ��, 21�� 11�� 1�Ͽ� �����˴ϴ�.<br>
								������Ʈ�� ����� ��� ������ �ڵ����� ��ҵ˴ϴ�.
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="radio"> �������� �� 3�� ���� ����
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="�Ŀ��ϱ�" style="width:380; height:50;">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h4>�Ŀ��� ����</h4>
					<table style="width:480; height:100;">
						<tr>
							<td>�̸�</td>
							<td>��ؼ�</td>
						</tr>
						<tr>
							<td>����ó</td>
							<td>010-1234-5678</td>
						</tr>
						<tr>
							<td>�̸���</td>
							<td>somsom@dongduk.ac.kr</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h4>����� ����</h4>
					<table style="width:480; height:100;">
						<tr>
							<td>�����ȣ</td>
							<td>02748</td>
						</tr>
						<tr>
							<td>�ּ�</td>
							<td>����� ���ϰ� ȭ���� 13�� 60</td>
						</tr>
						<tr>
							<td>�� �ּ�</td>
							<td>�������ڴ��б� �ι��� B312ȣ</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<h4>���� ����</h4>
					<table style="width:480; height:100;">
						<tr>
							<td>ī��</td>
							<td><input type="text" size="10"></td>
						</tr>
						<tr>
							<td>ī�� ��ȣ</td>
							<td><input type="text" size="20"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
	</form>	
	</div>
</body>
</html>