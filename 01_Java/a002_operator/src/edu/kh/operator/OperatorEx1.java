package edu.kh.operator;

import java.util.Scanner; // Scanner import 코드

public class OperatorEx1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // Scanner 객체 생성
		
		// 산술 연산자: + - * / %(모듈러)
		
		System.out.println("두 정수를 입력받아 산술 연산 결과 출력하기");
		
		System.out.print("정수 입력 1: ");
		int input1 = sc.nextInt();
		System.out.print("정수 입력 2: ");
		int input2 = sc.nextInt();
									// \n: 탈출 문자로 줄바꿈
		System.out.printf("%d + %d = %d \n", input1, input2, input1+input2);
		System.out.printf("%d - %d = %d \n", input1, input2, input1-input2);
		System.out.printf("%d * %d = %d \n", input1, input2, input1*input2);
		System.out.printf("%d / %d = %d \n", input1, input2, input1/input2);
		System.out.printf("%d %% %d = %d \n", input1, input2, input1%input2);
							  // printf에서 '%'를 출력하고 싶으면 "%%"를 작성
	}

}
