package edu.kh.objectarray.service;

import java.util.Random;
import edu.kh.objectarray.dto.Student;

// 기능 제공용 클래스(비즈니스 로직 처리)
public class StudentService {

	// ctrl + shift + o: import 자동 추가
	
	// Student 객체 참조변수 5개짜리 배열을 생성해서 studentArr 참조
	private Student[] studentArr = new Student[5];
	
	public StudentService() { // 기본 생성자
		// studentArr 배열의 각 요소는 Student 참조변수
		studentArr[0] = new Student(3, 5, 17, "홍길동");
		studentArr[1] = new Student(2, 3, 11, "김철수");
		studentArr[2] = new Student(1, 7, 3, "최미영");
		
		// 학생 랜덤 점수 추가
	    Random random = new Random();
	    for(Student s : studentArr) {
	    	if(s == null) break;
	        s.setKor(random.nextInt(101));
	        s.setEng(random.nextInt(101));
	        s.setMath(random.nextInt(101));
	    }
	}
	
	/** 1. 학생 추가 서비스
	 * @param grade: int
	 * @param classRoom: int
	 * @param number: int
	 * @param name: String
	 * 
	 * @return result: boolean(학생 추가 성공 시 true)
	 */
	public boolean addStudent(int grade, int classRoom, int number, String name) {
		// studentArr에서 비어있는 인덱스를 찾아
		// 해당 인덱스에 매개변수를 이용해서 생성된 Student 객체 주소를 대입 -> true 반환
		for(int i=0; i<studentArr.length; i++) {
			if(studentArr[i] == null) { // 비어있는 배열 요소에 매개변수를 이용해서 새 학생 객체 만들어 주소 대입
				studentArr[i] = new Student(grade, classRoom, number, name);
				return true;
			}
		}
		return false; // 만약 비어있는 인덱스가 없으면 -> false 반환
	}
	
	/** 2. 학생 전체 조회 서비스
	 * @return studentArr: Student[]
	 */
	public Student[] selectAll() {
		return studentArr; // studentArr를 반환
	}
	
	/** 3. 학생 정보 조회(인덱스)
	 * @param index: int
	 * 
	 * @return studentArr[index]: Student 참조변수
	 */
	public Student selectIndex(int index) {
		// ArrayIndexOutOfBoundsException 방지: 인덱스가 0~4 사이가 아닌 경우
		if(!(index>=0 && index<=studentArr.length-1)) {
			return null;
		}
		return studentArr[index];
	}
	
	/** 4. 학생 정보 조회(이름)
	 * @param inputName: String
	 * 
	 * @return resultArr: Student[] (조회된 학생이 없을 경우 null)
	 */
	public Student[] selectName(String inputName) {
		// 이름이 일치하는 학생 모두를 저장할 객체배열 선언 및 초기화
		Student[] resultArr = new Student[studentArr.length];
		// studentArr에서 이름이 일치하는 학생 찾기
		int index = 0; // resultArr에 값을 대입할 인덱스를 나타낸 변수
		for(int i=0; i<studentArr.length; i++) {
			
			// NullPointerException 방지: studentArr[i]가 null인지 검사
			if(studentArr[i] == null) {
				break;
			}
			
			if(studentArr[i].getName().equals(inputName)) {
				resultArr[index++] = studentArr[i]; // resultArr에 studentArr[i]의 주소 값을 대입(얕은 복사)
				// studentArr[i] 값 대입 후 index 값 증가(후위연산) == index++;
			}
		}
		// 이름이 일치하는 학생이 없어서 index가 증가하지 않았다면 null 반환
		if(index == 0) {
			return null;
		}
		return resultArr;
	}
	
	/** 5. 학생 정보 입력
	 * @param index: int
	 * @param kor: int
	 * @param eng: int
	 * @param math: int
	 * 
	 * @return 수정 성공시 true/실패시 false
	 */
	public boolean updateStudent(int index, int kor, int eng, int math) {
		if(!(index>=1 && index<=studentArr.length) || studentArr[index] == null) {
			return false; 
		}
		studentArr[index].setKor(kor);
		studentArr[index].setEng(eng);
		studentArr[index].setMath(math);
		return true;
	}
	
	/** 6. 합계, 평균, 최고점, 최저점
	 * @param sum: int
	 * @param avg: int
	 * @param max: int
	 * @param min: int
	 * 
	 * @return arr: int[](인덱스 순서: 합계, 평균, 최고점, 최저점)
	 */
	public int[] sumAvgMaxMin() {
		int[] arr = new int[4];
		
		int size = 0;
		for(int i=0; i<studentArr.length; i++) {
			if(studentArr[i] == null) break;
			else size++;
		}
		int[] sumArr = new int[size];
		
		int sum = 0;
		int totalSum = 0;
		int indexCount = 0;
		for(int index=0; index<studentArr.length; index++) {
			if(studentArr[index] == null) break;
			int kor = studentArr[index].getKor();
			int eng = studentArr[index].getEng();
			int math = studentArr[index].getMath();
			sum = (kor+eng+math);
			totalSum += sum;
			indexCount += 1;
			sumArr[index] = sum;
		}
		arr[0] = totalSum;
		arr[1] = totalSum/indexCount;
		
		int max = sumArr[0];
		int min = sumArr[0];
		for(int index=0; index<studentArr.length; index++) {
			if(studentArr[index] == null) break;
			if(max<=sumArr[index]) max = sumArr[index];
			if(min>=sumArr[index]) min = sumArr[index];			
		}
		arr[2] = max;
		arr[3] = min;
		
		return arr;
	}
}
