package edu.kh.variable;

public class VariableEx1 {

	public static void main(String[] args) {

		// ;(세미콜론): 명령어의 끝
		// Ctrl + Shift + F: 코드 정렬

		System.out.println("[변수 사용 X인 경우]");
		System.out.println(2 * 3.141592653589793 * 5);
		System.out.println(3.141592653589793 * 5 * 5);
		System.out.println(3.141592653589793 * 5 * 5 * 20);
		System.out.println(4 * 3.141592653589793 * 5 * 5);

		System.out.println("------------------------------");

		System.out.println("[변수 사용하는 경우]");
		
		// 변수 선언
		double pi = 3.141592653589793;
		int r = 5;
		int h = 20;
		
		System.out.println("pi: " + pi);
		System.out.println("r: "+ r);
		System.out.println("h: " + h);
		
		System.out.println(2 * pi * r); // 원의 둘레
		System.out.println(pi * r * r); // 원의 넓이
		System.out.println(pi * r * r * h); // 원기둥의 부피
		System.out.println(4 * pi * r * r); // 구의 겉넓이
		
		// 변수란?
		// - 메모리(RAM)에 값을 기록하는 공간
		// - 공간에 기록되는 값(Data)이 변할 수 있기에 변수라고 함
		
		// 변수 사용의 장점
		// 1. 코드 작성 용이, 코드 길이 감소
		// 2. 코드 가독성 향상
		// 3. 재사용성 증가
		// 4. 유지보수 용이
	}
}