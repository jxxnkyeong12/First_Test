<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 쿠키, URL/URI, 요청방식 등등 Request의 속성들을 일단 따라쳐보기</h1>
	<table border ="1">
		<tr>
			<td>쿠키정보</td>
			<%Cookie[] cookie = request.getCookies(); 
				if(cookie == null){ 
				%>
					<td>쿠키가 존재하지 않습니다.</td>
				<%}else {
				
				for(int i = 0; i<cookie.length; i++){
					%>
				  <td> <%=cookie[i].getName() %>&nbsp; <%=cookie[i].getValue() %></td><!-- 쿠키의 i번째 값을 출력하겠다 	JSESSIONID  1939CD080F15A855A141DF2FB9D76C08-->
				<%}
				
				}%>
		</tr>
		<tr>
			<td>서버 도메인명</td>
			<td><%=request.getServerName() %></td> <!-- 192.168.0.214 현재 내자리 아이피주소가 뜨넹 -->
		</tr>	
		<tr>
			<td>서버 포트</td>
			<td><%=request.getServerPort() %></td><!-- 80 톰캣 서버에서 8989였던거 80으로 바꿨던거. 그게 뜬다 -->
		</tr>	
		<tr>
			<td>요청 URL</td>
			<td><%=request.getRequestURL()%></td> <!-- http://192.168.0.214/imo/Ex01_Request/Ex00_infoRequest.jsp -->
		</tr>	
		<tr>
			<td>요청 URI</td>
			<td><%=request.getRequestURI() %></td> <!--	/imo/Ex01_Request/Ex00_infoRequest.jsp  -->
		</tr>	
		
			<!-- URI큰범위 -> URL 
			 URI 통합 자원 식별자(Uniform Resource Identifier) 웹기술에서 사용되는 논리,물리적
			 리소스를 식별하는 고유한 문자열 시퀀스
			 URL:웹주소 => ↑리소스가 어디에 있는지를 알려주기위한 URI에 서브셋(편하게보게만듬)
		  -->
		
			<tr>
			<td>요청 쿼리(질의어(SQL))</td>
			<td><%=request.getQueryString()%></td>  <!-- 내가 직접 입력한값이 나온다! ?id=12&pw=12 -->
		</tr>	
			<tr>
			<td>클라이언트 호스트명</td>
			<td><%=request.getRemoteHost() %></td>
		</tr>	
		</tr>	
			<tr>
			<td>클라이언트 IP주소</td>
			<td><%=request.getRemoteAddr() %></td>
		</tr>	
		
			<tr>
			<td>프로토콜</td>
			<td><%=request.getProtocol() %></td>
		</tr>	
			<tr>
			<td>메소드(요청방식)</td>
			<td><%=request.getMethod() %></td>
		</tr>	
		
			<tr>
			<td>컨텍스트 경로</td>
			<td><%=request.getContextPath() %></td>
		</tr>	
		
	</table>
	
	
	<a><%=(String)session.getAttribute("session") %></a>  <!-- 같은 곳이라서 유지가 돼! 오브젝트 형식이라서 String으로 캐스팅해줬지만 다음엔 object로 써보겠다 -->
	
	
	
</body>
</html>