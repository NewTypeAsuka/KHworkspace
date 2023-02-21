package edu.kh.inheritance.dto;

public class Child1 extends Parent { // Parent 상속

	private String car;
	
	// 기본 생성자
	public Child1() {
		System.out.println("Child1 기본 생성자");
	}
	// 매개변수 생성자
	public Child1(String car) {
		this.car = car;
		System.out.println("Child1(String) 매개변수 생성자");
	}
	// getter/setter
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	// toString
	public String toString() {
//		Parent p1 = new Parent();
//		p1.getMoney();
		// 같은 클래스 메서드 호출 시 이름만 부르면 됨
		// -> 상속 특징: 부모 필드/메서드를 상속받아 자식 것처럼 사용
//		System.out.println(getCar());
//		System.out.println(getMoney());
//		System.out.println(getLastName());
		
		return car;
	}
}
