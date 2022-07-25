package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employees.EmployeeDAO;
import employees.EmployeeDTO;

@WebServlet("*.emp")
public class Employees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String uri = request.getServletPath();
	String view = "";
	EmployeeDAO dao = new EmployeeDAO();
	
		if(uri.equals("/list.emp")) {
			System.out.println("사원목록에 잘 오나 확인");

			request.setAttribute("list", dao.getList());
			
			view = "employees/elist.jsp";
			
			request.getRequestDispatcher(view).forward(request, response);
		}
	
	
	
	}//service

}//class
