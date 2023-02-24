package edu.kh.api.service;

import edu.kh.api.dto.Student;

public class APIService {

	// API(Application Programming Interface): 응용 프로그래밍 접점
	// -> 프로그래밍 언어가 이미 가지고 있는 클래스, 기능, 기술을
	// 사용자가 쉽게 사용할 수 있도록 제공하는 것
	
	private Student[] studentList = new Student[10];
	
	public APIService() {
		studentList[0] = new Student(1, 1, 1, "김영희");
		studentList[1] = new Student(2, 3, 4, "홍길동");
		studentList[2] = new Student(3, 5, 12, "박민지");
	}
	
	// alt + shift + j: 설명 주석 추가
	/** 학생 추가 서비스1
	 * @param grade
	 * @param classRoom
	 * @param number
	 * @param name
	 * @return 추가 성공시 true / 실패시 false
	 */
	public boolean addStudent(int grade, int classRoom, int number, String name) {
		int index = 0; // 빈 인덱스 저장
		for(Student s : studentList) {
			if(s == null) break;
			
			boolean check1 = s.getGrade() == grade;
			boolean check2 = s.getClassRoom() == classRoom;
			boolean check3 = s.getNumber() == number;
			boolean check4 = s.getName().equals(name);
			
			if(check1 && check2 && check3 && check4) return false;
			index++;
		}
		if(index == studentList.length) return false; // 학생 배열에 학생이 가득 찬 경우
		
		studentList[index] = new Student(grade, classRoom, number, name); // 지정된 인덱스에 학생 추가
		return true;
	}
	
	/** 학생 추가 서비스2 (equals / hashCode 사용)
	 * @param grade
	 * @param classRoom
	 * @param number
	 * @param name
	 * @return 추가 성공시 true / 실패시 false
	 */
	public boolean addStudent2(int grade, int classRoom, int number, String name) {
		
		// 1. equals()를 이용한 비교
		// 1) 전달받은 값을 임시 학생 객체 생성
		Student temp = new Student(grade, classRoom, number, name);
		
		// 2) 학생 배열을 순차 접근하면서 동등한 학생이 있는지 검사
		int index = 0;
		for(Student s : studentList) {
			if(s == null) break;
			
			// s가 참조하는 학생과 temp가 참조하는 학생이 같은 경우(동등한 경우)
//			if(s.equals(temp)) return false;
			
			System.out.println(s.hashCode());
			System.out.println(temp.hashCode());
			System.out.println("--------------------------");
			
			// hashCode()가 같다 == 필드가 같다 == 중복된 학생이다(동등한 경우)
			if(s.hashCode() == temp.hashCode()) return false;
			
			index++;
		}
		// 3) 학생 배열에 학생이 가득 찬 경우
		if(index == studentList.length) return false;
		
		// 4) 임시 학생 객체를 학생 배열에 추가
		studentList[index] = temp;
		return true;
	}
	
	/** 학생 배열에서 이름 검색
	 * @param input
	 * @return 일치하는 학생이 있으면 Student[] / 없으면 null
	 */
	public Student[] selectName(String input) {
		// String.split(구분자): 문자열을 구분자를 기준으로 나누어 String[] 형태로 반환
//		String[] names = input.split("/");
		String[] names = input.split(",|/"); // , 또는 /를 기준으로 구분
		
		// 검색된 학생을 저장할 배열
		Student[] result = new Student[studentList.length];
		int index = 0; // result 배열에 저장될 위치를 지정할 변수
		for(String n : names) {
			for(Student s : studentList) {
				if(s == null) break;
				
				// 입력받은 이름이랑 학생의 이름이 같다면
				if(s.getName().equals(n)) {
					result[index++] = s; // result 배열에 일치하는 학생 저장(얕은 복사)
				}
			}
		}
		// 검색된 학생이 없으면 null 반환, 있으면 result 반환
		if(index == 0) {
			return null;
		}
		return result;
	}
	
	/** 모든 학생 이름을 하나의 문자열로 반환
	 * @return 
	 */
	public String printName() {
		// [김영희, 홍길동, 박민지, null, null, ...] -> 현재 학생의 수 구하기
		int size = 0;
		for(Student s : studentList) {
			if(s == null) break;
			size++;
		}
		// 이름만 저장할 배열 생성
		String[] names = new String[size];
		for(int i=0; i<size; i++) {
			names[i] = studentList[i].getName();
		}
		// String.join("구분자", String[])
		// -> String[]의 요소를 하나의 문자열로 합침, 단 요소 사이사이에 "구분자" 추가
		return String.join("%", names);
	}
}
