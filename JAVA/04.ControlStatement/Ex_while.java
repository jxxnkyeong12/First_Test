public class Ex_while {
	public static void main(String[] args) {
		//1부터 100까지의 누적합(forSum)을 구하시오 : for 
		int forSum = 0;
		
		for(int i = 1; i<=100; i++) {
			forSum = forSum + i; 	//forSum += i;
		}//for
		
		System.out.println("for 누적합 : " + forSum);
		
		//1부터 10까지의 누적합(whileSum)을 구하시오 : while
		int whileSum = 0;
		
		int i = 1;					//초기값
		while(i <=100) {			//조건식
			whileSum += i;			//실행문 : whileSume = whileSum + i;
			i++;					//증감값
		}//while
		
		
		
		System.out.println("while 누적합 : " + whileSum);
		
	}//main()
}//class


/*
 ★ while문 : 반복횟수를 모를 경우 사용(선조건→후처리)  
 
 초기값 설정:
 while(조건식){
 	실행문;
 	증감값;
 }
 
 */

