<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<jsp:include page="../include/layout.jsp"></jsp:include>
<div class = "container-fluid px-4">
<h3 class = "mt-4">공지글쓰기</h3>

<div class = 'list-top'>
	<ul>
<!-- 		 관리자회원으로 로그인한 경우만 글쓰기 가능 -->
		<li><a class = 'btn-fill' href ='new.no'>글쓰기</a></li>
	</ul>
</div>

	<table class = "table table-hover">
			<tr>
				<th>제목</th>	
				<th class = 'w-px120'>작성자</th>	
				<th class = 'w-px120'>작성일자</th>	
			</tr>
		</table>
</div>
<jsp:include page="../include/layout.jsp"></jsp:include>
</body>
</html>