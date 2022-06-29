package com.hanul.game;

public class Pickachu extends Character{ //extends(상속) : Pickachu ▶ Character
	//디폴트 생성자 메소드 : 객체가 생성될 때 동작되는 메소드
	//경험치, 에너지, 레벨을 초기화하고 생성된 캐릭터의 정보 메세지를 출력
	public Pickachu() {  //원래 public Pickachu () {} 이렇게 생겼는데 저 블록 안에 밑에 것들 생성한거야
		exp = 30;
		energy = 50;
		level = 0;
		System.out.println("피카츄 캐릭터가 생성되었습니다.");
		printInfo();
	} 
	
	
	@Override
	public void eat() {
		energy +=10;
	}

	@Override
	public void sleep() {
		energy +=5;
	}

	@Override
	public boolean play() {
		energy -= 20;
		exp += 5;
		levelUp();
		return checkEnergy(); //체크에너지에서 트루 펄스가 나와
	}

	@Override
	public boolean train() {
		energy -= 10;
		exp += 15;
		levelUp();
		return checkEnergy();
		
	}

	@Override
	public void levelUp() {
		if(exp >= 40) {
			level++;
			exp -=40;
			System.out.println(level + "단계로 레벨업 되었습니다!");
		}//if
		
	}

	
	
}//class
