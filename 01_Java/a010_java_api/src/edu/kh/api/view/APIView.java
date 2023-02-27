package edu.kh.api.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.api.dto.Student;
import edu.kh.api.service.APIService;

public class APIView {

	private Scanner sc = new Scanner(System.in);
	
	private APIService service = new APIService();
	
	public void displayMenu() {
		
		int input = 0;
		do {
			System.out.println("--- API 테스트 프로그램 ---");
			System.out.println("1. equals() + hashCode()");
			System.out.println("2. String 클래스 제공 메서드1(split)");
			System.out.println("3. String 클래스 제공 메서드2(join)");
			System.out.println("4. String 클래스의 특징, 문제점");
			System.out.println("5. StringBuffer/Builder");
			System.out.println("6. 문자열을 계속 입력받아 한번에 출력하기");
			System.out.println("7. Wrapper 클래스");
			System.out.println("8. Date 클래스");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택: ");
			try {
				input = sc.nextInt();
				sc.nextLine(); // 버퍼에 남은 개행문자 제거
				
				switch(input) {
				case 1: ex1(); break;
				case 2: ex2(); break;
				case 3: ex3(); break;
				case 4: ex4(); break;
				case 5: ex5(); break;
				case 6: ex6(); break;
				case 7: ex7(); break;
				case 8: ex8(); break;
				case 0: break;
				default: System.out.println("메뉴에 존재하는 번호만 입력해주세요");
				}
			}catch(InputMismatchException e) {
				// Scanner 입력이 잘못된 경우
				System.out.println("잘못된 형식을 입력하셨습니다. 다시 시도해주세요");
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못 입력된 문자열을 읽어와 없앰
				input = -1; // input에 0이 아닌 값을 대입하여 while문이 종료되지 않게 함
			}
		}while(input != 0);
	}
	
	private void ex1() {
		// 한 학생의 정보를 입력받아 Service의 학생 배열에 추가
		// 단 중복되는 학생은 제외
		System.out.println("\n--- 학생 정보 입력 ---\n");
		System.out.print("학년: ");
		int grade = sc.nextInt();
		System.out.print("반: ");
		int classRoom = sc.nextInt();
		System.out.print("번호: ");
		int number = sc.nextInt();
		sc.nextLine(); // 입력 버퍼에 남아있는 개행문자 제거
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		if(service.addStudent2(grade, classRoom, number, name)) {
			System.out.print("[추가되었습니다] \n");
		}else {
			System.out.print("중복되는 학생이 존재하거나 배열이 가득 찼습니다");
		}
	}
	
	private void ex2() {
		// 여러 이름을 한 줄로
		// 입력받아서 학생 배열에 같은 이름의 학생이 있다면 출력
		System.out.println("\n--- 학생 검색 ---\n");
		System.out.print("검색할 이름(여러 명 검색 시 / 또는 , 로 구분): ");
		
		Student[] result = service.selectName(sc.nextLine());
		
		if(result == null) {
			System.out.println("[검색 결과가 없습니다]");
		}else {
			for(Student s : result) {
				if(s == null) break;
				System.out.println(s.toString());
			}
		}
	}
	
	private void ex3() {
		System.out.println("\n--- 모든 학생 이름 출력 ---\n");
		System.out.println(service.printName());
	}
	
	private void ex4() {
		// String의 특징, 문제점
		// 1. String 객체 생성 방법
		String s1 = new String("abc"); // Heap 메모리 영역에 String 객체 생성
		String s2 = "abc"; // String은 많이 사용하기 때문에 별도의 리터럴 표기법 부여
						   // Heap 영역 중 String Pool에 객체 생성
		String s3 = "abc";
		// hashCode(): 필드 값이 같으면 같은 수
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
		// identityHashCode(객체주소): 객체주소를 이용해서 만든 정수를 반환
		System.out.println("s1: " + System.identityHashCode(s1));
		System.out.println("s2: " + System.identityHashCode(s2));
		System.out.println("s3: " + System.identityHashCode(s3));
		
		// "abc"
		s3 += "def";
				
		System.out.println("---------------");
		System.out.println("s2: " + System.identityHashCode(s2));
		System.out.println("s3: " + System.identityHashCode(s3));
		// 왜 값이 달라졌을까?
		// String은 불변성(한번 저장된 값은 변할 수 없음) 특징 때문에
		// String 값을 변경할 경우 기존 객체가 변경되는 것이 아니라
		// 새로운 객체를 생성해서 참조하게 됨
	}
	
