<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<style>
	table tr:last-child td input[name=address] { margin-top: 5px } 
	.ui-datepicker table tr th:first-child { border-right:none; }
	.ui-datepicker table tr { border-bottom: none; }
=======
<style>
	table tr:last-child td input[name=address] { margin-top: 5px } 
	.ui-datepicker table tr th:first-child {border-right: none; } 
	.ui-datepicker table tr {border-bottom: none;}
>>>>>>> 57a9eb5c78aa2303e258d9754fd419ef6de8adad
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
</head>
<body>
<jsp:include page="/include/layout.jsp"/>
<div class="container-fluid px-4">
<h3 class="mt-4">회원가입</h3>
<form>
<table class='w-px600'>
<tr><th class='w-px140'>성명</th>
	<td><input type='text' name='name'></td>
</tr>
<tr><th>아이디</th>
	<td><input type='text' name='userid'></td>
</tr>
<tr><th>비밀번호</th>
	<td><input type='password' name='userpw'></td>
</tr>
<tr><th>비밀번호확인</th>
	<td><input type='password' name='userpw_ck'></td>
</tr>
<tr><th>성별</th>
	<td>
		<label><input type='radio' name='gender' value='남'>남</label>
		<label><input type='radio' name='gender' value='여' checked>여</label>
	</td>
</tr>
<tr><th>이메일</th>
	<td><input type='text' name='email'></td>
</tr>
<tr><th>생년월일</th>
	<td><input type='text' name='birth'></td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone'></td>
</tr>
<tr><th>주소</th>
	<td>
		<a class='btn-fill' id='post'>우편번호찾기</a>
		<input type='text' name='post' class='w-px80' readonly>
		<input type='text' name='address' readonly>
		<input type='text' name='address' >
	</td>
</tr>
</table>
</form>
</div>

<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

$( "[name=birth]" ).datepicker({ 
<<<<<<< HEAD
	dateFormat: 'yy-mm-dd',
=======
	dateFormat:'yy-mm-dd',
>>>>>>> 57a9eb5c78aa2303e258d9754fd419ef6de8adad
	dayNamesMin: [ '일', '월', '화', '수', '목', '금', '토' ],
});

// $('#post').click(function(){
$('#post').on('click', function(){	
    new daum.Postcode({
        oncomplete: function(data) {
			console.log( data );
        	$('[name=post]').val( data.zonecode );
        	//R:도로명주소, J:지번주소
        	var address = data.userSelectedType == 'R' 
        					? data.roadAddress : data.jibunAddress;
        	if(data.buildingName!='') address += ' ('+data.buildingName+')';
        	$('[name=address]').eq(0).val( address );
        }
    }).open();
});

</script>
<jsp:include page="/include/footer.jsp"/>
<<<<<<< HEAD
=======
<style type="text/css">
	table tr:last-child td input[name=address] {
		margin-top: 5px; 
	}
	
	.ui-datepicker table tr th:first-child {
		border-right: none;
	}
	
	.ui-datepicker table tr {
		border-bottom: none;
	}
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<jsp:include page="/include/layout.jsp" />
	<div class="container-fluid px-4">
	<h3 class="mt-4">회원가입</h3>
		<form>
			<table class='w-px600'>
				<tr>
					<th class='w-px140'>성명</th>
					<td><input type="text" name='name'></td>
				</tr>
				<tr>
					<th class='w-px140'>아이디</th>
					<td><input type="text" name='userid'></td>
				</tr>
				<tr>
					<th class='w-px140'>비밀번호</th>
					<td><input type="password" name='userpw'></td>
				</tr>
				<tr>
					<th class='w-px140'>비밀번호 확인</th>
					<td><input type="password" name='userpw_ck'></td> <!-- DTO에 들어가지 않아도 된다 -->
				</tr>
				<tr>
					<th class='w-px140'>성별</th>
					<td><label><input type="radio" name='gender' value='남'>남</label>
					<label><input type="radio" name='gender' value='여' checked>여</label></td>
				</tr>
				<tr>
					<th class='w-px140'>이메일</th>
					<td><input type="text" name='email'></td>
				</tr>
				<tr>
					<th class='w-px140'>생년월일</th>
					<td><input type="text" name='birth'></td>
				</tr>
				<tr>
					<th class='w-px140'>전화번호</th>
					<td><input type="text" name='phone'></td>
				</tr>
				<tr>
					<th class='w-px140'>주소</th>
					<td><a class='btn-fill' id='post'>우편 번호 찾기</a>
					<input type="text" name='post' class='w-px80' readonly>
					<input type="text" name='address' readonly>
					<input type="text" name='address'></td>
				</tr>
			</table>
		</form>
	</div>
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	$( "[name=birth]" ).datepicker({
		dateFormat: 'yy-mm-dd', /* yy/mm/dd도 가능 */
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
		
	});
	
	// $('#post').click(function(){
	$('#post').on('click', function(){	
		new daum.Postcode({
			oncomplete: function(data) {
				console.log( data );
				$('[name=post]').val( data.zonecode );
	        	//R:도로명주소, J:지번주소
	        	var address = data.userSelectedType == 'R' 
	        					? data.roadAddress : data.jibunAddress;
	        	if(data.buildingName!='') address += ' ('+data.buildingName+')';
	        	$('[name=address]').eq(0).val( address );
	        }
	    }).open();
	});
	</script>
	
	<jsp:include page="/include/footer.jsp" />
