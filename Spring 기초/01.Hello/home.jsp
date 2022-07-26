<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> <!-- 이것때문에 오류나니까  --> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 이걸 해주면 이제 저장이 돼! -->
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> <a href = "login">로그인 </a> </P>
<P> <a href = "member">회원가입 </a> </P>
</body>
</html>
