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
import customer.CustomerDTO;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	
	RequestDispatcher rd; 
	CustomerDAO dao = new CustomerDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getServletPath().equals("/list.cu");
			System.out.println("고객관리 눌림");
			//dao.test(); 10이 찍혀 콘솔에
			
			rd = req.getRequestDispatcher("error.404.jsp");
			if(req.getServletPath().equals("/list.cu")) {
				List<CustomerDTO> list = dao.getList();
				req.setAttribute("list", list); //jsp에서 사용할수 있게 담음(저장)
				System.out.println(list.size());
				
				/* rd = req.getRequestDispatcher("Customer/list.jsp"); */
				rd = req.getRequestDispatcher("Customer/listjstl.jsp");
			}else if(req.getServletPath().equals("/insert.cu")) {
				
				
				CustomerDTO dto = new CustomerDTO();
				dto.setName(req.getParameter("name"));
				dto.setGender(req.getParameter("gender"));
				dto.setEmail(req.getParameter("email"));
				dto.setPhone(req.getParameter("phone"));
		     int result=	dao.insert(dto);
				
				//System.out.println(req.getParameter("name"));
				/*
				 * System.out.println(req.getParameter("gender"));
				 * System.out.println(req.getParameter("email"));
				 * System.out.println(req.getParameter("phone"));
				 */
				return;
			}
			rd.forward(req, resp);
			
	}
 }
