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
	// 오버라이딩: getMoney() 재정의
	// @Override: 컴파일러에게 해당 메서드는 재정의되었다는 컴퓨터용 주석 -> 오버라이딩 형식 맞는지 검사 진행
	@Override
	public int getMoney() {
		System.out.println("자식이 오버라이딩한 getMoney()");
		return super.getMoney() + 500;
	}
}
