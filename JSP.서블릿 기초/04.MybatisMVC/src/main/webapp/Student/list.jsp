<%@page import="student.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  	<%@ include file="../include/header.jsp" %>
       <h1 style="text-align: center;">학생정보를 보여 줍니다</h1>
       
<table class = "styled-table">
	 <thead>
	 	<tr> 
	 		<th>학생번호</th>
	 		<th>학생이름</th>
	 		<th>아이디</th>
	 		<th>성</th>
	 		<th>이름</th>
	 		<th>요청</th>
	 	</tr>
	 </thead>
	 	<tdody>
	 		<% ArrayList<StudentDTO> list = (ArrayList<StudentDTO>)request.getAttribute("list");
	 			for(int i =0; i<list.size(); i++) 	 		{  
	 		%>
	 				<tr>
	 					<td><a href="detail.st?student_no=<%=list.get(i).getStudent_no() %>&user_id=<%=list.get(i).getUser_id()%>"><%=list.get(i).getStudent_no() %></a></td>
	 					<td><a href="detail.st"><%=list.get(i).getStudent_name() %><a/></td>
						<td><%=list.get(i).getStudent_no()%></td>
	 					<td><%=list.get(i).getLast_name() %></td>
	 					<td><%=list.get(i).getFirst_name() %></td>
	 					
	 					<td>
	 					<form action="detail.st" method="get">  <!-- name값을 input에 넣어주면 이제 넘어가! -->
	 						<input type = "hidden" name ="student_no"  value= "<%=list.get(i).getStudent_no()%>"/>  
	 						<input type = "hidden" name ="user_id"  value= "<%=list.get(i).getUser_id()%>"/>  
	 						<input type = "submit" value ="detail.st로 요청">
	 					</form>
	 					</td>
	 				</tr>
	 		<%} %>
	 	</tdody>
</table>



<%@ include file="../include/footer.jsp" %>
</body>
</html>