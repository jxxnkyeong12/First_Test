package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("*.no")
public class NoticController extends HttpServlet {

	private RequestDispatcher rd;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list.no : 공지글 목록화면 요청한거다
		//detail.no : 공지글상세화면 요청
		//new.no : 공지글쓰기화면 요청
		
		String uri = request.getServletPath();
		String view = "";
		if(uri.equals("/list.no")) {
			System.out.println("공지사항 왔음");
			//응답화면 연결 - 공지글목록화면
			rd =	 request.getRequestDispatcher("/notice/list.jsp");
			view = "/notice/list.jsp";	
		
		}else if(uri.equals("/new.no")) {
			//신규공지글쓰기화면 요청
			//응답화면 연결 - 공지글쓰기화면
			view = "/notice/new.jsp";
			
		}
		
		
		request.getRequestDispatcher(view).forward(request, response);
	
		//화면연결방식 두가지!
		// ① forward 방식- 서로 다르게 처리할수 있다
		// ② redirect 방식- 실제응답하는 페이지와 일치
		
	
	
	}//service
}//class
