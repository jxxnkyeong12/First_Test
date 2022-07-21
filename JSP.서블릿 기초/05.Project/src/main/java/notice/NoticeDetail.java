package notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class NoticeDetail implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 선택한 공지글 정보를 DB에서 조회해와
		//화면에 출력할 수 있도록 request 에 데이터를 담는다: 비지니스로직
		//String -> int
		int id = Integer.parseInt( request.getParameter("id") );
		NoticeDTO dto = new NoticeDAO().notice_detail( id );
		request.setAttribute("dto", dto);
		request.setAttribute("crlf", "\r\n");
	}

}
