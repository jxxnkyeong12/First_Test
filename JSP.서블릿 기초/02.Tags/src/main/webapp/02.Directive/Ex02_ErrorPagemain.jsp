<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러 페이지</h1>
	<%@page errorPage="Ex02_ErrorPage.jsp" %>
	
	<!-- 에러가 발생할 코드가 있다면 어떤 (다른) 페이지서 처리할건지 가능 -->
	<% int[] arr = new int[3]; %>
		
	<%= arr[3] %>	
	
</body>
</html>