package edu.kh.control.condition.practice;

import java.util.Scanner;

// 실습문제 작성 클래스
public class ConditionPractice {
	
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		String result;
		System.out.println("숫자를 한 개 입력하세요: ");
		int intNum = sc.nextInt();
		
		if (intNum <= 0) {
			result = "양수만 입력해주세요.";
		} else {
			if (intNum%2 == 0) {
				result = "짝수입니다.";
			} else {
				result = "홀수입니다.";
			}
		}
		System.out.println(result);
	}
	
	public void practice2() {
		
		System.out.print("국어점수: ");
		int kor = sc.nextInt();
		System.out.print("수학점수: ");
		int math = sc.nextInt();
		System.out.print("영어점수: ");
		int eng = sc.nextInt();
		
		int sum = kor + math + eng;
		double avg = sum / 3;
		String result;
		
		if ((kor >= 40 && eng >= 40 && math >= 40) && avg >= 60) {
			System.out.println(
			"국어: " + kor +
			"\n수학: " + math +
			"\n영어: " + eng +
			"\n합계: " + sum +
			"\n평균: " + avg);
			result = "합격";
		} else {
			result = "불합격";
		}
		System.out.println(result + "입니다.");
	}
	
	public void practice3() {
		
		String result;
		System.out.print("1~12 사이의 정수 입력: ");
		int month = sc.nextInt();
		
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.printf("%d월은 31일까지 있습니다.", month);
			break;
		case 2: case 4: case 6: case 9: case 11:
			System.out.printf("%d월은 30일까지 있습니다.", month);
			break;
		default: System.out.printf("%d는 잘못 입력된 달입니다.", month);
		}
	}
	
	public void practice4() {
		
		String result;
		System.out.print("키(m)를 입력해주세요: ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해주세요: ");
		double weight = sc.nextDouble();
		double BMI = weight / (height * height);
		System.out.println("BMI 지수: " + BMI);
		
		if (BMI < 18.5) {
			result = "저체중";
		} else if (BMI >= 18.5 && BMI < 23) {
			result = "정상체중";
		} else if (BMI >= 23 && BMI < 25) {
			result = "과체중";
		} else if (BMI >= 25 && BMI < 30) {
			result = "비만";
		} else {
			result = "고도 비만";
		}
		System.out.println(result);
	}
	
	public void practice5() {
		
		String result;
		System.out.print("중간고사 점수: ");
		int midTest = sc.nextInt();
		double scoreMidTest = midTest * 0.2;
		System.out.print("기말고사 점수: ");
		int finalTest = sc.nextInt();
		double scoreFinalTest = finalTest * 0.3;
		System.out.print("과제 점수: ");
		int homework = sc.nextInt();
		double scoreHomework = homework * 0.3;
		System.out.print("출석 횟수: ");
		int attend = sc.nextInt();
		double finalScore = 
				scoreMidTest
				+ scoreFinalTest
				+ scoreHomework
				+ attend;
		
		// 여기 논리 맞는지 조금 더 손보자!
		if (finalScore < 70) {
			result = "Fail [점수 미달]";
		} else if (attend <= 14) {
			result = "Fail [출석 횟수 부족] (" + attend + "/20)";
		} else {
			result = "PASS";
		}
		
		System.out.println(
				"===========결과===========" +
				"\n중간고사 점수(20): " + scoreMidTest +
				"\n기말고사 점수(30): " + scoreFinalTest +
				"\n과제 점수    (30): " + scoreHomework +
				"\n출석 점수    (20): " + (double)attend +
				"\n총점: " + finalScore +
				result
				);
	}
}
