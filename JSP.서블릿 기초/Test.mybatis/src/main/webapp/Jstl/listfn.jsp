<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- ①먼저 위에 디렉티그 태그로 펑션이랑 코어 만들어줘 -->
  <h1>펑션태그</h1>
  <c:set var = "str" value ="             Hello Jsp Servlet              "/>
  <p>일반 EL 문자열 출력 : ${str }</p>
  <p>대문자로 바꾸기 : ${fn:toUpperCase(str) }</p> <!-- EL문법 안쪽에서 써줘야해 fn은!~ -->
  <p>소문자로 바꾸기 : ${fn:toLowerCase(str) }</p>
  <p>문자열의 길이 : ${fn:length(str) }</p>  <!-- 18개  -->
  <p> 공백을 제거 : ${fn:trim(str) }</p><!-- 좌우 공백이 사라져 -->
  <p> 공백을 제거 후 길이 : ${fn:length(fn:trim(str)) }</p><!-- 17개가 나와-->
  <p> Jsp문자를 JAVA 로 바꿔보기 : ${fn:replace(str ,  "Jsp", "JAVA") }</p>
  
  
</body>
</html>