public class Ex_if {
	public static void main(String[] args) {
		int num1 = 10;  		//정수형 변수 num1을 선언하고, 값(10)을 할당 ▶ 초기화
		if(num1 % 2 == 0) {		//num1을 2로 나눈 나머지 값이 0과 같다 → 짝수
			System.out.println("입력값은 " + num1 + "입니다");
			System.out.println(num1 + "은 짝수입니다.");
		}//if
		
		int num2 = 9;			//정수형 변수 num2를 선언하고, 값(9)을 할당 ▶ 초기화
		if(num2 % 2 != 0) {		//num2f를 2로 나눈 나머지 값이 0과 같지 않다 → 홀수 : if(num2 % 2 == 1)
		System.out.println("입력값은 " + num2 + "입니다." + "\n" + num2 + "는 홀수 입니다.");
			
		}
		
		
		
	}//main()
}//class



/*
 ★ 단순 if문 : 조건을 판단하여, 조건이 참일 경우에만 실행
 
 if(조건식){
 	실행문;
 }
 
 ※ 실행되는 문장이 단일문장이면 Blocking({ ~~ })을 생략해도 된다.→권장사항은 아니다
  	▶ if(조건식) 실행문;
 
 */
