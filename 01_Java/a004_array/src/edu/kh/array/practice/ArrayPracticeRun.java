package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPracticeRun {

	public static void main(String[] args) {
		ArrayPractice ap = new ArrayPractice();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("실행할 예제의 번호를 입력: ");
		int number = sc.nextInt();
		
		switch(number) {
		case 1: ap.practice1(); break;//완성
		case 2: ap.practice2(); break;//완성
		case 3: ap.practice3(); break;//완성
		case 4: ap.practice4(); break;//
		case 5: ap.practice5(); break;//완성
		case 6: ap.practice6(); break;//완성
		case 7: ap.practice7(); break;//완성
		case 8: ap.practice8(); break;//완성
		case 9: ap.practice9(); break;//완성
		case 10: ap.practice10(); break;//완성
		case 11: ap.practice11(); break;//
		case 12: ap.practice12(); break;//
		case 13: ap.practice13(); break;
		case 14: ap.practice14(); break;
		case 15: ap.practice15(); break;//완성
		case 16: ap.practice16(); break;//완성
		case 17: ap.practice17(); break;//완성
		case 18: ap.practice18(); break;
		case 19: ap.practice19(); break;//완성
		case 20: ap.practice20(); break;//완성
		case 21: ap.practice21(); break;//완성
		case 22: ap.practice22(); break;//완성
		case 23: ap.practice23(); break;
		case 24: ap.practice24(); break;
		default: System.out.println("존재하지 않는 예제 번호입니다.");
		}
	}
}
