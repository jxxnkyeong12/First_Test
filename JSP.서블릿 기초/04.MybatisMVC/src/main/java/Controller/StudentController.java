package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.StudentDAO;
import student.StudentDTO;



//*.aa
//<a href = "test.aa"></a>
@WebServlet("*.st") //*<- 전체를 받는 url패턴(맵핑)사용할때는 /<-빼야됨 오류남
public class StudentController extends HttpServlet {
	
	RequestDispatcher rd; 
	StudentDAO dao = new StudentDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("error.404.jsp");  //나중에 추가 예정(2022.06.30 KJK)
		
		if(req.getServletPath().equals("/list.st")) {
			
			//추후 DB에서 가져온 정보를 이용 -> 지금은 ArrayList를 수동으로 만들기
		//	ArrayList<StudentDTO> list  = dao.getList();
//			for (int i = 0; i < list.size(); i++) { //지금은 선생님이 10건을 줬으니까 size() 
//				System.out.println(list.);
//			}
			//jsp에 보내서 출력해보기
			Object olist = dao.getManualList();
//			list = (ArrayList<StudentDTO>) olist; //다시 list에 담아서 쓰면 된다
//			req.setAttribute("list", list);
//			
			
			ArrayList<StudentDTO> list = dao.getList();
			req.setAttribute("list", list);
			rd = req.getRequestDispatcher("Student/list.jsp");
			
		}else if(req.getServletPath().equals("/test.st")) {
			//디비연결 테스트
			dao.selectOne();
			//dao.getList();
		}else if(req.getServletPath().equals("/detail.st")) {
			
			System.out.println("여기까지옴 한명의 정보(상제정보)를 조회해야함");
			System.out.println(req.getParameter("student_no"));
			System.out.println(req.getParameter("user_id"));
			//ArrayList를 쓸지 다른걸 사용할지 고민.
			//DAO에 메소드 만들어보기 , getStudentInfo메소드 만들기( 리턴타입 자유롭게)
			
			//DTO데이터베이스 컬럼이랑 맞춰서 만들어놓은 클래스 (필드 ==데이터베이스 컬럼)
			//StudentDTO dto = dao.getStudentInfo(int student_no, String user_id); 
		    //StudentDTO dto =  dao.getStudentInfo((int)req.getParameter("student_no"), req.getParameter("user_id"));
			
			
			 StudentDTO dto = dao.getStudentInfo(req.getParameter("student_no"), req.getParameter("user_id"));
			 System.out.println(req.getParameter("student_no"));
			 System.out.println(req.getParameter("user_id"));
			
			 //detail.jsp <- 상세정보를 확인할수있는 페이지 (헤더, 푸터) 그대로 있고 내용만 바뀌게 
			 req.setAttribute("dto", dto);
			 rd = req.getRequestDispatcher("Student/detail.jsp");
			 
			//데이터베이스에 접근해서 학생 한명의 정보를 얻어오는 비지니스로직을 구현(데이터 한건 얻어오기)
			
			 
		}else if(req.getServletPath().equals("/update.st")) {
			//System.out.println("업데이트 성공 확인용");
		
			 StudentDTO dto = dao.getStudentInfo(req.getParameter("student_no"), req.getParameter("user_id"));
			 req.setAttribute("dto", dto);
			rd = req.getRequestDispatcher("Student/update.jsp");
			 
		}else if(req.getServletPath().equals("/modify.st")) {
			//(int student_no, String student_name, String user_id, String first_name, String last_name
			StudentDTO dto = new StudentDTO(Integer.parseInt(req.getParameter("student_no")), 
					req.getParameter("student_name"), 
					req.getParameter("user_id"), 
					req.getParameter("first_name"), 
					req.getParameter("last_name"));
					
					dao.getModify(dto); // select x , int(return)		
			
			//수정하는 로직을 작성하기
			//name <= x, first_name , last_name 만 수정되게끔 처리
			//업데이트 쿼리를 실행하고 0보다 큰 숫자가 return 되는지를 체크해보기
			//DAO이용한 업데이트 처리 ? (from 태그 또는 url(get)방식으로 Servlet에 왔을때 파라메터가 어디있는지?)
			
			int result = dao.getModify(dto); // select x , int(return)	
		
			resp.sendRedirect("list.st"); //<페이지를 바로 요청을 해버리면 list가 없기 때문에 에러발생
			return;
			//rd = req.getRequestDispatcher("Student/modify.jsp");
			 
		}else if(req.getServletPath().equals("/delete.st")) {
			StudentDTO dto = new StudentDTO(Integer.parseInt(req.getParameter("student_no")), 
					req.getParameter("student_name"), 
					req.getParameter("user_id"), 
					req.getParameter("first_name"), 
					req.getParameter("last_name"));
					
					dao.delete(dto);
					
					resp.sendRedirect("list.st"); //<링크니까 바로가 - 페이지를 바로 요청을 해버리면 list가 없기 때문에 에러발생
					return;
		}
		
		rd.forward(req, resp);

	}
	
	
}
