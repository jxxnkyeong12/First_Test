<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Request 요청 </h1>
	<ul>
		<li><a href="Ex01_Request/Ex00_infoRequest.jsp"> ( 관련 된 정보들을 살펴보기 )  </a> </li>
		<li><a href="Ex01_Request/Ex01_Request.jsp"> 요청해보기 </a> </li>
		<li><a href="Ex01_Request/Test01_Request.jsp"> 100개나오게해보기 </a> </li>
		<!-- Request(요청) 가 받을 수 있는 파라메터 form (get post), url?key=value -->
		<li><a href="Ex01_Request/Test02_Request.jsp"> 혼자 해보기[복습!] </a> </li>
		
		<li><a href = "Ex01_Request/Scope.jsp"> Scope(데이터의 전달 범위)</a></li>
		<li><a href = "Ex01_Request/ScopeServlet.jsp"> Scope(서블릿에서 써보기)</a></li>
		<li><a href = "TestServlet"> Scope(테스트!Controller로 접근하기 )</a></li>  <!-- 이거는 controller갔다가 입력받은것을 (set) 거쳐서 출력해라!(get) -->
		
		<!--  
			Scope(범위!) <= Zoom 망원경에 빗대서 표현!
			데이터의 전달범위는 각각의 스코프마다 차이가 있음
			1.많은 데이터를 사용하지 않는데 계속 전달을 하려면 유지를 해야함.(Memory가 제일 커)
			2.많은 데이터를 사용하지 않는데 어떠한 key값으로 저장을 해두면 나중에 혼동이 생김

			①PageContext (jsp 페이지 내에서만 데이터를 전달한다 (<=java변수, js변수) 사용빈도낮음
		  ■②Request	(요청이나 Forward(페이지 전환)시에 한번만 데이터를 전송한다.) 사용빈도 높음!!!!!!!!!!!!!!!!!!■
						(ex - login.jsp에서 로그인할때 요청 ==> Servlet에서 받음 => 페이지 전환(Request x) 
						(모든 데이터의 페이지 이동시 사용함)
						
							
		  ■③Session	(브라우저 내에서는 계속 유지되는 정보)       사용빈도 높음!!!!!!!!!!!!!!!!!!■
		  				(크롬을 실행시킴.<둘은 세션이 다름> 크롬창을 시크릿으로 킴)		
		  				(크롬을 실행시킴.<둘은 세션이 같름> 크롬 탭을 추가함)		
		  				(주로 로그인 정보나 유지가 되어야하는 정보들을 담을 용도로 사용함)
		  				(static이라고 생각하면 편함)
			④ApplicationContext   (어플리케이션(하나의 웹단위)이 완전히 종료되지 않는한 유지됨 => 주로 버전등으로만 사용)사용빈도낮음
		-->
		
		<li><a href = "Ex01_Response"> Response(테스트!Controller로 접근하기 )</a></li>  <!-- 이거는 controller갔다가 입력받은것을 (set) 거쳐서 출력해라!(get) -->
		<li><a href = "Ex02_Response/Ex01_Redirect.jsp"> Scope(테스트!Controller로 접근하기 )</a></li>  <!-- 이거는 controller갔다가 입력받은것을 (set) 거쳐서 출력해라!(get) -->
		<li><a href = "Ex02_Response/Ex01_Redirect.jsp"> Response(admin,id,pw )</a></li> 
		
		<li> 성공! </li>
		
	</ul>
	
	
	
	
</body>
</html>