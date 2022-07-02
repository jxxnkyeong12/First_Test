package com.hanul.animal;
//상태정보(멤버변수, 필드, 속성) : DTO(VO) Class ▶ 슈퍼(상위, 부모) 클래스의 역할 수행하기 위해 만들거야
public class Animal {
	//멤버변수 선언
	private String name;	//이름
	private int age;		//나이
	
	//디폴트 생성자 메소드
	public Animal() {}

	
	//생성자 메소드 초기화
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//getter & setters 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}//class
