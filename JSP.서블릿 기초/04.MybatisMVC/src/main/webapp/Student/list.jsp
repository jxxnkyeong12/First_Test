<%@page import="student.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 보기</title>
</head>
<body>
	<h1>학생정보를 보여 줍니다.</h1>
<%-- 	<%=request.getAttribute("list") %> --%> <!-- list를 받아와야지 -->
	
	<%
		ArrayList<StudentDTO> list =(ArrayList<StudentDTO>) request.getAttribute("list");
		for(int i = 0; i<list.size(); i++){%>
		<p><%=list.get(i).getStudent_no() %></p>		
				
		<% }%>

</body>
</html>