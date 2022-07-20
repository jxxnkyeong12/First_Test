<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/include/layout.jsp"%>
<div class="container-fluid px-4">
<h3 class="mt-4">공지글 안내</h3>
<table class='table'>
<tr><th class='w-px140'>제목</th><td colspan='5'>${dto.title }</td></tr>
<tr><th>작성자</th><td>${dto.name }</td>
	<th class = 'w-px120'>작성일자</th><td>${dto.writerdate}</td>
	<th class = 'w-px80'>조회수</th><td>${dto.readcnt}</td>
</tr>
<tr><th>내용</th><td colspan='5'>${fn: replace(dto.content, crlf,'<br>') }</td></tr>
</table>


	<div class ='btnSet'>
		<a class ='btn-fill' href='list.no'>목록으로</a>
	</div>

</div>
<%@ include file="/include/footer.jsp"%>
</body>
</html>