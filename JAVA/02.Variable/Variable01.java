public class Variable01 {
	public static void main(String[] args) {
		//정수 2개를 저장할 변수를 선언하시오(변수명은 num1, num2)
		int num1;	    	//정수형 변수 num1을 선언
		int num2;		    //정수형 변수 num2을 선언
		//int num1, num2    //같은 자료형의 변수를 나열(comma(,)로 구분)
		
		//변수 num1에 10, num2에 20을 할당(대입)
		num1 = 10; 	//변수 num1에 값(10)을 할당(대입)
		num2 = 20; 	//변수 num2에 값(20)을 할당(대입)
		
		//정수 2개를 저장할 변수를 선언(num3, num4)하고,
		//num3에 30을 할당하고, num4에 40을 할당하시오.
		int num3 = 30;	//정수형 변수 num3을 선언하고 동시에 값(30)을 할당 ▶ 초기화
		int num4 = 40;  //정수형 변수 num4을 선언하고 동시에 값(40)을 할당 ▶ 초기화
		//int num3 = 30, num4 = 40;  //같은 자료형의 변수를 초기화하고 나열
		
		//각각의 변수에 저장된 데이터를 출력하시오.
		System.out.println("변수 num1의 값 : " + num1);
		System.out.println("변수 num2의 값 : " + num2);
		System.out.println("변수 num3의 값 : " + num3);
		System.out.println("변수 num4의 값 : " + num4);
	}//main()
}//class
