<%@page import="mybsaone.MybsaoneDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/header.jsp" %>

<h1 style="text-align: center;">사원목록</h1>

<table class = "styled-table">
	 <thead>
	 	<tr> 
		 	<th>사번</th>
	 		<th>이름</th>
	 		<th>이메일</th>
	 		<th>부서</th>
	 		<th>휴대전화</th>
	 		<th>부서명</th>
	 		<th>전체주소</th>
	 		<th>부서최대급여</th>
	 		<th>부서최소급여</th>
	 		<th>부서평균급여</th>
	 	</tr>
	 </thead>
	 <tdody> 
<%List<MybsaoneDTO> list = (List<MybsaoneDTO>) request.getAttribute("list"); %>
 
 <%-- <%=list.size() %>  --%><!--107 사이즈 확인완 -->
 <%  for(int i = 0; i < list.size(); i++) {
		 
	   %>
    <tr>
    <td><a><%=list.get(i).getEmployee_id()%></a></td>
    <td><a><%=list.get(i).getName()%></a></td>
    <td><a><%=list.get(i).getEmail()%></a></td>
    <td><a><%=list.get(i).getDid()%></a></td>
    <td><a><%=list.get(i).getPhone()%></a></td>
    <td><a><%=list.get(i).getDname()%></a></td>
    <td><a><%=list.get(i).getAddr() %></a></td>
    <td><a><%=list.get(i).getMax_sal()%></a></td>
    <td><a><%=list.get(i).getMin_sal()%></a></td>
    <td><a><%=list.get(i).getAvg_sal()%></a></td>
  
    
    </tr>
    
    
	<%}//for %> 
	 
	</tdody>
</table>
<%@ include file="../include/footer.jsp" %>
</body>
</html>



 