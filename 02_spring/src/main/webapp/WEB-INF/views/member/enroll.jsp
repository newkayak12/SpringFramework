<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>  
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="${path }/resources/js/jquery-3.6.0.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

		<style>
			div#enroll-container{width:400px; margin:0 auto; text-align:center;}
			div#enroll-container input, div#enroll-container select {margin-bottom:10px;}
			div#userid-container{position:relative;padding:0px}
			div#userid-container span.guide{display:none; font-size:12px;position:absolute;top:12px;right:10px;}
			div#userid-container span.ok{color:green;}
			div#userid-container span.error{color:red;}
			
		</style>
<div id="enroll-container">
			<form name="memberEnrollFrm" action="${path }/member/memberenroll.fin" >
			
				<div id="userid-container">
					<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="userId" id="userId_" required>
					<button type="button" onclick="fn_jsonView()" class="btn btn-outline-success">jsonview</button>&nbsp;&nbsp;
					<button type="button" onclick="fn_responseBody()" class="btn btn-outline-success">responseBody</button>
					<span class="guide ok">이 아이디는 사용이 가능합니다.</span>
					<span class="guide error">이 아이디는 사용이 불가능합니다.</span>
				</div>
				<input type="password" class="form-control" placeholder="비밀번호" name="password" id="password_" required>
				<input type="password" class="form-control" placeholder="비밀번호확인" id="password2" required>
				<input type="text" class="form-control" placeholder="이름" name="userName" id="userName" required>
				<input type="number" class="form-control" placeholder="나이" name="age" id="age">
				<input type="email" class="form-control" placeholder="이메일" name="email" id="email" required>
				<input type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" required>
				<input type="text" class="form-control" placeholder="주소" name="address" id="address">
				<select class="form-control" name="gender" required>
					<option value="" disabled selected>성별</option>
					<option value="M">남</option>
					<option value="F">여</option>
				</select>
				<div class="form-check-inline form-check">
					취미 : &nbsp; 
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby0" value="운동"><label for="hobby0" class="form-check-label">운동</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby1" value="등산"><label for="hobby1" class="form-check-label">등산</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby2" value="독서"><label for="hobby2" class="form-check-label">독서</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby3" value="게임"><label for="hobby3" class="form-check-label">게임</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby4" value="여행"><label for="hobby4" class="form-check-label">여행</label>&nbsp;
				</div>
				<br />
				<input type="submit" class="btn btn-outline-success" value="가입" >&nbsp;
				<input type="reset" class="btn btn-outline-success" value="취소">
			</form>
		</div>
		
		<script>
			$("#userId_").keyup(e=>{
				const userId= e.target.value.trim();
				
					if(userId.length<0){
						alert('아이디를 입력하세요')
						return
					}else if(userId.length>=4){
						 
							$.get("${path}/member/checkUserId.do?userId="+userId, data=>{
								console.log(data)
								
								/* if (data =='true'){
									$(".error").css("display","none")
									$(".ok").css("display","block")
								} else{
									
									$(".ok").css("display","none")
									$(".error").css("display","block")
								} */
								/*  writer로 그냥*/
								
								let member = JSON.parse(data);
								if (member == null  ){
									$(".error").css("display","none")
									$(".ok").css("display","block")
								} else{
									$(".ok").css("display","none")
									$(".error").css("display","block")
								}
								
							})
						
						/* $ajax({
							url:"${path}/member/checkUserId.do",
							data:{"userId":userId},
							success:data=>{
								console.log(data);
								
							}
						}) */
						
						
					}
				
			})
			
			/*----------------------------  */
			function fn_jsonView(){
				$.get("${path}/member/checkIdJsonView.do?userId="+$("#userId_").val(), data=>{
					console.log(data);
						if (data["isAble"]){
							$(".error").css("display","none")
							$(".ok").css("display","block")
						} else{
							$(".ok").css("display","none")
							$(".error").css("display","block")
						}
					
				})
				
			}
			
			/* ---------------------------------- */
			function fn_responseBody(){
				$.get("${path}/member/checkIdResponseBody.do?userId="+$("#userId_").val(), data=>{
					console.log(data);
					
					
					
				})/*get닫기  */
			}
		</script>
		
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>