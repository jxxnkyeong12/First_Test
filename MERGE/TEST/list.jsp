<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객관리</title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
		<h1>고객관리 모듈</h1>
		<table class="styled-table">
		<thead>
			<tr>
				<th>학생번호</th>
				<th>학생이름</th>
				<th>성별</th>
				<th>메일</th>
				<th>폰넘버</th>
			</tr>
		</thead><!-- 헤더 콘텐츠 하나로 묶을때 사용 -->
		<tbody>
			<%
		ArrayList<CustomerDTO> list = (ArrayList<CustomerDTO>)request.getAttribute("list");//요소속성값 가져와 나열
		for(int i = 0 ;  i<list.size(); i ++){
	     %>
			<tr>
				
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getGender()%></td>
				<td><%=list.get(i).getEmail()%></td>
				<td><%=list.get(i).getPhone()%></td>
			
			</tr>
			
			<%} %>
		</tbody>
	</table>
	
	<%@ include file="/include/footer.jsp"%>
</body>
</html>