public class Operator01 {
	public static void main(String[] args) {
		//산술연산자 : +, -, *, / ▶ 수학식에서 다루는 사칙연산과 동일
		//나머지 연산 : % ▶ 짝수/홀수, 배수의 판단에 사용 → 조건문
		int num1 = 10, num2= 3; //정수형 변수 num1을 선언하고 값(10)을 할당 ▶ 초기화
								//정수형 변수 num2를 선언하고 값(3)을 할당 ▶ 초기화
		
		int addResult = num1 + num2;	//덧셈
		int subResult = num1 - num2;	//뺄셈
		int mulResult = num1 * num2;	//곱셈
		int divResult = num1 / num2;	//나눗셈(주의: 나눗셈의 연산 결과는 실수가 나올 수 있다)
		int modResutl = num1 % num2;	//나머지
		
		System.out.println("덧셈 : " + addResult); 		//출력값 : 13
		System.out.println("뺄셈 : " + subResult); 		//출력값 : 7
		System.out.println("곱셈 : " + mulResult); 		//출력값 : 30
		System.out.println("나눗셈 : " + divResult); 	//출력값 : 3
		System.out.println("나머지 : " +  modResutl);   //출력값 : 1
		
		int x = 5, y = 3;
		System.out.println("x + y = " + x + y);         //x + y = 53 ▶ 결합(Concatenation)
		System.out.println("x + y = " + (x + y));	    //x + y = 8 ▶ 최우선 순위를 갖는 연산자
		System.out.println(x + y + " = x + y");			//8= x + y ▶문자열 출력전에는 덧셈
		System.out.println("x - y = " + (x - y));		//x - y = 2 ▶ 출력문에서 + 연산자 개념
	}//main()
}//class
