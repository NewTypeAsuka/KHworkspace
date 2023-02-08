package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력: ");
		int inputNum = sc.nextInt();
		
		String result = inputNum == 0 ? "0" : 
			inputNum > 0 ? "양수" : "음수";
		
		System.out.println(result + " 입니다.");
	}
}
