package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybaticSaone.MybaticDAO;

@WebServlet("*.hr")
public class MybatisController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	RequestDispatcher rd ;
	MybaticDAO dao = new MybaticDAO();
	
	rd = req.getRequestDispatcher("error/404.jsp");
	
	
	if(req.getServletPath().equals("/list.hr")) {
		System.out.println("마이밧티스 사원목록 확인용");
		req.setAttribute("list", dao.getList());
		rd = req.getRequestDispatcher("Mybatis/list.jsp");
	}
	
	rd.forward(req, resp);
	}
	
}//class
