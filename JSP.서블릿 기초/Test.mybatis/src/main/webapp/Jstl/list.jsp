<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>

		<h1>JSTL 여기까지 옴</h1>
		<p>JSP 개발을 좀 더 편하고 단순화하기 위한 태그 library(JSP Standard Tag Library)</p>
		<h3>CORE(jstl/core)</h3>
		<a href = "listfmt.js">포맷태그</a><!-- listfmt.jsp 파일을 만들고 해당하는 파일로 연결되게 (Controller)처리 -->
		<a href = "listfn.js">펑션태그</a><!-- listfmt.jsp 파일을 만들고 해당하는 파일로 연결되게 (Controller)처리 -->
		
		<!-- 내가 사용할 기능이 들어있는 library를 taglib태그를 통해서 추가한다 -->
	<!-- Spring Boot(HTML) 타임리프 , Spring Legacy(JSP) -->

   <% int num = 100; %> <!-- 자바코드 이용해서 변수선언 (가독성이 떨어진다) -->
   <c:set var="num1" value ="200" /><!-- JSTL을 이용한 변수 선언 : var로 변수 지정해주고 -->
   <p>자바로 만든 변수  EL문법으로 출력 : ${num}</p> <!-- 아무값도 안나와 -->
   <p>JSTL로 만든 변수 출력 : ${num1}</p>
   <c:set var="num2" value ="300" /> 
   <p>num1과 num2의 합 : ${num1 + num2 }</p>
   
</body>
</html>