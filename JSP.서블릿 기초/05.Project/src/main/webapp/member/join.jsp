<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	table tr:last-child  td input[name=address] { margin-top: 5px}
	.ui-datepicker table tr th:first-child { border-right: none; }/* 달력에 있던 Su 옆에 있던 굵은 선 사라지게 만든거야 */
	.ui-datepicker table tr { border-bottom: none;}
	#delete { position : relative;  right: 30px ; display:  none;}
</style>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
</head>
<body>
	<jsp:include page="/include/layout.jsp" />
<div class="container-fluid px-4">
<h3 class="mt-4">회원가입</h3>
	
<p>* 는 필수입력항목입니다</p>	
 <form method="post" action ="member_join.mb">
 	<table class ="w-px600">
 	
 	<tr>
 		<th class ='w-px140'>* 성명</th>
 		<td><input type ='text' name ="name" ></td>
 	</tr>
 	<tr>
 		<th>* 아이디</th>
 		<td><input type="text" name= "userid" class="chk">
 			<a class ='btn-fill' id = "id_check">아이디 중복확인</a>
 			<div class = "valid">아이디를 입력하세요(영문소문자, 숫자만 입력가능)</div>
 		</td>
 	</tr>	
 	<tr>
 		<th>* 비밀번호</th>
 		<td><input type = "password" name ="userpw" class ="chk">
 				<div class = "valid">비밀번호를 입력하세요(영문대/소문자,숫자를 모두 포함)</div>
 		</td>
 	</tr>	
 	<tr>
 		<th>* 비밀번호확인</th> <!-- 화면상에서 체크만 하는거야 -->
 		<td><input type = "password" name ="userpw_ck" class ="chk">
 			<div class ="valid">비밀번호를 다시 입력하세요</div>
 		</td>
 	</tr>	
 	<tr>
 		<th>* 성별</th>
 			<td>
 			<label><input type = "radio" name ="gender" value ='남'>남</label>
 			<label><input type = "radio" name ="gender" value ='여' checked>여</label>
 			</td>
 	</tr>	
 	<tr>
 		<th>* 이메일</th>
 		<td><input type ="text" name ="email" class = "chk">
 			<div class = "valid">이메일을 입력하세요</div>
 		</td>
 	</tr>	
 	<tr>
 		<th>생년월일</th>
 		<td><input type ="text" name ="birth" readonly>
 				<a id='delete'><i class="font-r fa-solid fa-calendar-xmark"></i></a>
 		</td>
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
 <div class ='btnSet'>
 		<a class = 'btn-fill' onclick = "fn_join()">회원가입</a>
 		<a class = 'btn-empty' href = "javascript:history.go(-1)">취소</a>
 						   <!--href는 링크걸어줬었는데 history.go를 쓰고 싶으면 앞에 javascript:를 넣어줘야해!  -->
 	<!-- 	<a class = 'btn-empty' onclick = "history.go(-1)">취소</a> -->
 
 </div>

</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script><!-- 주소api -->
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script><!-- 생년월일 달력 만들기 위한 스크립트! 제이쿼리ui.com -->
<script src ="js/join_check.js?<%= new java.util.Date()%>"></script>
<script>


//회원가입창 join으로 하니까 아예 다 안먹어서 이름을 변경함!!
function fn_join() {
 	//필수입력항목에 입력되어있는지 확인
 	//특정항목에 대해서는 유효한 입력인지도 확인
 	if($('[name=name]').val() == ''){
 		alert('성명을 입력하세요');
 		$('[name=name]').focus();
		return;
 	}
 	
 	// 아이디는 중복확인 여부에 따라 처리
 	//중복확인 한 경우 : invalid이면 회원가입 '이미 사용중인 아이디 입니다!'
 	if($('[name=userid]').hasClass('checked')){
 		if ( $('[name=userid]').siblings('div').hasClass('invalid') ){
 			alert('회원가입 불가\n' + join.id.unUsable.desc );
 		 	$('[name=userid]').focus();
 		 	return;
	 	}
 		
 	}else {
 	//중복확인 하지 않은 경우 
 		if(! item_check( $('[name=userid]' ) ) ) return; 
 		else {
 			alert('회원가입 불가\n' + join.id.valid.desc);
 			$('[name=userid]' ).focus();
 			return;
 		}
 	
 	}
 	
 	
 	if(! item_check( $('[name=userpw]' ) ) ) return; /*pw가 회원가입불가이면 내려오지도 말고 그냥 리턴! */
 	if(! item_check( $('[name=userpw_ck]') ) ) return;
 	if(! item_check( $('[name=email]') ) ) return;
 	
 	
 	$('form').submit();
 }
  
  function item_check( tag ) {
	var status =join.tag_status( tag );
	if(status.code == 'invalid') {
		alert('회원가입 불가\n' + status.desc);
		tag.focus();
		return false;
		
	}else 
		return true;
}


