<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 요청방식은 크게 두가지(Get/Post) 
		GET : URL에 보낸 파라메터가 그대로 찍힘(보안x)
		Post: URL에 보낸 파라메터가 공개가 안됨(보안o) 테스트 x
		요청 => URL로 함(Servlet) =>Servlet => jsp (Model(데이터를 담고 이동하는 객체) View Controller)
			 => URL로함(jsp페이지로 이동) =>jsp
	-->
		
	<!-- Ex01_Request라는 서블릿을 만들고 요청해보기. form태그 이용해서.. -->
	<h1>겟 방식 요청</h1>
	<form action = "../Ex01_Request" method="get">
    	<!-- 인풋타입으로 텍스트 주고 이름하고 아이디 비밀번호 입력받게 만들기 -->
    	<table>
    	<tr>
    	<td>이　름 : <input type ="text" name = "name"  placeholder ="이름"></td>
    	</tr>
    	<tr>
    	<td>아이디 : <input type ="text" name = "id"  placeholder ="아이디"></td>
    	<tr>
    	<tr>
    	<td>비밀번호 : <input type ="password" name = "pw"  placeholder ="비밀번호"></td>
    	</tr>
		</table>
    	<input type = "submit"><br/>
	</form> 
 	<h1>포스트 방식 요청</h1>
 	
 		<form action = "../Ex01_Request" method="post">
    	<!-- 인풋타입으로 텍스트 주고 이름하고 아이디 비밀번호 입력받게 만들기 -->
    	<table>
    	<tr>
    	<td>이　름 : <input type ="text" name = "name"  placeholder ="이름"></td>
    	</tr>
    	<tr>
    	<td>아이디 : <input type ="text" name = "id"  placeholder ="아이디"></td>
    	<tr>
    	<tr>
    	<td>비밀번호 : <input type ="password" name = "pw"  placeholder ="비밀번호"></td>
    	</tr>
		</table>
    	<input type = "submit"><br/>
	</form> 
 <!-- http://192.168.0.214/imo/Ex01_Request
	  http://192.168.0.214/imo/Ex01_Request/Ex01_Request  이렇게 되서 안떠! 이게 뜨게 하려면..!!! ../Ex01_Request해주기!-->
	  
	  <h1>페이지 to 페이지</h1>
 	
 		<form action = "Ex01_RequestResult.jsp" method="get">
    	<!-- 인풋타입으로 텍스트 주고 이름하고 아이디 비밀번호 입력받게 만들기 -->
    	<table>
    	<tr>
    	<td>이　름 : <input type ="text" name = "name"  placeholder ="이름"></td>
    	</tr>
    	<tr>
    	<td>아이디 : <input type ="text" name = "id"  placeholder ="아이디"></td>
    	<tr>
    	<tr>
    	<td>비밀번호 : <input type ="password" name = "pw"  placeholder ="비밀번호"></td>
    	</tr>
		</table>
    	<input type = "submit"><br/>
	</form> 
</body>
</html>