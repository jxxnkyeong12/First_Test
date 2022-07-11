<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c로 해주는게 좋아!  -->   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "/include/header.jsp"  %>
	<h1>JSTL 사용</h1>
	<p>JP 개발을 좀 더 편하고 단순화하기 위한 태그 library(JSP Standard Tag Library)</p>
	<a href = "listfmt.js">포맷태그</a> <!-- listfmt.jsp 파일을 만들고 해당하는 파일로 연결되게 (Controller에서 처리) --> 
	<a href = "listfn.js">펑션태그</a> <!-- listfmt.jsp 파일을 만들고 해당하는 파일로 연결되게 (Controller에서 처리) --> 
	
	
	
	<h3>CORE(jstl/core)</h3>
	
	
	<!-- 내가 사용할 기능이 들어있는 library를 taglib 태그를 통해서 추가한다 -->
	<!-- Spring Boot(HTML) 타임리프, Spring Legacy(JSP) JSTL -->
  <% int num = 100; %> <!-- 자바코드 이용해서 변수선언 -->
	<c:set var="num1" value = "200" /> <!-- JSPL을 이용한 변수 선언 -->
	<p>자바로 만든 변수 EL문법으로 출력 : ${num}</p>  <!-- 값이 안나와 -->
	<p>JSTL로 만든 변수 출력 : ${num1}</p>
	
	
	<c:set var="num2" value = "300" /> <!-- JSPL을 이용한 변수 선언 -->
	
	<p>num1과 num2의 합 : ${num1 + num2}</p>
	<p>num1과 num2의 합 : ${num1} + ${num2}</p>
	
	
	<!-- attribute(req)에 들어있는 값을 판단해서 사용을 해야 금방 익숙해짐 -->
	<h1>코어 choose</h1>
	<c:choose>
		<c:when test="${num1 == 200 }">
			<a>200이 맞습니다</a>
		
		</c:when>
		<c:when test="${num1 != 200 }">
			<a>200이 아니다!</a>
		
		</c:when>
	
	</c:choose>
	<h1>코어 if</h1>
	<c:if test="${num1 ==200 }">
		<p>200이랑 같습니다 if</p>
	
	</c:if>
	
	<h1>코어 foreach</h1>
	<!-- ■ 데이터가 한건 이상일때는 collection자료 구조를 사용하기때문에 안쪽에 있는 object를 빼내올때 유용하다. -->
	<% for(int i = 0; i <=10; i++) {%>
		<p><%= i %> 자바 for문을 이용한 반복문</p>
	
	<% }%>
	<c:forEach var = "i" begin="0" end ="10"> <!--  0부터 10까지!-->
	<p>${i} 자바 foreach문을 이용한 반복문</p>	
	</c:forEach>
	
	<!-- 1. 구구단 출력해보기 (2단)만 ▶core 로 foreach -->
	
	
	<h2> 2단만 </h2>
	<c:forEach var = "i" begin="1" end ="9">
			<p>2 * ${i} = ${2*i} </p>
		</c:forEach> 
	
	<!-- 1. 구구단 출력해보기 (2단~9단) ▶core 로 foreach -->
	<h2> 2단~9단 </h2>
	<c:forEach var = "i" begin="2" end ="9">   <!-- 2 * 1, 2 * 2 -->
		<c:forEach var = "j" begin="1" end="9">
			<p>${i} * ${j} = ${i*j } </p><br/>
		</c:forEach>
	<br/>
	
	</c:forEach>
	
	
	
	
	
	
		<%@ include file="/include/footer.jsp"%>
</body>
</html>