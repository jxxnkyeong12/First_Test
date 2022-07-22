package notice;

import java.util.List;

import common.PageDTO;

public class NoticePageDTO extends PageDTO {
	private List<NoticeDTO> list; // 공지글 목록

	
	public List<NoticeDTO> getList() {
		return list;
	}

	public void setList(List<NoticeDTO> list) {
		this.list = list;
	}
	
	
	
}//class
