package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.mb")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		String view ="";
		
		if(uri.equals("/join.mb")) {
			//회원가입 화면을 요청한것
			//응답화면연결 -회원가입화면
		
			view = "/member/join.jsp";
		}
	 request.getRequestDispatcher(view).forward(request, response);
	 
	}//service

}//class
