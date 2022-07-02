public class Test_for02 {
	public static void main(String[] args) {
		//1부터 10까지의 정수 중에서 홀수의 누적합(oddSum)을 구하겨 출력 : for(반복), if(홀수판단)
		int oddSum = 0; //결과가 저장될 변수를 초기화
		 
		for(int i = 1; i<=10; i++) {
			if(i % 2 == 1) {	//(i % 2 !=0)
				oddSum = oddSum +i; 	//oddSum += i;
				System.out.println(i);
			}//if
		}//for
		System.out.println("홀수의 누적합 : " + oddSum);
	}//main()
}//class
