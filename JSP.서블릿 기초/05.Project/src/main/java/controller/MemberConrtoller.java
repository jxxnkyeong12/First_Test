package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberDTO;

@WebServlet("*.mb")
public class MemberConrtoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	request.setCharacterEncoding("utf-8");	 //한글이 깨지지 않게 설정! setCharacterEncoding!
	String uri	= request.getServletPath();
	String view ="";	
	MemberDAO dao = new MemberDAO();	
	
	if(uri.equals("/join.mb") ) {
			//1.회원가입 화면을 요청!
			//2.응답하는 화면 지정해주기 ->회원가입화면
			view = "/member/join.jsp";
		}else if (uri.equals("/id_check.mb")) {
			//아이디 중복확인 요청
			//화면에서 입력한 아이디가 DB에 존재하는지 확인하는 처리가 필요! : 비지니스 로직 - DB연결처리와 관련있음
			
		int count	= dao.member_id_check(request.getParameter("id")); //join.jsp-> 밑에 ajax에서 data 이름이 { id:$userid.val() }  'id'!!! 데이터는 request에 담겨져왔다
															//파라메터로 데이터(id)를 보내 	
															//조회된 결과 데이터는 1아니면 0에 해당하니까 결과 데이터를 받을 변수(int) 선언해줘 
		//1 : 아이디 존재, 0 : 아이디 없음
			response.getWriter().print(count);  //쓰기 작업을 통해서 내려주는 처리를 해줘야 하니까. response.getWriter()객체 생성
			return;
		}else if (uri.equals("/member_join.mb")) {
			//회원가입 처리를 요청
			//화면에서 입력한 회원정보를 DB에 저장하는 처리: 비지니스로직
			//화면에서 입력한 회원정보를 데이터객체(DTO)에 담는 처리가 필요하다
			MemberDTO dto = new MemberDTO();
			dto.setName(request.getParameter("name")); //입력한 데이터가 requst태그! name이 name이었다
			dto.setUserid(request.getParameter("userid"));
			dto.setUserpw(request.getParameter("userpw"));
			dto.setBirth(request.getParameter("birth"));
			dto.setGender(request.getParameter("gender")); //"GENDER" 열에 대한 값이 너무 큼(실제: 6, 최대값: 3) 이건 한글이 깨졌단 소리야!
			dto.setEmail(request.getParameter("email"));
			dto.setPhone(request.getParameter("phone"));
			dto.setPost(request.getParameter("post"));
			String[] address = request.getParameterValues("address"); // 배열의 형태로 넘어온거! 배열변수에는 인덱스가 들어있다! 
			//address[0] : 부산 강서구 어쩌고 저쩌고
			//address[1] : 101호
			//부산 강서구 어쩌고 저쩌고 <br>101호
			//String.join("<br>", address); //br로 연결할거다. 그래서 하나의 문자로 만들어버릴거다.
			//dto.setAddress(request.getParameter("address"));  //근데 address가 2개잖아. 배열의 형태로 넘어온거!
			dto.setAddress(String.join("<br>", request.getParameter("address") ) );  //이렇게 하나로 묶어서 보내도 된다.
			
			
			//이제 DB에 회원가입 처리를 하자
			
			StringBuffer msg = new StringBuffer(); 
			response.setContentType("text/html; charset=utf-8"); //응답객체를 통해서 쓰기작업할 객체를 생성. ->어떤내용으로 만들것인지 contenttype지정, 
																 //text로 되어있는 html/.한글 안깨지게 utf-8지정!
			
			msg.append("<script>"); //메세지의 기본형태(append)
			if(dao.member_join(dto)==1) { //1이면 회원가입완!
				msg.append("alert('회원가입 축하^^♥'); location= "); //' '를 쓰는데 밑에 체인 걸었으니까 " ' " + " ' "!!
 				//msg.append(" ' " +  request.getContextPath() + " ' "); //어플리케이션으로 갈수 있도록 request에 cp를 지정. 그래서 그 위치로 보내면 된다
 				msg.append(" ' ").append(request.getContextPath()).append(" ' "); //둘중 하나 선택해서 써도 된다~
			}else { //아니면 노노'; 
				msg.append("alert('회원가입 실패 ㅠㅠ'); history.go(-1);");
			}
			msg.append("</script>"); 
			
			response.getWriter().print(msg.toString()); //문자화 시켜서 보내라 toString
			return;
		}
		request.getRequestDispatcher(view).forward(request, response);
	
	}

}
