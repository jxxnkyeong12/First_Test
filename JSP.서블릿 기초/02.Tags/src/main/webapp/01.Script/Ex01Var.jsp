<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 전역변수 만들어보기 (String 변수 하나 만들기, double변수, String[]배열 4개 이상의 크기-->
	<%! int vInt =10; 
		String vst = "KJK";
		double vd = 3.25; 
		String[] vss = {"K", "J", "K", "R"};
	%>
	<!-- 바깥에 HTML -->
	
	
	<!-- 지역 변수 -->
	<% int lvInt =10; 
		vInt ++ ;
		lvInt ++ ;
	
	%>
	
	<!-- 전역변수 표현해보기  -->
	<p>vInt에 값 <%=vInt %> lvInt에 값 <%=lvInt %></p>
	<p><%= vst %></p>
	<p><%=vd %>
	<p><%= vss[0] %><%=vss[1] %><%=vss[2] %><%=vss[3] %></p>
</body>
</html>