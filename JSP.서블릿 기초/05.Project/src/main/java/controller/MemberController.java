package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import member.MemberDAO;
import member.MemberDTO;

@WebServlet("*.mb")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //성별에서 3인데 6이나 된다고 에러뜨는 경우가 있다. 이건 한글이 깨져서 그런거라 다시 utf-8을 주면 된다!
		String uri = request.getServletPath();
		String view ="";
		CommonUtil util = new CommonUtil();
	MemberDAO dao = new MemberDAO();
		if(uri.equals("/join.mb")) {
			//회원가입 화면을 요청한것
			//응답화면연결 -회원가입화면
			view = "/member/join.jsp";
			
		}else if(uri.equals("/iotlogin.mb")) {	
			//로그인처리 요청
			//화면에서 입력한 아이디와 비밀번호가 일치하는 회원정보를 
			//DB에서 조회해 와서 !
			
			MemberDTO dto = dao.member_login( request.getParameter("id")
											, request.getParameter("pw") );
			//세션에 저장한다.
			request.getSession().setAttribute("userInfo", dto);
			response.getWriter().print(dto==null ? false : true);
			return;
			
		}else if(uri.equals("/login.mb")) {	
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
	 request.getRequestDispatcher(view).forward(request, response);
	 
	}//service

}//class
