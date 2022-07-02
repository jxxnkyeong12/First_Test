public class Ex_for03 {
	public static void main(String[] args) {
		//1부터 100까지의 정수 중에서 홀수의 합(oddSum)과 짝수의 합(evenSum)을 출력
		//for(반복), if(홀수와 짝수의 판단)
		int oddSum = 0;		//홀수의 누적합이 저장될 변수를 초기화
		int evenSum = 0;	//짝수의 누적합이 저장될 변수를 초기화
		
		for(int i = 1; i<=100; i++) {	//반복변수 i를 1부터 100까지 1씩 증가(반복)
			if(i % 2 != 0) {			//홀수이면
				oddSum = oddSum + i;
			} else {					//짝수이면
				evenSum = evenSum + i;
			}//if
		}//for
		
		System.out.println("홀수의 누적합 : " + oddSum);
		System.out.println("짝수의 누적합 : " + evenSum);
		
		
	}//main()
}//class
