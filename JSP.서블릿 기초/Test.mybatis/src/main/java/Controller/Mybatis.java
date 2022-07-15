package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybsaone.MybasaonDAO;

@WebServlet("*.hr")
public class Mybatis extends HttpServlet {

	RequestDispatcher rd;
	MybasaonDAO dao = new MybasaonDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("마이밧티스 사원목록 확인용");
		rd = req.getRequestDispatcher("Error/404.jsp");// 나중에 만들예정
		if (req.getServletPath().equals("/list.hr")) {
			req.setAttribute("list", dao.getList());
			rd = req.getRequestDispatcher("Mybatis/list.jsp");
			rd.forward(req, resp);
		}
	
	}//serivce	
}//class
