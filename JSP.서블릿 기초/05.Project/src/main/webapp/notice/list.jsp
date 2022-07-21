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

<div class='list-top'>
	<ul>
		<!-- 관리자회원으로 로그인한 경우만 글쓰기 가능 -->
		<c:if test='${userInfo.admin eq "Y"}'>
		<li><a class='btn-fill' href='new.no'>글쓰기</a></li>
		</c:if>
	</ul>
</div>
<table class="table table-hover">
	<tr><th class ='w-px80'>번호</th>
		<th>제목</th>
		<th class='w-px120'>작성자</th>
		<th class='w-px120'>작성일자</th>
	</tr>	
	<c:forEach items="${list}" var="dto">
	<tr><td>${dto.no }</td>
		<td><a href='detail.no?id=${dto.id}'>${dto.title}</a></td>
		
		<td>${dto.name}</td>
		<td>${dto.writerdate}</td>
	</tr>
	</c:forEach>
</table>


		<%-- <td>${dto.writer}</td> 하면 작성자에 admin이 나온다!--%>



</div>
<%@ include file="/include/footer.jsp"%>

</body>
</html>