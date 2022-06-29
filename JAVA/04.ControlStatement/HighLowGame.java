import java.util.Random;
import java.util.Scanner;

public class HighLowGame {
	public static void main(String[] args) {
		//1~100 사이의 임의의 정수값을 할당하여 comNumber 변수에 저장 ▶ Random객체
		Random random = new Random();				//Random 객체 생성
		int comNumber = random.nextInt(100)+1; 		//1~100 사이의 임의의 정수값을 할당 0부터 시작하니까 +1넣어줘
		
		//사용자로부터 숫자를 입력받기 위한 준비상태 ▶ Scanner 객체
		
		Scanner scanner = new Scanner(System.in);	// Scanner 객체
		int userNumber = 0;				//사용자가 입력한 값을 저장할 변수를 초기화
		int count = 0;					//시도횟수를 저장할 변수를 초기화
		
		
		//게임시작
		 do {
			 System.out.print("1부터 100 사이의 정수값을 입력하세요 : ");
			 userNumber = Integer.parseInt(scanner.nextLine());
			 count++; //카운트 뒤에 ++을 하면 다음줄부터 증감이 돼!
			 
			 if(userNumber < comNumber) {			// ② user와 com 큰수 먼저 만들고 - continue;
				 System.out.println("더 큰수를 입력하세요!");
				 System.out.println("시도 횟수 :" + count + "\n");
				 continue;
			 } else if (userNumber > comNumber) {	//③user 와 com 작은 수 만들기 - continue;
				 System.out.println("더 작은수를 입력하세요!");
				 System.out.println("시도 횟수 :" + count + "\n");
				 continue;
			 }else {
				 System.out.println("맞췄습니다!"); 	//④ 빙고! 만들기  끝났으니까 break; 걸어주기
				 System.out.println("시도 횟수 :" + count);
				 break;
			 }//if
		 }while(true);     //① do_ while(true)를 먼저 틀 만들어줘
		 scanner.close(); //⑤ scanner도 닫아주면 진짜 끝
	}//main()
}//class






/*

○ HighLowGame

comNumber : 1~100 사이의 임의의 정수값을 할당 → ex)70이 할당

1부터 100 사이의 정수값을 입력하세요 : ex) 50 → userNumber
더 큰수를 입력하세요!
시도횟수 : 1회


1부터 100 사이의 정수값을 입력하세요 : ex) 80 → userNumber
더 작은수를 입력하세요! 
시도횟수 : 2회


1부터 100 사이의 정수값을 입력하세요 : ex) 70 → userNumber
맞췄습니다!
시도횟수 : 3회

*/