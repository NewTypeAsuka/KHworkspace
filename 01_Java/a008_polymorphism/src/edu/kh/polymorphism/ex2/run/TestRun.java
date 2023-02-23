package edu.kh.polymorphism.ex2.run;

import edu.kh.polymorphism.ex2.service.TestService;

public class TestRun {
	public static void main(String[] args) {
		
		TestService service = new TestService();
		
//		service.ex1(); // 추상화
//		service.ex2(); // 인터페이스
		service.ex3(); // 계산기
	}
}
