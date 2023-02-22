package edu.kh.inheritance.dto;

// final class: 상속이 불가능한 클래스
public /* final */ class Parent {

	private int money = 400_000_000;
	private String lastName = "박";
	
	// 기본 생성자
	public Parent() {
		System.out.println("Parent() 기본 생성자");
	}
	// 매개변수 생성자
	public Parent(int money, String lastName) {
		this.money = money;
		this.lastName = lastName;
		System.out.println("Parent(int, String) 매개변수 생성자");
	}
	// getter/setter
	// final method: 오버라이딩이 불가능한 메서드
	public /* final */ int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	// toString
	public String toString() {
		return money + " / " + lastName;
	}
}
