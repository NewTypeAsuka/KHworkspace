package edu.kh.objectarray.view;

import java.util.Scanner;
import edu.kh.objectarray.dto.Student;
import edu.kh.objectarray.service.StudentService;

public class StudentView {
	
	// 필드
	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();

	public void displayMenu() {
		int input = 0;
		
		do {
			System.out.println("----- [학생 관리 프로그램] -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 조회(인덱스)");
			System.out.println("4. 학생 정보 조회(이름)");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 점수 합계, 평균, 최고점, 최저점 조회");
			System.out.println("0. 종료");
			System.out.println("----------------------------");
			System.out.print(" 메뉴 선택: ");
			input = sc.nextInt();
			System.out.println();
			switch(input) {
			case 1: addStudent(); break;
			case 2: selectAll(); break;
			case 3: selectIndex(); break;
			case 4: selectName(); break;
			case 5: updateStudent(); break;
			case 6: sumAvgMaxMin(); break;
			case 0: System.out.println("[프로그램이 종료됩니다]"); break;
			default: System.out.println("[잘못 입력 하셨습니다]");
			}
			System.out.println();
		}while(input != 0);
	}

	/** 1. 학생 정보 추가 */
	private void addStudent() {
		System.out.println("[학생 추가]");
		System.out.print("학년: ");
		int grade = sc.nextInt();
		System.out.print("반: ");
		int classRoom = sc.nextInt();
		System.out.print("번호: ");
		int number = sc.nextInt();
		System.out.print("이름: ");
		String name = sc.next();
		
		// 학생 추가 서비스 호출
		boolean result = service.addStudent(grade, classRoom, number, name);
		if(result) { // true인 경우 == 학생 추가 성공
			System.out.println(name + " 학생이 추가되었습니다");
		}else { // false인 경우 == 학생 추가 실패
			System.out.println("더 이상 학생을 추가할 수 없습니다");
		}
	}
	/** 2. 학생 전체 조회 */
	private void selectAll() {
		System.out.println("[학생 전체 조회]");
		Student[] studentList = service.selectAll();
		// 매개변수, 반환값으로 참조변수가 사용될 경우 참조하고 있는 주소가 복사(얕은 복사)
		for(int i=0; i<studentList.length; i++) {
			if(studentList[i] == null) {
				break; // 참조하는 객체가 없으면 반복 종료
			}
			// Student 객체가 가지고 있는 toString() 메서드를 호출해서 학생 정보를 문자열로 반환받아 출력
			System.out.println(studentList[i].toString());
			// NullPointerException: 참조하고 있는 객체가 없는 참조변수를 이용해서 필드/메서드 호출할 때 발생하는 예외
		}
	}
	/** 3. 학생 정보 조회(인덱스) */
	private void selectIndex() {
		System.out.println("[학생 정보 조회(인덱스)]");
		System.out.print("조회할 학생의 인덱스 번호를 입력하세요: ");
		int index = sc.nextInt();
		Student std = service.selectIndex(index);// 인덱스에 해당하는 배열 요소를 얻어와서 저장
		
		// NullPointerException 방지
		if(std != null) {
			System.out.println(std.toString());
		}else if(std == null) {
			System.out.println("해당 인덱스에 학생 정보가 존재하지 않습니다");
		}
	}
	/** 4. 학생 정보 조회(이름) */
	private void selectName() {
		System.out.println("[학생 정보 조회(이름)");
		System.out.print("조회할 학생의 이름을 입력하세요: ");
		String inputName = sc.next();
		
		Student[] resultArr = service.selectName(inputName);
		
		if(resultArr != null) { // 이름이 일치하는 학생이 있을 경우
			// 향상된 for문
			// for(배열에서 꺼낸 요소 하나를 저장할 변수 : 배열명) {}
			// -> 배열에서 꺼내는 순서는 0부터 1씩 증가하여 마지막 인덱스까지(순차 접근, 반복 접근)
			for(Student s : resultArr) {
				// s: resultArr의 요소가 for문 반복마다 하나씩 저장되는 변수
				if(s == null) break; // if/else if/else/for/while문 등에서 {} 블록을 작성하는 구문에서 {}을 생략하면 다음 한 줄(; 전까지)에만 해당 구문을 적용
				System.out.println(s.toString());
			}
		}else { // 없을 경우
			System.out.println("이름이 일치하는 학생이 없습니다");
		}
	}
	/** 5. 학생 정보 수정(인덱스) */
	private void updateStudent() {
		System.out.println("[학생 정보 수정(인덱스)]");
		System.out.print("인덱스: ");
		int index = sc.nextInt();
		System.out.print("국어: ");
		int kor = sc.nextInt();
		System.out.print("영어: ");
		int eng = sc.nextInt();
		System.out.print("수학: ");
		int math = sc.nextInt();
		
		// 입력받은 index 번째 학생의 점수를 수정하는 서비스 호출
		// 수정 성공시 true, 실패시 false
		boolean result = service.updateStudent(index, kor, eng, math);
		if(result) System.out.println("수정되었습니다");
		else 	   System.out.println("해당 인덱스에 학생이 존재하지 않습니다");
	}
	
	/** 6. 합계, 평균, 최고점, 최저점 */
	private void sumAvgMaxMin() {
		System.out.println("[합계, 평균, 최고점, 최저점]");
		
		int[] arr = service.sumAvgMaxMin();
		
		System.out.println("합계: " + arr[0]);
		System.out.println("평균: " + arr[1]);
		System.out.println("최고점: " + arr[2]);
		System.out.println("최저점: " + arr[3]);
	}
}
