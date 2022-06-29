package com.hanul.fruit;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class FruitDAO {
	
	
	//★생성자 메소드를 만드는 법!★
	private ArrayList<FruitDTO> fruit;
	public FruitDAO(ArrayList<FruitDTO>fruit) {
		this.fruit = fruit;   //이 this를 해주면! 밑에 () 매개변수 안넣어도 다 들어가....ㅎ 그리고 Main에서 호출 해줄때 객체생성() 매개변수 넣어주면 아래는 안써줘도 자동 저장..★
							  //getPrice()같은곳에 매개변수 넣어버리면 Main에서 호출했을때 매개변수 다시 입력해줘야해..
	}
	
	
	//■가격계산 메소드 -향상된 for문
	public void getPrice() {
		for (FruitDTO dto: fruit) {  //식별자로 바로 접근!
			dto.setPrice(dto.getCost()*dto.getQty());
		}
	}//getPrice()
	
	
	//■내림차순 메소드
	public void priceDescSort() {
		for (int i = 0; i < fruit.size(); i++) {
			for (int j = i+1; j < fruit.size(); j++) {  //j는 i+1해줘야지!
				if (fruit.get(i).getPrice() < fruit.get(j).getPrice()) {
					FruitDTO temp = fruit.get(i);
					fruit.set(i, fruit.get(j));
					fruit.set(j, temp);
				}//if
			}
		}
	}//priceDescSort()
	

	public void display() {
		DecimalFormat df = new DecimalFormat();
		System.out.println("======================================================");
		System.out.println("과일명\t단가\t수량\t가격");
		System.out.println("======================================================");
		for (int i = 0; i < fruit.size(); i++) {
			FruitDTO dto = fruit.get(i);
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getCost() + "\t");
			System.out.print(dto.getQty() + "\t");
			System.out.print(df.format(dto.getPrice()) + "\n");
		}//for
		System.out.println("====================================================");
	}//display
	

	//출력2 -Prinf 뭐가 틀렸지..
	/*public void displayPrinf() {
		DecimalFormat df = new DecimalFormat("￦#,##0"); //String타입ㅇ로 바껴버려
		for (FruitDTO dto : fruit) {
			String name = dto.getName();
			int cost = dto.getCost();
			double qty = dto.getQty();
			int price = dto.getPrice();
			System.out.printf("%-6s\t%8s\t%2d\t%d\n", name, df.format(cost), qty,df.format(price));  //s붙은건 String d 는 decimal이야 (왼쪽 맞춤 하려면 -(마이너스) 해줘! 
		}//for
	}//displayPrinf()*/

	
	public void displayPrinf() {
		DecimalFormat df = new DecimalFormat("￦#,##0");
		for (FruitDTO dto : fruit) {
			String name = dto.getName();
			int cost = dto.getCost();
			double qty = dto.getQty();
			int price = dto.getPrice();
			System.out.printf("%-6s\t%8s\t%.2f\t%5s\n", name, df.format(cost), qty, df.format(price));
		}//for
	}//displayPrinf()
}//class
