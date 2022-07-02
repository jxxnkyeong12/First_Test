package com.hanul.student;

public class StudentDTO {
	private String name,major;
	private int num;
	private double java,avg,sum,cpp;
	
	
	//①디폴트 생성자 메소드
	public StudentDTO() {}

	
	//②생성자 메소드 초기화
	public StudentDTO(String name, int num, String major, double cpp, double java) {
		super();
		this.name = name;
		this.num = num;
		this.major = major;
		this.cpp = cpp;
		this.java = java;
	}


	

	//③getter & setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public double getJava() {
		return java;
	}


	public void setJava(double java) {
		this.java = java;
	}


	public double getAvg() {
		return avg;
	}


	public void setAvg(double avg) {
		this.avg = avg;
	}


	public double getSum() {
		return sum;
	}


	public void setSum(double sum) {
		this.sum = sum;
	}


	public double getCpp() {
		return cpp;
	}


	public void setCpp(double cpp) {
		this.cpp = cpp;
	}


	




	
	

	
	
	
}//class
