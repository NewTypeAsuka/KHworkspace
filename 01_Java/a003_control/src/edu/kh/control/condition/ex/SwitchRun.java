package edu.kh.control.condition.ex;

import java.util.Scanner;

//실행용 클래스
public class SwitchRun {

	public static void main(String[] args) {
		
		SwitchEx sw = new SwitchEx();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("실행할 예제의 번호를 입력: ");
		int number = sc.nextInt();
		
		switch (number) {
		case 1: sw.ex1(); break;
		case 2: sw.ex2(); break;
		case 3: sw.ex3(); break;
		case 4: sw.ex4(); break;
		case 5: sw.ex5(); break;
		default: System.out.println("존재하지 않는 예제 번호입니다.");
		}
	}
}
