package edu.kh.polymorphism.ex2.dto;
// 계산기 인터페이스
// -> 모든 계산기에 대한 공통 필드, 기능명을 제공하는 용도
// -> 공통 규약(이름만) 설정
public interface Calculator {
	
	public static final double PI = 3.14;
	final int MAX_NUM = 100_000_000;
	int MIN_NUM = -100_000_000;
	
	// alt + shift + j
	/** 두 정수의 합 반환
	 * @param a
	 * @param b
	 * @return a와 b의 합
	 */
	public abstract int plus(int a, int b);
	
	/** 두 정수의 차 반환
	 * @param a
	 * @param b
	 * @return a와 b의 차
	 */
	/* public abstract */ int minus(int a, int b);
	
	/** 두 정수의 곱 반환
	 * @param a
	 * @param b
	 * @return a와 b의 곱
	 */
	int multiple(int a, int b);
	
	/** 두 정수의 나눈 몫 반환
	 * @param a
	 * @param b
	 * @return a에서 b를 나눈 몫
	 */
	int divide(int a, int b);
	
	/** 두 정수의 나눈 결과 반환(나누기 소수점 연산)
	 * @param a
	 * @param b
	 * @return a에서 b를 나눈 결과
	 */
	double divide2(double a, double b);
	
	/** 원의 넓이 반환
	 * @param r
	 * @return 원의 넓이
	 */
	double areaOfCircle(double r);
	
	/** a의 x 거듭 제곱 반환(a^x)
	 * @param a
	 * @param x
	 * @return a의 x 거듭 제곱
	 */
	int square(int a, int x);
}
