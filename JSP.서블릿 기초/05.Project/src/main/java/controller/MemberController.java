package controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.CommonUtil;
import member.MemberDAO;
import member.MemberDTO;

@WebServlet("*.mb")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private String appName(HttpServletRequest request) {
		//URL :http://localhost/pj/login.mb
		//ServletPath : /login.mb
		return request.getRequestURL().toString().replace(request.getServletPath(), ""); //빈문자열로 바꿔서 지워버려
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //성별에서 3인데 6이나 된다고 에러뜨는 경우가 있다. 이건 한글이 깨져서 그런거라 다시 utf-8을 주면 된다!
		String uri = request.getServletPath();
		boolean redirect = false; //디폴트는 리다이렉트 하지 않는다! 
		String view ="";
		CommonUtil util = new CommonUtil();
		
		
		String NAVER_ID = "3C0gJleDZlNATaqQYI8p";  //네이버 개발자 들어가서 네이버 client_id 받은거 넣어줘!!
		String NAVER_SECRET = "xi5pg8jxMY";  //네이버 client_secret
		String KAKAO_ID = "9d6908da78be87da98861da31fded1f2";// 카카오 RestAPI 키
		
		
		
	MemberDAO dao = new MemberDAO();
		if(uri.equals("/join.mb")) {
			//회원가입 화면을 요청한것
			//응답화면연결 -회원가입화면
			view = "/member/join.jsp";
		}else if(uri.equals("/kakao_login.mb")) {	
			//카카오로그인 요청
			//https://kauth.kakao.com/oauth/authorize?response_type=code
			//&client_id=${REST_API_KEY}
			//&redirect_uri=${REDIRECT_URI}
			
			
			StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/authorize?response_type=code");
			url.append("&client_id=").append(KAKAO_ID);
			url.append("&redirect_uri=").append(appName(request)).append("/kakao_callback.mb");
			
			redirect = true;
			view = url.toString();
			
		}else if(uri.equals("/kakao_callback.mb")) {	
			String code = request.getParameter("code");
			String error = request.getParameter("error");
			
			redirect= true;
			if(error !=null ) view = request.getContextPath();
			else {
				//인가 코드로 토근 발급을 요청합니다
//				curl -v -X POST "https://kauth.kakao.com/oauth/token" \
//				 -H "Content-Type: application/x-www-form-urlencoded" \
//				 -d "grant_type=authorization_code" \
//				 -d "client_id=${REST_API_KEY}" \
//				 --data-urlencode "redirect_uri=${REDIRECT_URI}" \
//				 -d "code=${AUTHORIZE_CODE}"
//				
				//사용자정보 가져오기에 사용할 토근 발급 받기
				StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/token?grant_type=authorization_code");
				url.append("&client_id=").append(KAKAO_ID);
				url.append("&code=").append(code);
				
				
				
			 JSONObject json = new JSONObject(util.requestAPI(url.toString()) ); //Response성공 json형태로 변환
			 String type = json.getString("token_type");
			 String token = json.getString("access_token");
			 
			 //사용자 정보 가져오기
//			 curl -v -X GET "https://kapi.kakao.com/v2/user/me" \
//			  -H "Authorization: Bearer ${ACCESS_TOKEN}"
			 url = new StringBuffer("https://kapi.kakao.com/v2/user/me");  //위에 url 재사
			 json = new JSONObject( util.requestAPI(url.toString(), type + " " + token));
			 
			 //"id" : "32742776", : 네이버로 로그인시 id  문자열
			 //"id" : 123456789. : 카카오로 로그인시 id  숫자!
//			 {
//				    "id":123456789,
//				    "kakao_account": { 
//				        "profile_needs_agreement": false,
//				        "profile": {
//				            "nickname": "홍길동",
//				        
//				        },
//				        "name":"홍길동",
//				        "email": "sample@sample.com",
//				        "gender":"female" 네이버는 F M 이렇게 짧게 있었는데 여긴 full로 있눼?!
//				    },  
			 if(!json.isEmpty()) {
				 //카카오정보를 Member테이블의 회원으로 저장
				 MemberDTO dto = new MemberDTO();
				 dto.setSocial("K");
				 dto.setUserid(json.get("id").toString() ); //아이디가 숫자라서 문자로 변환해줘
				 
				 json = json.getJSONObject("kakao_account");
				 dto.setName(json.has("name") ? json.getString("name") : "");
				 dto.setEmail(json.getString("email"));
				 dto.setGender(json.getString("gender").equals("female") ? "여" : "남" );
				 
				 //닉네임이 있으면 name 에 닉네임을 담는다
				 if(json.getJSONObject("profile").has("nickname")) {
					 dto.setName(json.getJSONObject("profile").getString("nickname") );
				 }
				 
				 //카카오로그인이 처음이면 신규저장, 아니면 변경저장
				 if(dao.member_id_check(dto.getUserid()) ==0)  { //없으면 신규저장
					 dao.member_join(dto);
				 }else {
					 dao.member_update(dto);
					 
					request.getSession().setAttribute("userInfo", dto); 
				 }
				 view = request.getContextPath(); //리다이렉트 시켜줘
			 }
		 
			}
		
			
			
			
			
			
		}else if(uri.equals("/naver_login.mb")) {	
			//네이버 로그인처리 요청==========================================================================================■
			//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=CLIENT_ID&state=STATE_STRING&redirect_uri=CALLBACK_URL
			//https://nid.naver.com/oauth2.0/authorize?
			//response_type=code&
			//client_id=CLIENT_ID&
			//state=STATE_STRING&
			//redirect_uri=CALLBACK_URL
			
			//랜덤한 데이터 만들기
			
			//세션상태토큰으로 사용할 랜덤문자열 : UUID(Universal Unique ID)
			String state =UUID.randomUUID().toString();
			request.getSession().setAttribute("state", state);
			
			//"3C0gJleDZlNATaqQYI8p";
			StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/authorize?response_type=code");
			url.append("&client_id=").append(NAVER_ID);
			url.append("&state=").append(state);
			url.append("&redirect_uri=").append(appName(request)).append("/naver_callback.mb");
			
			
			redirect= true;
			view = url.toString();  //url은 객체니까 문자화 시켜서!
			
		}else if (uri.equals("/naver_callback.mb")) {
		     //	API 요청 성공시 : http://콜백URL/redirect?code={code값}&state={state값}
			//	API 요청 실패시 : http://콜백URL/redirect?state={state값}&error={에러코드값}&error_description={에러메시지}
			
			String error =request.getParameter("error");
			String code =request.getParameter("code");
			String state =request.getParameter("state");
			redirect = true;
			if( error!=null || !state.equals((String)request.getSession().getAttribute("state") )) { //정상적이다! attribute가 object라서 String으로 캐스팅!
				view = request.getContextPath();
			}else {
				//Callback으로 전달받은 'code'값을 이용하여 '접근토큰발급API'를 호출
				
				//https://nid.naver.com/oauth2.0/token?grant_type=authorization_code
				//&client_id=jyvqXeaVOVmV
				//&client_secret=527300A0_COq1_XV33cf
				//&code=EIc5bFrl4RibFls1
				//&state=9kgsGTfH4j7IyAkg
				
				StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
				url.append("&client_id=").append(NAVER_ID);
				url.append("&client_secret=").append(NAVER_SECRET);
				url.append("&code=").append(code);
				url.append("&state=").append(state);
				
				String result =util.requestAPI(url.toString());
				JSONObject json = new JSONObject(result);
				 String token = json.getString("access_token");
				String type = json.getString("token_type");
				
				
				//3.4.5접근 토큰을 이용하여 프로필 API 호출하기
				//https://openapi.naver.com/v1/nid/me
				//Authorization: {토큰 타입] {접근 토큰]
				
				
				 url = new StringBuffer("https://openapi.naver.com/v1/nid/me");
				 //url 변수 재사용 밑에도 다 재사용
				 result = util.requestAPI(url.toString(), type+ " " + token); //파라메터 2개 보내기
				 json = new JSONObject(result);
				 
				if( json.getString("resultcode").equals("00")){
//					 "resultcode": "00",
//					  "message": "success",
//					  "response": {
//					    "email": "openapi@naver.com",
//					    "nickname": "OpenAPI",
//					    "profile_image": "https://ssl.pstatic.net/static/pwe/address/nodata_33x33.gif",
//					    "age": "40-49",
//					    "gender": "F",
//					    "id": "32742776",
//					    "name": "오픈 API",
//					    "birthday": "10-01"
					json = json.getJSONObject("response");
					MemberDTO dto = new MemberDTO();
					dto.setSocial("N"); //네이버를 담고있으니까 N
					dto.setUserid(json.getString("id"));
					dto.setEmail(json.getString("email"));
					dto.setName(json.getString("name"));
					dto.setGender(json.getString("gender").equals("F") ? "여" : "남"); //M/F ->남/여
					dto.setPhone(json.getString("mobile")); //전화를 추가했으면 해주고! 안했으면 안해도 돼!
					//dto.setPhone(json.has("mobile") ? json.getString("mobile") : ""); //전화를 추가했으면 해주고! 안했으면 안해도 돼! 근데 이걸 잘 모를때 조건문을 넣어주면 돼
					
					//회원정보로 저장
					//네이버 로그인이 처음이면 신규저장, 아니면 변경저장
					//네이버로그인이 처음인지 파악 : 아이디의 존재여부
					if(dao.member_id_check(dto.getUserid()) ==0) { //0이면 신규저장!
						//신규저장
						dao.member_join(dto);
						
					}else {
						//변경저장
						dao.member_update(dto);
					}
					
					request.getSession().setAttribute("userInfo", dto);
				}
				view = request.getContextPath();
			}
				
				
			
				
				
			
		}else if(uri.equals("/iotlogin.mb")) {	
			//로그인처리 요청
			//화면에서 입력한 아이디와 비밀번호가 일치하는 회원정보를 DB에서 조회해 와서 !
			//화면입력 비번을 회원의 salt를 사용해서 암호화한 후 DB에 있는 salt_pw 와 일치하는 지를 확인해야 한다
			String salt = dao.member_salt(request.getParameter("id") );
			String salt_pw = util.getEncrypt(request.getParameter("pw"), salt);
			
//			MemberDTO dto = dao.member_login( request.getParameter("id")
//											, request.getParameter("pw") );
			
			MemberDTO dto = dao.member_login(request.getParameter("id"), salt_pw );
			//세션에 저장한다.
			request.getSession().setAttribute("userInfo", dto);
			response.getWriter().print(dto==null ? false : true);
			return;
		
		}else if(uri.equals("/logout.mb")) {		
			//로그아웃처리 요청
			//카카오로그인한 경우 카카오계정도 함께 로그아웃되게 처리하기
			String social
			= ((MemberDTO)request.getSession().getAttribute("userInfo")).getSocial();			
			
			request.getSession().removeAttribute("userInfo");
			
			if( social != null && social.equals("K") ) {
				//curl -v -X GET "https://kauth.kakao.com/oauth/logout
				//?client_id=${YOUR_REST_API_KEY}
				//&logout_redirect_uri=${YOUR_LOGOUT_REDIRECT_URI}"
				StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/logout");
				url.append("?client_id=").append(KAKAO_ID);
				url.append("&logout_redirect_uri=").append(appName(request));	
				view = url.toString();
			}else
				view = request.getContextPath();
			
			redirect = true;
			
			//해결방안 에러메시지 뜨면 내어플리케이션 - > 고급 -> 주소 http://localhost/pj 가 맞나 확인! '/'!! 이게 들어가있음 안돼!! 
			
			
		}else if(uri.equals("/login.mb")) {	
			//노출된 비밀번호를 암호화해서 저장해두는 처리 : 나중에 주석처리함
//			List<MemberDTO> list= dao.member_list();
//			for(MemberDTO dto : list) {
//				String salt = util.generateSalt();
//				String salt_pw = util.getEncrypt(dto.getUserpw(), salt);
//				dto.setSalt(salt);
//				dto.setSalt_pw(salt_pw);
//				dao.member_pw_encrypt(dto);
//			}
			//-----------------------------------------------------------------
			
			//로그인화면 만들기
			view = "/member/login.jsp";
			
			
		}else if (uri.equals("/id_check.mb")) {
			//아이디 중복확인 요청
			//화면에서 입력한 아이디가 DB에 존재하는지 확인 : 비지니스로직 - DB연결과 관련이 있다
		int count = dao.member_id_check(request.getParameter("id"));
			//1이면 아이디가 존재, 0이면 아이디가 존재하지 않음! 없어!
			response.getWriter().print(count);
			return;
		}else if (uri.equals("/member_join.mb")) {
			//회원가입처리를 요청!!
			
			
			//07.15비밀번호 암호화를 위한 salt생성
			String salt = util.generateSalt();
			String salt_pw = util.getEncrypt(request.getParameter("userpw"), salt);
			
			//화면에서 입력한 회원정보를 데이터객체(DTO)에 담는다
		MemberDTO dto =	new MemberDTO();
		dto.setSalt(salt);
		dto.setSalt_pw(salt_pw);// 07.15비밀번호 암호화를 위한 salt
		
		
		dto.setName(request.getParameter("name"));
		dto.setUserid(request.getParameter("userid"));
		dto.setUserpw(request.getParameter("userpw"));
		dto.setGender(request.getParameter("gender"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone(request.getParameter("phone"));
		dto.setBirth(request.getParameter("birth"));
		dto.setPost(request.getParameter("post"));
		
		String address [] = request.getParameterValues("address");
		//address[0] : 부산 상서구 르노삼성대로 14
		//address[1] : 101호
		//부산강서구 르노삼성대로 14<br>101호
		//String.join("<br>", address);
		/* dto.setAddress(request.getParameter("address")); */
		dto.setAddress(String.join("<br>", request.getParameterValues("address") ) ); 
		//화면에서 입력한 회원정보를 DB에 저장하는 처리! : 비지니스로직
		
		StringBuffer msg = new StringBuffer();
		response.setContentType("text/html; charset=utf-8");
		
		msg.append("<script>");
		if( dao.member_join(dto) == 1) {
			//회원가입축하 메일 전송하기!
			util.sendEmail( dto.getEmail(), dto.getName(), request );
			
			msg.append("alert('회원가입 축하^^!'); location = ");
		//	msg.append(" ' "+ request.getContextPath() + " ' ");
			msg.append(" ' ").append(request.getContextPath()).append("';");
		}else {
			msg.append("alert('회원가입 실패 ㅠ'); history.go(-1);");
		}
		msg.append("</script>");
		
		response.getWriter().print( msg.toString()) ;
		return;
	}
		
		if( redirect )
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	
	}//service

}//class
