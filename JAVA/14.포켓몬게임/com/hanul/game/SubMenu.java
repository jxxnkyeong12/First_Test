package com.hanul.game;

import java.util.Scanner;

public class SubMenu {
	//멤버변수와 생성자 메소드 구현
	private Scanner scanner;
	public SubMenu(Scanner scanner) { 
		this.scanner = scanner;
	}
	//private Scanner scanner;
	//public SubMenu(Scanner scanner) { 	//GameMain에서 SubMenu의 scanner 그래 scanner 내가 받을게!
	//	this.scanner = scanner; 
	//}①↑이건 하드코딩한거
	public void playGame(Character character) { //GameMain- playGame을 마우스로 빨간줄 가져가면 자동완성기능으로 만들어줘
		System.out.println("무엇을 할까요?");
		System.out.println("1.먹이주기\t2.잠재우기\t3.놀아주기");
		System.out.print("4.운동시키기\t5.종료하기 ▶ ");
		
		while(true) {  //▶while문으로 돌려보기
			System.out.println("무엇을 할까요?");
			System.out.println("1.먹이주기\t2.잠재우기\t3.놀아주기");
			System.out.print("4.운동시키기\t5.종료하기 ▶ ");
			
			int menu = Integer.parseInt(scanner.nextLine());
			if(menu == 1) {
				character.eat();
			}else if(menu == 2) {
				character.sleep();
			}else if(menu == 3) {
				boolean result = character.play();
				if(!result) {	//죽일거야! : 부정(true → false, false → true) !연산을 쓰면 코드가 더 줄어들어~
					System.out.println("에너지가 부족해서 캐릭터가 사망했습니다.");
					System.out.println("게임을 종료합니다!");
					break;
				}//if			
			}else if(menu == 4) {
				boolean result = character.train();
				if(result) { //살려줄게
					//character.printInfo();
				}else {
					System.out.println("에너지가 부족해서 캐릭터가 사망했습니다.");
					System.out.println("게임을 종료합니다!");
					break;
				}//if
			}else if(menu == 5) {
				System.out.println("게임을 종료합니다!");
				break;
			}else {
				System.out.println("잘못 입력 하셨습니다!");
			}//if
			character.printInfo();
		}//while
	}//playGame
	

}//class



/*System.out.println("무엇을 할까요?");
System.out.println("1.먹이주기\t2.잠재우기\t3.놀아주기");
System.out.print("4.운동시키기\t5.종료하기 ▶ ");

int menu = Integer.parseInt(scanner.nextLine()); ▶그냥 돌려보기!
if(menu == 1) {
	character.eat(); //부모(character야 먹어라)
	
}else if(menu == 2){
	character.sleep();
}else if(menu == 3) {
	boolean result	= character.play();
		if(!result) {	 //! : 부정(true→false, false -> true)
			System.out.println("에너지가 부족해서 캐릭터가 사망했습니다.");
			System.out.println("게임을 종료합니다!");
		}//if !result
}else if(menu == 4) {
	boolean result= character.train();
		if(result) {
			character.printInfo();
		}else {
			System.out.println("에너지가 부족해서 캐릭터가 사망했습니다.");
			System.out.println("게임을 종료합니다!");
		}//if result
}else if(menu == 5) {
	System.out.println("게임을 종료합니다!");
	
}else {
	System.out.println("잘못 입력 하셨습니다!");
	
}//if menu
*/