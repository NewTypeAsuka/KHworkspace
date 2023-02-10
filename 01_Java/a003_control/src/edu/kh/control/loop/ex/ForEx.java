package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {
	/*
	 * for문
	 * - 끝이 정해져 있는 경우에 사용하는 반복문
	 * (== 반복 횟수가 지정되어 있는 경우에 사용)
	 * 
	 * - 작성법
	 * 		[1]     [2][5]  [4][7]..
	 * for (초기식; 조건식; 증감식) {
	 * 		조건식이 true일 때 반복 수행할 코드
	 * 		[3][6]
	 * }
	 * // [1]~[4] 수행 후 조건식이 false가 나올 때까지 [5]~[7].. 반복
	 * 
	 * - 초기식: for문을 제어하는 용도의 변수를 선언 및 초기화
	 * - 조건식: for문의 반복 여부를 지정하는 식
	 * 			 (조건식이 true일 경우에만 반복 수행)
	 * 			 (보통 초기식에 사용된 변수를 이용해서 조건식 작성)
	 * - 증감식: for문이 한번 반복을 수행할 때마다 마지막에 특정 값을 증가 또는 감소시키는 식
	 * 			 (초기식 변수를 증감시켜 조건식 결과를 변화시키는 용도)
	 * 
	 * 
	 */
	
	// for문 기초 사용법 1
	public void ex1() {
		
		// 1~10까지 반복 출력
		for (int num = 1; num <= 10; num++) {
			// num은 1~10까지 1씩 증가하는 변수
			System.out.println(num);
		}		
	}
	
	// for문 기초 사용법 2	
	public void ex2() {
		
		// 5부터 12까지 1씩 증가하며 출력
		for (int num = 5; num <= 12; num++) {
			System.out.print(num + " ");
		}
	}
	
	// for문 기초 사용법 3
	public void ex3() {
		
		// 3부터 20까지 2씩 증가하면서 출력
		for (int i = 3; i <= 20; i += 2) {
			System.out.print(i + " ");
		}
	}
	
	// for문 기초 사용법 4
	public void ex4() {
		
		// 1부터 100까지의 모든 정수의 합
		int sum = 0; // i가 증가하면서 변한 값들을 누적할 변수
		for (int i = 1; i <= 100; i++) {
			sum += i; // [1]~[n] 순서로 디버그표 체크하면 이해됨
		}
		System.out.println("합계: " + sum);
	}
	
	// for문 기초 사용법 5
	public void ex5() {
		
		// 두 정수를 입력받아 두 정수 사이의 모든 정수의 합 출력
		// (단 첫번째 입력 받은 정수가 무조건 작다고 가정)
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수: ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수: ");
		int num2 = sc.nextInt();
		
		int sum = 0;
		for (int i = num1; i <= num2 ; i++) {
			sum += i;
		}
		System.out.printf("%d부터 %d까지 모든 정수의 합: %d", num1, num2, sum);
	}
	
	// for문 기초 사용법 6
	public void ex6() {
		
		// 다른 자료형으로 for문 사용하기
		// 10부터 20까지 0.5씩 증가하며 출력
			 // int i -> 10 무한루프
		for (double i = 10; i <= 20; i += 0.5) {
			System.out.print(i + " ");
			// 초기식을 int형으로 지정하게 되는 경우 무한루프
			// i += 0.5 수행 시 10.5이 아닌 (int)10으로 형변환 대입되기 때문에
		}
		System.out.println("\n------------------------------");
		
		// A ~ Z까지 모든 알파벳 출력하기
		
		// 1) A와 Z의 유니코드 번호를 알 때
		for (int i = 65; i <= 90; i++) {
			char j = (char)i;
			System.out.print(j);
		}
		
		// 2) 유니코드 번호를 모를 때
		System.out.println();
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char)i);
		}
		
		// 3) char 자료형은 문자형이지만 실제로는 정수를 저장하는 걸 알 때
		System.out.println();
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
	}
	
	// for문 응용 사용법 1
	public void ex7() {
		
		// 감소하기
		// 10부터 1까지 1씩 감소하며 출력
		for (int i = 10; i >= 1; i--) {
			System.out.print(i + " ");
		}
	}
	
	// for문 응용 사용법 2
	public void ex8() {
		
		// 입력, 합계(sum), for문
		// 정수 5개를 입력받아 합계 출력하기
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // 합계를 저장할 변수 선언 및 0으로 초기화
		for (int i = 1; i <= 5; i++) {
			System.out.printf("%d번째 정수 입력: ", i);
			sum += sc.nextInt();
		}
		System.out.println(sum);
	}
	
	// for문 응용 사용법 3
	public void ex9() {
		
		// ex8 응용
		// 정수 몇번 입력받을지 먼저 입력하고 입력된 정수의 합계 출력하기
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		System.out.print("몇번 입력받겠습니까?: ");
		int z = sc.nextInt();
		for (int i = 1; i <= z; i++) {
			System.out.printf("%d번째 정수 입력: ", i);
			sum += sc.nextInt();
		}
		System.out.println("합계: " + sum);
	}
	
	// for문 응용 사용법 4
	public void ex10() {
		
		// for문 + if문 동시 사용
		// 1부터 10까지 반복하며 출력
		// 단 짝수일 경우 ()로 숫자를 감싸서 출력
		// 1 (2) 3 (4) 5 (6) 7 (8) 9 (10)
		
		for (int i = 1; i <= 10; i++) {
			if (i%2 == 1) {
				System.out.print(i + " ");
			} else {
				System.out.print("(" + i + ")" + " ");
			}
		}
	}
	
	// for문 응용 사용법 5
	public void ex11() {
		
		// 1부터 10까지 1씩 증가하며 출력
		// 단 3의 배수인 경우 숫자를 []로 감싸서 출력
		// 단 5의 배수인 경우 숫자 대신 '@' 출력
		
		for (int i = 1; i <= 10; i++) {
			if (i%3 == 0) {
				System.out.printf(" [%d] ", i);
			} else if (i%5 == 0) {
				System.out.print(" @ ");
			} else {
				System.out.print(" "+ i + " ");
			}
		}
	}
	
	// for문 응용 사용법 6
	public void ex12() {
		
		// 구구단 2단 출력하기
		for (int i = 1; i <= 9; i++) {
			System.out.printf("2 x %d = %2d \n", i, (2*i));
										// %2d: 정수 2칸으로 정렬
		}
	}
	
	// for문 응용 사용법 7
	public void ex13() {
		
		// 원하는 단을 입력한 후 구구단 역순 출력하기
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단을 외우시겠습니까?: ");
		int level = sc.nextInt();
		
		for (int i = 9; i >= 1; i--) {
			System.out.printf("%d x %d = %2d \n",
					level, i, (level*i));
		}
	}
	
	// for문 응용 사용법 8
	public void ex14() {
		
		// 입력받은 단 출력하기
		// 단 입력받은 단이 2~9 사이가 아니라면 "잘못 입력하셨습니다" 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단을 외우시겠습니까?: ");
		int level = sc.nextInt();
		
		if (level <= 1 || level >= 10) {
			System.out.println("잘못 입력하셨습니다");
		} else {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d x %d = %2d \n",
						level, i, (level*i));
				}
		}
	}
	
	// 중첩 반복문 기본 사용법 1
	public void ex15() {
		
		// 12345 4줄 출력
		for (int j = 1; j <= 4; j++) { // 4줄 출력
			for (int i = 1; i <= 5; i++) { // 12345
				System.out.print(i);
			}
			System.out.println(); // 개행
		}
	}
	
	// 중첩 반복문 기본 사용법 2
	public void ex16() {
		
		// 1  2  3  4  5
		// 2  4  6  8 10
		// 3  6  9 12 15
		// 4  8 12 16 20
		// 5 10 15 20 25
		for (int j = 1; j <= 5; j++) {
			
			for (int i = 1; i <= 5; i++) {
			System.out.printf("%3d", (i*j));
			}
			System.out.println(); // 개행
		}
	}
	
	// 중첩 반복문 응용 사용법 1
	public void ex17() {
		
		// 구구단을 2단부터 9단까지 모두 출력하기
		for (int j = 1; j <= 9; j++) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf(" %dx%d=%2d |", i, j, (i*j));
			}
			System.out.println();
		}
	}
	
	// 중첩 반복문 응용 사용법 2
	public void ex18() {
		
		// 2중 for문을 이용하여 다음 모양을 출력
		// 1
		// 12
		// 123
		// 1234
		for (int i = 1; i <= 4; i++) {
			
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	// 중첩 반복문 응용 사용법 3
	public void ex19() {
		
		// 2중 for문을 이용하여 다음 모양을 출력
		// 4
		// 43
		// 432
		// 4321
		for (int x = 4; x >= 1; x--) {
			
			for (int i = 4; i >= x; i--) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	// 중첩 반복문 응용 사용법 4
	public void ex20() {
		
		// 입력된 정수부터 시작하여
		// 321
		// 21
		// 1
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력된 정수: ");
		int input = sc.nextInt();
		
		for (int x = input; x >= 1; x--) {

			for (int i = x; i >= 1; i--) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	// 카운트(개수 세기)
	public void ex21() {
		
		// 1부터 20 사이의 3의 배수의 합과 개수 출력
		
		int sum = 0; // 합계 저장용 변수
		int count = 0; // 카운트 저장용 변수
		
		for (int i = 1; i <= 20; i++) {
			if (i%3==0) { // 3의 배수인 경우
				sum += i; // 합계 저장
				count++; // 카운트 증가
			} 
		}
		System.out.println("sum: " + sum);
		System.out.println("count: " + count);
	}
	
	// 카운트를 이용한 2중 for문
	public void ex22() {
		
		// 1  2  3  4
		// 5  6  7  8
		
		// 9 10 11 12
		int count = 1; // 숫자를 세기 위한 변수 선언
		
		for (int row = 1; row <= 3; row++) { // 3행
			
			for (int col = 1; col <= 4; col++) { // 4행
				System.out.printf("%3d", count++); // 후위연산 적용
			}
			System.out.println(); // 개행
		}
	}
}
