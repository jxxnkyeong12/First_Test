<<<<<<< HEAD
<%@page import="student.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

/* h1 {
  text-align: center;
}
table {
  width: 80%;
  border-collapse: collapse;
  font-family: Arial, Helvetica, sans-serif;
  margin: 0px, auto;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

td, th {
  border: 1px solid #000;
  padding: 8px;
}

th {
  color: white;
  background-color: #673ab7;
}

td {
  text-align: center;
}
 */
</style>
<meta charset="UTF-8">
<title>학생 정보 보기</title>
</head>
<body>

	<%@ include file = "/include/header.jsp"  %> <!-- 뒤로 한칸 올라가니가 /해줘 -->
	
	<!-- 테이블 태그로 학생의 이름 , 성 , user_id, first_name, last_name-->
	
	
	<h1>학생정보를 보여 줍니다.</h1>
	<%-- <%response.setIntHeader("Refresh", 3); %>  --%> <!--  3초에 한번씩 새로고침이 되서 다른사람이 삭제한게 실시간으로 확인가능!-->
	<table class="styled-table">
		<thead>
	<tr>
		<th>학생번호</th> <!-- th는 머리부분! -->
		<th>학생이름</th>
		<th>아이디</th>
		<th>성</th>
		<th>이름</th>
	</tr>
		</thead>
	<tbody>
<%-- 	<%=request.getAttribute("list") %> --%> <!-- list를 받아와야지 -->
	
		<%
		ArrayList<StudentDTO> list =( ArrayList<StudentDTO> ) request.getAttribute("list");
		for(int i = 0 ;  i<list.size(); i ++){
	%>
		
	<tr>
		<td><a href="detail.st?student_no=<%=list.get(i).getStudent_no() %>&user_id=<%=list.get(i).getUser_id()%>"><%=list.get(i).getStudent_no() %></a></td>
		<td><a href="detail.st"><%=list.get(i).getStudent_name()%></a></td>
		<td><%=list.get(i).getUser_id()%></td>
		<td><%=list.get(i).getFirst_name()%></td>
		<td><%=list.get(i).getLast_name()%></td>
	
	<td>
	<form action="detail.st" method="get">
		<input type = "hidden" name = "student_no" value = "<%=list.get(i).getStudent_no()%>"> 		
		<input type = "hidden" name = "user_id" value = "<%=list.get(i).getUser_id()%>"> 		
		<input type ="submit" value ="detail.st로 요청"> 
	</form> 
	</td> 
	</tr>
			<%} %>
	</tbody>
	</table>
		<%@ include file = "/include/footer.jsp"  %>
</body>
</html>



<%-- 
	<%@ include file = "/include/header.jsp"  %> <!-- 뒤로 한칸 올라가니가 /해줘 -->
	
	<!-- 테이블 태그로 학생의 이름 , 성 , user_id, first_name, last_name-->
	
	
	<h1>학생정보를 보여 줍니다.</h1>
	<table border="1">
	<%=request.getAttribute("list") %> <!-- list를 받아와야지 -->
	
	<%
		ArrayList<StudentDTO> list =(ArrayList<StudentDTO>) request.getAttribute("list");
		for(int i = 0; i<list.size(); i++){%>
		<p><%=list.get(i).getStudent_no() %></p>		
		<p><%=list.get(i).getStudent_name()%></p>		
				
		<% }%>
		
	
=======
<%@page import="student.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

/* h1 {
  text-align: center;
}
table {
  width: 80%;
  border-collapse: collapse;
  font-family: Arial, Helvetica, sans-serif;
  margin: 0px, auto;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

td, th {
  border: 1px solid #000;
  padding: 8px;
}

th {
  color: white;
  background-color: #673ab7;
}

td {
  text-align: center;
}
 */
</style>
<meta charset="UTF-8">
<title>학생 정보 보기</title>
</head>
<body>

	<%@ include file = "/include/header.jsp"  %> <!-- 뒤로 한칸 올라가니가 /해줘 -->
	
	<!-- 테이블 태그로 학생의 이름 , 성 , user_id, first_name, last_name-->
	
	
	<h1>학생정보를 보여 줍니다.</h1>
	<%-- <%response.setIntHeader("Refresh", 3); %>  --%> <!--  3초에 한번씩 새로고침이 되서 다른사람이 삭제한게 실시간으로 확인가능!-->
	<table class="styled-table">
		<thead>
	<tr>
		<th>학생번호</th> <!-- th는 머리부분! -->
		<th>학생이름</th>
		<th>아이디</th>
		<th>성</th>
		<th>이름</th>
	</tr>
		</thead>
	<tbody>
<%-- 	<%=request.getAttribute("list") %> --%> <!-- list를 받아와야지 -->
	
		<%
		ArrayList<StudentDTO> list =( ArrayList<StudentDTO> ) request.getAttribute("list");
		for(int i = 0 ;  i<list.size(); i ++){
	%>
		
	<tr>
		<td><a href="detail.st?student_no=<%=list.get(i).getStudent_no() %>&user_id=<%=list.get(i).getUser_id()%>"><%=list.get(i).getStudent_no() %></a></td>
		<td><a href="detail.st"><%=list.get(i).getStudent_name()%></a></td>
		<td><%=list.get(i).getUser_id()%></td>
		<td><%=list.get(i).getFirst_name()%></td>
		<td><%=list.get(i).getLast_name()%></td>
	
	<td>
	<form action="detail.st" method="get">
		<input type = "hidden" name = "student_no" value = "<%=list.get(i).getStudent_no()%>"> 		
		<input type = "hidden" name = "user_id" value = "<%=list.get(i).getUser_id()%>"> 		
		<input type ="submit" value ="detail.st로 요청"> 
	</form> 
	</td> 
	</tr>
			<%} %>
	</tbody>
	</table>
		<%@ include file = "/include/footer.jsp"  %>
</body>
</html>



<%-- 
	<%@ include file = "/include/header.jsp"  %> <!-- 뒤로 한칸 올라가니가 /해줘 -->
	
	<!-- 테이블 태그로 학생의 이름 , 성 , user_id, first_name, last_name-->
	
	
	<h1>학생정보를 보여 줍니다.</h1>
	<table border="1">
	<%=request.getAttribute("list") %> <!-- list를 받아와야지 -->
	
	<%
		ArrayList<StudentDTO> list =(ArrayList<StudentDTO>) request.getAttribute("list");
		for(int i = 0; i<list.size(); i++){%>
		<p><%=list.get(i).getStudent_no() %></p>		
		<p><%=list.get(i).getStudent_name()%></p>		
				
		<% }%>
		
	
>>>>>>> 297b4db (JSP 서블릿 기초 0705)
		<%@ include file = "/include/footer.jsp"  %> --%>