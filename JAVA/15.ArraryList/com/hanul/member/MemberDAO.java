package com.hanul.member;

import java.util.ArrayList;
import java.util.Iterator;




public class MemberDAO {
	

	//★생성자 메소드를 만들면 () 이 안에 넣지 않아도 다 들어가!!★
	private ArrayList<MemberDTO> list;
	public MemberDAO(ArrayList<MemberDTO>list) {
		this.list = list;
		
	}
	
	//■출력메소드
	public void display() {
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}//for
		System.out.println("======================================================");
		
	}//display

	
	//■나이의 오름차순 정렬
	
		public void ageAscSort() {
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) { //선택정렬이 돼!
					if(list.get(i).getAge() > list.get(j).getAge()) {
						MemberDTO temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}//if
				}//for j
			}//for i		
		}//ageAscSort()

	//■나이의 내림차순 정렬
		public void nameDescSort() {
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if(list.get(i).getName().compareTo(list.get(j).getName()) < 0) {
						MemberDTO temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}//if
				}//for j
			}//for i		
		}//ageAscSort()
}//class
