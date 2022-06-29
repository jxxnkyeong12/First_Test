public class Ex_static02Main {
	public static void main(String[] args) {
		
		//Ex_static02 ex02 = new Ex_static02();	//객체 생성
		//ex02.display01();   //static 있어서 생성안해도 바로 사용가능(접근가능)하다고 경고가 떠~
		//ex02.display02();
		//Ex_static02.java 기본 생성자 메소드 private 선언 ▶ 객체를 생성할 수 없다. (철저하게 막아 버린거)
		
		//클래스명.static메소드명(); - 호출! 해주면 이제 돼!
		Ex_static02.display01();
		
		
		
	}//main()
}//class




//static : 접근이 편하지만, 남발하지 않는다. ▶메모리 문제때문에
