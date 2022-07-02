<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Request(요청) Response(응답) --> <!-- 이번페이지는 응답에 대해 알아볼거야 -->
	<h1>응답 객체 사용해보기(Response)</h1>
	
	<!-- 파라메터로 id가 admin 그리고 pw가 admin1234가 들어왔을때만 구글로 가기
		 그외에는 현재 페이지를 보여준다.
		
		파라메터를 받는 방법 (Attribute(Servlet, Controller), Url ) From -x 
		//param, Atrribete(이전 페이지에서 어떻게 요청했는지???)
		
		@Controller
		String page() {
		 	return " Ex02_Respone/Ex01_Redirect";  //Forward이면 무조건 Attribute!!!!!!!
		 }
	 -->
	
	
	
	<%if(request.getAttribute("id").equals("admin") && request.getAttribute("pw").equals("1234")){ %>
		<%response.sendRedirect("http://www.google.com"); %>
	<%}else {%>
	   <%-- 	<%response.sendRedirect("http://192.168.0.214/imo"); %>		 --%>
	
	<%} %>
	
	<!-- Ex01_Response.java(Servlet,Controller)를 통해서 여기까지 와보기  -->
	<%-- 여기까지 오면 구글이 잘 실행되는지 확인해보기 --%>

</body>
</html>