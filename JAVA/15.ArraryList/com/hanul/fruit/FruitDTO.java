package com.hanul.fruit;

public class FruitDTO {
	private String name;
	private int qty, cost,price;
	
	//디폴트 생성자 메소드
	public FruitDTO() {
		
	}
	
	
	//생성자 메소드 초기화
	public FruitDTO(String name, int cost, int qty) {
		super();
		this.name = name;
		this.cost = cost;
		this.qty = qty;
	}

	
	//getter & setters

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
}//class
