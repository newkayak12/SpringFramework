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



<!-- 
	
	new해서 jsp 만들고... template드가서 이렇게 집어 넣고 쓰세요!
	
	
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %> --%>
==============================================================================



c:set var = "path" value="$${pageContext.request.contextPath }/"  

	section id="container"
	
	/section

jsp:include page = "/WEB-INF/views/common/footer.jsp"

템플릿을 이렇게 만들어요!


 -->
 	 <style>
	    div#board-container{width:400px; margin:0 auto; text-align:center;}
	    div#board-container input{margin-bottom:15px;}
    </style>
				



		
		<jsp:include page="/WEB-INF/views/common/header.jsp">
			<jsp:param value="Main" name="title"></jsp:param>
		</jsp:include>
				
				<div id="board-container">
        <form name="boardFrm" action="${path }/board/insertBoard.do" method="post" enctype="multipart/form-data"  >
            <input type="text" class="form-control" placeholder="제목" name="boardTitle" id="boardTitle" required>
            <input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="boardWriter" value="${loginmember.userid}" readonly required>
            
            
<!-- 1  -->   
            <div class="input-group mb-3" style="padding:0px;">
                <!-- 
                	단순히 cos.jar를 설치하는 것만으로는 requestdispatcher를 넘어가서 handlermapper를 넘어가는 구조라 새로운 라이브러리가 필요
                	commons-io > 2.6
                	commons-fileupload > 1.3.3
                	버젼을 받으시면 됩니다.
                	
                	pom.xml 열고 받아오세여 그러면 mvn이 알아서 작업하겠죠??
                 -->
                <div class="input-group-prepend" style="padding:0px;">
                    <span class="input-group-text">첨부파일1</span>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" name="upFile" id="upFile1">
                    <label class="custom-file-label" for="upFile1">파일을 선택하세요</label>
                </div>
                
            </div>
                    <!-- 여러 개의 파일 업로드를 위해서 위의 것을 복사해서 붙여넣기 할게요-->
            
            
            
<!-- 2  -->         
            <div class="input-group mb-3" style="padding:0px;">

   
                <div class="input-group-prepend" style="padding:0px;">
                    <span class="input-group-text">첨부파일1</span>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" name="upFile" id="upFile1">
                    <label class="custom-file-label" for="upFile1">파일을 선택하세요</label>
                </div>
                
                    <!-- 여러 개의 파일 업로드를 위해서 위의 것을 복사해서 붙여넣기 할게요-->
                
            </div>
            
            <textarea class="form-control" name="boardContent" placeholder="내용" required></textarea>
            <br />
            <input type="submit" class="btn btn-outline-success" value="저장" >
        </form>
    </div>

   
				
				
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
		
		<script>
				$(function(){
					$("[name=upFile]").change(e=>{
						const fileName = $(e.target).prop("files")[0].name;
						
						$(e.target).next(".custom-file-label").html(fileName);
					});
				})
		</script>
		
