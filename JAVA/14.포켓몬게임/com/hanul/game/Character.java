package com.hanul.game;

public abstract class Character { 	//abstract class : 추상 클래스
	//멤버 변수 선언 : protected → 같은 패키지에서만 접근을 허용하겠다
	protected int exp; 		//경험치
	protected int energy; 	//에너지
	protected int level;	//레벨
	
	//추상 메소드 선언
	public abstract void eat(); 		//먹이를 준다
	public abstract void sleep();		//잠을 재운다
	public abstract boolean play();		//놀아준다
	public abstract boolean train();	//운동을 시킨다
	public abstract void levelUp();		//레벨을 올린다
	
	
	//에너지를 체크하는 메소드를 만들자
	public boolean checkEnergy() {
		if(energy >= 0) {
			return true;
		}else {
			return false;
		}//if
	}//checkEnergy()

	//캐릭터의 현재 상태를 출력
	public void printInfo() {
		System.out.println("=========================================");
		System.out.println("현재 캐릭터의 정보를 출력합니다.");
		System.out.println("경험치 : " +  exp);
		System.out.println("에너지 : " + energy);
		System.out.println("레벨 : " + level);
		System.out.println("=========================================");
	}//printInfo
	
}//class
