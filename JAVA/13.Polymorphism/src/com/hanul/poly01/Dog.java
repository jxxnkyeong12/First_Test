package com.hanul.poly01;

public class Dog extends Animal{	//서브(하위, 자식) 클래스 : Animal 클래스 상속
	@Override //재정의 : 슈퍼클래스가 정의한 메소드를 수정하겠다
	public void cry() {
		System.out.println("멍멍");
	}//cry
	
	
}//class
