<%@page import="student.StudentDAO"%>
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
	<%@ include file = "/include/header.jsp"  %>
	
	
	
<%
	 // StudentDAO dao = new StudentDAO() ;
		StudentDTO dto = (StudentDTO)request.getAttribute("dto");
	
	
	%>
	
<h1 style="text-align: center;"> 상세 정보 </h1>
	
	<table class="styled-table" border="1">
		<thead>
			<tr>
				<th>학생번호</th>
				<td><a> <%=dto.getStudent_no()%></a> </td>
			</tr>
			<tr>
				<th>학생이름</th>
					<td><a href="detail.st"><%=dto.getStudent_name()%></a></td>
			
			</tr>
			<tr>
				<th>아이디</th>
				<td><%=dto.getUser_id()%></td>
				
			</tr>
			<tr>
				<th>성</th>
				<td><%=dto.getFirst_name()%></td>
			
			</tr>
			<tr>
				<th>이름</th>
					<td><%=dto.getLast_name()%></td>
			</tr>
			<tr>
				<th>요청</th>
					<td>
				<form  action="detail.st" method="get" >
					<input type="hidden" name="studentno" value="<%=dto.getStudent_no()%>">
					<input type="hidden" name="user_id" value="<%=dto.getUser_id()%>">
					<input type="submit" value="detail.st로 요청">
				</form>
				</td>
			</tr>
		
		</thead>
		<tbody>
				<tr>
					<td><a href="update.st?student_no=<%=dto.getStudent_no()%>&user_id=<%=dto.getUser_id() %>" >수정하기</a>
					</td>
					<td><a href="#">삭제하기</a>
					</td>
			
				</tr>
		</tbody>
	</table>
		<%@ include file = "/include/footer.jsp"  %>
</body>
</html>