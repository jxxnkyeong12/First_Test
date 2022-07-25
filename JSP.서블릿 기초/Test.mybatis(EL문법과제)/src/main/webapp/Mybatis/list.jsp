<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	 		<th>부서</th>
	 		<th>이메일</th>
	 		<th>휴대전화</th>
	 		<th>부서명</th>
	 		<th>전체주소</th>
	 		<th>부서최대급여</th>
	 		<th>부서최소급여</th>
	 		<th>부서평균급여</th>
	 	</tr>
	 </thead>


	<tbody>
	<c:forEach items="${list}"  var ="dto"> <!-- 만들어둔 list에 dto를 넣어보겠다! -->
		<tr>
			<td>${dto.employee_id}</td>
			<td>${dto.name }</td>
			<td>${dto.did}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
			<td>${dto.dname }</td>
			<td>${dto.addr }</td>
			<td>${dto.max_sal }</td>
			<td>${dto.min_sal }</td>
			<td>${dto.avg_sal}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<%@ include file="../include/footer.jsp" %>
</body>
</html>