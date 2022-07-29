<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix='tiles' %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- 띄어쓰기 주의해@! -->

<c:choose>
	<c:when test="${category eq 'cu'}"><c:set var = 'title' value = '고객관리'/></c:when>
	<c:when test="${category eq 'hr'}"><c:set var = 'title' value = '사원관리'/></c:when>
	<c:when test="${category eq 'no'}"><c:set var = 'title' value = '공지사항'/></c:when>
	<c:when test="${category eq 'bo'}"><c:set var = 'title' value = '방명록'/></c:when>
	<c:when test="${category eq 'da'}"><c:set var = 'title' value = '공공데이터'/></c:when>
	<c:when test="${category eq 'vi'}"><c:set var = 'title' value = '시각화'/></c:when>
	
</c:choose>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지능형 IoT ${title} </title> <!-- 웹브라우저 맨 위쪽 이름바뀌는거얌 -->
<link rel='stylesheet' type='text/css' 
	href='css/common.css?<%=new java.util.Date()%>'>
<link rel = 'icon' type ='image/x-icon' href = 'img/hanul.ico'>	<!-- 브라우저 아이콘! -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">



<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src='js/common.js?<%=new java.util.Date()%>'></script>
</head>
<body>
<tiles:insertAttribute name='header'/>
<div id='container'>
<tiles:insertAttribute name='container'/>
</div>
<tiles:insertAttribute name='footer'/>

</body>
</html>