public class BookMain02 {
	public static void main(String[] args) {
		//도서정보(title, name, company, price ▶ BookDTO. java)를 저장 할 객체배열(BookDTO[])을 선언하자 
		BookDTO[] book;
	
		
		//3권의 도서정보가 저장될 객체 배열을 생성 : new
		book = new BookDTO[3];  //◐_◐위에 있는 new는 배열을 생성하는 new!
		
		//객체배열을 선언 및 생성
		//BookDTO[] book = new BookDTO[3];
		
		//BookDTO.java의 초기화된 생성자 메소드를 이용하여 내용(값)을 입력- ⊙△⊙여기 new는 값을 할당하기 위해, 변수를 하나로 묶어서 관리하기 위해서!
		book[0] = new BookDTO("JAVA", "신용권", "한빛", 24000);
		book[1] = new BookDTO("View", "김은옥", "삼양", 28000);
		

		//디폴트 생성자 메소드를 이용하여 값을 할당 : setter method (★현장에서 많이 씀★) 
		BookDTO dto = new BookDTO(); //빈깡통
		dto.setTitle("SQL");
		dto.setName("개발자");
		dto.setCompany("한울");
		dto.setPrice(15000);
		book[2] = dto;  //dto를 book[2]에 할당
		
		
		//앞서 만든 도서정보(book[])의 내용을 출력 ▶ BookDAO.java → display() 메소드 호출
		BookDAO dao= new BookDAO();
		dao.display(book); //display호출은 한번만 써줘!!! 위에 또 쓰면 에러난다!!!!(토욜복습날 한번 틀렸으면 됐지)
		
		
	}//main()
}//class
