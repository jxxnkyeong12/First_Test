package com.hanul.mouse;
//extends(상속 을 받았다!) : 상위 클래스인 Mouse 클래스를(오른쪽) 하위클래스인 WheelMouse 클래스가 상속(왼쪽) - 내가 구현하지 않아도 쓸수 있다 + 
//                           자식클래스에 공통된것 말고 다른 하나! scroll만 생성해주면 돼
public class WheelMouse extends Mouse {	//Sub Class, 하위 Class, 자식 Class
	public void scroll() {
		System.out.println("스크롤 기능 추가");
	}//scroll
	
	
}
