package edu.kh.variable;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//sc.next(): 다음 입력되는 한 단어를 얻어옴
		//sc.nextInt(): 다음 입력되는 정수를 얻어옴
		//sc.nextDouble(): 다음 입력되는 실수를 얻어옴
		
		System.out.print("이름: ");
		String inputName = sc.next();
		
		System.out.print("나이: ");
		int inputAge = sc.nextInt();
		
		System.out.print("키: ");
		double inputHeight = sc.nextDouble();
		
		System.out.printf("%s님은 %d세, 키 %f.1cm입니다",
				inputName, inputAge, inputHeight);
	}
}
