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
		pageContext.setAttribute("pageCtx", "Kjk_PAGE"); //페이지컨텍스트에다가 데이터를 넣어둔 상태
		
		//요청이 있거나 페이지 전환(forward)시에 데이터를 한번 유지함
		request.setAttribute("req", "Kjk_REQ");//attribute !=param  키값을 주고 나서 속성을 넣는다★★★★★★★★★★★★★★★
	
		session.setAttribute("session", "Kjk_SESSION"); //★★★★★★★★★★★★★★★
		
		application.setAttribute("app", "Kjk_APP");  //어떤 version Jsp 내가 로그아웃했다해서 회사정보가 사라지는건 아니니까
		
		
		//HashMap<Key, Value>  public protect를 쓰는 이유!-메모리를 다루기 위해서-
	%>

	
 	
	<form action="../ScopeServlet" method ="get">
		<input type ="submit" value ="전송">
	
	</form>
	
<%-- 	<jsp:forward page="ScopeResult.jsp"></jsp:forward> --%><!-- 이게 있으면 페이지를 전환  전송! 저거 위에 있는것들 없어져!  -->
	<!-- M   V=>Vx V=>C =>V -->
	<!--attribute에 있는 내용이 전송되려면 forward방식으로 페이지를 전환하는 요청을 해야함 ■(Servlet)■ -->
</body>
</html>