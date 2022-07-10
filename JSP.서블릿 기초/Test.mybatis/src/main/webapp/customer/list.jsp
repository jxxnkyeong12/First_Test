<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
<h1 style="text-align: center;">고객관리 모듈</h1>
<table class = "styled-table">
	 <thead>
	 	<tr> 
		 	<th>고객 ID</th>
	 		<th>고객이름</th>
	 		<th>성별</th>
	 		<th>email</th>
	 		<th>핸드폰번호</th>
	 	</tr>
	 </thead>
	 <tdody>
<% List<CustomerDTO> list = (List<CustomerDTO>) request.getAttribute("list");  
          %>
      <%--     <%=list.size() %>  --%><!--리스트 사이즈 먼저 출력해보고! list가 넘어왔는지 확인을 해줘   -->
  <%  for(int i = 0; i < list.size(); i++) {
		 
	   %>
    <tr>
    <td><a><%=list.get(i).getId() %></a></td>
    <td><a><%=list.get(i).getName() %></a></td>
    <td><a><%=list.get(i).getGender() %></a></td>
    <td><a><%=list.get(i).getEmail() %></a></td>
    <td><a><%=list.get(i).getPhone() %></a></td>
	    
    
    </tr>
    
    
	<%}//for %>
	</tdody>
	</table>
<%@ include file="/include/footer.jsp" %>
</body>
</html>