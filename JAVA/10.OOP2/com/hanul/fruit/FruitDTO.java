package com.hanul.fruit;

public class FruitDTO {
	//① 멤버변수 선언 : 정보은닉 → private
	private String name;
	private int cost, qty, price;
	
	//② 디폴트 생성자 메소드
	public FruitDTO() {}

	//③ 생성자 메소드 초기화 : 멤버변수 3개로 초기화
	public FruitDTO(String name, int cost, int qty) {
		super();
		this.name = name;
		this.cost = cost;
		this.qty = qty;
	}

	//④ getters & setters 메소드 : 자동완성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}//class
