package edu.kh.oop.field.run;

import edu.kh.oop.field.dto.Student;

/*
 * Java 실행 단계
 * 1. 코드 훑어보기
 *    -> static 키워드 찾기
 *    -> 찾은 static 키워드가 포함된 필드/변수/메서드를
 *       static 메모리 영역에 생성/추가
 *       (static 영역에 추가 시 클래스명.필드명 / 클래스명.메서드명으로 기록됨)
 * 2. main 실행
 */

public class StudentRun {

	public static void main(String[] args) {
		
		// Student 객체 생성
		Student s1 = new Student();
		s1.name = "김삼순";
		s1.grade = 5;
		
		Student s2 = new Student();
		s2.name = "박철수";
		s2.grade = 2;
		
		System.out.println("s1 학생 정보");
		System.out.println(s1.name);
		System.out.println(s1.grade);
		System.out.println(s1.schoolName);
		System.out.println("---------------------");
		System.out.println("s2 학생 정보");
		System.out.println(s2.name);
		System.out.println(s2.grade);
		System.out.println(s2.schoolName);
		
		// 학교 이름 변경
//		s1.schoolName = "KH국민학교";
		// 참조 변수를 이용해서 static으로 지정된 필드 값을 바꿀 수 있지만
		// 클래스명.필드명을 이용해서 다루는 것을 권장(static way)
		Student.schoolName = "KH중학교"; // 클래스명.필드명
		
		System.out.println("---------------------");
		System.out.println("s1 학교명: " + s1.schoolName);
		System.out.println("s2 학교명: " + s2.schoolName);
		// schoolName은 static에 저장했기 때문에 s1 하나만 변경해도 s2에도 변경이 적용됨
		
		// public static final: 어디서든 공유할 수 있는 상수
		System.out.println(Math.PI); // PI 매뉴얼에서 원주율 값 3.14..를
									 // final로 설정해둔 것을 확인할 수 있음
	}
}
