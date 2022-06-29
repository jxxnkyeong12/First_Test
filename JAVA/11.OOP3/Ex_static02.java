public class Ex_static02 {
	//기본 생성자 메소드 : 객체가 생성될 때 호출되는 메소드
	
	//public Ex_static02() {} //생략 가능 : 컴파일(JVM)가 자동으로 생성 (빈깡통)
	
	private Ex_static02() {} //접근제어자가 private 선언 ▶ 객체를 생성할 수 없게 만든다. ->Ex_static02Mian객체 생성자에서 바로 오류 떠버려
	
	public static void display01() {  
		System.out.println("Display01");	
		}//display(1)

		public void display02() {
			System.out.println("Display02");	
		}//display(2)
		
}
