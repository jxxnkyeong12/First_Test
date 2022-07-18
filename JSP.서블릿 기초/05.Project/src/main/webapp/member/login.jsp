<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='css/member.css' rel='stylesheet'>
</head>
<body>
<jsp:include page="/include/layout.jsp"/>
<div class="container-fluid px-4">
<h3 class="mt-4">로그인</h3>
<div class='box'>
	<ul>
		<li><input type='text' id='userid' class='chk'  placeholder="아이디"></li>
		<li><input type='password' id='userpw'  class='chk' placeholder="비밀번호"></li>
		<li><input type='button' value='로그인' onclick='login()'></li>
	</ul>
</div>

</div>
<script>
$('#userpw').keypress(function(e){
	if( e.keyCode==13 ) login();
});
function login(){
	if( ! emptyCheck() ) return;
	
	$.ajax({
		url: 'iotlogin.mb',
		data: { id:$('#userid').val(), pw:$('#userpw').val() },
		success: function( response ){
			if( JSON.parse(response) ){
				location = '<c:url value="/"/>';
			}else{
				alert('아이디나 비밀번호가 일치하지 않습니다!');
				$('#userid').focus();
			}			
		},error: function(req, text){
			alert(text+':'+req.status);
		}
	});
}

</script>


<jsp:include page="/include/footer.jsp"/>
</body>
</html>