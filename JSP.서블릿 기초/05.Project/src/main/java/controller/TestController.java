package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testtable.TestTableDAO;

@WebServlet("*.ts")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestTableDAO dao = new TestTableDAO();
	String uri = request.getServletPath();
	String view = "";
	
	  if(uri.equals("/list.ts")) {
	System.out.println( dao.testList());
		
		view = "testfolder/test.jsp";
	  }//if
	  	request.getRequestDispatcher(view).forward(request, response);
	  
	}

}
