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
				
		<section id="board-container" class="container">
		<div class="d-flex  justify-content-between">
      	  <p class="align-self-center">총 ${total }건의 게시물이 있습니다.</p>&nbsp;&nbsp;
      	  <button type="button" class="btn btn-outline-success btn-block" style="width:20%" onclick="location.assign('${path}/board/boardWrite.do')">글쓰기</button>
		</div>
        
        <table id="tbl-board" class="table table-dark table-striped table-hover">
        <thead class="thead-light">
            <tr>
                <th >번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>첨부파일</th>
                <th>조회수</th>
            </tr>
           </thead>
            <!-- 내용출력할것 -->
            <c:choose>
	            <c:when test="${requestScope.list !=null }">
            		<c:forEach items="${list }" var="i">
	             <tr>
	             
	             
	             	
            			<td class="cols"><c:out value="${i.boardNo }"/></td>
            			<td class="cols">
            				<a href="${path }/board/boarddetail.do?boardNo=${i.boardNo}" class="text-decoration-none text-reset">
            					<c:out value="${i.boardTitle }"/>
            				</a>
           				</td>
            			<td class="cols"><c:out value="${i.boardWriter }"/></td>
            			<td class="cols"><fmt:formatDate value="${i.date }"/></td>
            			<td class="cols">
           			
            				<c:choose>
	            				<c:when test="${i.attachment.originalFileName !=null}">
									<img alt="file" src="${path }/resources/images/file.png" width="25px">
								</c:when>
								<c:otherwise>
									<p>NO_ATTACHMENT</p>
								</c:otherwise>
							</c:choose>
						</td>
            			<td scope="col"><c:out value="${i.boardReadCount }"/></td>
            		
	            </tr>		
            		</c:forEach>
	            </c:when>
	            
	            
	            
	            
	            <c:otherwise>
	            	<tr>
	            		<td colspan="6">NO_DATA</td>
	            	</tr>
	            </c:otherwise>
            </c:choose>
           
        </table> 
        <div id="pagebar-container">
        	${requestScope.pageBar }
        </div>
</section>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
		
		
