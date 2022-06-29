import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	//입력을 받기 위한 객체 생성
		Random random = new Random();		//★★★★★★무작위로 숫자를 할당하기 위한 객체생성
 			
			while (true) {
 				//Intro 
				System.out.print("게임 시작 : 1, 게임종료 : -1을 입력하세요 ▶ ");
				//int input = scanner.nextInt();	//정수만 가져와.. 뒤에 enter는 안가져와 그래서 nextline으로!
				int input = Integer.parseInt(scanner.nextLine());   //★★★★★★string인 scanner nextline을 캐스팅해줘서  enter처리 끝!
				
				//1, -1 이외의 숫자가 입력되면 오류메세지를 출력하고 재입력
				if(input !=1 && input != -1) { 		//or 가 아닌  and!
					System.out.println("숫자를 잘못 입력하셨습니다!\n");
					continue;   //★★
				 }//if
				
				//-1이 입력되면 게임을 종료
				 if(input == -1) {
					 System.out.println("게임을 종료합니다!");
					 break;
				 }//if
				 
				 
				//게임을 시작 : 사용자의 숫자를 무작위로 할당;
				 System.out.println("주사위 게임을 시작합니다^^");
				 System.out.println("사용자가 주사위를 굴립니다.");
				 System.out.print("Enter Key를 입력하세요.\n");
				 scanner.nextLine();  //위에 enter는 누르면 넘어가는데 이걸 넣어주면 enter또 눌렀을때 드디어 실행되게 해줘!
				 int userNumber = random.nextInt(6)+ 1;  //1 ~ 6 사이의 정수를 무작위로 할당
				 System.out.println("사용자의 숫자는 " + userNumber + "입니다");
				 
				 //컴퓨터의 숫자를 무작위로 할당
				 System.out.println("컴퓨터가 주사위를 굴립니다.");
				 System.out.println("Enter Key를 입력하세요!");
				 scanner.nextLine();
				 int comNumber = random.nextInt(6)+1;
				/* if(userNumber == 6) {      이건 컴퓨터가 무조건 이기는 조건 ㅎ....맨 마지막 단계야..
					 comNumber = 6;
				 }else {
					 comNumber = userNumber + 1; 
				 }*/
				 System.out.println("컴퓨터의 숫자는 " +  comNumber + "입니다.\n");
				 
				 //사용자의 숫자와 컴퓨터의 숫자를 비교하여 결과를 출력
				 if(userNumber > comNumber) {
					 System.out.println("Result : You Win!!!");
				 }else if(userNumber<comNumber) {
					 System.out.println("Result : You Lose!!!");
					 
				 }else {
					 System.out.println("Result : DRAW!!!");
				 }//if
				
 			}//while
			scanner.close();
	}//main()
}//class


/*
[출력예시]
게임시작 : 1, 게임종료 : -1을 입력(Scanner)하세요 ▶ 2(if) while , continue; break;
숫자를 잘못 입력하셨습니다!

게임시작 : 1, 게임종료 : -1을 입력하세요 ▶ -1
게임을 종료합니다!
*/