public class Ex_Swap {
	public static void main(String[] args) {
		//swap(교환) : 기본 데이터 타입(PDT), 배열(Array)
		int a = 10;
		int b = 20;
		System.out.println("교환전 : a = " + a + ", b = " + b);
		
		//a와 b의 값을 교환하여 출력하시오
		// System.out.println("교환후 : a = " + b + ", b = " + a);  이러면 안돼
		
		
		int temp = a;			//기존의 a의 값을 저장할 임시변수(temp)를 선언하고 a의 값을 할당
		a = b; 					//변수 b의 값을 변수 a에 재할당 시켜라
		b = temp;				//임시변수 temp의 값을 변수 b에 재할당 시켜라
		
		System.out.println("교환후 : a = " + a + ", b = " + b);
		
	}//main()
}//class
