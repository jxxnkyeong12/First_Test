package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;

@WebServlet("*.cu")
public class CusController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//.System.out.println("일단 넘어왔나 확인용 cu");
		//1.list.cu가 url로 요청이 되는지 크롬에서 확인하기
		//2.list.cu를 요청받는 Servlet(Controller)를 만들기
		//3.list.jsp(customer폴더 추가) 로 연결 하기 (Forward)
	  //4.DAO를 구성해서 데이터 조회 해오기
		//데이터를 forward시 list.jsp로 보내주기
		//조회된 데이터를 jstl이용해서 화면에 보여주기
		
		
		String uri = req.getServletPath();
		String view = "";
		CustomerDAO dao = new CustomerDAO();
		
		if(uri.equals("/list.cu")) {
			System.out.println("고객관리 잘 들어옴");
			req.setAttribute("list" , dao.getList()); 
			view = "customer/cuslist.jsp";
		}else if(uri.equals("/delete.cu")) {
			//dao를 이용해서 삭제하기
			//■delete from table_ name where key = value 키가 value인게 힌트야!
			System.out.println("삭제하기 잘 들어왔으");
		    dao.deleteInfo(req.getParameter("id")); //String으로 아이디값만 가져와도 돼
		    resp.sendRedirect(req.getContextPath()+"/list.cu" );
		    
		    return;
		    
		}
		req.getRequestDispatcher(view).forward(req, resp);  //쏴주는거 잊지말자
		
		
		
	}
	
	
}
