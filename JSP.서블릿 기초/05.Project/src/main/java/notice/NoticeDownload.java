package notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtil;

public class NoticeDownload implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//해당 글에 대한 첨부파일정보를 DB에서 조회해와서 클라이언트 다운로드처리를 한다 : 비지니스 로직
	    int id	=Integer.parseInt( request.getParameter("id") );  
		NoticeDTO dto = new NoticeDAO().notice_detail(id);
		
		new CommonUtil().fileDownload(request, response, dto.getFilename(), dto.getFilepath());
		
		
	}

}
