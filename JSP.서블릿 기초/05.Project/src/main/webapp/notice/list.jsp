<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
<jsp:include page="../include/layout.jsp"></jsp:include>
<div class = "container-fluid px-4">
	<h3 class ="mt-4">공지목록 </h3>
	
	<div class ='list-top'>
		<ul>
			<li><a class ='btn-fill' href = 'new.no'>글쓰기</a></li> <!-- 요청은 컨트롤러가 받아줄 준비를 하고 있어야해 -->
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
  
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>