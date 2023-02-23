package edu.kh.polymorphism.ex2.dto;
	   // 추상 클래스 			// Object 상속 -> 미작성 시 컴파일러가 자동 추가
	   // 단 추상 메서드가 없어도 추상 클래스 선언 가능
public abstract class Animal /* extends Object */ {
	// 추상화, 캡슐화
	
	// 필드
	private String type; // 종
	private String eatType; // 식성
	
	// 생성자
	public Animal() { // 기본 생성자
		/* super(); */ // 부모 생성자 호출 -> 미작성 시 컴파일러가 자동 추가
	}
	public Animal(String type, String eatType) { // 매개변수 생성자
		this.type = type;
		this.eatType = eatType;
	}
	
	// 메서드
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEatType() {
		return eatType;
	}
	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	// toString
	// String Object.toString()
	// - 객체가 가지고 있는 필드를 하나의 문자열로 반환하는 용도의 메서드
	// (자식이 오버라이딩해서 사용하길 권장)
	// - 오버라이딩 X -> 패키지명+클래스명@해시코드 문자열로 반환
	@Override
	public String toString() {
		return type + " / " + eatType;
	}
	
	// 추상 메서드(미완성된 메서드) -> 상속받은 자식 클래스에서 오버라이딩 강제
	// 추상 메서드를 포함한 클래스는 반드시 추상 클래스여야만 한다(3번 줄)
	public abstract void breath();
}
