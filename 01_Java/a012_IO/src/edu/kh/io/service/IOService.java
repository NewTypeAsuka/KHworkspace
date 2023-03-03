package edu.kh.io.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.io.dto.Student;

public class IOService {

	// 스트림(Stream): 데이터가 이동하는 통로(기본적으로 일방통행)
	// 바이트 기반 스트림:
	// - 1바이트 단위로 데이터를 입출력하는 스트림
	// - 1바이트 문자로 이루어진 텍스트(알파벳, 숫자, 키보드 특수문자)
	// - 이미지, 영상, 파일 등 문자가 아닌 파일
	// 문자 기반 스트림
	// - 문자 단위로 데이터를 입출력하는 스트림
	// - 문자로 이루어진 텍스트, 채팅, 코드
	
	private String content = "Hello World~~~\n" + 
							 "0987654321\n" + 
							 "월요일이 또 오겠죠\n" + 
							 "!@#$%^&*()";
	
	public void byteOutput() {
		// 바이트 기반 출력
		
		// finally에서도 해당 참조변수를 사용할 수 있도록 try 전에 스트림 참조변수 선언
		FileOutputStream fos = null;
		try {
//			fos = new FileOutputStream("byte/byteTest.txt", true); // 이어쓰기 옵션
			fos = new FileOutputStream("byte/byteTest.txt");
			// 프로그램에서 지정된 경로로 파일을 내보냄(출력) -> FileNotFoundException 발생 가능성
			// 만약 경로 제일 마지막에 작성한 파일이 존재하지 않으면 출력 구문 수행 시 자동 생성
			
			// c:\tools\eclipse [절대 경로: 절대적인 기준점을 기준으로 경로 작성]
			// byte/byteTest.txt [상대 경로: 현재 위치를 기준으로 경로 작성]
			
			// content에 작성된 문자를 하나씩 쪼개기
			for(int i=0; i<content.length(); i++) {
				char ch = content.charAt(i);
				
				fos.write(ch); // 프로그램이 txt 파일에 쓴다(출력)
			}
			System.out.println("바이트 기반 스트림 출력 완료");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				// NullPointerException 방지
				if(fos != null) fos.close(); // 스트림 내부 내용을 모두 밀어낸 후 닫음(메모리 반환)
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void charOutput() {
		// 문자 기반 출력
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("char/charTest.txt", true); // 이어쓰기 옵션
//			fw = new FileWriter("char/charTest.txt");
			
			// 문자열 content를 지정된 경로로 출력(쪼개서 출력 X)
			fw.write(content);
			System.out.println("문자 기반 스트림 출력 완료");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(fw != null) fw.close(); // 스트림 내부 내용을 모두 밀어낸 후 닫음(메모리 반환)
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void byteInput() {
		// 바이트 기반 입력
		
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream("char/charTest.txt"); // FileNotFoundException 발생 가능성
			
			int value = 0; // 파일에서 읽어온 바이트 하나를 저장할 변수
			while(true) { // 파일의 내용이 얼마나 있는지 모르기 때문에 일단 무한 반복
				try {
					value = fis.read(); // 다음 1바이트를 읽어와 int형으로 반환
					// 더 이상 읽어올 데이터가 없으면 -1 반환
				}catch(IOException e) {
					e.printStackTrace();
				}
				if(value == -1) break; // 파일을 다 읽어온 경우 반복을 멈춤
				System.out.print((char)value); // int -> char로 형변환해서 문자 형태로 출력
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally { // 스트림 닫기(메모리 반환)
			try {
				if(fis != null) fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void charInput() {
		// 문자 기반 입력
		
		FileReader fr = null;
		
		try {
			fr = new FileReader("char/charTest.txt");
			
			int value = 0; // 파일에서 문자를 하나씩 읽어와 저장
			while(true) {
				try {
					value = fr.read(); // 다음 1바이트를 읽어와 int형으로 반환
					// 더 이상 읽어올 데이터가 없으면 -1 반환
				}catch(IOException e) {
					e.printStackTrace();
				}
				if(value == -1) break;
				System.out.print((char)value);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr != null) fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileCopy() {
		// 어떤 형식의 파일이든 복사
		
		Scanner sc = new Scanner(System.in);
		
		// 바이트 기반 스트림 사용 -> 성능 향상을 위한 보조 스트림 함께 사용
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			System.out.print("복사할 파일의 경로: ");
			String target = sc.nextLine();
			
			System.out.print("복사된 파일의 경로 + 파일명: ");
			String copy = sc.nextLine();
			
					// 보조 스트림 + 기본 스트림 -> 보조 스트림으로 성능 향상
			bis = new BufferedInputStream(new FileInputStream(target)); // 복사 대상을 읽어올 스트림
			bos = new BufferedOutputStream(new FileOutputStream(copy)); // 복사된 파일을 출력할 스트림
			
			int value = 0;
			while(true) {
				value = bis.read(); // 읽어오기
				if(value == -1) break;
				
				bos.write(value); // 출력하기
			}
			System.out.println("복사 완료");
		}catch(FileNotFoundException e) {
			System.out.println("지정된 경로가 존재하지 않거나 파일이 없습니다");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("입출력 과정에서 문제가 발생했습니다");
			e.printStackTrace();
		}finally {
			try {
				if(bis != null) bis.close();
				if(bos != null) bos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void objectOutput() {
		// 객체 출력 보조 스트림
		
		// ObjectXXXStream: 객체를 파일 또는 네트워크를 통해 입출력할 수 있는 스트림
		// ObjectOutputStream: 객체를 바이트 기반 스트림으로 출력할 수 있게 하는 스트림
		// 			-> 조건: 출력하려는 객체의 직렬화 가능 여부를 나타내는 Serializable 인터페이스를 상속받아야 함
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream
					(new FileOutputStream("object/Student.txt"));
			
			// 내보낼 학생 객체 생성
			Student s = new Student("홍길동", 3, 5, 7, '남');
			
			// 학생 객체를 파일로 출력
			oos.writeObject(s);
			
			System.out.println("학생 출력 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos != null) oos.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void objectInput() {
		// 객체 입력 보조 스트림
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream
					(new FileInputStream("object/Student.txt"));
			// readObject(): 직렬화된 객체 데이터를 읽어와 역직렬화시켜 정상적인 객체 형태로 반환
			Student s = (Student)ois.readObject();
			System.out.println(s);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) ois.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void listOutput() {
		// List에 Student 객체를 담아서 파일로 출력
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream
					(new FileOutputStream("object/studentList.ini"));
			
			List<Student> list = new ArrayList<>();
			list.add(new Student("김하니", 1, 1, 1, '여'));
			list.add(new Student("김영희", 2, 2, 2, '여'));
			list.add(new Student("김사랑", 3, 3, 3, '여'));
			list.add(new Student("김철수", 4, 4, 4, '남'));
			
			// writeObject(객체): 출력하려는 객체는 직렬화가 가능해야만 한다(Serializable 인터페이스 구현 필수)
			// 컬렉션은 모두 직렬화가 가능하도록 Serializable 인터페이스 구현 O
			// 단 컬렉션에 저장하는 객체가 직렬화 가능하지 않다면 컬렉션도 직렬화 X(NotSerializableException 발생)
			oos.writeObject(list);
			
			System.out.println("학생 목록 출력 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos != null) oos.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void listInput() {
		// Student 객체를 담은 List를 파일로 입력
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream
					(new FileInputStream("object/studentList.ini"));
			
			List<Student> list = (List<Student>)ois.readObject();
			
			for(Student s : list) {
				System.out.println(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) ois.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
