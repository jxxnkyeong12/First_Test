import java.text.DecimalFormat;

public class Book {
	//멤버변수(필드,속성) 선언 ▶①상태정보 : DTO, VO , Bean(콩! 묶어버리는!)
	//가격계산 멤버메소드 정의 :getPrice()
	//출력 멤버메소드 정의 :display()
	String title, name, company;
	int cost ,qty, price;
	
	
	//가격계산 멤버메소드 정의 :getPrice() ②▶행위정보 : DAO
	public void getPrice() {
		price= cost*qty;
		
	}//getSum

	
	//출력 멤버 메소드 정의 ③▶ 행위정보 : DAO  ▷여기까지 클래스가 3개가 돼는거야
	//단, 금액의 경우 통화기호를 표시하고 천단위 구분기호를 표시해라 (예 : 24000 -> ￦24,000)
	//출력 형식을 변경 : DecimalFormat Class ▶￦#,##0 (￦ : ㄹ- > 한자)
	public void display() {
		DecimalFormat df = new DecimalFormat("￦#,##0");
		System.out.println("도서명 : " + title);
		System.out.println("저자 : " + name);
		System.out.println("출판사 : " + company);
		System.out.println("단가 : " + df.format(cost));
		System.out.println("수량 : " + qty);
		System.out.println("가격 : " + df.format(price) );
		System.out.println("================");
		
	}
	
}//class
