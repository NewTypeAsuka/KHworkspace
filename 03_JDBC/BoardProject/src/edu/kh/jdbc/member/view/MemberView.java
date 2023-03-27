package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.dto.Member;
import edu.kh.jdbc.member.model.service.MemberService;

/**
 * 회원 전용 화면
 * @author 이상준(https://github.com/NewTypeAsuka)
 */
public class MemberView {

	private Scanner sc = new Scanner(System.in);
	private MemberService service = new MemberService();
	
	/**
	 * 회원 기능 메뉴
	 */
	public void memberMenu() {
		
		int input = 0;
		
		do {
			try {
				System.out.println("\n===== 회원 기능 =====\n");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 회원 목록 조회");
				System.out.println("3. 내 정보 수정");
				System.out.println("4. 비밀번호 변경");
				System.out.println("5. 회원 탈퇴(보안코드, 비밀번호, UPDATE)");
				System.out.println("9. 메인 메뉴로 돌아가기");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n메뉴 선택: ");
				input = sc.nextInt();
				sc.nextLine();

				switch(input) {
				case 1: selectMyInfo(); break;
				case 2: selectMemberList(); break;
				case 3: updateMember(); break;
				case 4: updatePassword(); break;
				case 5: if(unregister()) return;
						break;
				case 9: System.out.println("\n===== 메인 메뉴로 돌아갑니다 =====\n"); break;
				case 0: System.out.println("\n=== 프로그램 종료 ===\n");
				// System.exit(): JVM 강제 종료 -> 매개변수는 기본이 0, 다른 숫자는 오류를 의미
					System.exit(0);
				default: System.out.println("\n*** 메뉴 번호만 입력해주세요 ***\n");
				}
			} catch(InputMismatchException e) {
				System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
				sc.nextLine();
				input = -1;
			}
		} while(input != 9);
	}
	
	/**
	 * 내 정보 조회
	 */
	private void selectMyInfo() {
		System.out.println("\n===== 내 정보 조회 =====\n");
		
		// 회원 번호, 아이디, 이름, 성별(남/여), 가입일
		// Session.loginMember 이용
		
		System.out.println("회원 번호: " + Session.loginMember.getMemberNo());
		System.out.println("아이디: " + Session.loginMember.getMemberId());
		System.out.println("이름: " + Session.loginMember.getMemberName());
		if(Session.loginMember.getMemberGender().equals("M")) System.out.println("성별: 남");
		else System.out.println("성별: 여");
		System.out.println("가입일: " + Session.loginMember.getEnrollDate());
	}
	
	/**
	 * 회원 목록 조회
	 */
	private void selectMemberList() {
		System.out.println("\n===== 회원 목록 조회 =====\n");
		
		try {
			// 회원 목록 조회 서비스 호출 후 결과 반환 받기
			List<Member> memberList = service.selectMemberList();
			
			if(memberList.isEmpty()) { // 조회 결과 X
				System.out.println("\n===== 조회 결과가 없습니다 =====\n");
				return;
			}
			
			for(int i=0; i<memberList.size(); i++) {
				System.out.printf("%d\t%s\t%s\t%s \n", 
						i+1, 
						memberList.get(i).getMemberId(),
						memberList.get(i).getMemberName(),
						memberList.get(i).getMemberGender());
			}
		} catch(Exception e) {
			System.out.println("\n***** 회원 목록 조회 중 예외 발생 *****\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * 내 정보 수정
	 */
	private void updateMember() {
		System.out.println("\n===== 내 정보 수정 =====\n");
		
		System.out.print("수정할 이름: ");
		String memberName = sc.next();
		String memberGender = null;
		while(true) {
			System.out.print("수정할 성별(M/F): ");
			memberGender = sc.next().toUpperCase();
			// Java의 char: 문자 1개 <> DB의 CHAR: 고정 길이 문자열(Java의 String)
		
			if(memberGender.equals("M") || memberGender.equals("F")) break;
			System.out.println("\n*** M 또는 F만 입력해주세요 ***\n");
		}
		try {
			int result = service.updateMember(memberName, memberGender, Session.loginMember.getMemberNo());
			// Session.loginMember.getMemberNo(): 로그인한 회원의 번호
			if(result > 0) {
				System.out.println("\n=== 수정되었습니다 ===\n");
				Session.loginMember.setMemberName(memberName);
				Session.loginMember.setMemberGender(memberGender);
			}
			else System.out.println("\n*** 수정 실패 ***\n");
		} catch(Exception e) {
			System.out.println("\n***** 내 정보 수정 중 예외 발생 *****\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * 비밀번호 변경
	 */
	private void updatePassword() {
		System.out.println("\n===== 비밀번호 변경 =====\n");
		
		Member member = new Member();
		String oldPassword = null;
		String newPassword = null;
		
		System.out.print("현재 비밀번호 입력: ");
		oldPassword = sc.next();
		while(true) {
			System.out.print("새 비밀번호 입력: ");
			newPassword = sc.next();
			System.out.print("비밀번호 확인: ");
			String checkPassword = sc.next();
			if(newPassword.equals(checkPassword)) break;
			else System.out.println("\n*** 새 비밀번호가 일치하지 않습니다 ***\n");
		}
		try {
			int result = service.updatePassword(oldPassword, newPassword, Session.loginMember.getMemberNo());
			if(result > 0) {
				System.out.println("\n=== 비밀번호가 변경되었습니다 ===\n");
			}
			else System.out.println("\n*** 현재 비밀번호가 일치하지 않습니다 ***\n");
		} catch(Exception e) {
			System.out.println("\n***** 비밀번호 변경 중 예외 발생 *****\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원 탈퇴
	 * @return boolean
	 */
	private boolean unregister() {
		System.out.println("\n===== 회원 탈퇴 =====\n");

		System.out.print("현재 비밀번호: ");
		String currPassword = sc.next();
		
		String code = service.createSecurityCode();
		System.out.printf("보안코드 입력 [%s]: ", code);
		String inputCode = sc.next();
		if(!inputCode.equals(code)) {
			System.out.println("\n*** 보안코드가 일치하지 않습니다 ***\n");
			return false;
		} 
		
		while(true) {
			System.out.print("\n=== 정말 탈퇴하시겠습니까?(Y/N) ===\n");
			char check = sc.next().toUpperCase().charAt(0);
			
			if(check == 'N') {
				System.out.println("\n*** 탈퇴 취소 ***\n");
				return false;
			}
			if(check == 'Y') break;
			System.out.println("\n*** Y 또는 N만 입력해주세요 ***\n");
		}
		
		try {
			int result = service.unregister(currPassword, Session.loginMember.getMemberNo());
			if(result > 0) {
				System.out.println("\n=== 회원 탈퇴되었습니다 ===\n");
				Session.loginMember = null; // 로그아웃
				return true;
			}
			else System.out.println("\n*** 현재 비밀번호가 일치하지 않습니다 ***\n");
		} catch (Exception e) {
			System.out.println("\n***** 회원 탈퇴 중 예외 발생 *****\n");
			e.printStackTrace();
		}
		return false;
	}
}
