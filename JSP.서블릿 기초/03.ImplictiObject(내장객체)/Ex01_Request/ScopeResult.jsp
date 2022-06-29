<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		String pageCtx = (String) pageContext.getAttribute("pageCtx");// param(String) , attribute(Object) 오브젝트라서 캐스팅 해줘야해
		String req =(String) request.getAttribute("req");
		String sSession =(String) session.getAttribute("session");
		String sApp =(String) application.getAttribute("app");
	%>
	
	<p>PageContext : <%= pageCtx%></p> <!-- 페이지 내에서만 작동되니까.. 이건 지금 이동해왔잖아 그러니까 null! -->
	<p>Request : <%= req%></p>  <!-- 요청한게 아니라 페이지 전환이라서 유지가 안돼 -->
	<p>Session : <%= sSession%></p>
	<p>Application : <%= sApp%></p>
	
</body>
</html>