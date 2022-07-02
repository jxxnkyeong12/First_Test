public class ProductMain01 {
	public static void main(String[] args) {
		Product p1 = new Product(); // Product Class를 이용한 객체 p1을 생성
		p1.num = 1; 				//p1의 멤버변수 num에 값(1)을 할당
		p1.name = "컴퓨터"; 		//p1의 멤버변수 name에 값(컴퓨터)을 할당
		
		
		Product p2 = new Product();
		p2.num = 2;
		p2.name = "모니터";
		
		Product p3 = new Product();
		p3.num = 3;
		p3.name = "프린터";
		
		System.out.println("객체 p1의 정보");
		System.out.println("제품번호 : " + p1.num);
		System.out.println("제품명 : " + p1.name);
		
		System.out.println("===============");
		
		System.out.println("객체 p2의 정보");
		System.out.println("제품번호 : " + p2.num);
		System.out.println("제품명 : " + p2.name);
		
		System.out.println("===============");
		
		System.out.println("객체 p3의 정보");
		System.out.println("제품번호 : " + p3.num);
		System.out.println("제품명 : " + p3.name);
		
		System.out.println("===============");
		
		
	}//main()
}//class
