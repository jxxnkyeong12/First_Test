<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
 .star {
  display: inline-block;
  color:red; 
 }
table tr:last-child  td input[name =address] {
	margin-top: 5px;
}

.ui-datepicker table tr th:first-child{
	border-right: none;  /* 달력sun에 있는 선 없애주는거 */
}
.ui-datepicker table tr { border-bottom: none;}

#delete { position: relative; right: 30px; display: none; } /* 생년월일 text 안으로 넣는 거! 근데 삭제할때만 보여줘야 하니까 일단은 숨겨두기display:none */

</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css"><!-- 생년월일 css -->


</head>
<body>
	<jsp:include page="/include/layout.jsp"/>

<div class = "container-fluid px-4">
	<h3 class ="mt-4">회원가입</h3>
	<div><div class =star>*</div>는 필수입력 항목입니다 </div>
	<form method="post" action="member_join.mb"> <!-- 주소가 member_join.mb로 바뀔거야 -->
		<table class ='w-px600' >
		<tr>
			<th class = 'w-px140'><div class =star>* </div> 성명</th> <!-- 오라클에서 만들어놨던 데이터랑 이름을 input name =' '에 똑같이 맞춰줘 -->
			<td>
				<input type ="text" name ='name' >
			</td>
			
		</tr>
		<tr>
			<th><div class =star>* </div> 아이디</th>
			<td><input type ="text" name = 'userid' class ='chk'>
			<a class = 'btn-fill' id = 'id_check'>아이디 중복확인</a>  <!-- a태그로도 버튼의 형식을 만들수 있다.. 와우.. class로 만들었네!! -->
				<div class = 'valid'>아이디를 입력하세요(영문소문자, 숫자만 입력가능)</div> <!-- 유효성검사를 위해 div태그를 추가해준다 -->
			</td>
		</tr>
		<tr>
			<th><div class =star>* </div> 비밀번호</th>
			<td>
			<input type ="password" name = 'userpw' class ='chk'>
			<div class = 'valid'>비밀번호를 입력하세요 (영문대/소문자,숫자를 모두 포함)</div>
			</td>
		</tr>
		<tr>
			<th><div class =star>* </div> 비밀번호확인</th>
			<td>
			<input type ="password" name = 'userpw_ck' class ='chk'>
			<div class = 'valid'>비밀번호를 다시 입력하세요</div>
			</td>
		</tr>
		<tr>
			<th><div class =star>* </div> 성별</th>
			<td>
			<label><input type ="radio" name = 'gender' value = '남'>남</label><!-- radio와 checkbox는 선택이 되어진 값을 전송하려면 value가 반드시 있어야 한다! -->
			<label><input type ="radio" name = 'gender' value = '여' checked>여</label>
			</td> 
		</tr>
		<tr>
			<th><div class =star>* </div> 이메일</th>
			<td>
			<input type ="text" name = 'email' class ='chk'>
			<div class = 'valid'>이메일을 입력하세요</div>
			</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type ="text" name = 'birth' readonly>
			<a id ='delete'><i class="font-r fa-solid fa-calendar-xmark"></i></a> <!-- https://fontawesome.com 무료 아이콘!에서 삭제아이콘 가져오기 눌러서 삭제하게 할거니까 a태그로 감싸줘!-->
			</td>  
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type ="text" name = 'phone' ></td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
			<a class ='btn-fill' id ="post">우편번호찾기</a> <!-- 애들이 너무 다닥다닥 붙어있어서 위에 style을 주고 address인 얘들한테 margin-top을 줌! -->
			<input type ="text" name = 'post' class ='w-px80' readonly> <!-- 찾은 우편번호가 들어갈 공간 -->
			<input type ="text" name = 'address' readonly> <!-- 읽기전용 -->
			<input type ="text" name = 'address'><!-- 내가 직접 입력하는 곳. oo동oo호 -->
			</td>
		</tr>
		</table>
	</form>
	<div class ="btnSet">
		<a class = 'btn-fill' onclick="fn_join()">회원가입</a>
		<!-- <a class = 'btn-empty' onclick="history.go(-1)">취소</a> -->
		<a class = 'btn-empty' hrer="javascript:history.go(-1)">취소</a><!-- href를 쓸때 history는 스크립트코드라는걸 알려줘야 하니까 앞에 붙여줘 -->
	</div>
	</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script><!-- 우편번호 선언문 -->
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script> <!-- 생년월일 선언문 -->
<script src ="js/join_check.js?<%=new java.util.Date()%>"></script><!-- 계속 내려받을 수 있도록 표현식을 통해서 바뀌는 데이터인 시간데이터를 보내면 된다! -->
<!-- 유효성 검사를 위한 선언문 넣기! -->
<script>

