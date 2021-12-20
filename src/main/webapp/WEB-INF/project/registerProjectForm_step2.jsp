<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<c:import url="/WEB-INF/view/header.jsp"></c:import>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/projectRegister.css'/>"/>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<script>
	    function projectCreate(targetUri) {
	    	form.action = targetUri; 
	    	form.submit();
	    }
	    document.getElementById( 'pro' ).value = '50';
	    
	    function div_show() {
	        document.getElementById("thumbnailVideo").style.display = "block";
	    }
	    
	    function updateVideo() {
	    	var form = document.getElementById('videoDiv');
	    	
	    	var text = document.createTextNode("\u00a0");
	    	form.appendChild(text);
	    	
	    	var video = document.createElement('input');
	    	video.type = 'file';
	    	video.name = 'thumbnailVideo';
	    	form.appendChild(video);
	    }
	    
	    function updateImage() {
	    	var form = document.getElementById('imageDiv');
	    	
	    	var text = document.createTextNode("\u00a0");
	    	form.appendChild(text);
	    	
	    	var image = document.createElement('input');
	    	image.type = 'file';
	    	image.name = 'thumbnailImage';
	    	form.appendChild(image);
	    }
	    
	    function updateFile() {
	    	var form = document.getElementById('fileDiv');
	    	
	    	var text = document.createTextNode("\u00a0");
	    	form.appendChild(text);
	    	
	    	var file = document.createElement('input');
	    	file.type = 'file';
	    	file.name = 'projectFile';
	    	form.appendChild(file);
	    }
	</script>
	<style>     
	    #step02 {
	    	background-color: #87CEFA;
	    	color: white;
	    }
	</style>
</head>
<body>
 <div class="main">
    	<a href="<c:url value='/project/view' />" target="_self">프로젝트 등록</a>
    	<span class="step"> > Step 01 > Step 02</span>
    </div>
	<c:import url="/WEB-INF/project/register.jsp">
		<c:param name="main"></c:param>
	</c:import>
		<div id="enrollProgress">
	    		진행도 <progress value="0.4"></progress>
	    	</div>
	    </div>
     <div class="right">
     	<form name="form" method="post" enctype="multipart/form-data" action="<c:url value='/project/register/file' />">
 			<p>Q1. 프로젝트 대표 영상을 첨부해주세요.(10MB 미만만 가능).<c:if test="${project.projectId != -1}"> 수정을 원하는 경우에만 파일을 첨부해주세요.</c:if></p>
			&nbsp<input type="file" name="thumbnailVideo">
			<p>Q2.프로젝트 대표 이미지를 첨부해주세요.<c:if test="${project.projectId != -1}"> 수정을 원하는 경우에만 파일을 첨부해주세요.</c:if></p>
			&nbsp<input type="file" name="thumbnailImage">
			<br><br>
			<p>Q3. 프로젝트와 관련된 각종 인증 정보 및 기타 서류를 첨부해주세요.<c:if test="${project.projectId != -1}"> 수정을 원하는 경우에만 파일을 첨부해주세요.</c:if></p>
			&nbsp<input type="file" name="projectFile">
			<p>Q4. 상세한 프로젝트 설명을 작성해주세요.</p>
			&nbsp<textarea rows="5" cols="100" name="detailInfo">${project.detailInfo}</textarea>
			<p>Q5. 예산 사용 및 일정 계획을 작성해주세요.</p>
			&nbsp<textarea rows="5" cols="100" name="planInfo">${project.planInfo}</textarea>
			<p>Q6. 교환 및 환불 안내 사항을 작성해주세요.</p>
			&nbsp<textarea rows="5" cols="100" name="exchangeInfo">${project.exchangeInfo}</textarea>
			<p></p>
			&nbsp<button name="step" class="goNext" value="step3">Step 03</button>
		</form>
     </div>
</body>
</html>