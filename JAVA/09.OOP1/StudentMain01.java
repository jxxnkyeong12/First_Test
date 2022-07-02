public class StudentMain01 {
	//Student Class 를 이용하여 객체 생성
	//값 (이름, 국어, 영어, 수학)을 할당 : 멤버변수
	//총점계산, 평균계산, 결과를 출력하는 메소드를 호출 : 멤버 메소드
	public static void main(String[] args) {
	 Student s1 = new Student(); 		//Student 객체를 생성 : s1 → 인스턴스 변수
	 s1.name = "홍길동";				//인스턴스변수.멤버변수 = 값;
	 s1.kor = 90;
	 s1.eng = 65;
	 s1.mat = 100;
	 s1.getSum();   					//인스턴스변수.멤버메소드(); ->호출!
	 s1.getAvg();
	 s1.display();
	 
	 
	 Student s2 = new Student(); 		//Student 객체를 생성 : s2 → 인스턴스 변수
	 s2.name = "박문수";				//인스턴스변수.멤버변수 = 값;
	 s2.kor = 100;
	 s2.eng = 95;
	 s2.mat = 80;
	 s2.getSum();   					//인스턴스변수.멤버메소드(); ->호출!
	 s2.getAvg();
	 s2.display();
	 
	 
	}//main()
}//class