>>>>>>> 110036bf97481f0e78d51b6b4dcf66d3bc66ad34
=======
>>>>>>> 57a9eb5c78aa2303e258d9754fd419ef6de8adad
=======

<style type="text/css">
	table tr:last-child  td input[name=address] { margin-top: 5px}
	.ui-datepicker table tr th:first-child { border-right: none; }/* 달력에 있던 Su 옆에 있던 굵은 선 사라지게 만든거야 */
	.ui-datepicker table tr { border-bottom: none;}
</style>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
</head>
<body>
	<jsp:include page="/include/layout.jsp" />
<div class="container-fluid px-4">
<h3 class="mt-4">회원가입</h3>
	
 <form action="">
 	<table class ="w-px600">
 	
 	<tr>
 		<th class ='w-px140'>성명</th>
 		<td><input type ='text' name ="name" ></td>
 	</tr>
 	<tr>
 		<th>아이디</th>
 		<td><input type="text" name= "userid"></td>
 	</tr>	
 	<tr>
 		<th>비밀번호</th>
 		<td><input type = "password" name ="userpw"></td>
 	</tr>	
 	<tr>
 		<th>비밀번호확인</th> <!-- 화면상에서 체크만 하는거야 -->
 		<td><input type = "password" name ="userpw_ck"></td>
 	</tr>	
 	<tr>
 		<th>성별</th>
 			<td>
 			<label><input type = "radio" name ="gender" value ='남'>남</label>
 			<label><input type = "radio" name ="gender" value ='여' checked>여</label>
 			</td>
 	</tr>	
 	<tr>
 		<th>이메일</th>
 		<td><input type ="text" name ="email"></td>
 	</tr>	
 	<tr>
 		<th>생년월일</th>
 		<td><input type ="text" name ="birth"></td>
 	</tr>	
 		<tr>
 		<th>전화번호</th>
 		<td><input type ="text" name ="phone"></td>
 	</tr>	
 		<tr>
 		<th>주소</th>
 		<td>
 			<a class ='btn-fill' id = 'post'>우편번호찾기</a>
 		<input type ="text" name ="post" class ='w-px80' readonly>
 		<input type ="text" name ="address"  readonly>
 		<input type ="text" name ="address">
 		</td>
 	</tr>	
 	</table>
 </form>


</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script><!-- 주소api -->
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script><!-- 제이쿼리ui.com -->
<script type="text/javascript">

$( "[ name=birth]" ).datepicker({
	dateFormat: 'yy-mm-dd',
	dayNamesMin: ['일','월','화','수', '목', '금','토'], /*  7개니까 배열선언!*/
	
});



//	$('#post').click(function () {
	 $('#post').on('click', function () {
		//alert('dfs') 확인완! 다음 우편
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		       		console.log(data);
		        $('[name=post]').val( data.zonecode )
		        
		        var address = data.userSelectedType == 'R' ? 
		        				   data.roadAddress : data.jibunAddress;
		        if(data.buildingName!='') address += ' ('+data.buildingName+')';
		        $('[name=address]').eq(0).val( address);
		        
		        }
		    }).open();
	});	
		
	

</script>

	<jsp:include page="/include/footer.jsp" />
>>>>>>> 32e9e693ec09997d8f33c553f3b7ed09231074c7
</body>
</html>