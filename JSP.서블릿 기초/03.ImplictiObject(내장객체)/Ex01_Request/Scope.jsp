<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		JSP에서 제공하는 내장 객체들을 사용해보기.
		
	
	 -->

	<%
		//페이지 내에서 데이터를 유지함
		pageContext.setAttribute("pageCtx", "Kjk_PAGE"); //페이지컨텍스트에다가 데이터를 넣어둔 상태
		
		//요청이 있거나 페이지 전환(forward)시에 데이터를 한번 유지함
		request.setAttribute("req", "Kjk_REQ");//attribute !=param  키값을 주고 나서 속성을 넣는다★★★★★★★★★★★★★★★
	
		session.setAttribute("session", "Kjk_SESSION"); //★★★★★★★★★★★★★★★
		
		application.setAttribute("app", "Kjk_APP");
	%>
	<%
	
		String pageCtx = (String) pageContext.getAttribute("pageCtx");// param(String) , attribute(Object) 오브젝트라서 캐스팅 해줘야해
		String req =(String) request.getAttribute("req");
		String sSession =(String) session.getAttribute("session");
		String sApp =(String) application.getAttribute("app");
	%>
	
	<p>PageContext : <%= pageCtx%></p>
	<p>Request : <%= req%></p>
	<p>Session : <%= sSession%></p>
	<p>Application : <%= sApp%></p>
	
 <a href = "ScopeResult.jsp"> 페이지를 전환 ScopeResult</a>
 	<!-- 폼태그 안에 있는 정보들을 파라메터(String)타입으로 전송시킴 -->
 	
	<form action="ScopeResult.jsp" method ="get">
		<input type ="submit" value ="전송">
	
	</form>
	
<%-- 	<jsp:forward page="ScopeResult.jsp"></jsp:forward> --%><!-- 이게 있으면 페이지를 전환  전송! 저거 위에 있는것들 없어져!  -->
	<!-- M   V=>Vx V=>C =>V -->
	<!--attribute에 있는 내용이 전송되려면 forward방식으로 페이지를 전환하는 요청을 해야함 ■(Servlet)■ -->
</body>
</html>