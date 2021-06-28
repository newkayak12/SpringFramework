<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="memo" name="title"/>
</jsp:include>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<c:set var="path" value="${pageContext.request.contextPath }"/>  
<!-- jQuery library -->
<script src="${path }/resources/js/jquery-3.6.0.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${path }/resources/css/style.css" type="text/css">
<style>
    div#memo-container{width:60%; margin:0 auto;}
</style>

	<section id="content">
	    <div id="memo-container">
	        <form action="${pageScope.path }/memo/insert.do" class="form-inline">
	            <input type="text" class="form-control col-sm-6" name="memo" placeholder="메모" required/>&nbsp;
	            <input type="password" class="form-control col-sm-2" name="password" maxlength="4" placeholder="비밀번호" required/>&nbsp;
	            <button class="btn btn-outline-success" type="submit" >저장</button>
	        </form>
	    </div>
	    
	    <!-- 위가 입력 아래가 출력 -->
	     <br />
	        <!-- 메모목록 -->
	        <table class="table">
	            <tr>
	                <th scope="col">번호</th>
	                <th scope="col">메모</th>
	                <th scope="col">날짜</th>
	                <th scope="col">삭제</th>
	            </tr>
	            
	            <c:forEach items="${requestScope.list }" var="i">
	            	<tr>
						<td scope="col">${i.memoNo }</td>            	
						<td scope="col">${i.memo }</td>            	
						<td scope="col"><fmt:formatDate value="${i.memoDate }" pattern="yy년 MM월 dd일 HH시 mm분 ss초 저장" /></td>            	
						<td scope="col"><input type="button" class="btn btn-success" value="삭제" data-toggle="modal" data-target="#deleteModal" onclick="fn_del('${i.memoNo}');"></td>            	
	            	</tr>
	            </c:forEach>
		<!-- 내용출력 -->
	        </table>
        
        
        </section>
        
        <div class ="modal" id="deleteModal">
        	<div class="modal-dialog">
        		<div class="modal-content">
					
					<div class="modal-header">
						<h4 class="modal-title">비밀번호 입력</h4>
						<button type="button" class="close" data-dismiss="modal">&times</button>
					</div>
					
					<div class="modal-body">
						<input type="hidden" id="hiddenNo" name="hiddenNo" value="">
						<input type="password" id="password_" name="password">
					</div>
					
					<div class="modal-footer">
					
						<button type="button" class="btn btn-success" onclick="fn_delete()">삭제</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">close</button>
					</div>
        		</div>
        	</div>
        </div>
        
        
        <script>
        	const fn_del=(e)=>{
        		
        		$("#hiddenNo").val(e);
        		console.log($("#hiddenNo").val())
        		/* location.assign('${pageScope.path}/memo/delete.do?no='+e); */
        	}
			
        	const fn_delete=()=>{
        		console.log($("#hiddenNo").val())
        		console.log($("#password_").val())
        		location.assign('${pageScope.path}/memo/delete.do?no='+$("#hiddenNo").val()+'&pw='+$("#password_").val());
        		
        	}
        	
        </script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>