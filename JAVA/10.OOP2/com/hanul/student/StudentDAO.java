package com.hanul.student;

import java.text.DecimalFormat;

public class StudentDAO { //고객이 동작적인 부분을 요청했을때. 프로그램 유지보수 용이
	//■객체배열(student[])을 매개 변수로 전달받는 생성자 메소드 구현
	private StudentDTO[] st;
	public StudentDAO(StudentDTO[] st) {
		this.st = st;
	}//this
	
	//■총합 계산
	public void getSum() {
		for (int i = 0; i < st.length; i++) {
			st[i].setSum(st[i].getJava() + st[i].getCpp());
		}//for i
	} // getSum()

	
	//■평균을 계산하는 메소드 정의 : getAvg()
	public void getAvg() {
		for (int i = 0; i < st.length; i++) {
			st[i].setAvg(st[i].getSum() / 2);
		}//for i 
	} // getAvg()
	
	

	//■평균의 내림차순으로 정렬하는 메소드 정의 : avgDescSort()
	public void avgDescSort() {
		for (int i = 0; i < st.length; i++) {
		 for (int j = i + 1; j < st.length; j++) {
			if(st[i].getSum() < st[j].getSum()) {
				StudentDTO temp = st[i];
				st[i] = st[j];
				st[j] = temp;
			 }//if
			}//for j
		}//for i
	} // avgDescSort()
	
	//■평균의 오름차순으로 정렬하는 메소드 정의 : avgAscSort()
	public void avgAscSort() {
		for (int i = 0; i < st.length; i++) {
		 for (int j = i + 1; j < st.length; j++) {
			if(st[i].getSum() > st[j].getSum()) {
				StudentDTO temp = st[j];
				st[j] = st[i];
				st[i] = temp;
			 }//if
			}//for j
		}//for i
	}//avgAscSort
	
	//■이름의 오름차순으로 정렬하는 메소드 : nameAscSort()  가나다 순....?
	public void nameAscSort() {
		for (int i = 0; i < st.length; i++) {
			for (int j = i + 1; j < st.length; j++) {
				if(st[i].getName().compareTo(st[j].getName()) > 0) {
				StudentDTO temp = st[i];
				st[i] = st[j];
				st[j] = temp;
			}//if
		}//for j
	}//for i, 
	}//nameAscSort
	//■이름의 내림차순으로 정렬하는 메소드 : nameDesSort()  -...왜 나길동부터 나올까...?(5.23)
	public void nameDesSort() {
		for (int i = 0; i < st.length; i++) {
			for (int j = i+1; j < st.length; j++) {
				if(st[i].getName().compareTo(st[j].getName())< 0) {
					StudentDTO temp = st[i];
					st[i] = st[j];
					st[j] = temp;
				}//if
			}//for j
		}//for i 
	}//nameDesSort
	
	//■출력하는 메소드 호출 : display() ▶단, 각 과목별 점수와 총점, 평균은 소수 첫째자리까지 표시
	public void display() {
		DecimalFormat df = new DecimalFormat("0.0");
		System.out.println();
		System.out.println("성명\t학번\t  학과\t C++\tJAVA\t총점\t평균");
		System.out.println("=====================================================");
		for (int i = 0; i < st.length; i++) {
			System.out.print(st[i].getName() + "\t");
			System.out.print(st[i].getNum()+" ");
			System.out.print(st[i].getMajor() + "\t ");
			System.out.print(st[i].getCpp() + "\t");
			System.out.print(st[i].getJava() + "\t");
			System.out.print(df.format(st[i].getSum()) + "\t");
			System.out.print(df.format(st[i].getAvg()) + "\n");
		}//for i 
		System.out.println("=====================================================");
	} // display()


}
