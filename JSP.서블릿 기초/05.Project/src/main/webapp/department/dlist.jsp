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
	<h1 class ="mt-4">부서 조회 </h1>

		<div class="card-body">
			<table id="datatablesSimple">
				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서이름</th>
						<th>관리자 아이디</th>
						<th>위치 번호</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>부서번호</th>
						<th>부서이름</th>
						<th>관리자 아이디</th>
						<th>위치 번호</th>
					</tr>
				</tfoot>
					<tbody>
					<c:forEach items="${list}" var="dto">
							<tr>
								<td>${dto. department_id}</td>
								<td>${dto. department_name}</td>
								<td>${dto. manager_id}</td>
								<td>${dto. location_id}</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
     <%@ include file ="/include/footer.jsp" %>    


</body>
</html>