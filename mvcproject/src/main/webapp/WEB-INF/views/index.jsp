<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>springboot main</h1>
	<form action ="${pageContext.request.contextPath }/selectOneMember" method="get">
		<input type="text" name= "userId" placeholder="아이디 입력">
		<input type="submit" value= "찾기">
	</form>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>gender</th>
			<th>email</th>
			<th>phone</th>
			<th>address</th>
		</tr>
		<c:forEach var="m" items="${list }">
			
			<tr>
				<td>${m.userId }</td>
				<td>${m.userName }</td>
				<td>${m.age }</td>
				<td>${m.gender }</td>
				<td>${m.email }</td>
				<td>${m.phone }</td>
				<td>${m.address }</td>
			
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>