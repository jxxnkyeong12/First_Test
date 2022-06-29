package com.hanul.poly03;

public class Tv implements RemoCon{		//interface의 상속 implements 키워드 사용

	@Override
	public void volUp() {
		System.out.println("Tv 소리를 올린다.");
		
	}

	@Override
	public void volDown() {
		System.out.println("Tv 소리를 내린다.");
		
	}

	@Override
	public void internet() {
		System.out.println("인터넷에 접속한다.");
		
	} 

}//class
