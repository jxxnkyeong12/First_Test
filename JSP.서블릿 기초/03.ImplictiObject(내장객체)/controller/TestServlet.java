package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Ex01_Request/TestServlet.jsp");
		request.setAttribute("aa", "잘왔나확인용"); //1. 서버 스타트, 2.크롬킴 3. Url로 Controller까지 접근(TestServlet)4.Controller가 Jsp페이지로 전환! -이 과정을 안거쳤더니 null으 떠버림;  왜지..?
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
