<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
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
	<%@ include file = "/include/header.jsp"  %> <!-- 뒤로 한칸 올라가니가 /해줘 -->
		<h1>고객관리모듈</h1>
	<table class="styled-table">
		<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>이메일</th>
			<th>핸드폰</th>
		</tr>
		</thead>
	<% ArrayList<CustomerDTO> list = (ArrayList<CustomerDTO>)request.getAttribute("list"); %>
	<%=list.size() %><!-- list 사이즈를 먼저 보고 여기까지 잘 오나 확인! -->
			<% for(int i = 0 ;  i<list.size(); i ++){ %>
			
			<!--List로 해서 해도 돼!   -->
	<!-- private int id;
	private String name, gender, email, phone; -->
		<tr>
	
		<td><%=list.get(i).getId()%></td>
		<td><%=list.get(i).getName()%></td>
		<td><%=list.get(i).getGender()%></td>
		<td><%=list.get(i).getEmail()%></td>
		<td><%=list.get(i).getPhone()%></td>
	
	</tr>
		
	<% }%>
	</table> 
	<%@ include file = "/include/footer.jsp"  %>
</body>
</html>