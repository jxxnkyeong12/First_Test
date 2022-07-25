package notice;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtil;

public class NoticeReplyInsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
// 화면에서 입력한 답글정보를 DB에 저장
		//화면에서 입력한 답글정보를 수집 : DTO에 담기
		NoticeDTO dto = new NoticeDTO();
		dto.setTitle(request.getParameter("title") );
		dto.setContent(request.getParameter("content") );
		dto.setWriter(request.getParameter("writer") );
		dto.setRoot(Integer.parseInt( request.getParameter("root") ) );
		dto.setStep(Integer.parseInt(request.getParameter("step") ) );
		dto.setIndent(Integer.parseInt(request.getParameter("indent") ) );
	
		
		//파일을 첨부한 경우 첨부파일 정보를 DTO에 담는다.
		HashMap<String, String> map =new CommonUtil().fileUpload(request, "notice");
		dto.setFilename(map.get("filename") );
		dto.setFilename(map.get("filepath") );
		
		
		new NoticeDAO().notice_relpy_insert(dto);
		
	
	}

}
