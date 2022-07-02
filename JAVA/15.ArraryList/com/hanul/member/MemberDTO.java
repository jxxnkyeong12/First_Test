package com.hanul.member;

public class MemberDTO {
	
	//멤버변수 선언
	private	String name, addr, tel;   //tel은 '-' 하이픈이 들어가니까 문자로 넣어줘야해!
	private	int age;
	
	
	//디폴트 생성자 메소드
	public MemberDTO() {}

	
	//생성자 메소드 초기화
	public MemberDTO(String name, int age, String addr, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
	}




	//getter & setter 메소드
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

}//class
