public class Operator02 {
	public static void main(String[] args) {
		//증감 연산자 : 변수의 값을 1씩 증가(++), 감소(--) ▶ 반복문에서 활용
		//연산자의 위치가 변수의 앞인지 뒤인지에 따라 결과값이 다르다
		int num1 = 0;
		int num2 = 10;
		
		System.out.println("++num1 : " + (++num1));  //출력값: 1
		System.out.println("--num1 : " + (--num2));  //출력값: 9
		
		int num3 = 0, num4 = 10;
		System.out.println("num3++ : " + (num3++));  //출력값: 0
		System.out.println("num3 : " + num3); 		 //출력값: 1
		System.out.println("num4-- : " + (num4--));  //출력값: 10
		System.out.println("num4 : " + (num4));      //출력값: 9
		
		
	}//main()
}//class
