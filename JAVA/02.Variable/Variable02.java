public class Variable02 {
	public static void main(String[] args) {
		//정수형 변수 num1과 num2를 선언하고, 동시에 num1에 10, num2에 20을 할당하시오.
		int num1 = 10, num2 = 20;		//변수의 선언과 동시에 값을 할당 ▶ 초기화, 나열
		
		//변수 num1과 num2의 값을 출력
		System.out.println("변수 num1의 값 : " + num1);
		System.out.println("변수 num2의 값 : " + num2);
		
		
		System.out.println();   //빈줄 산입 돼
		
		//변수 num1의 값을 30으로, num2의 값을 40으로 변경한 후 출력하시오 ▶ 재할당
		num1 = 30; //변수 num1의 값이 10에서 30으로 변경된다(재할당이 된다)
		num2 = 40; //변수 num2의 값이 20에서 30으로 변경 (재할당)
		System.out.println("변수 num1의 값 : " + num1);
		System.out.println("변수 num2의 값 : " + num2);
		
	}//main()
}//class
