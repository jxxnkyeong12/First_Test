<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   <!--  --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입처리-join</title>
</head>
<body>
<h2>회원가입정보 [${method }]</h2>
<table border = '1' style = 'width: 600px'>
	<tr>
		<th style ='width: 140px'>성명</th>
		<td>${name }</td>
	</tr>
		<tr>
		<th>성별</th>
		<td>${gender }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${email }</td>
	</tr>

	
</table>
<hr>

<!-- vo를 넣어줘 -->
<table border = '1' style = 'width: 600px'>
	<tr>
		<th style ='width: 140px'>성명</th>
		<td>${vo.name }</td>
	</tr>
		<tr>
		<th>성별</th>
		<td>${vo.gender }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${vo.email }</td>
	</tr>

	
</table>


<a href ='<c:url value = "/join"/>'>회원가입 화면으로</a> <!-- 이렇게 해줘야 깔끔하게 사라지고 join회원가입 창으로 잘 돌아온다 -->
</body>
</html>