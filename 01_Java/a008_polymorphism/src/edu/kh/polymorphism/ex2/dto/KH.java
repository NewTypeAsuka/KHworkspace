package edu.kh.polymorphism.ex2.dto;

public interface KH { // 인터페이스(접점)

	// 상수형 필드(public static final)만 작성 가능
	// - 인터페이스는 무조건 상수형 필드만 작성 가능하기 때문에
	// 상수를 나타내는 키워드 public static final을 생략해도 묵시적, 자동으로 인식
	public static final String KH_ADDRESS = "서울시 중구 남대문로 120 2층";
	/* public static final */ int A = 10;
	
	// 추상 메서드
	// - 인터페이스는 추상 클래스의 변형체로 모든 메서드가 추상 메서드(public abstract)
	// 인터페이스의 모든 메서드는 묵시적으로 추상 메서드(public abstract)
	// 단 (default) 메서드, static 메서드는 abstract가 아님
	/* public abstract */ void lesson();
}
