<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록</title>
</head>
<body>
   <%@ include file ="/include/layout.jsp" %>   
<div class = "container-fluid px-4">
	<h1 class ="mt-4">사원 조회 </h1>

		<div class="card-body">
			<table id="datatablesSimple">
				<thead>
					<tr>
						<th>사원번호</th>
						<th>이름</th>
						<th>이메일</th>
						<th>핸드폰번호</th>
						<th>작업 번호</th>
						<th>부서 번호</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>사원번호</th>
						<th>이름</th>
						<th>이메일</th>
						<th>핸드폰번호</th>
						<th>작업 번호</th>
						<th>부서 번호</th>
					</tr>
				</tfoot>
					<tbody>
					<c:forEach items="${list}" var="dto">
							<tr>
								<td>${dto. employee_id}</td>
								<td>${dto. name}</td>
								<td>${dto. email}</td>
								<td>${dto. phone_number}</td>
								<td>${dto. job_id}</td>
								<td>${dto. department_id}</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
     <%@ include file ="/include/footer.jsp" %>    


</body>
</html>