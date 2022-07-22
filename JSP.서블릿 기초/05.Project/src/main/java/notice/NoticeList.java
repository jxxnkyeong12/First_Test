/**
 * 
 */
package notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class NoticeList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 공지글목록을 조회해와 목록화면에 출력할 수 있도록
		//request에 데이터를 담는다: 비지니스로직
		//파라미터는 존재하나 값이 없을 때는 빈문자열을 받는다
		
		//String data = ""; 
		//파라미터가 존재하지 않으면
		//String data = null 이 담겨 있을거다
		
		
		
		int curPage = Integer.parseInt(request.getParameter("curPage") == null 
										? "1" : request.getParameter("curPage")  );
		
		 NoticePageDTO page =new NoticePageDTO();
		 page.setCurPage(curPage);
		 page =new NoticeDAO().notice_page(page);  //페이지 변수에 담아
		 
		//페이지 정보를 화면에 출력할 수 있도록 request에 담는다. 
		 request.setAttribute("page", page);
		 
		//페이지 처리하지 않은 경우 
//		List<NoticeDTO> list= new NoticeDAO().notice_list();
//		request.setAttribute("list", list);
		
		
	}

}