//회원가입 버튼에 호출할 함수 선언
function fn_join() {   //함수 이름을 join 으로 하니까 join.tag_status is not a function를 인식하지 못한다는 에러가 뜬다-> 함수이름 변경 fn_join
	//필수입력항목에 입력되어있는지 확인
	//특정항목에 대해서는 유효하게 입력되어져 있는지도 확인하자
	 if($('[name=name]').val() == '') {  //이름항목에 이름이 없다!
		 alert('성명을 입력하세요');
		 $('[name=name]').focus();
		 return; //못내려오게 return시키기
		 
	 }
	 
	//아이디는 중복확인 여부에 따라 달라지게 처리하자
	//중복확인 한 경우 : invalid 이면 회원가입
	//invalid이면 회원가입불가
	if($('[name=userid]').hasClass('checked')) {
		
		if($('[name=userid]').siblings('div').hasClass('invalid')){
			alert('회원가입불가 \n' + join.id.unUsable.desc );
			$('[name=userid]').focus();
			 return;
		}
	}else {
		
	  //중복확인 하지 않은 경우
		if( ! item_check( $('[name = userid]') ) ) return; //false로 넘어오면 return이야!
		else {
			alert('회원가입 불가!\n' + join.id.valid.desc );
			$('[name = userid]').focus();
			return;
		}
	}
	
	
	if( ! item_check( $('[name = userpw]') ) ) return; //여기의 결과가 false면 그냥 return
	if( ! item_check( $('[name= userpw_ck]') ) ) return;
	if( ! item_check( $('[name = email]') ) ) return;
	$('form').submit();
	
	
}

function item_check( tag ) { //각항목을 체크해볼 함수 선언! 어떤 항목을 체크할것인지 대상이 되는 태그(tag)를 파라메터로 받아오도록 하자
	var status	= join.tag_status(tag); //code 하고 desc를 가져온다
	if(status.code=='invalid'){
		alert('회원가입 불가!\n' + status.desc ); //status.desc이유 설명해주기!
		tag.focus();  //이유에 해당하는 태그를 바꿀수 있도록 커서 위치 옮겨주기!
		return false;
	}else {
		return true;
	}
}




//아이디 중복확인 버튼을 눌렀을때 이벤트 발생하게 하기
$('#id_check').on('click', function () {
	//이중선언 하지 않으려면 함수 선언..!
	id_check(); //만들어둔 함수 선언!
	
});

