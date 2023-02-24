package edu.kh.api.view;

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
}
