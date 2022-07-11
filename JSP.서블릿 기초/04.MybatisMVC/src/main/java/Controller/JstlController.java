package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;

@WebServlet("*.js")
public class JstlController extends HttpServlet {
	
	RequestDispatcher rd; 
	CustomerDAO dao = new CustomerDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			System.out.println("JSP 찍히나 확인용");
			
			rd = req.getRequestDispatcher("error.404.jsp");
			
			if(req.getServletPath().equals("/list.js")) {
				rd = req.getRequestDispatcher("jstl/list.jsp");
			}else if(req.getServletPath().equals("/listfmt.js")) {
				rd =req.getRequestDispatcher("jstl/listfmt.jsp");
				
			}else if(req.getServletPath().equals("/listfn.js")) {
				rd =req.getRequestDispatcher("jstl/listfn.jsp");
				
			}
			
			
			rd.forward(req, resp);
			
	}
	
	
	
	
}
