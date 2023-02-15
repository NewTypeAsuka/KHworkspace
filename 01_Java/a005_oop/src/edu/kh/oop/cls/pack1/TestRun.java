package edu.kh.oop.cls.pack1;
import edu.kh.oop.cls.pack2.*; // import 후 public으로 Test2 접근 가능

public class TestRun {

	public static void main(String[] args) {
		
		// Test1 클래스를 이용해서 객체 생성
		Test1 t1 = new Test1();
		// Stack 영역과 Heap 영역 할당 연결
		
		// Test2 클래스를 이용해서 객체 생성
		Test2 t2 = new Test2();
		// Test2의 접근 제한자가 default면 다른 패키지에서 접근 불가
		
		t1.testMethod1();
		t2.testMethod2();
	}
}

// 하나의 java 파일 하나에 여러 class 작성 가능
class Test3 {
	// 내부 클래스: 클래스 안에 클래스 작성 가능
	class Test4 {
		
	}
}
