<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/628c8d2499.js" crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.gstatic.com" />
	<link rel="stylesheet" href="<c:url value='/resources/css/header.css'/>" type="text/css" />
	<link rel="stylesheet" href="<c:url value='/resources/css/header_new.css'/>" type="text/css" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	
<script>
function search() {
	if (form.keyword.value == "") {
		alert("검색어를 입력해주세요.");
		form.keyword.focus();
		return false;
	} 
	
	form.submit();
}
</script>
	
</head>
<table align="center" width="100%">
	<tr>
		<td class="txLeft">
			<a href="<c:url value='/home/main'/>"><img id="logo" src="<c:url value='/resources/img/logo.png'/>"></a>
		</td>
		<td></td>

		<td class="txCenter">
			<form name="form" method="POST" action="<c:url value='/home/search'/>">
				<table align="center">
					<tr>
						<td><span class="input"> <input size="40"
								name="keyword" type="text" placeholder="다양한 프로젝트를 검색해보세요." />
						</span></td>
						<td>
							<div class="button" onClick="search()"></div>
						</td>
					</tr>
				</table>
			</form>
		</td>
		<td></td>
		<td class="txRight">
			<table>
				<tr>
					<td>
						<c:choose>
							<c:when test="${ecoerId == null}">
								<div class="button_in" onClick="location.href='<c:url value='/user/loginform'/>';"></div>
							</c:when>
							<c:otherwise>
								<div class="userinfo"><a>${ecoerId}님<br/>환영합니다.</a></div>
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${ecoerId == null}">
								<div class="button_reg" onClick="location.href='<c:url value='/user/register'/>';"></div>
							</c:when>
							<c:otherwise>
								<div class="button_out" onClick="location.href='<c:url value='/user/logout'/>';"></div>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<div id="logo_area">
	
	
