<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSPL 태그를 이용하기 위한 준비 ! ↑ -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- $<-동적으로 request에 있는 자원에 접근해서 사용 
	bean을 만들어서 자동으로 데려오는거
-->
	<%@ include file = "/include/header.jsp"  %> <!-- 뒤로 한칸 올라가니가 /해줘 -->
	<h1>고객관리모듈 (JSTL)</h1>
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

		<c:forEach items="${list}" var="dto">
		 <tr>
			<td>${dto.id}</td>
			<td>${dto.name}</td>
			<td>${dto.gender}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
    	</tr>

		</c:forEach>

		</tbody>
	</table>	
		<%@ include file="/include/footer.jsp"%>
</body>
</html>