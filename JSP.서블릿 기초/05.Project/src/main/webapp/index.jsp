<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
     <body>
     <%@ include file = "include/layout.jsp" %>
     <h2>내용</h2>
	<div class="card-body">
		<table id="datatablesSimple">
			<thead>
				<tr>
					<th>Name</th>
					<th>Position</th>
					<th>Office</th>
					<th>Age</th>
					<th>Start date</th>
					<th>Salary</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Name</th>
					<th>Position</th>
					<th>Office</th>
					<th>Age</th>
					<th>Start date</th>
					<th>Salary</th>
				</tr>
			</tfoot>
			</table>
			</div>
			<%@ include file="include/footer.jsp"%>
</body>
</html>
