<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
	<th class='w-px120'>작성일자</th><td class='w-px120'>${dto.writerdate}</td>
	<th class='w-px80'>조회수</th><td class='w-px80'>${dto.readcnt}</td>
</tr>
<tr><th>내용</th><td colspan='5'>${fn: replace(dto.content, crlf, '<br>') }</td></tr>
<tr><th>첨부파일</th>
	<td>${dto.filename}
		<c:if test='${dto.filename != null}'>
		<a href='download.no?id=${dto.id}'><i class="font-b fa-solid fa-file-arrow-down"></i></a>
		</c:if>
	</td>
</tr>
</table>

<div class='btnSet'>
	<a class='btn-fill' href='list.no'>목록으로</a>
	<!-- 관리자로 로그인한 경우만 수정/삭제 가능 -->
<%-- 	<c:if test='${userInfo.admin eq "Y"}'> --%>
	<!-- 작성자로 로그인한 경우만 수정/삭제 가능 -->
	<c:if test='${userInfo.userid eq dto.writer}'>
	<a class='btn-fill' href='modify.no?id=${dto.id}'>정보수정</a>
	<a class='btn-fill' href='delete.no?id=${dto.id}'>정보삭제</a>
	</c:if>
	<!-- 로그인된 경우 답글쓰기 가능 -->
	<c:if test='${!empty userInfo}'>
	<a class='btn-fill' href='reply.no?id=${dto.id}'>답글쓰기</a>
	</c:if>
</div>
</div>
<%@ include file="/include/footer.jsp"%>
</body>
</html>