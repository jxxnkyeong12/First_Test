<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 
     <%@ include file ="/include/layout.jsp" %>   
<div class = "container-fluid px-4">
	<h1 class ="mt-4"> 부서 조회 </h1>

		<div class="card-body">
			<table class = "table table-hover">  <!-- 테이블 id에서 class로 바꿔주고 부트스트랩에서 맘에 드는걸로 바꿔넣어줘! 
																	그리고 <tfoot>지워줘! -->
				<thead>
					<tr>
						<th>부서코드</th>
						<th>부서명</th>
						<th>관리자 아이디</th>
						<th>위치 번호</th>
					</tr>
				</thead>
			<!-- 	<tr>
						<th>부서코드</th>
						<th>부서명</th>
						<th>관리자 아이디</th>
						<th>위치 번호</th>
					</tr> -->
					<tbody>
					<c:forEach items="${list }" var="dtod">
							<tr>
								<td>${dtod. department_id}</td>
								<td>${dtod. department_name}</td>
								<td>${dtod. manager_id}</td>
								<td>${dtod. location_id}</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
     <%@ include file ="/include/footer.jsp" %>    
</body>
</html>