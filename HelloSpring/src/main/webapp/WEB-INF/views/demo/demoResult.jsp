<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %>
<c:set var = "path" value="${pageContext.request.contextPath }/" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="${path }/resources/js/jquery-3.6.0.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link rel ="stylesheet" href="${path }/resources/css/style.css" type="text/css" >	

</head>
<style>
	table#tbl-dev{
	margin : 0 auto;
	width: 50%
	}

</style>
<body>

		
		<jsp:include page="/WEB-INF/views/common/header.jsp">
			<jsp:param value="DemoResult" name="title"></jsp:param>
		</jsp:include>
				
		<section id="content">
			<table class = "table" id ="tbl-dev">
				<tr>
					<th scope="col">이름</th>
					<td>${dev.devName}</td>
				</tr>
				<tr>
					<th>나이</th>
					<td>${dev.devAge}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${dev.devEmail}</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${dev.devGender}</td>
				</tr>
				<tr>
					<th>개발가능 언어</th>
					<td>
						<c:choose>
							<c:when test="${dev.devLang!=null }">
								<c:forEach var="i" items="${dev.devLang }">
									<p>${i }</p>
								
								</c:forEach>
							</c:when>
							
							<c:otherwise>
								<span>None</span>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			
			</table>
			
			
			
		</section>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>