package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.StudentDAO;
import student.StudentDTO;

@WebServlet("*.st")
public class StudentController extends HttpServlet {

	RequestDispatcher rd ;
	StudentDAO dao = new StudentDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("Error/404.jsp");//나중에 만들예정
		
      if(req.getServletPath().equals("/list.st")) {
    	  System.out.println("학생목록 확인용");
    	  
    	// 추후 DB에서 가져온 정보를 이용 =>ArrayList
    	  //호출하고 JSP에 보내서 출력해보기!
    	  ArrayList<StudentDTO> list = dao.getList(); 
    	   req.setAttribute("list", list);
    	  rd = req.getRequestDispatcher("student/list.jsp");
    	  
      }else if (req.getServletPath().equals("/detail.st")) {
    	  //DTO 데이터베이스 컬럼이랑 맞춰서 만들어놓은 클래스(필드 ==데이터베이스)
    	  //String student_no = req.getParameter("student_no);
    	  //Array 리스트를 쓰든 아무거나 이용해서 DAO에 메소드 만들기 - getStudentInfo(리턴타입 자유롭게)
    	  System.out.println("상세정보 확인용");
    	  System.out.println(req.getParameter("student_no"));
    	  System.out.println(req.getParameter("user_id"));
   	    
    	  StudentDTO dto = dao.getStudentInfo(req.getParameter("student_no"), req.getParameter("user_id")); 
    	  //...왜 계속 null오류가 나나 했더니... 여기서 내가 그냥 dao.getStudetnInfo("student_no", "user_id"); 로 해서였다.. 당연하게도 값이 없지...ㅎ
    	  //찾느라 애먹었다 ㅠ 근데 돈쪽에서 자꾸 오버플로우 예외가 뜨네... 돈은 입력안했는뎅 ㅠ
    	  
    	  req.setAttribute("dto", dto); 
    	  //detail.jsp/ 상세정보를 확인할 수 있는 페이지 (헤더, 푸터) 그대로 있고 내용만 바뀌게
   	  rd = req.getRequestDispatcher("student/detail.jsp");
//    	  
      }else if(req.getServletPath().equals("/update.st")) {
    	  System.out.println("업데이트 잘찍혔나확인용");
    	  StudentDTO dto = dao.getStudentInfo(req.getParameter("student_no"), req.getParameter("user_id")); 
    	  req.setAttribute("dto", dto);
    	  rd = req.getRequestDispatcher("student/update.jsp");
    	  
      }else if(req.getServletPath().equals("/modify.st")) {
    	  
    	  StudentDTO dto = new StudentDTO(
    			  null,
    			  req.getParameter("user_id"), 
    			  null,
    			  req.getParameter("first_name"), 
    			  req.getParameter("last_name"),
    			  Integer.parseInt(req.getParameter("student_no")));
    	  
    	  dao.modify(dto);  // 어떤 데이터를 넘길필요가 없음(페이지 새로고침만 하면 돼!)
      
        resp.sendRedirect("list.st");
        return;
        //수정하는 로직을 작성하기.
        //name <=x first_name, last_name만 수정되게끔 처리
        
      }else if(req.getServletPath().equals("/delete.st")) {
    	  //DAO를 통해서 삭제 처리 -?=1&시험용&
    		int result = dao.deleteInfo(req.getParameter("student_no") , req.getParameter("user_id"));
    	   resp.sendRedirect("list.st");
    	  return;
      }
		
		
		
		rd.forward(req, resp);
	
	}//서비스
	
	
}
