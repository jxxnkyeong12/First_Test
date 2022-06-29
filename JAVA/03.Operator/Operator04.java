public class Operator04 {
	public static void main(String[] args) {
		//논리연산자 : 여러개의 조건을 판단 ▶ 조건식 작성에 사용
		//연산의 결과는 true, false로 반환된다.
		//조건A && 조건B : 모두 만족 ▶ AND 조건 ->~~이고, ~~이면서
		//조건A || 조건B : 하나라도 만족 ▶ OR 조건 -> 또는, ~이거나
		//논리 부정 연산자 : true -> false, false -> true ▶ !(부정)
		
		int num1 = 5, num2 =10;
		
		System.out.println(num1 > num2 && num1 < num2);    //출력값 : false && true ▶false 
		System.out.println(num1 < num2 && num1 > num2);    //출력값 : true && false ▶false 
		System.out.println(num1 == num2 && num1 > num2);    //출력값 : false && false ▶false
		System.out.println(num1 != num2 && num1 < num2);    //출력값 : true && true ▶ true

		System.out.println(num1 > num2 || num1 < num2);    //출력값 : false || true ▶true 
		System.out.println(num1 < num2 || num1 > num2);    //출력값 : true || false ▶true
		System.out.println(num1 == num2 || num1 > num2);    //출력값 : false || false ▶false
		System.out.println(num1 != num2 || num1 < num2);    //출력값 : true || true ▶ true
	}//main()
}//class
