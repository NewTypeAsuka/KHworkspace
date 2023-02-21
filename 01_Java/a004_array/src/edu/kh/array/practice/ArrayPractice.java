package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {
	
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		
		int[] arr;
		arr = new int[9];
		int sum = 0;
		
		for(int i=1; i<=arr.length; i++) {
			System.out.print(i + " ");
			arr[i-1] = i;
			if(i%2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.println("짝수 번째 인덱스 합: " + sum);
	}
}
