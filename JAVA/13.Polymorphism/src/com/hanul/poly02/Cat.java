package com.hanul.poly02;

public class Cat extends Animal {    //추상 클래스를 상속 ▶ 추상 메소드의 재정의가 필수

	@Override //상위 클래스에서 선언만 한 추상 메소드를 반드시 재정의(Override)
	public void cry() {
		System.out.println("야옹");
	}//cry()	

	//Cat 클래스만이 가지고 있는 고유한 메소드(알파상태)
	public void night() {
		System.out.println("고양이는 야행성이다");
	}//night
	
}//class
