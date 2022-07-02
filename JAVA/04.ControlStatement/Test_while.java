public class Test_while {
	public static void main(String[] args) {
		//1부터 100까지의 정수 중에서 짝수의 누적합(forEvenSum)을 구하겨 출력 : for, if
		int forEvenSum = 0;
		
		for(int i = 1; i<=100; i++) {
			if(i % 2 ==0) {
				forEvenSum += i;	//forEvenSum = forEvenSum + i;
			}//if
		}//for
		
		System.out.println("for 짝수의 합 : " + forEvenSum);
		
		//1부터 100까지의 정수 중에서 짝수의 누적합(whileEvenSum)을 구하여 출력 : while, if
		int whileEvenSum = 0;
		
		int i = 1;
		while(i <= 100) {
			if(i % 2 == 0) {		//if가 실행문이야 그러니까 i++;블록 밑에 써줘!
				whileEvenSum += i;	//whileEvenSum = whileEvenSum + i;
			}//if
			i++;
		}//while
		System.out.println("while 짝수의 합 : " + whileEvenSum);
		
	}//main()
}//class
