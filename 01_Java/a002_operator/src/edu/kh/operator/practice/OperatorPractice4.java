package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어: ");
		int inputKorScore = sc.nextInt();
		System.out.print("영어: ");
		int inputEngScore = sc.nextInt();
		System.out.print("수학: ");
		int inputMathScore = sc.nextInt();
		
		System.out.println();
		
		int resultSum = inputKorScore + inputEngScore + inputMathScore;
		System.out.println("합계: " + resultSum);
		
		double resultAvg = (inputKorScore + inputEngScore + inputMathScore) / 3;
		System.out.println("평균: " + resultAvg);
		
		String resultFinal =
				(  inputKorScore >= 40
				&& inputEngScore >= 40
				&& inputMathScore >= 40)
				&& resultAvg >= 60
				? "합격" : "불합격";
				
		System.out.println(resultFinal);
		
	}
}
