package edu.kh.oop.method.service;

// 기능 제공용 객체를 만들기 위한 클래스 -> 비즈니스 로직 작성
// 비즈니스 로직: 아메리카노는 출력 값이고 아메리카노를 만들기 위한 작업이 비즈니스 로직
public class MethodExService {

	// 2. 매개변수 O, 반환 값 X
	// void: 반환 값 없음
	// 매개변수: 전달받은 값을 저장할 변수
	public void threeNumbersSumAndAverage(int a, int b, int c) { // 세 숫자의 합계와 평균
		
		int sum = a + b + c;
		double avg = sum / 3.0;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("합계: " + sum);
		System.out.println("평균: " + avg);
	}
	
	// 3. 매개변수 X, 반환 값 O
	// int[]: return으로 반환하는 자료형 작성
	public int[] fiveRandomNumbers() {
		
		int[] arr = new int[5];
		for (int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1); // 1~10 난수를 배열 요소에 저장
		}
		return arr; // return: 로직 처리 완료 후 호출된 곳으로 돌아가라는 명령어
					// 돌아갈 때 가지고 갈 값이 있으면 return 옆에 작성(arr)
	}
	
	// 4. 매개변수 O, 반환 값 O
	// String: return으로 반환하는 자료형 작성
	public String calcalate(int num1, int num2, String op) { // 메서드 이름은 동사로 쓰는 것이 원칙
						  // 매개변수를 일치시켜 이해도 향상 -> 단 변수명이 같다고 해서 같은 변수는 아님
		String result = null; // String은 참조형 -> 주소 저장(null == 참조하는 것이 없다 != 비어있음)
		
		// *********************************************************************************
		// 참조형을 비교할 때 값이 아닌 주소를 비교한다(op == "/"는 0x100 == 0x200으로 비교 -> false)
		// 해결방법: 참조형의 값 자체를 비교하는 equals() 사용
		// boolean a.equals(b) -> a와 b가 참조하는 객체의 값이 같다면 true, 아니면 false
		// *********************************************************************************
		if(num2 == 0 && (op.equals("/") || op.equals("%"))) { // 두번째 숫자가 0이고 연산자가 / 또는 %인 경우
			result = "0으로 나눌 수 없습니다";
			return result;
			// *********************************************************************************
			// 코드 수행 중 return을 만나면 뒤에 코드로 넘어가지 않고 메서드 종료 후 호출한 곳으로 돌아감
			// *********************************************************************************
		}
		switch(op) {
		// String.format("패턴", 변수): 패턴 형태의 문자열을 반환(printf의 반환 버전)
		case "+": result = String.format("%d %s %d = %d", num1, op, num2, (num1+num2)); break;
		case "-": result = String.format("%d %s %d = %d", num1, op, num2, (num1-num2)); break;
		case "*": result = String.format("%d %s %d = %d", num1, op, num2, (num1*num2)); break;
		case "/": result = String.format("%d %s %d = %d", num1, op, num2, (num1/num2)); break;
		case "%": result = String.format("%d %s %d = %d", num1, op, num2, (num1%num2)); break;
		default: result = "연산 기호가 잘못 입력되었습니다";
		}
		return result;
	}
}
