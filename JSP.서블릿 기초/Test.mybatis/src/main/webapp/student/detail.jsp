<%@page import="student.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
		background: #aaa;
		
	}
</style>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<h1 style="text-align: center;"> 상세 정보 </h1>
	<%
		StudentDTO dto = (StudentDTO)request.getAttribute("dto");
	%>
<table class = "styled-table">
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
	 	
	 	<tbody>
				<tr>
					<td><a href="update.st?student_no=<%=dto.getStudent_no()%>&user_id=<%=dto.getUser_id()%>">수정하기</a>
					</td>
					<td><a onclick="deleteInfo('<%=dto.getStudent_no()%>' , '<%=dto.getUser_id()%>');">삭제하기</a>
					</td>
			
				</tr>
		</tbody>
</table>

<script type="text/javascript">
		function deleteInfo(student_no , user_id){
			if(confirm('정말 삭제하시겠습니까??')){
				location.href='delete.st?student_no=' + student_no + '&user_id=' + user_id;
				// 삭제를 하기위해서는 key값이 필요함 url에 찍히게 해보기 
			}else{
						
			}
		}
	</script>
<%@ include file="../include/footer.jsp" %>
</body>
</html>