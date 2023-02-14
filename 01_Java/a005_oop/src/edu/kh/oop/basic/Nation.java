package edu.kh.oop.basic;

// 현실에서의 객체: 속성(data)과 기능(method)을 가지고 있는 식별 가능한 것

// 클래스: 객체의 특성(속성, 기능) 정의한 것
//         일종의 설계도 -> 클래스(설계도)는 객체가 아님
//                       -> 하나의 클래스(설계도)로 여러 객체를 만들 수 있음

public class Nation { // 국민 클래스

	// 국민이라면 가지고 있어야 하는 공통된 속성(데이터)
	// -> [추상화](공통점만 추출, 불필요한 요소 제거)
	
	/* 국민의 속성(== 멤버 변수, 인스턴스 변수) */
	private String pNo;  	// 주민번호
	// 멤버 변수를 private으로 지정해서 외부 접근 막기 -> [캡슐화 두번째 특징]
	String name; 	// 이름
	char gender;    // 성별(남/여)
	String address; // 주소
	String phone;   // 전화번호
	int age;        // 나이
	
	/* 국민의 기능(== 메서드) */
	public void speakKorean() {
		System.out.println("가나다라 한국말 가능");
	}
	public void medicalBenefit() {
		System.out.println("의료 혜택을 누릴 수 있음");
	}
	
	// private으로 지정한 멤버 변수에 대한 간접 접근 방법 작성 -> [캡슐화 두번째 특징]
	public String getpNo() { // 외부에서 내부 데이터를 얻어가는 방법
		return this.pNo;
	}
	public void setpNo(String pNo) { // 내부에서 외부 데이터를 설정하는 방법
		this.pNo = pNo;
	}
	
} // 클래스 내에 객체의 속성, 기능을 묶어놓음 -> [캡슐화 첫번째 특징]