//■아이디 중복확인 처리
function id_check() {
	var $userid = $('[name=userid]'); //네이밍, 코드가 길면 길수록 가독성이 떨어진다. 그래서 변수를 하나 선언해서 사용하자
	//유효한 입력 아이디에 대해서만 중복확인을 하자
	var status = join.tag_status( $userid );  //userid인 태그에 대해서 판단을 해야한다.그러면 반환받아오는 데이터가 있었다. 상태에 해당하는! code와 desc를 받아와!
	if(status.code=='invalid') {
	    alert('아이디 중복확인 불필요\n' + status.desc);   //고객의 입장에서~ 받아온 상태의 이유(status.desc)에 따라 변환되도록!
		$userid.focus(); //커서를 다시 userid에 가게 한다
	    return; //리턴해버리면 흐름은 밑으로 내려오지 않는거야. else이프로 해도 되고~		
	}//if

	//실제 DB에 있는지 확인할 중복확인을 하자
	
	$.ajax({
		
		url : 'id_check.mb',  //요청할 uri 컨트롤러에서 *.mb로 했잖아
		data : {id : $userid.val() },  //내가 입력한 값이 DB에 있는지 봐야지. 그럼 입력한 값을 파라메터로 전송해줘야 하잖아
		success: function(response ){ //성공했다면 데이터를 받아온 파라메터 선언
			//console.log(response);
			$userid.addClass('checked');//userid태그는 중복확인을 했다고 클래스를 추가해줘! 결과-> class='chk' 가 확인을 하게 되면 class = 'chk checked'로 바뀐다
										//근데 이대로 두면 계속 chk cheked가 되니까
			response = join.id_usable( response )  //받아온 숫자 데이터(response)를 파라메터로 보내면 된다- 반환받아온 값을 변수에 담아준다( code와 desc데이터가 있다)
			$userid.siblings('div').text(response.desc ).removeClass().addClass(response.code);
			//$userid= 위에서 변수 선언했잖아. $('[name=userid]')의 형제요소 'div'라는 뜻~
		},error: function (req, text) {  //에러에 대한 처리!
			alert(text + " : " + req.status);  //메지시를 출력! text는 에러! 어떤 코드인지 보려면 req.status 이걸로! 404/500이런거
		}
	});
		
}



//■ ■ 입력의 유효성을 판단 입력하는 중에
$('.chk').on('keyup', function (e) {  //발생한 이벤트를 받아올 파라메터 선언! 'e'(엔터를 치면 아이디중복환인 체크 되게 이벤트 발생시켜보자!)
	if($(this).attr('name') =='userid'){  //userid에대해서만 판단을 하게 따로 넣어주기
		if(e.keyCode==13 ) {id_check(); return; } //발생한 이벤트에 키코드를 판단  - 엔터에 해당하는 코드(13)면! 아이디 중복확인하는 함수를 호출해줘 
												 //근데 또 판단할 필요 없으니까. 이때는 중복확인 한 다음 리턴시켜버리자
	    else $(this).removeClass('checked');  //근데 그냥 removeClass()하면 다 사라지니까 특정 클래스만 없애자! removeClass('checked')
	
	}
 var status	= join.tag_status($(this)); //join에 있는 상태를 체크한다. 이때 태그를 전달해야 하니까 키업이 발생한! 자기 자신(chk=this=tag)을 전달하면 된다
	$(this).siblings('div').text( status.desc ).removeClass().addClass( status.code);     
 	//자기 자신 태그에!있는 형제요소중에 div에 - 텍스트로 상태에 해당하는 desc 출력
	//메소드 체인...?걸고 .addClass()클래스 추가! 상태 는 상태에 받아온 값이 valid이냐 invalid이냐 값이 code에 담겨있어..
	//근데 이러면 요소검사를 했을때 태그에 valid invalid다 들어가..! 그러니 앞에 valid를 삭제하는  removeClass()를 넣어주자
			
});//키보드를 눌렀다가 뗐을때 이벤트발생하게 하자


//12.만13세까지만 가입이 가능하게 만들기
var today = new Date(); //오늘날짜에 해당하는 객체 생성!
var start = today.getFullYear() - 90 ; //새발견!
today.setFullYear( today.getFullYear() - 13 ); //오늘 날짜 기분에 해당하는 년도데이터를 뽑는다. 그리고 이 연도에서 -13을 뺀다. today의 년도로 지정
today.setDate (today.getDate()-1 ); //만 13은 오늘날짜보다 하루 이전까지만 가능. 일자에 해당하는 데이터를 -1 today의 날짜로 지정

