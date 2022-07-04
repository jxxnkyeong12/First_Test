<%@page import="student.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>

<h1 style="text-align: center;"> 수정 </h1>

  <h1> 업데이트</h1>



 <% 
//input type = text로  
	StudentDTO dto = (StudentDTO)request.getAttribute("dto");
 
 %>
	<table class="styled-table" border="1">
		<thead>
			<tr>
				<th>학생번호</th>
				<td><input type ="text" disabled="disabled" value = " <%=dto.getStudent_no()%>" ></td>
				
			</tr>
			<tr>
				<th>학생이름</th>
				<td><input type ="text" value = " <%=dto.getStudent_name()%>"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type ="text" disabled="disabled" value = " <%=dto.getUser_id()%>" ></td>
			</tr>
			<tr>
				<th>성</th>
				<td><input type ="text" value = " <%=dto.getFirst_name()%>" ></td>
			</tr>
			<tr>
				<th>이름</th>
					<td><input type ="text" value = " <%=dto.getLast_name()%>" ></td>
			</tr>
		
		
		</thead>
		
	</table>


</body>
</html>