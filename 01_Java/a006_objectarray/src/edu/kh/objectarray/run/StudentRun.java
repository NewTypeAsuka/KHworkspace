package edu.kh.objectarray.run;

import edu.kh.objectarray.view.StudentView;

public class StudentRun {
	
//	클래스 읽기 순서
//	1. static 읽기
//	2. main() 메서드 실행
//	3. StudentView() 객체 생성
//	4. (StudentView 클래스 안) Scanner, StudentService 객체 생성
//	5. (StudentService 클래스 안) Student[5] 배열 생성, 기본 생성자 내용 수행
//		-> Student 객체 3개 생성 후 0, 1, 2 인덱스에 주소 대입

	public static void main(String[] args) {
		
		StudentView view = new StudentView();
		view.displayMenu();
	}
}
