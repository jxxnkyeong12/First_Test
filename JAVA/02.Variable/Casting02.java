public class Casting02 {
	public static void main(String[] args) {
		char i = 'A';
		int j = i;		//자동 형 변환(char -> int)(작은게 큰걸로 바뀜)
		System.out.println("변수 i의 값 :" + i); 		//출력값: A
		System.out.println("변수 j의 값 :" + j); 		//출력값: 65 ->UniCode 값
		System.out.println("변수 j의 값 :" + (char) j); 		//출력값: A ->강제 형 변환(int -> char)
				
		int num1 = 10, num2 = 2, num3 = 4;   //변수의 선언 + 할당(대입) ▶ 초기화, 나열
		int result1 = num1 / num2;
		int result2 = num1 / num3;
		double result3 = num1 / num3;
		double result4 = (double) num1 / (double) num3; //강제 형 변환(int -> double) 앞에거랑 비교 이런경우는 가능해
		
		System.out.println("결과 1 : " + result1);	//출력값 : 5 (10/2=5)
		System.out.println("결과 2 : " + result2);	//출력값 : 2 (10-4 -> int / int = int) 소수 버리고 정수만 가져와
		System.out.println("결과 3 : " + result3);  //출력값 : 2.0(int / int = int ▶ double) 2를 double로 받으니까 2.0이 돼
		System.out.println("결과 4 : " + result4);  //출력값 : 2.5(double/ double = double)
	}//main()
}//class
