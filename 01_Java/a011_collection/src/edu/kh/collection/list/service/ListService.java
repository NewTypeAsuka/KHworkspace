package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;

public class ListService {

	/* List: 자료들을 순차적으로 나열한 자료구조(배열과 비슷함)
	 * - 인덱스를 이용해서 순서를 유지
	 * - 순서 구분이 가능하기 때문에 중복되는 데이터를 저장할 수 있음
	 * 
	 * List 인터페이스를 구현한 대표적인 클래스
	 * - ArrayList, Vector, LinkedList
	 */
	
	public void ex1() {
		/* 컬렉션 특징
		 * 1) 크기 제약이 없다.
		 * 2) 추가, 삭제, 수정 등의 기능이 구현되어있다.
		 * 3) 여러 타입의 객체를 저장할 수 있다. -> Object 타입의 참조변수 묶음이라서
		 */
		
		// ** 컬렉션은 모두 java.util 패키지에 존재 **
		
//		ArrayList list = new ArrayList(); // 기본 생성자 -> 10칸짜리 생성
		ArrayList list = new ArrayList(3); // 매개변수 생성자 -> 3칸짜리 생성
		// -> 예상되는 데이터 수에 따라 생성자를 골라서 사용(생성자에 따라 메모리 효율 달라짐)
		
		// boolean add(E e): 리스트 마지막에 요소 추가
		// * E(Element): 요소(객체)를 의미하는 제네릭 표기법(오브젝트 타입으로 생각)
		list.add("문자열");
		list.add(123); // 객체로 Wrap되어서 Integer로 저장(AutoBoxing)
		list.add(3.14); // 객체로 Wrap되어서 Double로 저장(AutoBoxing)
		list.add("초과"); // list 범위 3 초과 -> 자동으로 크기 증가
		
		// void add(int index, E e): 원하는 인덱스 위치에 요소 추가
		list.add(1, "중간 삽입");
//		list.add(100, "100번 인덱스 추가 확인"); // 에러 -> 중간 삽입만 가능
		
		// E get(int index): 주어진 index의 요소를 반환
		// int size(): 리스트에 저장된 요소의 개수(length)
		System.out.println(list.get(3));
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
			
			// 컬렉션에서 여러 데이터 타입을 저장할 경우의 단점
			// - 각 요소마다 타입이 다르기 때문에 원하는 코드가 있을 경우 타입 검사와 다운 캐스팅이 강제됨
			if(list.get(i) instanceof String) {
				char ch = ((String)list.get(i)).charAt(0);
				System.out.println("ch: " + ch);
			}else if(list.get(i) instanceof Integer) {
				int max = ((Integer)list.get(i)).MAX_VALUE;
				System.out.println("max: " + max);
			}else if(list.get(i) instanceof Double) {
				double min = ((Double)list.get(i)).MIN_VALUE;
				System.out.println("min: " + min);
			}
		}
		System.out.println("------------");
	}
	
	public void ex2() {
		// 제네릭을 이용한 컬렉션 타입 체크
		// - <타입> 형식으로 작성
		
		List<String> list = new ArrayList<String>();
		// String으로 타입이 제한된 ArrayList 객체를 생성하여 부모 타입인 list로 참조
		
		// 컴파일 단계에서 타입 체크 -> 컬렉션에 사용되는 객체의 타입이 처음 지정된 타입과 같은지 확인, 자동으로 다운 캐스팅
		list.add("서울");
		list.add("도쿄");
		list.add("베이징");
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i); // 다운 캐스팅 필요 없음
			System.out.println(str.charAt(0));
		}
		System.out.println("------------");
		
		// 향상된 for문
		for(String s : list) {
			System.out.println(s);
		}
	}
}
