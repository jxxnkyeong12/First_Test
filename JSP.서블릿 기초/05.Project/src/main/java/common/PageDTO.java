package common;

public class PageDTO {
	private int pageList = 10; 	//한 페이지당 보여질 목록수
	private int blockPage = 10; //한 블럭당 보여질 페이지수
	private int totalList; 	//총 목록수:DB에서 조회
	private int totalPage, totalBlock;  
	//총 페이지수:  총 목록수 / 페이지당 보여질 목록수, 나머지가 있으면 +1
	//총 블록수 :   총 페이지수 / 블럭당 보여질 페이지수, 나머지가 있으면 +1
	private int endList, beginList; //끝 목록번호, 시작 목록번호
	//각 페이지의 끝 목록번호 :  총 목록수 - (페이지번호-1) * 페이지당 보여질 목록수  
	//각 페이지의 시작 목록번호 :  끝 목록번호 - (페이지당 보여질 목록수-1)
	
	private int curPage, curBlock; //현재페이지번호, 현재블록번호
	// 블록번호 : 페이지번호 / 블록당 보여질 페이지수, 나머지가 있으면 +1
	private int endPage, beginPage; //끝 페이지번호, 시작 페이지번호
	//각 블럭의 끝 페이지번호 : 블록번호 * 블록당 보여질 페이지수
	//각 블럭의 시작 페이지번호 : 끝 페이지번호 - (블럭당 보여질 페이지수-1)
	
	public int getPageList() {
		return pageList;
	}
	public void setPageList(int pageList) {
		this.pageList = pageList;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getTotalList() {
		return totalList;
	}
	public void setTotalList(int totalList) {
		this.totalList = totalList;
		
		//총 페이지수:  총 목록수 / 페이지당 보여질 목록수, 나머지가 있으면 +1
		totalPage = totalList / pageList;
		if( totalList % pageList > 0 ) ++totalPage;
		
		//총 블록수 :   총 페이지수 / 블럭당 보여질 페이지수, 나머지가 있으면 +1
		totalBlock = totalPage / blockPage;
		if( totalPage % blockPage > 0 ) ++totalBlock;
		
		//각 페이지의 끝 목록번호 :  총 목록수 - (페이지번호-1) * 페이지당 보여질 목록수
		endList = totalList - (curPage-1)*pageList;
		//각 페이지의 시작 목록번호 :  끝 목록번호 - (페이지당 보여질 목록수-1)
		beginList = endList - (pageList-1);

		// 블록번호 : 페이지번호 / 블록당 보여질 페이지수, 나머지가 있으면 +1
		curBlock = curPage / blockPage;
		if( curPage % blockPage > 0 ) ++curBlock;
		
		//각 블럭의 끝 페이지번호 : 블록번호 * 블록당 보여질 페이지수
		endPage = curBlock * blockPage;
		//각 블럭의 시작 페이지번호 : 끝 페이지번호 - (블럭당 보여질 페이지수-1)
		beginPage = endPage - (blockPage-1);
		//끝페이지번호가 총페이지수보다 크면 총페이지수를 끝페이지번호로 한다
		if( endPage > totalPage )   endPage = totalPage;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getEndList() {
		return endList;
	}
	public void setEndList(int endList) {
		this.endList = endList;
	}
	public int getBeginList() {
		return beginList;
	}
	public void setBeginList(int beginList) {
		this.beginList = beginList;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
}
