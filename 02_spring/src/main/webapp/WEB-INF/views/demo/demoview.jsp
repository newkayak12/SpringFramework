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



</head>
<body>

		
	<jsp:include page="/WEB-INF/views/common/header.jsp">
		<jsp:param value="view" name="title"/>
	</jsp:include>




	<table class="table">
		<c:forEach items="${requestScope.list }" var="i" varStatus="vs" >
		
			<c:if test="${ vs.first}">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">나이</th>
					<th scope="col">이메일</th>
					<th scope="col">성별</th>
					<th scope="col">개발가능언어</th>
					<th scope="col">수정</th>
				</tr>
			</c:if>
			
			<tr>
				<td>${i.devNo }</td>
				<td>${i.devName }</td>
				<td>${i.devAge }</td>
				<td>${i.devEmail }</td>
				<td>${i.devGender }</td>
				<td>
					<c:forEach items="${i.devLang }" var="j" varStatus="vs" >
						${j }
						
						<c:if test="${!vs.last }">
						,
						</c:if>
						
					</c:forEach>
				</td>
				<td>
					<input type="button" value="수정하기" onclick="fn_modi(${i.devNo})">
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<script>
		const fn_modi=(i)=>{
			
		}
	</script>


	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
		
		
</body>
</html>