package edu.kh.polymorphism.ex2.dto;

// 각자 계산기 구현하기
public class LSJCalculator implements Calculator, KH {

	@Override
	public int plus(int a, int b) {
		int result = a + b;
		return result;
	}

	@Override
	public int minus(int a, int b) {
		int result = a - b;
		return result;
	}

	@Override
	public int multiple(int a, int b) {
		int result = a * b;
		return result;
	}

	@Override
	public int divide(int a, int b) {
		int result = a / b;
		return result;
	}

	@Override
	public double divide2(double a, double b) {
		double result = a / b;
		return result;
	}

	@Override
	public double areaOfCircle(double r) {
		double result = Calculator.PI * r * r; // 정확한 표기법, 그냥 PI라고 해도 됨
		return result;
	}

	@Override
	public int square(int a, int x) {
		int result = 1;
		for(int i=1; i<=x; i++) {
			result *= a;
		}
		return result;
	}

	@Override
	public void lesson() {
		System.out.println("KH에서 자바 강의를 듣습니다");
	}
}
