package edu.kh.polymorphism.ex2.dto;

// 클래스 상속: extends -> 개체 크기의 확장 개념
// 인터페이스 상속: implements -> 구현 개념

public class HongGilDong implements KH {

	@Override
	public void lesson() {
		System.out.println("A강의장에서 자바 수업 참여");
	}
}
