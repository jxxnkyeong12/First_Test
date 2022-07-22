package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import member.MemberDAO;
import member.MemberDTO;
import notice.NoticeDetail;
import notice.NoticeDownload;
import notice.NoticeInsert;
import notice.NoticeList;
import notice.NoticeRead;
import notice.NoticeReplyInsert;
import notice.NoticeUpdate;
@WebServlet("*.no") @MultipartConfig
public class NoticController extends HttpServlet {

	private RequestDispatcher rd;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list.no : 공지글 목록화면 요청한거다
		//detail.no : 공지글상세화면 요청
		//new.no : 공지글쓰기화면 요청
		
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false; //기본이 redirect 안해
		CommonUtil util = new CommonUtil();
		
		if(uri.equals("/list.no")) {
			/*임의로 로그인처리한 후 나중에 삭제하기*/
			String id = "admin2";
			MemberDAO dao = new MemberDAO();
			String salt = dao.member_salt(id);
			String salt_pw = util.getEncrypt("Manager", salt);
			MemberDTO member = dao.member_login(id, salt_pw);
			request.getSession().setAttribute("userInfo", member);
			//----------------------------------------
			
			//DB에서 공지글목록을 조회해와 목록화면에 출력할 수 있도록
			//request에 데이터를 담는다: 비지니스로직
			
			//--------------------------------------------------
			
			System.out.println("공지사항 왔음");
			//DB에서 공지글 목록을 조회해서 목록화면에 출력할 수 있도록 request 에 데이터를 담는다 : 비지니스로직
			//응답화면 연결 - 공지글목록화면
			//rd =	 request.getRequestDispatcher("/notice/list.jsp");
			new NoticeList().execute(request, response);
			view = "/notice/list.jsp";	
			
		}else if(uri.equals("/reply_insert.no")) {
			//답글저장처리 요청
			//원글의 정보를 DB에서 조회해온 후!
			
			//화면에서 입력한 답글정보를 DB에 저장한 후
			new NoticeReplyInsert().execute(request, response);
			
			//응답화면연결 - 목록화면 연결
			view  = "list.no"; 
			redirect= true;
			
		}else if(uri.equals("/reply.no")) {
			//답글쓰기화면 요청
			//원글의 정보를 DB에서 조회하고 
			new NoticeDetail().execute(request, response);
			//답글쓰기 화면에 출력할 수 있도록 request에 담는다 : 비지니스로직!
			//응답화면연결 - 답글쓰기화면
			
			view = "/notice/reply.jsp";
			
		}else if(uri.equals("/detail.no")) {
			//조회수 증가처리
			
			new NoticeRead().execute(request, response);
			//공지글 상세화면 요청
			//화면에서 선택한 공지글 정보를 DB에서 조회해와
			//화면에 출력할 수 있도록 request에 데이터를 담는다 : 비지니스로직!
			new NoticeDetail().execute(request, response);
			//응답할 화면을 연결 - 상세화면!
		    
			
			
			view = "/notice/detail.jsp";
			
		}else if(uri.equals("/update.no")) {
			//정보수정 저창저리 요청
			//화면에서 변경입력한 정보를 DB에 변경저장한 후
			//응답할 화면을 변경연결 - 상세화면으로 연결!
			new NoticeUpdate().execute(request, response);
			
			view = "detail.no?id=" + request.getParameter("id");
			redirect = true;
			
		}else if(uri.equals("/modify.no")) {
			//정보수정화면 요청
			//해당글의 정보를 DB에서 조회해와
			//수정화면에 출력할 수 있도록 request에 데이터를 담는다. : 비지니스로직
			new NoticeDetail().execute(request, response);
			
			//응답화면연결 - 정보수정화면
			
			view = "/notice/modify.jsp";
			
			
		}else if(uri.equals("/download.no")) {
			//해당 글에 대한 첨부파일정보를 DB에서 조회해와서 클라이언트 다운로드처리를 한다 : 비지니스 로직
			new NoticeDownload().execute(request, response);
			
			
			return; //그자리에 그대로 있어야지. 다운로드 했다고 화면이 바뀌면 안돼
			
		}else if(uri.equals("/insert.no")) {
			//신규공지글 저장처리 요청
			//화면에서 입력한 정보를 DB에 신규정한 후 : 비지니스로직 -커맨드로 처리!
			//응답화면연결 - 목록화면
			new NoticeInsert().execute(request, response);
			//view = "/notice/list.jsp";
			view = "list.no"; //목록으로 보내야 하니까 redirect시켜
			redirect=true;
			
		}else if(uri.equals("/new.no")) {
			//신규공지글쓰기화면 요청
			
			
			//응답화면 연결 - 공지글쓰기화면
			view = "/notice/new.jsp";
			
		}
		
		//화면연결방식 두가지!
		// ① forward 방식- 서로 다르게 처리할수 있다
		// ② redirect 방식- 실제응답하는 페이지와 일치
		
		if(redirect)
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	
	 
	
	
	}//service
}//class
