package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.CommonDAO;

public class NoticeDAO {
	//쿼리문실행기능을 가진 클래스
	//CRUD : Creat, Read, Update, Delete
	
	private SqlSession sql = CommonDAO.sql;
	
	//공지글 답글저장
	public void notice_relpy_insert(NoticeDTO dto) {
		sql.insert("notice.rely_insert", dto);
	}
	
	
	//공지글 신규저장
	public void notice_insert(NoticeDTO dto) {
		sql.insert("notice.insert", dto);
	}
	
	
	//공지글 목록조회 : 페이지 처리된 형태
	public NoticePageDTO notice_page(NoticePageDTO page) {
		//총공지글 목록수를 조회
		page.setTotalList(sql.selectOne("notice.total", page));
		page.setList( sql.selectList("notice.list", page) ) ; //기존의 목록을 처리하도록 하자 이제 page는!
		return page;
	}
	
	//공지글 목록조회 : 페이지 처리 없는 형태
	public List<NoticeDTO> notice_list() {
		return sql.selectList("notice.list");
	}
	
	//공지글 상세조회
	public NoticeDTO notice_detail(int id) { //한건에 대한 정보
		return sql.selectOne("notice.detail", id); //조건절에 사용할 두번째 파라메터 id!
	}
	
	//공지글 조회수 증가처리
	public void notice_read(int id) {
		sql.update("notice.read", id);
	}
	
	//공지글 변경저장
	public void notice_update(NoticeDTO dto) {
		sql.update("notice.update", dto);
	}
	
	//공지글 삭제
	public void notice_delete(int id) { //해당 공지글만 삭제가능하도록 pk인 id만 가져와
		
	}
	
	
}//class


