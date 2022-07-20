package notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtil;

public class NoticeInsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//첨부파일이 있으면 업로드한다
		new CommonUtil().fileUpload(request, "notice");
		
		//화면에서 입력한 정보를 DB에 신규정한 후 : 비지니스로직
		NoticeDTO dto =new NoticeDTO();
		dto.setWriter(request.getParameter("writer"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		new NoticeDAO().notice_insert(dto);
	}

}
