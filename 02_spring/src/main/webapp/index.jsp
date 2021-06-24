<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %>

<c:set var = "path" value="${pageContext.request.contextPath }/" />  



	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="${path }/resources/js/jquery-3.6.0.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link rel ="stylesheet" href="${path }/resources/css/style.css" type="text/css" >	





		
		<jsp:include page="/WEB-INF/views/common/header.jsp">
			<jsp:param value="Main" name="title"></jsp:param>
		</jsp:include>
				
		<section id="content">
			<img src="${path }/resources/images/logo-spring.png" id="center-image" alt="springLogo">
		</section>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
		
		
