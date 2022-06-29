package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test02")  //웹 서블릿 -맵핑 이름만 확인해서 밑에 Test02_Request.jsp로 가!
public class Test02_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter에 들어가는 키값은 form태그 안쪽에 있는 태그의 name
		
		System.out.println("작동되나 확인용");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
