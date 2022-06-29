<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 아이디와 비밀번호를 직접만든 서블릿해서 요청받기 -->
<form action ="../Test02" method= "get"> <!-- 액션은 위쪽 Test02_Requset는 자바!쪽 서블릿거 복붙하구 위에 있으니 ../해줘얗. 이름 똑같아서 헷갈렸다 ㅠ -->
	<input type = "text" name = "id" placeholder="아이디를 입력하세요"> <!-- name을 안주고 하면 get방식이지만 주소창에 파라메터가 아무것도 안찍혀! -->
	<input type = "text" name = "pw" placeholder="비밀번호를 입력하세요">
	<input type="submit" value = "">
	<!-- form태그 안쪽에 있는 태그에 값을 전송(HTML) => 태그의 이름을 Key값으로 사용 -->
	</form>
</body>
</html>