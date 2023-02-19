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
		boolean result = false;
		
		for(int i=0; i<5; i++) {
			System.out.printf("입력 %d: ", i);
			int input = sc.nextInt();
			arr[i] = input;
		}
		
		System.out.print("검색할 값: ");
		int target = sc.nextInt();
		for(int i=0; i<5; i++) {
			if(target == arr[i]) {
				System.out.println("인덱스 값: " + i);
				result = true;
				break;
			}else if(target != arr[i]) {
				result = false;
				continue;
			}
		}
//		switch(result) {
//		case true: break;
//		case false: break;
//		}
	}
	
	public void practice5() {
		System.out.print("문자열: ");
		String inputStr = sc.next();
		char[] arr = inputStr.toCharArray();
		int sum = 0;
		
		System.out.print("문자: ");
		String inputChar = sc.next();
		char ch = inputChar.charAt(0);
		
		for (int i = 0; i < arr.length; i++) {
		    System.out.print(arr[i]);
		}
		System.out.printf("에 %s가 존재하는 위치(인덱스): ", ch);
		
		for(int i=0; i<arr.length; i++) {
			if(ch == arr[i]) {
				System.out.print(i + " ");
				sum += 1;
			}
		}
		System.out.println();
		System.out.printf("%s 개수: %d", ch, sum);
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
	
	public void practice7() {
		char[] arr = new char[14];
		
		System.out.print("주민등록번호(-포함): ");
		String str = sc.next();
		
		for(int i=0; i<arr.length; i++) {
			if(i>=8) {
				arr[i] = '*';
			}else {
				arr[i] = str.charAt(i);
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		
	}
	
	public void practice8() {
		System.out.print("정수: ");
		int num = sc.nextInt();
		for(boolean check=false; check=true;) {
			if(num%2==0 || num<3) {
				System.out.println("다시 입력하세요");
				check=false;
				System.out.print("정수: ");
				num = sc.nextInt();
			}else if(num%2==1 || num>=3) {
				check=true;
				break;
			}
		}
		int[] arr = new int[num];
		for(int i=0; i<((arr.length/2)+1); i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
		for(int i=((arr.length/2)+2); arr[i] != 1; i--) {
			arr[i] = i-2;
			System.out.print(arr[i] + " ");
			if(arr[i] == 1) {
				break;
			}
		}
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
	
	public void practice10() {
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			int random = (int)((Math.random()*10) + 1);
			arr[i] = random;
		}
		System.out.print("발생한 난수: ");
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			if(arr[i] > max) {
				max = arr[i];
			}
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println();
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}
	
	public void practice11() { // 미완성
		int[] arr = new int[10];
		arr[0] = 0;
		
		for(int i=0; i<arr.length; i++) {
			int random = (int)((Math.random()*10) + 1);
			for(int check=0; check<arr.length; check++) {
				if(arr[i] == random) {
					continue;
				}else if(arr[i] != random) {
					arr[i] = random;
				}
			}
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice12() { // 미완성
		System.out.print("문자열: ");
		String str = sc.next();
		char[] arrTemp = new char[str.length()];
		char[] arr;
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			arrTemp[i] = ch;
			System.out.print(arrTemp[i] + " ");
		}
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
	
	public void practice21() { //미완성
		String[] students = {"강건강", "남나나", "도대담",
							 "류라라", "문미미", "박보배",
							 "송성실", "윤예의", "진재주",
							 "차천축", "피풍표", "홍하하"};
		String arr1[][] = new String[3][2];
		String arr2[][] = new String[3][2];
		for(int i=0; i<students.length; i++) {
			for(int row1=0; row1<arr1.length; row1++) {
				for(int col1=0; col1<arr1[row1].length; col1++) {
					arr1[row1][col1] = students[i];
					if(arr1[2][1] != null) {
						for(int row2=0; row2<arr2.length; row2++) {
							for(int col2=0; col2<arr2[row2].length; col2++) {
								arr2[row2][col2] = students[i];
							}
						}
					}
				}
			}
		}
		
		System.out.println("== 1분단 ==");
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice22() {
		
	}
	
	public void practice23() {
		
	}
	
	public void practice24() {
		
	}
}
