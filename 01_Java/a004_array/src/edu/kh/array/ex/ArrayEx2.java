package edu.kh.array.ex;

public class ArrayEx2 {

	// 2차원 배열 사용법
	public void ex1() {
		
		// 2차원 배열 선언 및 할당
		int[][] arr = new int[2][3]; // 2행 3열
		
		System.out.println("행의 길이: " + arr.length);
		System.out.println("열의 길이: " + arr[0].length);
		
		// 2차원 배열 초기화
		// 1) 인덱스를 이용한 초기화
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21;
		arr[1][0] = 28;
		arr[1][1] = 35;
		arr[1][2] = 42;
		System.out.println("------------------------");
		
		// 2) 2중 for문을 이용한 초기화
		int number = 0;
		for (int row=0; row<arr.length; row++) { // 행 반복
			for (int col=0; col<arr[0].length; col++) { // 열 반복
				arr[row][col] = number * 5;
				number++;
			}
		}
		System.out.println("------------------------");
		
		// 3) 선언과 동시에 초기화
		int[][] arr2 = { {1, 2, 3, 4, 5}, 
					     {60, 70, 80, 90, 100},
					     {11, 22, 33, 44, 55} };
		System.out.println("1행 3열: " + arr2[1][3]); // 1행 3열: 90
		// 행/열 깔끔하게 출력하기
		for (int row=0; row<arr2.length; row++) {
			System.out.print(row + "행: ");
			for (int col=0; col<arr2[row].length; col++) {
				System.out.print(arr2[row][col] + " ");
			}
			System.out.println(); // 개행
		}
	}
	
	// 2차원 배열 응용
	public void ex2() {
		
		// 3행 3열 짜리 int 2차원 배열에 난수(0~9)를 대입한 후
		// 각 행의 합과 전체 합을 출력
		int[][] arr = new int[3][3]; // 3행 3열 짜리 int형 배열 생성
		
		// 난수 대입 및 출력
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				arr[row][col] = (int)(Math.random() * 10); // 0~9 난수 대입
				System.out.printf("%3d", arr[row][col]); // 출력
			}
			System.out.println(); // 출력
		}
		
		// 합계 계산 및 출력
		int sum = 0; // 전체의 합
		for (int row=0; row<arr.length; row++) {
			int rowSum = 0; // 행의 합
			for (int col=0; col<arr[row].length; col++) {
				rowSum += arr[row][col];
			}
			System.out.printf("%d행의 합: %d \n", row, rowSum);
			sum += rowSum; // 각 행의 합을 sum에 누적
		}
		System.out.println("전체의 합: " + sum);
	}
	
	// 가변배열
	public void ex3() {
		
		// 가변배열
		// - 2차원 배열 할당 시 마지막 차수(열)의 크기를 지정하지 않고
		//   추후에 각 행에 새로운 1차원 배열의 주소를 대입하는 배열
		
		char[][] arr = new char[4][]; // 4행만 할당
		arr[0] = new char[3];
		arr[1] = new char[4];
		arr[2] = new char[5];
		arr[3] = new char[2]; // 각기 다른 열 할당
		
		// 배열의 모든 요소에 a부터 시작하여 하나씩 증가하는 알파벳 대입
		char ch = 'a';
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) { // 각기 열이 다르기 때문에 [row]
				arr[row][col] = ch; // 요소에 문자 대입
				ch++; // 다음 문제로 증가
				System.out.print(arr[row][col] + " "); // 출력
			}
			System.out.println();
		}
	}
}
