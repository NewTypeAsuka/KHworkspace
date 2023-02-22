package edu.kh.inheritance.dto;

public class Child1 extends Parent { // Parent 상속

	private String car;
	
	// 기본 생성자
	public Child1() {
		super(); // super() 생성자(컴파일러 자동 추가) -> Parent 기본 생성자로 이동
		System.out.println("Child1 기본 생성자");
	}
	// 매개변수 생성자
	public Child1(String car) {
//		super(); // super() 생성자(컴파일러 자동 추가) -> Parent 기본 생성자로 이동
		super(200_000_000,"백"); // 부모로부터 상속받은 setter를 이용해서 부모 필드 초기화
							    // 부모의 필드를 초기화하는 방법이 부모 매개변수 생성자에 존재(코드 길이 감소)
		this.car = car;
		System.out.println("Child1(String) 매개변수 생성자");
		
//		setMoney(100_000_000); // 부모로부터 상속받은 setter를 이용해서 부모 필드 초기화
//		setLastName("김");
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
		
		// 부모의 필드 값을 간접 접근 방법으로 얻어와 하나의 문자열로 만들어 반환
//		return car + " / " + getMoney() + " / " + getLastName();
		// StackOverflow 발생: toString()이 toString()을 계속 반복함(재귀 호출)
//		return car + " / " + toString();
		// 해결방법: 자식의 toString()이 아닌 부모의 toString()을 호출한다고 명시(super.)
		return car + " / " + super.toString();
	}
}
