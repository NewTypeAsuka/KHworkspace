package edu.kh.polymorphism.ex2.service;

import edu.kh.polymorphism.ex2.dto.*;

public class TestService {

	public void ex1() {
		
		// 1. 추상 클래스는 진짜 객체로 못 만들까?
//		Animal a = new Animal();
		// Cannot instantiate the type Animal: 객체화 불가능 -> 추상 클래스라서
		
		// 2. Animal을 상속받은 자식 객체 생성
		Person p1 = new Person("포유류", "잡식", "홍길동", 25);
		p1.breath();
		
		// 3. 추상 클래스는 객체 생성 X / 부모 타입 참조변수 O(다형성 업 캐스팅)
		Animal a1 = new Person("포유류", "채식", "김건강", 30);
		a1.breath(); // 정적 바인딩 대기(a1.breath()) -> 동적 바인딩 실행(p1.breath())
		
		// 객체배열 + 추상 클래스
		Animal[] arr = new Animal[3];
		// Animal 객체 참조 변수의 묶음을 생성
		// (Animal 객체는 만들 수 없음)
		arr[0] = new Fish();
		arr[1] = new Person();
		arr[2] = new Fish();
		
		System.out.println("--------------------------");
		for(Animal a : arr) {
			a.breath();
		}
	}
	
	public void ex2() {
		
		// 인터페이스
		
		// 1. 인터페이스는 상수형 필드(public static final)만 작성 가능
		// - 인터페이스에 작성했지만 클래스에 작성하는 static 필드와 사용법 동일
		// 상수를 나타내는 키워드 public static final을 생략해도 묵시적, 자동으로 인식
		System.out.println(KH.KH_ADDRESS);
		System.out.println(KH.A);
		
		// 2. 인터페이스로 객체 생성 X, 부모 타입 참조 변수 O
//		KH k = new KH(); // 객체 생성 X
		// 객체 배열 + 다형성 + 동적 바인딩
		KH[] arr = new KH[2]; // KH 참조 변수 묶음 생성
		arr[0] = new HongGilDong();
		arr[1] = new KimSamSun();
		
		for(KH k : arr) {
			k.lesson();
		}
	}
	
	public void ex3() {
		// 계산기 구현
		
		Calculator cal = new LSJCalculator();
		
		int a = 7;
		int b = 4;
		int r = 12;
		int num = 2;
		int x = 9;
		System.out.println("a = 7, b = 4");
		System.out.println("합: " + cal.plus(a, b));
		System.out.println("차: " + cal.minus(a, b));
		System.out.println("곱: " + cal.multiple(a, b));
		System.out.println("몫: " + cal.divide(a, b));
		System.out.println("나누기 결과(실수): " + cal.divide2(a, b));
		System.out.println("---------------------------");
		System.out.println("반지름 = " + r);
		System.out.println("원의 넓이: " + cal.areaOfCircle(r));
		System.out.println(num + "의 " + x + "제곱");
		System.out.println("결과: " + cal.square(a, x));
	}
}
