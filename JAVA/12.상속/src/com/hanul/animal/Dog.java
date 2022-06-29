package com.hanul.animal;

public class Dog extends Animal {	//Animal Class 를 상속받았다 : 서브(하귀, 자식) 클래스
	//디폴트 생성자 메소드 
	public Dog() {} //빈깡통이 돼
	
	
	//생성자 메소드 초기화 -하나로 묶을 수 있어
	public Dog(String name, int age) {
		super(name, age); 	//Animal Class의 생성자 메소드 호출!
	}//dog

}//class
