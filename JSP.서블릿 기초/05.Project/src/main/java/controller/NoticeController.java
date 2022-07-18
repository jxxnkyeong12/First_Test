package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.no")
public class NoticeController extends HttpServlet {
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//list.no : 공지글 목록을 요청한거야
	//detail.no : 공지글 목록을 요청한거야
	//new.no : 공지글쓰기 화면을 요청한거야
		String uri = request.getServletPath(); //매번 if문안에 조건문으로 넣어뒀던걸... 이렇게 간편하게!
		String view = "";
		
		//■①
		if(uri.equals("/list.no")) {
			//응답화면 연결 - 공지글 목록화면
			
			view = "/notice/list.jsp";
		//이런 이름의 화면으로 forward시키겠슴니당.
		
		//■②
		}else if(uri.equals("/new.no")) {
			//신규공지글쓰기 화면을 요청!
			
			//응답화면연결 - 공지글쓰기화면
			view ="/notice/new.jsp";
			
		}
		
		request.getRequestDispatcher(view).forward(request, response);	
		
		
		//화면연결 방식
		//① forward, redirect 
		//둘의 차이점은 forward는 주소창에 있는 주소하고 실제 응답하는 페이지하고 서로 다르게 처리할수 있다
		//redirect는 실제 응답하는 페이지와 일치하는 형태
		
		
		
	}//service

}//class
