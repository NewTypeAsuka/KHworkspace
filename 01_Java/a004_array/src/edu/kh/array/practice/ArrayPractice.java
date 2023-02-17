package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		int[] arr;
		arr = new int[9];
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			if(i%2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.println("짝수 번째 인덱스 합: " + sum);
	}
	
	public void practice2() {
		int[] arr;
		arr = new int[9];
		int sum = 0;
		
		for(int i=arr.length; i>0; i--) {
			arr[i-1] = i;
			System.out.print(arr[i-1] + " ");
			if((i-1)%2 == 1) {
				sum += arr[i-1];
			}
		}
		System.out.println();
		System.out.println("홀수 번째 인덱스 합: " + sum);
	}
	
	public void practice3() {
		System.out.print("양의 정수: ");
		int input = sc.nextInt();
		int[] arr;
		arr = new int[input];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice4() { // 미완성
		int[] arr;
		arr = new int[5];
		
		System.out.print("입력 0: ");
		int num1 = sc.nextInt();
		System.out.print("입력 1: ");
		int num2 = sc.nextInt();
		System.out.print("입력 2: ");
		int num3 = sc.nextInt();
		System.out.print("입력 3: ");
		int num4 = sc.nextInt();
		System.out.print("입력 4: ");
		int num5 = sc.nextInt();
		
		arr[0] = num1;
		arr[1] = num2;
		arr[2] = num3;
		arr[3] = num4;
		arr[4] = num4;
	}
	
	public void practice5() { // 미완성
		System.out.print("문자열: ");
		String input = sc.next();
		System.out.println(input);
	}
	
	public void practice6() {
		System.out.print("정수: ");
		int input = sc.nextInt();
		
		int[] arr;
		arr = new int[input];
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값: ", i);
			int indexNum = sc.nextInt();
			arr[i] = indexNum;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		System.out.println();
		System.out.println("총 합: " + sum);
	}
	
	public void practice7() { // 미완성
		char[] arr;
		arr = new char[14];
		
		System.out.print("주민등록번호(-포함): ");
		String input = sc.next();
	}
	
	public void practice8() { // 미완성
		
	}
	
	public void practice9() {
		int[] arr;
		arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			int random = (int)((Math.random()*10) + 1);
			arr[i] = random;
		}
		System.out.print("발생한 난수: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice10() { // 미완성
		int[] arr;
		arr = new int[10];
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			int random = (int)((Math.random()*10) + 1);
			arr[i] = random;
		}
		System.out.print("발생한 난수: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			if(arr[i] > max) {
				max = arr[i];
			}
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}
	
	public void practice11() { // 미완성
		int[] arr;
		arr = new int[10];
	}
	
	public void practice12() {
		
	}
	
	public void practice13() {
		
	}
	
	public void practice14() {
		
	}
	
	public void practice15() {
		int[][] arr = new int[3][3];
		
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[0].length; col++) {
				System.out.printf("(%d, %d)", row, col);
			}
			System.out.println();
		}
	}
	
	public void practice16() {
		int[][] arr = new int[4][4];
		
		int number = 1;
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[0].length; col++) {
				arr[row][col] = number;
				number++;
			}
		}
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
	}
	
	public void practice17() {
		int[][] arr = new int[4][4];
		
		int number = 16;
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[0].length; col++) {
				arr[row][col] = number;
				number--;
			}
		}
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
	}
	
	public void practice18() {
		
	}
	
	public void practice19() {
		int row = 0;
		int col = 0;
		
		while(true) {
            System.out.print("행 크기: ");
            row = sc.nextInt();
            if(1<=row && row<=10) {
                break;
            }
            System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다");
        }
        
        while(true) {
            System.out.print("열 크기: ");
            col = sc.nextInt();
            if(1<=col && col<=10) {
            	break;
            }
            System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다");
        }
        
        char[][] arr = new char[row][col];
        
		for (row=0; row<arr.length; row++) {
			for (col=0; col<arr[0].length; col++) {
				arr[row][col] = (char)('A' + (Math.random()*26));
			}
		}
		
		for (row=0; row<arr.length; row++) {
			for (col=0; col<arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice20() {
		System.out.print("행의 크기: ");
		int inputRow = sc.nextInt();
		char[][] arr = new char[inputRow][];
		char ch = 'a';
		
		for(int i=0; i<inputRow; i++) {
			System.out.printf("%d열의 크기: ", i);
			int inputCol = sc.nextInt();
			arr[i] = new char[inputCol];
		}
		
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				arr[row][col] = ch;
				ch++;
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice21() {
		
	}
	
	public void practice22() {
		
	}
	
	public void practice23() {
		
	}
	
	public void practice24() {
		
	}
}
