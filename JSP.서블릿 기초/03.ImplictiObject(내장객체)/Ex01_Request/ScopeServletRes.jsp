<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>콘드롤러에서 다시 돌아옴 뷰로</h1>
	 <% String Attr= (String)request.getAttribute("attr"); %>
	 <%= Attr %>
	 
	 
</body>
</html>