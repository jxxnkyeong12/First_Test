package notice;

import java.sql.Date;

public class NoticeDTO {
//	id     NUMBER   CONSTRAINT notice_id_pk PRIMARY key /*PK*/, 
//	title  VARCHAR2(300) not null /*제목*/,
//	content VARCHAR2(4000) not null/*내용*/ ,
//	writer  varchar2(50)  /*작성자의 id가 담겨질 컬럼*/,
//	writerdate    date  default sysdate  /*작성일자*/,
//	readcnt   number
	
	private int id, readcnt;
	private String title, content, writer, name;
	private Date writerdate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getWriterdate() {
		return writerdate;
	}
	public void setWriterdate(Date writerdate) {
		this.writerdate = writerdate;
	}
	
}//class
