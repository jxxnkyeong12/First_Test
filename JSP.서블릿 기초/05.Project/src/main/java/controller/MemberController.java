package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberDTO;

@WebServlet("*.mb")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getServletPath();
		String view ="";
	MemberDAO dao = new MemberDAO();
		if(uri.equals("/join.mb")) {
			//회원가입 화면을 요청한것
			//응답화면연결 -회원가입화면
			view = "/member/join.jsp";
			
		}else if (uri.equals("/id_check.mb")) {
			//아이디 중복확인 요청
			//화면에서 입력한 아이디가 DB에 존재하는지 확인 : 비지니스로직 - DB연결과 관련이 있다
		int count = dao.member_id_check(request.getParameter("id"));
			//1이면 아이디가 존재, 0이면 아이디가 존재하지 않음! 없어!
			response.getWriter().print(count);
			return;
		}else if (uri.equals("/member_join.mb")) {
			//회원가입처리를 요청!!
			//화면에서 입력한 회원정보를 데이터객체(DTO)에 담는다
		MemberDTO dto =	new MemberDTO();
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
			msg.append("alert('회원가입 축하!'); location = ");
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
