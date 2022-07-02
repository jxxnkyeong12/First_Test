package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Res") //이걸로도 이동갑니다
public class Ex01_Response extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//페이지전환 RequestDispatcher
		//Jsp Container에서 받아서 사용하게끔 만들어놓음.(서버 스타트시 알아서 객체를 내장객체화해둠)
//		RequestDispatcher rd = request.getRequestDispatcher("내가 가고 싶은 JSp페이지"); 
		//RequestDispatcher rd = request.getRequestDispatcher("Ex02_Response/Ex01_Redirect.jsp"); 
		RequestDispatcher rd = request.getRequestDispatcher("Ex02_Response/Ex01_Redirect.jsp"); 
		
		request.setAttribute("id", "admin");
		request.setAttribute("pw", "1234");
		
		rd.forward(request, response);//가라고 지시사항 해주기!
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
