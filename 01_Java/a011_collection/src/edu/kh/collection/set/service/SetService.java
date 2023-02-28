package edu.kh.collection.set.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.list.dto.Student;

public class SetService {

	public void ex1() {
		// Set(집합)
		// - 순서를 유지하지 않음(인덱스 없음)
		// - 중복 데이터 저장 불가(같은 객체를 덮어씌움) -> null도 하나만 저장 가능
		
		// 대표적인 자식 클래스: HashSet, LinkedHashSet, TreeSet
		Set<String> set = new HashSet<>();
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("당근마켓");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		// 순서 유지 X
		
		set.add("라인");
		set.add("라인");
		set.add("라인");
		set.add("라인");
		set.add("라인");
		set.add("라인");
		set.add("라인");
		// 중복 저장 X
		
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		// null도 추가할 수 있지만 하나만 가능
		
//		System.out.println(set.toString());
		System.out.println(set);
		
		// boolean remove(Object o)
		// - set에 저장된 객체 중 같은 객체를 찾아서 제거
		// - 같은 객체가 있어서 제거되면 true / 아니면 false
		// - 같은 객체의 기준 == equals() -> true, hashCode() 같음
		
		if(set.remove("직방")) System.out.println("직방이 제거되었습니다");
		else System.out.println("직방이 존재하지 않습니다");
		System.out.println(set);
		
		if(set.remove("직방")) System.out.println("직방이 제거되었습니다");
		else System.out.println("직방이 존재하지 않습니다");
		System.out.println(set);
		
		System.out.println("-------------------------------");
		
		// set에 저장된 요소 하나씩 얻어오기
		// 1. Iterator(반복자)
		// - 코드 설명에 Iterator, iterable 단어가 포함되어 있다면 반복 접근이 가능하다고 판단
		// - 컬렉션에서 제공하는 컬렉션 객체의 요소를 반복 접근하는 객체
		
		Iterator<String> it = set.iterator();
		// set 객체에는 반복자 Iterator 객체가 붙어있다고 생각
		
		// hasNext(): 다음 꺼내올 객체가 존재하면 true, 아니면 false
		// next(): 다음 객체를 꺼내옴
		while(it.hasNext()) {
			String temp = it.next();
			System.out.println(temp);
		}
		System.out.println("-------------------------------");
		
		// 2. 향상된 for문 이용
		for(String s : set) {
			System.out.println(s);
		}
	}
	
	public void ex2() {
		// set이 저장된 객체가 중복임을 확인하는 방법
		// -> equals()를 통해 필드 값이 같으면 중복으로 판단 (equals() 오버라이딩 필수)
		
		// Hash가 붙은 set/map
		// - Hash가 붙은 이유: 속도 향상
		// (hashCode 오버라이딩 필수 -> equals()가 true일 때 hashCode도 같아야 함)
		// == Hash가 붙은 set/map은 hashCode()를 이용해서 중복 판단
		// 최종 결론: Hash가 붙은 set/map을 사용하려면 equals(), hashCode() 오버라이딩 필수
		
		Set<Student> set = new HashSet<>();
		
		set.add(new Student("홍길동", 1, 2, 3, "서울시 용산구", 'M', 50));
		set.add(new Student("홍길동", 1, 2, 3, "서울시 용산구", 'M', 50));
		set.add(new Student("홍길동", 1, 2, 3, "서울시 용산구", 'M', 50));
		// 중복 저장 X
		// equals(), hashCode() 오버라이딩 안하면 중복 저장
		
		for(Student s : set) {
			System.out.println(s);
		}
	}
	
	public void createLotto() {
		// 로또 번호 5세트 만들어서 출력하기
		List<Set<Integer>> lottoList = new ArrayList<>();
		
		Random random = new Random();
		
		for(int i=0; i<5; i++) {
//			Set<Integer> set = new HashSet<>(); // 검색 속도가 높은 set
			Set<Integer> set = new TreeSet<>(); // 정렬해서 출력하는 set 
			while(set.size() < 6) {
				set.add(random.nextInt(45)+1); // 1~45
			}
			lottoList.add(set);
		}
		for(Set<Integer> set : lottoList) System.out.println(set);
	}
}
