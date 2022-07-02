public class Ex_static01 { 
	public static void main(String[] args) {   //②
		display01();
		//display02();  	//non-static :  static 이 없어서 메모리에 접근이 불가능 하다
		
		Ex_static01 ex01 = new Ex_static01(); 	//객체를 생성
		ex01.display02();
		
	}//main()
	
	public static void display01() {  //③
	System.out.println("Display01");	
	}//display(1)

	public void display02() {
		System.out.println("Display02");	//④
	}//display(2)
	
	static {
		System.out.println("초기화 블럭");  //①
	}//static
	
}//class


//static : 프로그램 시작전에(초기화) 가장 먼저 메모리에 할당된다. 
//초기화 블럭 : static {~~~} ▶ 가장 먼저 실행되는 블럭에 해당



