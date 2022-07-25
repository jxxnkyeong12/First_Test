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
		
		rd = req.getRequestDispatcher("Error/404.jsp");//나중에 만들예정
		if(req.getServletPath().equals("/list.cu")) {
			System.out.println("고객 관리 모듈 확인용");
			//dao.test();
			//List<CustomerDTO> list	= dao.getList();
			req.setAttribute("list", dao.getList());  //jsp에서 사용할수 있게 담음(저장했다) 페이지를 새로 열때, 여기에 또 바로 담아버리네...!
           //rd = req.getRequestDispatcher("customer/list.jsp");	
           rd = req.getRequestDispatcher("customer/listjstl.jsp");	//이게 더 간단할수도 있음
           
		}
		
		rd.forward(req, resp);
	}
	
	
}
