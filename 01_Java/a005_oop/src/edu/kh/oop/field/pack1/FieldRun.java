package edu.kh.oop.field.pack1;

import edu.kh.oop.field.pack2.FieldTest2;
import edu.kh.oop.field.pack2.FieldTest3; // 다른 패키지는 import 필요

public class FieldRun extends FieldTest3 { // 상속

	public static void main(String[] args) {
		
		// 클래스를 이용해서 객체(인스턴스) 생성
		
		// FieldTest1/2는 FieldRun과 같은 패키지 -> import 없이 사용 가능
		FieldTest1 f1 = new FieldTest1();
		FieldTest2 f2 = new FieldTest2();
		// FieldTest3은 FieldRun과 다른 패키지 -> import 필요
		FieldTest3 f3 = new FieldTest3();
		
		// 접근제한자 확인
		System.out.println(f1.v1); // public
		System.out.println(f1.v2); // protected
		System.out.println(f1.v3); // (default)
//		System.out.println(f1.v4); // private -> 다른 클래스라 사용 불가
		
		System.out.println(f2.v1); // public
//		System.out.println(f2.v2); // protected -> 다른 패키지라 사용 불가
//		System.out.println(f2.v3); // (default) -> 다른 패키지라 사용 불가
//		System.out.println(f2.v4); // private   -> 다른 클래스라 사용 불가
	}
	
	public void ex() {
		
		FieldTest3 t3 = new FieldTest3();
		
		System.out.println(t3.v1); // public
//		System.out.println(t3.v2); // protected -> 상속받으면 t3.은 필요 없음 
		System.out.println(v2);    // protected -> 상속받으면 FieldTest3의 필드를 FieldRun이 자신의 것처럼 사용 가능
//		System.out.println(t3.v3); // (default) -> 다른 패키지라 사용 불가
//		System.out.println(t3.v4); // private   -> 다른 클래스라 사용 불가
	}
}
