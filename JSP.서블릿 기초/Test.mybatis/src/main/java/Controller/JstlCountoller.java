package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("*.js")
public class JstlCountoller extends HttpServlet {

	
	RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		rd = req.getRequestDispatcher("error/404.jsp"); //나중에 추가 예정
		if(req.getServletPath().equals("/list.js")) {
			System.out.println("JSTL 컨트롤 거치나 확인용");
			rd = req.getRequestDispatcher("Jstl/list.jsp");
			
		}else if(req.getServletPath().equals("/listfmt.js")) {
			System.out.println("포맷태그");
			rd = req.getRequestDispatcher("Jstl/listfmt.jsp");
		}else if (req.getServletPath().equals("/listfn.js")) {
			System.out.println("펑션태그");
			rd = req.getRequestDispatcher("Jstl/listfn.jsp");
		}
		
		
		rd.forward(req, resp);
	}
	
	
}
