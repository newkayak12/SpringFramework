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
				
		 <div id="board-container">
        <input type="text" class="form-control" placeholder="제목" name="boardTitle" id="boardTitle" value="${detail.boardTitle }" required>
        <input type="text" class="form-control" name="boardWriter" value="${detail.boardWriter }" readonly required>
		
        <textarea class="form-control" name="boardContent" id="boardContent" placeholder="내용" required>${detail.boardContent }</textarea>
    </div>
    
    <div id="button-container">
    
    
         <c:if test="${detail.attachment.size()>0 }">
         	<c:forEach var ="a" items="${detail.attachment }" varStatus="vs">
         		<button type="button" class="btn btn-outline-primary btn-block btn-sm"  onclick="location.assign('${path}/board/fileDownload.do?oriname=${a.originalFileName }&rename=${a.renamedFileName }')">
         			<c:out value="첨부파일 : ${vs.count } - ${a.originalFileName }"/>
         		</button>
         		
         	</c:forEach>	
         </c:if>
         
         
    	<c:if test="${loginmember.userid !=null && loginmember.userid==detail.boardWriter }">
    		 <button type="button" class="btn btn-outline-success btn-block btn-sm" onclick="fn_modify()">수정하기</button>
    	</c:if>
         <button type="button" class="btn btn-outline-danger btn-block btn-sm"  onclick="location.assign('${path}/board/boardlist.do')">돌아가기</button>
         
    </div>

     <style>
    div#board-container{width:400px; margin:0 auto; text-align:center;}
    div#board-container input,div#board-container button{margin-bottom:15px;}
    div#board-container label.custom-file-label{text-align:left;}
    </style>
    
    <script>
    	const fn_modify=()=>{
    		
    		
    		location.assign('${path}/board/boardmodify.do?boardTitle='+$("#boardTitle").val()+"&boardContent="+$("#boardContent").html()+"&boardNo=${detail.boardNo}");
    	}
    </script>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
		
		