$( "[name = birth]" ).datepicker({
	//1.이제 미국식에서 한국식으로 날짜를 바꿔보기로 하자! 먼저 속성명은!
	dateFormat: 'yy-mm-dd', /*3. format시켜! */
 	dayNamesMin : ['일','월','화','수','목','금','토'],  /* 4.요일데이터 변경. 이름이 일~토 7개니까 이름들!Names! 짧은 이름을 쓰기 Min - 그리고 배열로 넣기 */
	showMonthAfterYear: true, /* 5.연도Year 뒤에after 월을 month 보여지게show 처리를 해준다 ■ ; 이거 하지마..이거하면 아래까지 다 막혀서 안돼...ㅎ■ */
	monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], //6.
	
	changeYear : true, //7.년도를 변경할수 있게!
	changeMonth : true, //8.월도 변경할수 있게 속성추가 
	//9. 그러면 년도와 월이 스크롤 형태로 변해서 내가 마음대로 바꿀수 있게 된다 (select 태그! 연도 데이터를 기준으로 위아래로 10개씩 된다)
	//11. 10번의 함수를 적용시키기 : 이전에 해당하는 날짜를 보여지게 할것인지. 이런 속성을 선언한 함수(before)를 선언!
	//beforeShowDay: before, 13.today변수들 위로 올려서 이건 이제 못써 
    maxDate : today, //이제 2009년부터선택할수 있게 변해
	yearRange : start + ' : ' + today.getFullYear(), //스크롤로 한번에 보이게!

}); //2.속성을 지정해준다- 객체를 선언해준다 {}


//→10.특정 날짜(오늘)까지만 선택할수 있게 함수 선언!
function before(data) { //달력에 있는 날짜를 받아올 파라메터(data)하나를 설정해주고
	if( data > new Date() ) return [false];  //날짜정보를 받아와서 오늘날짜(new Date()객체 생성)보다 크다면 선택하지 못하게! 그러면 반환시키기를 선택할수 없게[false]!
	else 					return [true];   //아니면 선택할수 있게
}

//13. 생년월일이 변경되면 삭제이미지가 보이게 
$('[name=birth]').change(function () {
	$('#delete').css('display', 'inline'); /* block으론 주지마~ */
	
});

//14.달력삭제 클릭시 생년월일 없애기 + 삭제 이미지도 안보이게 처리하기! 
$('#delete').click(function () {
	$('[name=birth]').val(''); //name이 birth인 값을 ''없애면 된다!
	$('#delete').css('display', 'none'); /*값이 없어졌으니 아이콘도 다시 사라지게 설정해준다! */
})


//우편주소 JQ
/* $('#post').click(function () { */
$('#post').on('click', function () {
/* 1. alert('확인완') id가 post인 우편번호찾기를 눌렀을때 이벤트가 잘 뜨나 확인용!*/	 	
 new daum.Postcode({
     oncomplete: function(data) {
		console.log(data); /* 2.일단 뭐가 찍히는지 봐보자 */
    	 $('[name = post]').val(data.zonecode ); /* 3.name이 post인 태그에다가 값을 담는다. 담아야할 값은 파라메터로 받아온 데이터에 있는데 객체의 이름이 뭐냐면 zonecode! */
			// ■ R:도로명 주소, J :지번주소
    	 var address = data.userSelectedType =='R' ? data.roadAddress : data.jibunAddress  //4.빌딩 이름때문에 편집을 해서 담을 수 있는 변수 하나 선언!
    			 //유저가 선택한 타입이 로드이면 데이터는 roadAddress, 아니면 jibunAddress !  
    		if(data.buildingName !='') address += '( ' + data.buildingName + ' )'; // 6.buildingName이 비어있지 않으면 address기본에다가 추가를 해준다.무엇을? 건물이름을!
    			 								//그리고 ( )여기 안에 넣어주려면 따로 내가 만들어줘야함'( ' + 변수 + ' )'! 
    	 $('[name = address]').eq(0).val(address);  // 5.그리고 위의 변수를 주소태그에 담는다. 근데 위에 태그 이름들이 둘다 address니까 이대로 두면 똑같이 입력값이 들어가진다
    	 	//첫번째 주소에만 담길수 있도록 eq(0)을 선언해준다								
         
     }
 }).open();
});



</script>
</body>
	<jsp:include page="/include/footer.jsp"/>
</html>