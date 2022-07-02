
import java.util.Scanner;

public class Test_Scanner_gugudan {
	//출력하고 싶은 구구단의 단수(danNumber)를 입력받은 후,
	//입력받은 단수의 구구단 값을 출력하시오 ▶ Scanner, for(구구단 출력-1~9까지 알고 있으니까 for문!)
	//단, 입력받은 구구단의 단수를 2단부터 9단까지만 입력받으며, ▶ 2~9까지만 if
	//다른 구구단의 단수가 입력되면 오류메세지를 출력하고,
	//재입력 받아 구구단을 출력하시오 ▶ while, break, continue
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		System.out.print("출력하고 싶은 구구단의 단수를 입력하세요: ");
		 int danNumber = scanner.nextInt();
	
		
		 if (danNumber < 2 || danNumber> 9) {
			 //오류메세지
			 System.out.println("입력하신 구구단의 단수가 잘못 입력되었습니다!");
			 System.out.println("2부터 9사이의 단수를 입력하세요!"+"\n");
			 continue;
		 }else {
			 //구구단 출력
			 System.out.println(danNumber + "단을 출력합니다");
		 for(int i = 1; i<=9; i++) {
			 if(danNumber*i<10) {
				 System.out.println(danNumber + " X "+ i + "= 0" + (danNumber*i));
			 }else {
			System.out.println(danNumber + " X " + i + " =" + (danNumber*i));
			}//if
		 }//for
		 break;
		}//if
	   }//while
		 scanner.close(); //scanner 종료
	}//main()
}//class








/*
[출력예시]
출력하고 싶은 구구단의 단수를 입력하세요 : (내가 입력) XXX
입력하신 구구단의 단수가 잘못 입력되었습니다!
2부터 9사이의 단수를 입력하세요! ->오류메세지


출력하고 싶은 구구단의 단수를 입력하세요 : (내가 입력) X
X단을 출력합니다.
X * 1 = X
X * 2 = X
X * 3 = X
*/