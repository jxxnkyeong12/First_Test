package com.hanul.mouse;

//상위클래스인 WheelMouse를(오른쪽-부모) 하위클래스인 OpticalMouse가(왼쪽-자식) 상속
//Override : 하위클래스에서 상위클래스로부터 상속받은 메소드를 재정의(수정) 하는 단계
public class OpticalMouse extends WheelMouse{
	
	@Override 		//직접입력해서 알려줘- 재정의(내용수정)했다는 의미 [같은이름, 매개변수,타입, 순서 다 똑같아야 해-오버로딩이랑 다른점!]
	public void clickLeft() {
		System.out.println("광마우스 왼쪽 버튼 클릭");
	}//clickLeft()

	@Override		//Source MenuBar > Override/Implement Methods....호출!
	public void clickRight() {
		System.out.println("광마우스 오른쪽 버튼 클릭"); //부모쪽에서 만든 왼오 버튼- 무시해버리고 광마 오우가 나와
		//super.clickRight(); //super = extends WheelMouse를 의미 부모가 가지고 있는 clickRight를 쓰게 해주겠다
	}//clickRight()
	
	@Override		//Ctrl + SpaceBar : 자동완성
	public void scroll() {
		System.out.println("광마우스의 스크롤 기능");
		
	}//scroll()
}//class
