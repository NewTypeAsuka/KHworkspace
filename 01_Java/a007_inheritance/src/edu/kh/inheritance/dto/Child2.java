package edu.kh.inheritance.dto;

public class Child2 extends Parent { // Parent 상속

	private String house;
	
	// 기본 생성자
	public Child2() {
		System.out.println("Child2() 기본 생성자");
	}
	// 매개변수 생성자
	public Child2(String house) {
		this.house = house;
		System.out.println("Child2(String) 매개변수 생성자");
	}
	// getter/setter
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	// toString
	public String toString() {
		return house;
	}
}
