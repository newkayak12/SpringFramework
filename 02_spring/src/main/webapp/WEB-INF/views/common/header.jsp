<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${path }/resources/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="${path }/resource/css/style.css" type="text/css">
</head>
<body>
	<div id="container">
		<header>
			<div id="header-container">
				<h2><c:out value="${param.title }"/></h2>
			</div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">
					<img src="${path }/resources/images/logo-spring.png" 
					alt="스프링로고" width="50px"/>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" 
				data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active">
							<a class="nav-link" href="${path }">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="">게시판</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${path }/demo/demo.do">Demo</a>
						</li>
						
						
						
							drop teacher	
						 <li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
								demo
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="${path }/demo/demo.do">Demo등록</a>
								<a class="dropdown-item" href="${path }/demo/demoList.do">Demo목록</a>
							</div>
						</li>
						<li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                     role="button" data-toggle="dropdown" aria-haspopup="true"
                     aria-expanded="false">
                        demo
                     </a>
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${path }/demo/demo2.do">Demo등록</a>
                        <a class="dropdown-item" href="${path }/demo/demoList.do">Demo목록</a>
                     </div>
                  </li>
						
						
					</ul>
				</div>
			</nav>
		</header> --%>


		
		 
		 
		 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${path }/resources/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="${path }/resources/css/style.css" type="text/css">
</head>
<body>
	<div id="container">
		<header>
			<div id="header-container">
				<h2><c:out value="${param.title }"/></h2>
			</div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">
					<img src="${path }/resources/images/logo-spring.png" 
					alt="스프링로고" width="50px"/>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" 
				data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active">
							<a class="nav-link" href="${path }">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="">게시판</a>
						</li>
						<%-- <li class="nav-item">
							<a class="nav-link" href="${path }/demo/demo.do">Demo</a>
						</li>
						 --%>
						
						
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								demo
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="${path }/demo/demo.do">Demo등록</a>
								<a class="dropdown-item" href="${path }/demo/demoList.do">Demo목록</a>
							</div>
							
							
							
						</li>
						
						 
						 
						 <%-- <li class="dropdown">
							<button  type="button" class="dropdown-toggle" id="navbarDropdown"
							 data-toggle="dropdown">
								demo
							</button>
							<div class="dropdown-menu" >
								<a class="dropdown-item" href="${path }/demo/demo.do">Demo등록</a>
								<a class="dropdown-item" href="${path }/demo/demoList.do">Demo목록</a>
							</div>
							
							
							<a class="dropdown-item" href="${path }/demo/demo.do">Demo등록</a>
								<a class="dropdown-item" href="${path }/demo/demoList.do">Demo목록</a> 
						</li>--%>
						
						<li class="nav-item">
							<a class="nav-link " href="${path }/memo/memo.do">메모</a>
						</li>
						<li class="nav-item">
							<a class="nav-link " href="${path }/board/boardlist.do">게시판</a>
						</li>
						
						
						
					</ul>
					
					<c:choose>
						<c:when test="${loginmember==null }">
							<button class="btn btn-outline-success my-2 my-sm-0" type="button" data-toggle="modal" data-target="#loginModal">로그인</button>
							&nbsp;&nbsp;
							<button class="btn btn-outline-success my-2 my-sm-0" type="button" onclick="location.assign('${path}/member/memberEnroll.do')">회원가입</button>
						</c:when>
						<c:otherwise>
						
							<span> <a href="${path }/member/memberview.do">${loginmember.username }님 반갑습니다!</a></span>
							&nbsp;&nbsp;
							<button class="btn btn-outline-success my-2 my-sm-()" type="button" onclick="location.assign('${path}/member/logout.do')">로그아웃</button>
							
						</c:otherwise>
					</c:choose>
				</div>
			</nav>
		</header>
		
		
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModal" aria-hidden="true" >
			<div class="modal-dialog" role="documnet">
				<div class="modal-content">
					<!-- 헤더 -->
					
					
					<div class="modal-header">
						<h5 class="modal-title" id="exmapleModalLabel">로그인</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					
					
					
					<!-- 메인 -->
					<form action="${path }/member/memberlogin.do" method="post">
						<div class="modal-body">
							<input type="text" name="userid" class="form-control" placeholder="아이디입력" required><br>
							<input type="password" name="password" class="form-control" placeholder="비밀번호 입력" required>
						</div>
					
						<div class="modal-footer">
							<button type="submit" class="btn btn-outline-success">로그인</button>
							<button type="button" class="btn btn-outline-success" data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		 
