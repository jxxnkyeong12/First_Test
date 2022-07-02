package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ScopeServlet")
public class ScopeServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JSP페이지에서 (View) 요청할때 보내준 데이터를 Servlet(Controller)에서 사용하는 방법
		//PageContext<=페이지 내에서만 사용할수 있게 되어있어서 Controller에서는 접근이 불가능함
		System.out.println(" Request에 있는 Attr : "+ request.getAttribute("req"));
		
		HttpSession session = request.getSession(); //HttpSession 인터페이스는 리퀘스트에서 겟세션으로 가져올수 있다
		System.out.println(" Session에 있는 Attr : " +  session.getAttribute("session"));
		
		System.out.println(" Application(ServletContext)에 있는 Attr : " +getServletContext().getAttribute("app"));
		
		//Controller 에서 페이지를 전환하는 방식( Forward)
		//요청자원을 넘기는 방식 (Forward, redirect)
		//RequestDispatcher <= ↑ 포워드를 해주는 객체 (View => a태그, form,js 등등 거쳐서 Controller로 와! =>forward, redirect
		RequestDispatcher rd = request.getRequestDispatcher("Ex01_Request/ScopeServletRes.jsp");//항상 request로 내장객체를 가져와! 재활용! "어떤 경로로 이동할건지 써주세요 !"
		//네가 돌아갈 위치는 Ex01 에 있는 scRes다!
		
		request.setAttribute("attr", "ServletsendData"); //
		
		//■ excute(실행)해줘야지! DB연동했던거 생각해봐. 끌고와서 사용안할거임? ■
		rd.forward(request, response); //실제 페이지를 요청하는 로직
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
