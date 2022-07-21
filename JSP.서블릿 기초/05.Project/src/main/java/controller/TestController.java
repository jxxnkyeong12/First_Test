package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonDAO;

@WebServlet("*.te")
public class TestController extends HttpServlet {
	
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	req.getSession().setAttribute("userInfo", "a");
		
		
		CommonDAO dao = new CommonDAO();

		System.out.println("조회 잘됐나 확인용");
		rd =req.getRequestDispatcher("index.jsp");
		
		dao.getTest();
		
		rd.forward(req, resp);
	}

}
