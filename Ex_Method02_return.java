public class Ex_Method02_return {
	//getSum() 메소드에 10과 20을 매개변수로 보내는 메소드 호출문 작성
	//단, 결과는 return 받은 후 출력하시오 ▶getSum() 결과값 → main() 전달
	public static void main(String[] args) { //①
		int num1 = 10, num2 = 20; 	//③getSum() 메소드로 보낼 매개변수를 초기화
		int sum = getSum(num1, num2); 		//④getSum() 메소드를 호출 ▶ 실인수 ⑦int sum= 앞에 붙여줘
		System.out.println("첫 번째 정수 : " + num1);   //⑧ 출력문 넣어주기
		System.out.println("두 번째 정수 : " + num2);
		System.out.println("두 정수의 합 : " + sum);
		
	}//main()
	
	//2개의 정수를 매개변수로 전달받아 합계(sum)를 구하고 리턴하는 메소드를 정의
	public static int getSum(int num1, int num2) {	//②getSum() 메소드를 정의 ▶ 가인수 (
		int sum = num1 + num2;			//⑤
		return sum; //원래 static void였던걸 return이 들어오면 해당 타입(int)으로 변경해줘야 해
					//⑥return : 리턴타입 변경 ▶ void -> int
		
	}//getSum
	
}//class
