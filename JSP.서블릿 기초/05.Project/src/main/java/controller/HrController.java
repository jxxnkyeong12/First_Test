package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDTO;
import empdept.DeptDAO;
import empdept.DeptDTO;
import empdept.EmpDAO;

  


@WebServlet({"/list.emp", "/list.dept"})  //배열로 하면 두개를 동시에 사용가능
public class HrController extends HttpServlet {
	
	RequestDispatcher rd ;
	EmpDAO dao = new EmpDAO();
	DeptDAO daod = new DeptDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 
		if(req.getServletPath().equals("/list.emp")) {
			//DAo를 만들고 req.setAttr해야 됨
			System.out.println("사원조회 확인용");
			   req.setAttribute("list", dao.getList());
			
			rd = req.getRequestDispatcher("Hr/Emplist.jsp");
		
		}else if(req.getServletPath().equals("/list.dept")) {
			
			System.out.println("부서조회 확인");
			req.setAttribute("list", daod.getList());
			rd = req.getRequestDispatcher("Hr/Dlist.jsp");
		}
		rd.forward(req, resp);
   }

}