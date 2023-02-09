package edu.kh.control.condition.ex;

import java.util.Scanner;

public class SwitchEx {
	/*
	 * Switch문(switch - case문)
	 * - 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
	 * -> 식의 결과에 맞는 case문이 수행됨
	 * 
	 * [작성법]
	 * switch(식) { // 식 수행 결과는 true/false가 아닌 값(정수, 실수, 문자열)
	 * case 결과값1: 수행코드1; break;
	 * case 결과값2: 수행코드2; break;
	 * default: 수행코드; // 모든 case가 만족하지 않을 경우 수행하는 코드
	 * }
	 */
	
	// switch 예시 1번
	public void ex1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int inputNum = sc.nextInt();
		String result;
		// Sc -> ctrl + space -> 자동완성
		
		// 1) if-else if-else 버전
//		if (inputNum == 1) {
//			result = "RED";
//		} else if (inputNum == 2) {
//			result = "ORANGE";
//		} else if (inputNum == 3) {
//			result = "YELLOW";
//		} else if (inputNum == 4) {
//			result = "GREEN";
//		} else {
//			result = "BLUE";
//		}
//		System.out.println(result);
		
		// 2) switch 버전
		switch (inputNum) {
		case 1: result = "RED"; break;
		case 2: result = "ORANGE"; break;
		case 3: result = "YELLOW"; break;
		case 4: result = "GREEN"; break;
		default: result = "BLUE";
		}
		System.out.println(result);
		
	}
	
	// switch 예시 2번
	public void ex2() {
		// Math.random(): Java에서 난수 발생
		// 1) 난수의 발생 범위: 0.0 <= random < 1.0
		// 2) 발생한 난수의 자료형: double
		// + 실수 -> 정수 강제 형변환: 소수점 버림
		
//		Math.random();     		  // 0.0 <= random < 1.0
//		Math.random() * 3;  	  // 0.0 <= random * 3 < 3.0
//		(int)(Math.random() * 3); // 0 <= (int)(random * 3) < 3
		int random = (int)(Math.random() * 3); // 0, 1, 2 중 하나 무작위 발생
		String result;
		
		switch (random) {
		case 0: result = "백팀"; break;
		case 1: result = "청팀"; break;
		default: result = "홍팀";
		}
		System.out.println(result);
	}
	
	// switch 예시 3번: 식의 결과가 문자열
	public void ex3() {
		// scan -> ctrl + space -> 스캐너 자동 import + 완성 수동 설정
		Scanner sc = new Scanner(System.in);
		
		// 메뉴를 입력받아서 가격이 얼마인지 출력하기
		System.out.println("메뉴를 입력하세요(김밥/라면/샌드위치/떡볶이): ");
		String input = sc.next();
		
		int price;
		
		switch (input) {
		case "김밥": 		price = 4500; break;
		case "라면": 		price = 3500; break;
		case "샌드위치": 	price = 5800; break;
		case "떡볶이":	    price = 4000; break;
		default: price = -1; // 잘못 입력한 경우에 사용하지 않는 숫자(-1) 이용
		}
		if (price != -1) {
			System.out.printf("%s는(은) %d원입니다.", input, price);
		} else { // price가 -1인 경우
			System.out.println("존재하지 않는 메뉴입니다.");
		}
	}
	
	// switch 예시 4번
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 입력: ");
		int inputNum1 = sc.nextInt();
		System.out.print("연산자 입력: ");
		String inputOp = sc.next();
		System.out.print("정수2 입력: ");
		int inputNum2 = sc.nextInt();
		
		switch (inputOp) {
		case "+": System.out.printf("%d %s %d = %s",
				inputNum1, inputOp, inputNum2, (inputNum1 + inputNum2));
				break;
		case "-": System.out.printf("%d %s %d = %s",
				inputNum1, inputOp, inputNum2, (inputNum1 - inputNum2));
				break;
		case "*": System.out.printf("%d %s %d = %s",
				inputNum1, inputOp, inputNum2, (inputNum1 * inputNum2));
				break;
		case "/": 
			if (inputNum2 == 0) {
				System.out.println("0으로는 나눌 수 없습니다.");
				break;
			} else {
				System.out.printf("%d %s %d = %.3f",
				inputNum1, inputOp, inputNum2, ((double)inputNum1 / (double)inputNum2));
				break;
			}
		case "%": 
			if (inputNum2 == 0) {
				System.out.println("0으로는 나눌 수 없습니다.");
				break;
			} else {
				System.out.printf("%d %s %d = %s",
				inputNum1, inputOp, inputNum2, (inputNum1 % inputNum2));
				break;
			}
		default: System.out.println("존재하지 않는 연산자입니다.");
		}
	}
	
	// switch 예시 5번: break의 역할
	public void ex5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("달(월) 입력: ");
		int month = sc.nextInt();
		String result;
		
		// break: 해당 case를 수행한 후 멈추라는 뜻
		// break 미작성 시 다음 case가 연달아서 수행
		// case마다 꼭 코드가 작성될 필요는 없음
		switch(month) {
		case 12: case 1: case 2:  result = "겨울"; break;
		case 3:	case 4:	case 5:   result = "봄"; break;
		case 6:	case 7:	case 8:   result = "여름"; break;
		case 9:	case 10: case 11: result = "가을"; break;
		default: result = "잘못 입력하셨습니다.";
		}
		System.out.println(result);
	}
}
