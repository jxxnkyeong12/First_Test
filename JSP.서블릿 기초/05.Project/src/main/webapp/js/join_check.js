/**
 * 회원가입 입력유효성 확인
 1.변수에 담아서 쓸수 있도록! 변수 선언하자
 */
 
  var join = {  //join에 선언되어진 함수들 ->tag_status , id_status, id, common
	tag_status : function(tag) { //2.태그의 상태를 판단할 함수를 하나 선언하자 - 3.화면에서 tag를 넘겨받을거야
	var name = tag.attr('name'); //4.태그가 가지고 있는 속성(attr)중에 name속성을 가지고 판단을 하는데, 4.이 이름이 무엇이냐에 따라서 만약 이름이 userid다 (name == 'userid')
								// 5.id에 대해서 판단할 함수를 호출해야 한다 - id_status().<-하나 만들어줘
	if( name == 'userid')  return this.id_status( tag.val() ); //태그의 name이 userid!값 파라메터로 
													//return id_status( tag.val() ); 이렇게 하면 'id_status is not defined'에러가 난다. 
													//해결법 : join안에 있는 id_status니까 this.id_status로 선언해주면 해결!
	else if(name =='userpw') return this.pw_status( tag.val() );										
	else if(name =='userpw_ck') return this.pw_ck_status( tag.val() );										
	else if(name =='email') return this.email_status( tag.val() );										
	
	},
	
	//이메일
	
	email_status : function( email ) {
		
		//이메일형식 구글링해서 넣기
		var reg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			// 바깥쪽에 있는 ^는 not이 아니라 이것으로 '시작하는'이란 뜻!!!
		if( email=='' )    				  return this.common.empty;
		else if(email.match(this.space) )   return this.common.space;//space 가 정의되어 있지 않다 - 앞에 match(this.sapce) join안에 있으니까 this 넣어줘야지.
		else if ( reg.test( email ) )        return this.email.valid;
		else 							  return this.email.invalid;
		
	},

	email : {
		valid: { code:'valid', desc:'사용가능한 이메일입니다' },
		invalid: { code:'invalid', desc:'이메일형식이 아닙니다' }
		
	},
	
	//비밀번호 체크함수
	pw_ck_status : function(pw_ck) {
	    //비밀번호와 입력값이 같은지만 판단하면 돼
		if(pw_ck =='')    								 return   this.common.empty;
		else if(pw_ck == $('[name =userpw]').val() )	 return this.pw.equal;
		//패스워드 태그에 있는 값하고 비교하면 돼, 제이쿼리 사용해서 name=userpw에 값하고 같은지만 판단!
		else         									 return this.pw.Notequal;
		
	},
	
	
	
	//비밀번호 
	pw_status : function( pw ) {
		//영문소문자나 숫자외에는 입력불가
		var reg =/[^a-zA-Z0-9]/g, upper = /[A-Z]/g, lower = /[a-z]/g, digit =/[0-9]/g ; //digit: 숫자!에 해당하는 데이터중에 하나라도 빠지면 안된다 
	
		if(pw == '')    				 return this.common.empty;
		else if( pw.match(this.space) )   return this.common.space;
		else if( reg.test(pw))            return this.pw.invalid;  //정규식을 판단했더니(test) 잘못입력된게 들어왔다! 그러면 invalid로 반환해라
		else if( pw.length < 5 )          return this.common.min;
		else if ( pw.length > 10 )         return this.common.max;
		else if( !upper.test(pw) || !lower.test(pw) || ! digit.test(pw) )    return this.pw.lack;       //있는지 없는지 비교할땐 test!!!
																									    // upper나 lower나 digit가  없다면 lack를 반환해라 
		else 							 return this.pw.valid;
	},
	
	pw : {
		equal: {code : 'valid', desc : '비밀번호가 일치합니다'},
		Notequal: {code : 'invalid', desc : '비밀번호가 일치하지 않습니다'},
		lack : {code: 'invalid', desc : '영문 대/소문자, 숫자를 모두 포함해야 합니다'}, //먼가 하나 빠졌다!
		valid : {code: 'valid', desc : '사용가능한 비밀번호 입니다'},
		invalid : {code: 'invalid', desc : '비밀번호는 영문 대/소문자만 입력가능합니다'}
	},
	
	space : /\s/g,  //공백에 해당하는 문자를 체크할 속성을 추가!
		
	
	
	
	id_status: function( id ) { //6.함수 선언! 입력된 값을 받아 올거야 - 그게 id값 -'홍길동'이라는!
	
	//영문소문자나 숫자외에는 입력불가↓
	  var reg = /[^a-z0-9]/g; //정규식 ! 문자중에 ^(not!) 
	
		if(id =='') 				   return this.common.empty;  //조인안에 common이 있잖아. 그러니까 this! (join)자기 자신이 가지고 있는 common에 empty를 가져와
		else if(id.match(this.space))  return this.common.space; //입력한 데이터가 아이디나, 공백문자와 일치(match)하는게 있다. 그럼 join에 있는 commmo sapce를 반환!
		
		else if(reg.test(id))		   return this.id.invalid; //정규식을 판단해서, 입력한 id에 대해서 이 결과가 참이면(^(not)에 해당된다!영문소문자 아닌게 있단소리!) 
															   //이 잘못입력한 케이스는 공통이 아니라 아이디에만 적용되는거야!
		else if(id.length < 5 )		   return this.common.min;
		else if(id.length > 10 )	   return this.common.max;
		else 						   return this.id.valid;  //정상적으로 잘 입력했다
	
	
	},
	
	//아이디 사용가능한지의 여부를 판단할 함수 추가
	
	id_usable : function( usable ){//1아니면 0의 형태니까 if,else
		if( usable ==1)    return this.id.unUsable;
		else 			   return this.id.usable;
	},
	
	
	id : {
		invalid: {code: 'invalid', desc :'영문 소문자, 숫자만 입력하세요'},
		//valid : {code: 'valid', desc : '사용가능한 아이디 입니다'} //valid이면 무조건 사용가능으로 뜨는거니까,
		valid : {code: 'valid', desc : '아이디 중복확인 하세요'}, //valid이면 무조건 사용가능으로 뜨는거니까, 아이디 중복확인하라고 메세지를 변경
		usable: {code : 'valid', desc : '사용가능한 아이디입니다.'},
		unUsable: {code : 'invalid', desc : '이미 사용중인 아이디입니다.'}
	},
	
	
	common: { //아이디, 이메일 유효성검사 필요한곳에 공통적으로 들어가는 부분은 common으로 빼둔다
		empty: {code: 'invalid', desc : '입력하세요'}, //아무것도 입력되지 않은상태면 - invalid상태로 변하고 문구(desc)가 튀어나간다
		space: {code: 'invalid', desc : '공백없이 입력하세요'}, //공백이 들어가면 invalid상태로 변하고 문구desc가 튀어나간다!
		max : {code: 'invalid', desc : '최대 10자이하로 입력하세요'},
		min : {code: 'invalid', desc : '최소 5자이하로 입력하세요'}
	}
	
}//객체 형태로 표현
 
 
 
 
 
 
 
 
 
 
 
 
 