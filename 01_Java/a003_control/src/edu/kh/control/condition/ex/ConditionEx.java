package edu.kh.control.condition.ex;

import java.util.Scanner;

public class ConditionEx {

	public void test1() {
		System.out.println("test1() 수행");
	}
	
	public void test2() {
		System.out.println("test2() 수행");
	}
	
	public void test3() {
		System.out.println("test3() 수행");
	}
	
	// if 예시 1번
	public void ex1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int input = sc.nextInt();
		
			// 조건식
		if (input > 0) {
			// 조건식이 true인 경우에만 if문 내부 코드 수행
			System.out.println("양수입니다.");
			System.out.println("ex1() 종료");
		} 
		
		if (input < 0) {
			System.out.println("음수입니다.");
			System.out.println("ex1() 끝");
		}
	}
	
	// if 예시 2번: if-else
	public void ex2() {
		// 조건식이 true이면 if문 수행
		// false면 else문 수행
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력해주세요: ");
		int input = sc.nextInt();
		
		if (input > 0) {
			System.out.println("양수입니다.");
		} else {
//			System.out.println("음수입니다.");
			
			// [중첩 if문]
			if (input == 0) {
				System.out.println("0입니다.");
			} else {
				System.out.println("음수입니다.");
			}
		}
	}
	
	// if 예시 3번: if-else if-else
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[홀짝 판별기]");
		System.out.print("정수 입력: ");
		int input = sc.nextInt();
		
		// 홀수, 짝수, 0
		if (input == 0) {
			System.out.println("0은 홀/짝수를 구분할 수 없습니다.");
		} else if (Math.abs(input)%2 == 1){
			System.out.println("홀수입니다.");
		} else {
			System.out.println("짝수입니다.");
		}
	}
	
	// if 예시 4번
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계절을 알고싶은 달(월)을 입력해주세요: ");
		int input = sc.nextInt();
		
		// 조건물 결과를 저장할 문자열 변수 선언
		String result;
		
		if (input == 3 || input == 4 || input == 5) {
			result = "봄";
		} else if(input == 6 || input == 7 || input == 8) {
			result = "여름";
		} else if(input == 9 || input == 10 || input == 11) {
			result = "가을";
		} else if(input == 12 || input == 1 || input == 2) {
			result = "겨울";
		} else {
			result = "1~12 사이의 정수를 입력해주세요.";
		}
		// if-else if-else를 거치게 되면
		// result에 무조건 값이 하나 저장되어 있음
		System.out.println(result);
	}
	
	// if 예시 5번
	public void ex5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 살이세요?: ");
		int inputAge = sc.nextInt();
		
		String result;
		
		if (inputAge <= 13) {
			result = "어린이";
		} else if (inputAge <= 19) {
			// 13세 이하는 앞에서 걸러지니까 19세 이하라도 처리 가능
			result = "청소년";
		} else {
			result = "성인";
		}
		System.out.println(result + "입니다.");
	}
	
	// if 예시 6번
	public void ex6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력: ");
		int inputAge = sc.nextInt();
		System.out.print("키 입력: ");
		double inputHeight = sc.nextDouble();
		String result;
		
		// 방법 1 -> "잘못 입력하셨습니다." 출력 안됨
//		if (inputAge > 12 && inputHeight >= 140.0) {
//			result = "탑승 가능";
//		} else if (inputAge < 12) {
//			result = "적정 연령이 아닙니다.";
//		} else if (inputHeight < 140.0) {
//			result = "적정 키가 아닙니다.";
//		} else {
//			result = "잘못 입력하셨습니다.";
//		}
//		System.out.println(result);
		
		// 방법 2 -> 효율 + 모두 만족
		if (inputAge < 0 || inputAge > 100) {
			result = "잘못 입력하셨습니다.";
		} else if (inputAge < 12) {
			result = "적정 연령이 아닙니다.";
		} else if (inputHeight < 140.0) {
			result = "적정 키가 아닙니다.";
		} else {
			result = "탑승 가능";
		}
		System.out.println(result);
	}
	
	// if 예시 7번 -> 완벽
	public void ex7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력: ");
		int inputAge = sc.nextInt();
		String result;
		
		// 나이를 입력받자마자 검사
		if (inputAge < 0 || inputAge > 100) {
			result = "나이를 잘못 입력하셨습니다.";
		} else if (inputAge < 12) {
			result = "적정 연령이 아닙니다.";
		} else {
			
			// else 내부에서는 나이는 정상 입력으로 판단
			System.out.print("키 입력: ");
			double inputHeight = sc.nextDouble();
			
			if (inputHeight < 20.0 || inputHeight > 220.0) {
				result = "키를 잘못 입력하셨습니다.";
			} else if (inputHeight < 140.0) {
				result = "적정 키가 아닙니다.";
			} else {
				result = "탑승 가능합니다.";
			}
		}
		System.out.println(result);
	}
}
