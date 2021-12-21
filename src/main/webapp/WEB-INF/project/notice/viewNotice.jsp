<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../view/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지</title>
<style>
	.d {
		text-align:center;
		width:1000px;
		margin-left:auto;
		margin-right:auto;
	}
	table {
		margin-left:auto;
		margin-right:auto;
	}
	h3 {
		text-align:left;
		padding-left:100px;
	}
	hr {
		border:0;
		height:1px;
		background-color:#97e6e4;
	}
	.top {
	 	border-top:1px solid #6495ED;
	}
	tr {
		height:35px;
	}
	.content {
		height:50px;
		font-size:20px;
		padding-left:30px;
	}
	.date {
		text-align:right;
		font-size:15px;
		padding-right:10px;
	}
	.change {
		text-align:center;
		width:10%;
	}
	.delete {
		text-align:center;
		width:10%;
	}
	.register {
		padding-top:20px;
		padding-right:20px;
		text-align:right;
	}
	.changeBtn {
		border:0;
		width:50px;
		height:25px;
		font-size:15px;
		font-weight:bold;
		color:white;
		background-color:#d2d2d2;
		border-radius:3px;
	}
	.changeBtn:hover {
		background-color:#6EDCDC;
	}
	.deleteBtn {
		border:0;
		width:50px;
		height:25px;
		font-size:15px;
		font-weight:bold;
		color:#b3b3b3;
		background-color:white;
		border-radius:3px;
		border-bottom:1px solid #b3b3b3;
	}
	.deleteBtn:hover {
		color:white;
		background-color:#fa8c8c;
		border-bottom:0;
	}
	.regBtn {
		border:0;
		width:80px;
		height:30px;
		font-size:20px;
		font-weight:bold;
		color:white;
		background-color:#87e2f5;
		border-radius:3px;
	}
	.regBtn:hover {
		background-color:#70b3ff;
	}
</style>
</head>
<body>
	<div class="d">
 		<table style="width:900px">
 			<tr>
 				<td width="25%"><img src="<c:url value='/upload/${project.image}' />" width="150px" height="150px" ></td>
 				<td style="font-size:30px;">${project.title}</td>
 				<td width="20%" style="text-align:left;">${project.creatorName}</td>
 		</table>
 		<hr>
		<h3>공지사항</h3>
		<br>
		<table class="n" style="width:700px">
			<c:forEach var="notice" items="${noticeList}">
				<tr class="top">
					<td colspan="3" class="content">${notice.noticeContent}</td>
				</tr>
				<tr>
					<td class="date">${notice.noticeDate}</td>
					<td class="change">
						<button type="button" class="changeBtn"
							onClick="location.href='<c:url value='/project/notice/update?noticeId=${notice.noticeId}&projectId=${project.projectId}'>
								<c:param name="notice" value="view" />
							</c:url>'">수정
						</button>
					</td>
					<td class="delete"  class="delete">
						<button type="button" class="deleteBtn"
							onClick="location.href='<c:url value='/project/notice/delete?noticeId=${notice.noticeId}&projectId=${project.projectId}' />'">
						삭제</button>
					</td>
				</tr>
			</c:forEach>
			<tr class="top">
				<td class="register" colspan="3">
					<button type="button" class="regBtn"
			   			onClick="location.href='<c:url value='/project/notice/register?projectId=${project.projectId}' />'">추가
					</button>
				</td>
			</tr>
		</table>
 	</div>
</body>
</html>