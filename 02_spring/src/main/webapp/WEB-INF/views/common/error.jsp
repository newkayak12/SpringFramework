<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
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
		<!-- <p> 3초후 메인으로 이동합니다.</p> -->
		<h1 id="errorp" style="text-align: center">5초 후 이동</h1>
		<h1 style="text-align: center"><%=exception.getMessage() %></h1>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
		
		


<script>
	/* setTimeout(() => {
		location.replace("${path}/")
	}, 3000); */
	let count =5;
	setInterval(() => {
		
		
			count=count -1;
			$("#errorp").html(count+"초 후 이동");
		
		if(count ==0){
			location.replace("${path}/")
		}
			
		
	}, 1000);
</script>
