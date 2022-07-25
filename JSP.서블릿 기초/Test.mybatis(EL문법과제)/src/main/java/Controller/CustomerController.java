package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerDTO;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {

	RequestDispatcher rd ;
	CustomerDAO dao = new CustomerDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		if(req.getServletPath().equals("/list.cu")) {
			System.out.println("고객 관리 모듈 확인용");
			//dao.test();
			List<CustomerDTO> list	= dao.getList();
			req.setAttribute("list", list);
           rd = req.getRequestDispatcher("customer/list.jsp");	
           
		}
		
		rd.forward(req, resp);
	}
	
	
}
