package com.hanul.animal;

public class Cat extends Animal{   //Animal Class 를 상속받았다 : 서브(하귀, 자식) 클래스
	
	//디폴트 생성자 메소드
	public Cat() {}
	
	//생성자 메소드 초기화
	public Cat(String name, int age) {   //2,3단계만 있어. getter setter없어!
		super(name, age);
		
	}//cat
}//animal