</div>
<nav id="menu">
    <div class="menu-item">
        <div class="menu-text">
            <a href="<c:url value='/home/main' />">Home</a>
        </div>
        <div class="sub-menu">
	        <a href="<c:url value='/home/main' />">
            <div class="icon-box">
                <div class="icon"><i class="fas fa-globe-asia"></i></div>
                <div class="text">
                    <div class="title"> Ecoding <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 다양한 환경보호 프로젝트를 만나보세요. </div>
                </div>
            </div>
            <div class="icon-box">
                <div class="icon"><i class="fal fa-crown"></i></div>
                <div class="text">
                    <div class="title"> 인기 프로젝트 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 인기 프로젝트를 만나보세요. </div>
                </div>
            </div>
            <div class="icon-box">
                <div class="icon"><i class="fal fa-thumbs-up"></i></div>
                <div class="text">
                    <div class="title"> 추천 프로젝트 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> Eco-Score가 높은 프로젝트를 만나보세요.</div>
                </div>
            </div>
            </a>
            <div class="sub-menu-holder"></div>
        </div>
    </div>
    <div class="menu-item highlight">
        <div class="menu-text">
            <a href="<c:url value='/home/list' />">Support</a>
        </div>
        <div class="sub-menu">
            <div class="icon-box">
                <div class="icon"><i class="far fa-comments-dollar"></i></div>
                <div class="text">
                    <div class="title"> 프로젝트 후원하기 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 프로젝트를 둘러보고 후원하세요. </div>
                </div>
            </div>
            <div class="icon-box">
                <div class="icon"><i class="far fa-heart"></i></div>
                <div class="text">
                    <div class="title"> 프로젝트 찜하기 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 마음에 드는 프로젝트를 찜하세요. </div>
                </div>
            </div>
            <div class="icon-box">
                <div class="icon"><i class="far fa-scroll"></i></div>
                <div class="text">
                    <div class="title"> 프로젝트 등록하기 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 환경을 위한 프로젝트를 개설하세요. </div>
                </div>
            </div>
            <div><br/></div>
            <div class="bottom-container">
                프로젝트를 개설하고 싶으신가요?
                <c:choose>
	                <c:when test="${ecoerId ne null}">
	                	<a href="<c:url value='/project/view' />">시작하기</a>
	                </c:when>
	                <c:otherwise>
	                	<a href="<c:url value='/user/register' />">회원가입</a>
	                </c:otherwise>
                </c:choose>
            </div>
            <div class="sub-menu-holder"></div>
        </div>
    </div>
    <div class="menu-item">
        <div class="menu-text">
            <a href="<c:url value='/board/list?cid=0'/>">Community</a>
        </div>
        <div class="sub-menu">
        	<a href="<c:url value='/board/list?cid=0'/>">
            <div class="icon-box">
                <div class="icon"><i class="far fa-comments"></i></div>
                <div class="text">
                    <div class="title"> 자유게시판 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 환경보호 관련 팁, 일상에 대해 이야기하세요. </div>
                </div>
            </div>
            </a>
            <a href="<c:url value='/board/list?cid=1'/>">
            <div class="icon-box">
                <div class="icon"><i class="far fa-users-class"></i></div>
                <div class="text">
                    <div class="title"> 후기게시판 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 프로젝트 후기, 리워드에 대해 이야기하세요. </div>
                </div>
            </div>
            </a>
        </div>
    </div>
    <div class="menu-item">
        <div class="menu-text">
            <a href="#">Category</a>
        </div>
        <div class="sub-menu">
            <div class="icon-box">
                <div class="icon"><i class="far fa-heart"></i></div>
                <div class="text">
                    <div class="title"> 항목 1 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 항목 1 설명 </div>
                </div>
            </div>
            <div class="icon-box">
                <div class="icon"><i class="far fa-heart"></i></div>
                <div class="text">
                    <div class="title"> 항목 2 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 항목 2 설명 </div>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${ecoerId ne null}">
    <div class="menu-item">
        <div class="menu-text">
            <a href="<c:url value='/user/view'>
            	<c:param name='ecoerId' value='${ecoerId}'/>
			</c:url>">Mypage</a>
        </div>
        <div class="sub-menu">
        	<a href="<c:url value='/user/support/listView' />">
	            <div class="icon-box">
		            <div class="icon"><i class="fas fa-shopping-basket"></i></div>
					<div class="text">
	                    <div class="title"> 후원 내역 <i class="far fa-arrow-right"></i></div>
	                    <div class="sub-text"> 내가 후원한 프로젝트 목록을 한 눈에 살펴봅니다. </div>
	                </div>
	            </div>
            </a>
            <a href="<c:url value='/user/interest/listView' />">
	            <div class="icon-box">
	                <div class="icon"><i class="fal fa-heart"></i></div>
	                <div class="text">
	                    <div class="title"> 관심 내역 <i class="far fa-arrow-right"></i></div>
	                    <div class="sub-text"> 내가 찜한 프로젝트 목록을 한 눈에 살펴봅니다. </div>
	                </div>
	            </div>
            </a>
            <a href="<c:url value='/user/project/listView' />">
            <div class="icon-box">
                <div class="icon"><i class="fas fa-book-spell"></i></div>
                <div class="text">
                    <div class="title"> 나의 프로젝트 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 커뮤니티에 작성한 글을 한 눈에 살펴봅니다. </div>
                </div>
            </div>
            </a>
            <a href="<c:url value='/user/post/listView' />">
            <div class="icon-box">
                <div class="icon"><i class="fas fa-clipboard-list"></i></div>
                <div class="text">
                    <div class="title"> 나의 커뮤니티 <i class="far fa-arrow-right"></i></div>
                    <div class="sub-text"> 커뮤니티에 작성한 글을 한 눈에 살펴봅니다. </div>
                </div>
            </div>
            </a>
            <div class="sub-menu-holder"></div>
        </div>
    </div>
    </c:if>
    <div id="sub-menu-container">
        <div id="sub-menu-holder">
            <div id="sub-menu-bottom">

            </div>
        </div>
    </div>
</nav>
<div class="new_clear"><br/></div>