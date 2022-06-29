

public class BookMain {
	//Book Class객체 생성
	//값을 할당
	//가격을 계산하고 출력하는 메소드 호출
	public static void main(String[] args) {
		
		
		Book b1 = new Book(); //Book객체 생성- b1:클래스에서 만들어진 변수 (인스턴트 변수라고 불러)
		b1.title = "JAVA";
		b1.name = "신용권";
		b1.company="한빛미디어";
		b1.cost = 24000;
		b1.qty = 11;
		
		b1.getPrice(); 
		b1.display();  //출력해주세요
		
		Book b2 = new Book();
		b2.title = "View";
		b2.name = "김은옥";
		b2.company = "김은옥";
		b2.cost = 28000;
		b2.qty = 14;
		
		b2.getPrice();
		b2.display();
		
		Book b3 = new Book();
		b3.title = "SOL";
		b3.name = "개발팀";
		b3.company = "한울직교";
		b3.cost = 15000;
		b3.qty = 12;
		
		b3.getPrice();
		b3.display();
		
		
	}//main()
}//class
