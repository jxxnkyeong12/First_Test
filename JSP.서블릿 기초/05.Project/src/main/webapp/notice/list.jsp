<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/include/layout.jsp"%>
<div class="container-fluid px-4">
<h3 class="mt-4">공지글목록</h3>

<form method="post" action = "list.no">
<div class='list-top'>
	<ul>
		<!-- 관리자회원으로 로그인한 경우만 글쓰기 가능 -->
		<c:if test='${userInfo.admin eq "Y"}'>
		<li><a class='btn-fill' href='new.no'>글쓰기</a></li>
		</c:if>
	</ul>
</div>
<input type ="hidden" name = "curPage" value ="1">
</form>

<table class="table table-hover">
	<tr><th class ='w-px80'>번호</th>
		<th>제목</th>
		<th class='w-px120'>작성자</th>
		<th class='w-px120'>작성일자</th>
		<th class='w-px120'>첨부파일</th>
	</tr>	
	<c:forEach items="${page.list}" var="dto">  <!--forEach는 배열 넣어야 하고! page는 배열이 아니야. 그 안에 있는 list를 넣어야지 ! -->
	<tr><td>${dto.no }</td>
		<td><c:forEach var="no" begin="1" end="${dto.indent}">
				${dto.indent eq no 
				? '<i class="font-b fa-regular fa-comment-dots"></i>' : '&nbsp;&nbsp;&nbsp;'}
			</c:forEach>
			<a href='detail.no?id=${dto.id}'>${dto.title}</a></td>
		<td>${dto.name}</td>
		<td>${dto.writerdate}</td>
		<td>${empty dto.filename ? '' : '<i class="font-b fa-solid fa-paperclip"></i>' }</td>
	</tr>
	</c:forEach>
</table>
<div class = 'btnSet'>
	<jsp:include page="/include/page.jsp"/>
</div>

		<%-- <td>${dto.writer}</td> 하면 작성자에 admin이 나온다!--%>



</div>
<%@ include file="/include/footer.jsp"%>

</body>
</html>