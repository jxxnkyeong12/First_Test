<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포맷태그</title>
</head>
<body>


	<h1> 포맷태그 사용</h1>
	<c:set var ="date" value="<%=new Date() %>"></c:set>
	<p>현재시간을 EL로 그냥 표현하기 :  ${date }</p>
	<p>오늘의 날짜 FMT태그 : <f:formatDate value="${date}" type="date"/></p>
	<p>오늘의 날짜 FMT태그 : <f:formatDate value="${date}" type="time"/></p>
	<p>오늘의 날짜 FMT태그 : <f:formatDate value="${date}" type="both"/></p>
	<p> 포맷을 이용한 패턴 : <f:formatDate value="${date}" type ="date" pattern="yyyy년 MM월 dd일(E)"/></p>
	
	<c:set var ="num" value="123456789"/>
	<p>현재 숫자를 EL로 그냥 표현하기 : ${num}</p>
	<p>fmt이용 그루핑 사용 : <f:formatNumber value ="${num}" groupingUsed="true" ></f:formatNumber></p>
	<p>fmt이용 그루핑 미사용 : <f:formatNumber value ="${num}" groupingUsed="false" ></f:formatNumber></p>
	<p>fmt 이용 패턴 : <f:formatNumber value="${num}" pattern="#,##0"/></p>
	<p>fmt 이용 패턴 : <f:formatNumber value="${num}" pattern="#,##0원"/></p>
	
	<!--기타 포맷: 통화기호, 백분율  -->
	<p> 금액1 : <f:formatNumber value = "${num}" type ="currency"/></p>
	<p> 금액2 : <f:formatNumber value = "${num}" type ="currency" currencySymbol="$"/></p>
	<p> 퍼센트 : <f:formatNumber value = "0.123" type ="percent"/></p>
	<p> 퍼센트 : <f:formatNumber value = "0.123" pattern = "0.00%"/></p>
	
	
	
	
</body>
</html>