	private void ex5() {
		System.out.println("\n--- StringBuffer/Builder ---\n");
		
		// StringBuffer와 StringBuilder 두 클래스는 제공하는 메서드가 동일함
//		StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		
		// StringBuffer.capacity(): 현재 버퍼의 크기 출력
		System.out.println("현재 버퍼 크기: " + sb.capacity());
		System.out.println("현재 주소: " + System.identityHashCode(sb));
		
		// StringBuffer.append(문자열): StringBuffer 객체에 문자열을 기존 데이터 뒤에 붙임
		sb.append("abc");
		
		// StringBuffer.toString(): StringBuffer에 저장된 문자열을 String 형태로 반환
		System.out.println("sb에 저장된 문자열: " + sb.toString());
		System.out.println("abc 추가 후 주소: " + System.identityHashCode(sb));
		
		sb.append("def");
		System.out.println("sb에 저장된 문자열: " + sb.toString());
		System.out.println("def 추가 후 주소: " + System.identityHashCode(sb));
		
		// 새로운 문자열이 추가되어도 객체의 주소는 변하지 않음(가변성)
		// -> 문자열 수정 시 새로운 객체를 생성하지 않아 메모리 소비 절약
		
		// StringBuffer.insert(인덱스, 문자열): 중간 삽입
		sb.insert(2, "0");
		System.out.println("0 추가: " + sb.toString());
		
		// StringBuffer.delete(int start, int end): 삭제(start 이상 end 미만)
		sb.delete(3, 5);
		System.out.println("3 이상 5 미만 인덱스 삭제: " + sb.toString());
		
		// StringBuffer.length: 길이 출력
		System.out.println("길이: " + sb.length());
		
		// StringBuffer.replace(int start, int end, String str): 교체(start 이상 end 미만을 str로 교체)
		System.out.println("교체: " + sb.replace(0, 2, "AB"));
	}
	
	private void ex6() {
		System.out.println("\n--- 문자열을 계속 입력받아 한번에 출력 ---\n");
		
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열 입력 (종료를 원할 경우 !wq 입력)");
		
		String str = null;
		while(true) {
			// sc.nextLine(): 한줄 입력받아 String 반환
			// sc.append(String str): 기존 문자열 뒤에 추가
			str = sc.nextLine();
			if(str.equals("!wq")) break; // 입력 종료를 원하는 경우
			sb.append(str);
			sb.append("\n"); // 개행문자
		}
		// delete()를 이용해 마지막 문자열 \n 제거
		sb.delete(sb.length()-1, sb.length());
		
		System.out.println("----- 입력받은 내용 -----");
		System.out.println(sb.toString());
	}
	
	private void ex7() {
		System.out.println("\n--- Wrapper 클래스 ---\n");
		
		/* Wrapper 클래스
		 * - 기본 자료형을 객체로 다룰 수 있도록 포장하는 클래스
		 * - 왜 포장이 필요한가?
		 * 1) 기본 자료형이 제공하지 않는 추가 필드, 메서드를 제공하기 위해
		 * 2) 기본 자료형을 객체로 다뤄야 하는 경우가 있기 때문에(컬렉션)
		 */
		
		// Integer(+모든 Wrapper 클래스) 제공 상수 필드
		System.out.println(Integer.BYTES); // byte 단위 크기
		System.out.println(Integer.SIZE); // bit 단위 크기
		System.out.println(Integer.MAX_VALUE); // 자료형 최대값
		System.out.println(Integer.MIN_VALUE); // 자료형 최소값
		System.out.println(Integer.TYPE); // Wrapper 클래스 대상 타입
		
		// String을 기본 자료형으로 변환
		int i = Integer.parseInt("100") + 50;
		System.out.println("i: " + i);
		long l = Long.parseLong("12345678900") + 10_000_000_000L;
		System.out.println("l: " + l);
		double d = Double.parseDouble("3.141592") + 10.0;
		System.out.println("d: " + d);
		
		// 기본 자료형을 String으로 변환
		String str1 = Integer.valueOf(999).toString();
		String str2 = 999 + ""; // "": 빈 문자열로, 내용은 없지만 길이 0짜리 String
		
		// Wrapper 클래스 이용하여 객체 생성
		Integer iNum1 = new Integer(10);
		int iNum2 = iNum1;
		 // (int) (Integer) -> (int) [AutoUnboxing]
		System.out.println("iNum2: " + iNum2);
		Integer iNum3 = 50; // [AutoBoxing]
		/* Boxing / Unboxing
		 * Boxing: 기본 자료형 -> Wrapper 클래스 객체
		 * Unboxing: Wrapper 클래스 객체 -> 기본 자료형
		 * 
		 * AutoBoxing / AutoUnboxing
		 * - 사용자가 신경쓰지 않아도 상황에 따라 기본 자료형 <-> Wrapper 클래스 객체로 자동으로 변하는 기술
		 */
	}
	
	private void ex8() {
		System.out.println("\n--- Date 클래스 ---\n");
		
		// java.util.Date
		Date d1 = new Date(); // 기본 생성자 -> 객체 생성 시점의 시간 저장
		System.out.println(d1.toString());
		
		Date d2 = new Date(0L); // Date(long date) -> Date 기준시와의 ms단위 시차
		System.out.println(d2.toString());
		
		Date d3 = new Date(1000L); // 1000ms = 1초
		System.out.println(d3.toString());
		
		// System.currentTimeMillis() -> 기준 시간으로부터 지난 시간을 나타냄(ms)
		System.out.println("현재시각 - 기준시간(ms): " + System.currentTimeMillis());
		
		// 현재 시간으로부터 1시간 후 저장
		long temp = 60 * 60 * 1000; // ms단위 1시간
		Date d4 = new Date(System.currentTimeMillis() + temp);
		System.out.println(d4.toString());
		
		// SimpleDateFormat: 간단하게 날짜 형식을 지정하는 객체
		// java.text 패키지에서 제공
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("G yyyy년 MM월 dd일 HH시 mm분 ss초");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		System.out.println(sdf1.format(d4));
		System.out.println(sdf2.format(d4));
		System.out.println(sdf3.format(d4));
	}
}
