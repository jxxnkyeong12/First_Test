package com.hanul.poly03;

public class Radio implements RemoCon{

	@Override
	public void volUp() {
		System.out.println("라디오 소리를 올린다.");
	}

	@Override
	public void volDown() {
		System.out.println("라디오 소리를 내린다.");
		
	}

	@Override
	public void internet() {
		System.out.println("인터넷 접속 기능이 없다.");
		
	}

}