//입력의 유효성을 판단
$('#id_check').on('click', function(){
	id_check();
});

//아이디 중복확인처리
function id_check(){
	var $userid= $('[name=userid]');
	//유효한 입력 아이디에 대해서만 중복확인
	var status = join.tag_status( $userid );
	if( status.code=='invalid' ){
		alert( '아이디 중복확인 불필요\n' +  status.desc );
		$userid.focus();
		return;
	}
	
	$.ajax({
		url: 'id_check.mb',
		data: { id: $userid.val() },
		success: function(response ){
			/* console.log(response) */
			$userid.addClass('checked');
			response = join.id_usable( response );
			$userid.siblings('div').text( response.desc )
								   .removeClass().addClass(response.code);
		},error: function(req, text){
			alert(text +':' +req.status);
		}
	});
	
}


//입력의 유효성을 판단(입력하는것 중에)
$('.chk').on('keyup', function(e){ /* 엔터쳐도 다음으로넘어가게 하는법! e */
	if($(this).attr('name')== 'userid'){
		if(e.keyCode==13) { id_check();  return;} /* 엔터키코드가 13번이야 */
		else $(this).removeClass('checked'); /* ()안에 아무것도 안쓰면 다 사라지니까 특정클래스! checked 클래스만 없애자! */
	}
	var status = join.tag_status( $(this) );
	$(this).siblings('div').text( status.desc ).removeClass().addClass( status.code );
});




//만 13세까지만 가입가능하게 해주기 
var today = new Date();  
var start = today.getFullYear()-90; /* 오늘날짜부터 90년도까지 쫘악 나오게 변수 지정  */
today.setFullYear(today.getFullYear() - 13 );  /* 만이니까 13년빼기 */ 
today.setDate(today.getDate()-1) 

var defaultDay = new Date();
defaultDay.setFullYear(1990); //1990 -07-13이 있는 달력이 기본으로 보이게


//ㅁ달력 넣어주기 이벤트 jqueryui.com -> datepicker -> view소스 열어보기 -> 스크립트 선언문 넣어주기 
$( "[ name=birth]" ).datepicker({ 
	dateFormat: 'yy-mm-dd',
	dayNamesMin: ['일','월','화','수', '목', '금','토'], /*  7개니까 배열선언!*/
	showMonthAfterYear: true, /* 생년월일 2022을 앞으로 빼주는거 */
	monthNamesShort: [ '1월', '2월', '3월', '4월', '5월', '6월', 
								 '7월', '8월', '9월', '10월', '11월', '12월'],
	changeYear: true,
	changeMonth: true,
	
	//beforeShowDay: before, 오늘날짜까지만 선택할수 있게 해준거고! 
	// maxDate: today,
	maxDate: today,
	yearRange : start + ' : '  + today.getFullYear(), //이제 날짜가 한줄에 쭈루루룩 나와 스크롤로
	defaultDate : defaultDay,
});


//특정날짜(오늘)까지만 선택할수 있게
 function before(date) { 
	if(date > new Date() ) return [false];
	else						   return [true];
}

//생년월일을 변경되면 삭제이미지가 보이게(지금은 display : none으로 숨겨놓음)
$('[name=birth]').change(function () {
	 $('#delete').css('display', 'inline');
});

//delete를 눌러서 생일 사라지게 하는거 달력삭제,. 클릭시 생년월일 없애기!
$('#delete').click(function () {
	$('[name=birth]').val('');
	 $('#delete').css('display', 'none');  /* 삭제되면 이미지는 다시 사라지게 */
});




//	$('#post').click(function () { 
	 $('#post').on('click', function () {
		//①alert('dfs') 확인완! 다음 우편 서비스에서 스크립트랑 안에 있는 내용 긁어오기!
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // ②팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		       		console.log(data);//③콘솔 부분에 잘 넘어오는지 확인하기 위해 이걸 해야 밑에 data.zonecode가 잘 찍혀나와
		        $('[name=post]').val( data.zonecode ) //④F12 누르면 나오는 요소검사! 맨밑에 이게 있어. 그 바로 위에 있는 userSelectedType을 확인하기!
				//R : 도로명 주소, J : 지번주소
		        var address = data.userSelectedType == 'R' ? data.roadAddress : data.jibunAddress; //⑤선택한게 도로명 주소면 roadAddress 지번이면 jibunAddress! 라고 조건을 선언해주고
		        if(data.buildingName!='') address += ' ('+data.buildingName+')'; //⑦빌딩name이 비어있지 않으면 조건문을 준다! addres기본에다가 추가해준다 무엇을? 건물이름을!
		        																 // ⑧그리고 ( ) 안에 담길수 있게 편집해주면 된다 
		        $('[name=address]').eq(0).val( address); //⑥첫번째 주소에만 담길수 있도록 선언해주기
		        
		        }
		    }).open();
	});	
		


	   
</script>

	<jsp:include page="/include/footer.jsp" />
</body>
</html>