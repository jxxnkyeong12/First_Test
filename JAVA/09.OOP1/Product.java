public class Product {	
	//class(설계도) : 특성(상태정보)과 동작(행위정보)이 기술(구현)
	//멤버 변수(필드, 속성) : 상태정보 ▶DTO Class, VO Class, Bean
	int num;
	String name;
	
	//멤버 메소드 : 행위정보 ▶ DAO Class
	public void display() {
		System.out.println("제품번호 : " + num);
		System.out.println("제품명 : " +  name);
		System.out.println("================");
	}//display()   ProductMain01에 필요한↑공통적인 특성들 적어줘
}//class
