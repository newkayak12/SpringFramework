<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="${path }/resources/js/jquery-3.6.0.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link rel ="stylesheet" href="${path }/resources/css/style.css" type="text/css" >	





<meta charset="UTF-8">
<title>HELLOSPRING</title>


<style>
   div#demo-container{
      width:40%;
      padding:15px;
      margin:0 auto;
      border:1px solid lightgray;
      border-radius: 10px;
   }
   </style>

</head>
<body>

		
		<jsp:include page="/WEB-INF/views/common/header.jsp">
			<jsp:param value="demo" name="title"/>
		</jsp:include>

	<section id="container">
			<h1 style="text-align:center" >파라미터 테스트</h1>
		<div id="demo-container">
		
		<form id="devFrm" method="post" >
			<div class="form-group row">
			<label for="devName" class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="devName" name="devName">
			</div>
			</div>
			<div class="form-group row">
			<label for="devAge" class="col-sm-2 col-form-label">나이</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="devAge" name="devAge">
			</div>
			</div>
			<div class="form-group row">
			<label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="devEmail" name="devEmail">
			</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="devGender" id="devGender0" value="M">
					<label class="form-check-label" for="devGender0">남</label>
					</div>
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="devGender" id="devGender1" value="F">
					<label class="form-check-label" for="devGender1">여</label>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label" style="font-size:14px">개발언어</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" name="devLang" id="devLang0" value="Java">
					<label class="form-check-label" for="devLang0">Java</label>
					</div>
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" name="devLang" id="devLang1" value="C">
					<label class="form-check-label" for="devLang1">C</label>
					</div>
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" name="devLang" id="devLang2" value="Javascript">
					<label class="form-check-label" for="devLang2">Javascript</label>
					</div>
				</div>
			</div>
			
		</form>
			<div class="list-group">
				<button type="button" onclick="demo('demo1.do')"; class="list-group-item list-group-item-action">
					HttpRequest로 파라미터 처리하기				
				</button>
			</div>
			<div class="list-group">
				<button type="button" onclick="demo('demo2.do')"; class="list-group-item list-group-item-action">
					@RequestParam을 이용해서 파라미터 처리하기				
				</button>
			</div>
			<div class="list-group">
				<button type="button" onclick="demo('demo3.do')"; class="list-group-item list-group-item-action">
					Command(VO)객체를 이용해서 파라미터 처리하기				
				</button>
			</div>
			<div class="list-group">
				<button type="button" onclick="demo('demo4.do')"; class="list-group-item list-group-item-action">
					Map 이용해서 파라미터 처리하기				
				</button>
			</div>
			<div class="list-group">
				<button type="button" onclick="demo('demo5.do')"; class="list-group-item list-group-item-action">
					추가 데이터 가져오기(header, cookie 등!)			
				</button>
			</div>
			<div class="list-group">
				<button type="button" onclick="demo('insertdev.do')"; class="list-group-item list-group-item-action">
					INSERT INTO DB	
				</button>
			</div>
	</div>
	
			
		
	
	</section>
	
	
<script>
	function demo(url){
		$("#devFrm").attr("action","${path}/demo/"+url);
		$("#devFrm").submit();
		
	}

</script>


	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
		
		
</body>
</html>