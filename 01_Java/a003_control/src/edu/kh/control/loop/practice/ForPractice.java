package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 1]");
		System.out.print("1 이상의 숫자를 입력하세요: ");
		int input = sc.nextInt();
		
		if (input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요!");
		} else {
			for (int i=1; i<=input; i++) {
				System.out.print(i + " ");
			}
		}
	}
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 2]");
		System.out.print("1 이상의 숫자를 입력하세요: ");
		int input = sc.nextInt();
		
		if (input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요!");
		} else {
			for (int i=input; i>=1; i--) {
				System.out.print(i + " ");
			}
		}
		
	}
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 3]");
		System.out.print("정수를 하나 입력하세요: ");
		int input = sc.nextInt();
		int sum = 0;
		
		for (int i=1; i<=input; i++) {
			if (i == input) {
				sum += i;
				System.out.print(i);
			} else {
				sum += i;
				System.out.print(i);
				System.out.print(" + ");	
			}
		}
		System.out.println(" = " + sum);
	}
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 4]");
		System.out.print("첫 번째 숫자: ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자: ");
		int num2 = sc.nextInt();
		
		if (num1<1 || num2<1) {
			System.out.println("1 이상의 숫자를 입력해주세요!");
		} else {
			if (num1 > num2) {
				for (int i=num2; i<=num1; i++) {
					System.out.print(i + " ");
				}
			} else if (num2 > num1) {
				for (int j=num1; j<=num2; j++) {
					System.out.print(j + " ");
				}
			} else {
				System.out.println("같은 수를 입력하셨습니다!");
			}
		}
	}
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 5]");
		System.out.print("숫자: ");
		int input = sc.nextInt();
		
		for (int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d \n",
					input, i, (input*i));
		}
	}
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 6]");
		System.out.print("숫자: ");
		int input = sc.nextInt();
		
		if (input < 2 || input > 9) {
			System.out.println("2~9 사이 숫자만 입력해주세요!");
		} else {
			for(int dan=input; dan<=9 ; dan++) {
				System.out.printf("===== %d단 ===== \n", dan);
				for (int i=1; i<=9; i++) {
					System.out.printf("%d * %d = %d \n",
							dan, i, (dan*i));
				}
			}
		}
	}
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 7]");
		System.out.print("정수 입력: ");
		int input = sc.nextInt();
		
		for (int i=1; i<=input; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}		
	}
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 8]");
		System.out.print("정수 입력: ");
		int input = sc.nextInt();
		
		for (int i=1; i<=input; i++) {
			for (int j=input; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void practice9() { // 미완성
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 9]");
		System.out.print("정수 입력: ");
		int input = sc.nextInt();
		
		for (int i=1; i<=input; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void practice10() { // 미완성
		Scanner sc = new Scanner(System.in);
		System.out.println("[실습문제 10]");
		System.out.print("정수 입력: ");
		int input = sc.nextInt();

		// if (i<=input일 때)
		for (int i=1; i<=input; i++) {
			System.out.print("*");
		}
		System.out.println();
		// if (j>input일 때)
		for (int j=(input+1); j<=input; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	public void practice11() {
		
	}
	public void practice12() {
		
	}
	public void practice13() {
		
	}
}
