package com.hanul.game;

public class Raichu extends Character{
	public Raichu() {
		exp = 50;
		energy = 50;
		level = 0;
		System.out.println("라이츄 캐릭터가 생성되었습니다.");
		printInfo();
	}

	@Override
	public void eat() {
		energy += 30;
	}

	@Override
	public void sleep() {
		energy += 40;
	
	}

	public boolean play() {
		energy -=40;
		exp +=30;
		levelUp();
		return checkEnergy();
	}
	
	@Override
	public boolean train() {
		energy -= 50;
		exp += 50;
		levelUp();	
		return checkEnergy();
		
	}
	@Override
	public void levelUp() {
		if(exp >= 70) {
			level++;
			exp -= 70;
			System.out.println(level + "단계로 레벨업 되었습니다!");
		}//if
	}
}//class
