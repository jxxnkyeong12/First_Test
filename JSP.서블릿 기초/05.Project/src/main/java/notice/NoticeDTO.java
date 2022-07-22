package notice;

import java.sql.Date;

public class NoticeDTO {
//	id     NUMBER   CONSTRAINT notice_id_pk PRIMARY key /*PK*/, 
//	title  VARCHAR2(300) not null /*제목*/,
//	content VARCHAR2(4000) not null/*내용*/ ,
//	writer  varchar2(50)  /*작성자의 id가 담겨질 컬럼*/,
//	writerdate    date  default sysdate  /*작성일자*/,
//	readcnt   number
	
	private int id, readcnt, no, root, step, indent;
	private String title, content, writer, name, filename,filepath;
	private Date writerdate;
	
	
	
	
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
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
