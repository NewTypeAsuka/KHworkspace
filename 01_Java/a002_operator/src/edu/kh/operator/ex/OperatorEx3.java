package edu.kh.operator.ex;

public class OperatorEx3 {
	public static void main(String[] args) {
		// 논리 연산자: &&(AND), ||(OR)
		// &&(AND) 연산자: 둘 다 true이면 true, 나머지는 false
		// ~와, 그리고, 이면서, 부터, 까지, 사이 -> AND
		
		// 정수가 100 이상이면서 짝수인가?
		int num1 = 98;
		boolean result1 = num1 >= 100 && num1%2 == 0;
		System.out.println("100 이상이면서 짝수?: " + result1);
		
		// 정수가 50 이하이고 3의 배수인가?
		int num2 = 42;
		boolean result2 = num2 <= 50 && num2%3 == 0;
		System.out.println("50 이하이고 3의 배수?: " + result2);
		
		// 정수가 1부터 100 사이의 숫자인가?
		int num3 = 100;
		boolean result3 = 1 <= num3 && num3 <= 100; // 이항 연산자는 두 개의 항만 비교하기 때문에 1 <= num3 <= 100은 오류
		System.out.println("1부터 100 사이의 숫자?: " + result3);
		
		// ||(OR) 연산자: 둘 다 false이면 false, 나머지는 true
		// ~거나, 또는 -> OR
		
		// 정수가 10을 초과하거나 홀수인가?
		int num4 = 7;
		boolean result4 = num4 > 10 || num4%2 == 1;
		System.out.println("10 초과하거나 홀수?: " + result4);
		
		// 정수는 0부터 50 사이의 숫자 또는 음수인가?
		int num5 = -1;
		boolean result5 = 0 <= num5 && num5 <= 50 || num5 < 0; // 우선 순위: 부등호 -> && -> || -> =
		System.out.println("0부터 50사이의 숫자 또는 음수?: " + result5);
		
		// 논리 부정 연산자: ! (not)
		// - 논리 값을 반대로 바꾸는 단항 연산자
		
		// 11은 짝수가 아니다?
		int num6 = 11;
		boolean result6 = !(11%2 == 0);
		System.out.println("11은 짝수가 아니다? " + result6);
		
		System.out.println(true || false && !false); // true
	}
}
