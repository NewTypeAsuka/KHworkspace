package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");
		String inputName = sc.next();
		System.out.print("학년(정수): ");
		int inputGrade = sc.nextInt();
		System.out.print("반(정수): ");
		int inputClass = sc.nextInt();
		System.out.print("번호(정수): ");
		int inputNumber = sc.nextInt();
		System.out.print("성별(남학생/여학생): ");
		String inputGender = sc.next();
		System.out.print("점수(소수점 아래 둘째 자리까지): ");
		double inputScore = sc.nextDouble();
		
		System.out.printf("\n%d학년 %d반 %d번 %s %s의 성적은 %.2f입니다.",
				inputGrade, inputClass, inputNumber, inputName, inputGender, inputScore);
	}
}
