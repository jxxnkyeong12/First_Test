package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.er")
public class ErrorController extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("에러 페이지 연결해주기");
		System.out.println(req.getServletPath());
		if(req.getServletPath().equals("/404.er")) {
			rd = req.getRequestDispatcher("error/404.jsp");
		}else if(req.getServletPath().equals("/401.er")) {
			rd = req.getRequestDispatcher("error/401.jsp");
		}else if(req.getServletPath().equals("/500.er")) {
			rd = req.getRequestDispatcher("error/500.jsp");
		}else {
			resp.getWriter().println("<a>나중에 에러처리 할 예정 </a>");
			return;//이미 응답을함(↑) 다시 포워드가 처리되지않게 막음
		}
		//401 , 404 , 500 외에 에러처리가 안되는 페이지가 나온다면 
		// default로 보여줄수있는 에러페이지를 만들예정
		
		rd.forward(req, resp);
	}
}
