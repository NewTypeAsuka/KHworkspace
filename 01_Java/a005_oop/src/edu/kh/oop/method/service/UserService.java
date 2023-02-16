package edu.kh.oop.method.service;

import edu.kh.oop.method.dto.User;
import edu.kh.oop.method.view.UserView;

public class UserService {

	// 1. 회원가입
	public User signUp(String userId, String userPw, String userPwConfirm, String userName, char userGender) {
		// 전달받은 값 중 비밀번호, 비밀번호 확인이 일치할 경우 User 객체를 생성해서 주소 반환
		// 일치하지 않는 경우 null 반환
		User user = null; // 아무것도 참조하지 않음
		if(userPw.equals(userPwConfirm)) {
			user = new User(userId, userPw, userName, userGender);
			// User 객체 생성 후 주소를 user에 저장
		}
		return user; // 주소 또는 null 반환
	}
	
	// 2. 로그인
	public void login(String userId, String userPw, User signUpUser) {
		boolean idCheck = userId.equals(signUpUser.getUserId()); // 아이디 일치 여부 검사
		boolean pwCheck = userPw.equals(signUpUser.getUserPw()); // 비밀번호 일치 여부 검사
		if(idCheck && pwCheck) { // 아이디와 비밀번호 모두 일치하는 경우 로그인 처리
			//UserView에 있는 클래스 변수(static) loginUser에 가입한 회원의 정보를 가지고 있는 객체의 주소를 대입
			UserView.loginUser = signUpUser;
		}
	}
	
	// 5. 회원정보 수정
		public boolean userUpdate(String userName, char userGender, String userPw) {
			if(!UserView.loginUser.getUserPw().equals(userPw)) { // 비밀번호가 일치하지 않은 경우(논리 부정 연산자)
				return false;
			}
			UserView.loginUser.setUserName(userName); // 비밀번호가 일치할 경우 -> 로그인한 User 정보에 전달받은 값 세팅
			UserView.loginUser.setUserGender(userGender);
			return true; // 얕은 복사라 signUpUser가 아닌 loginUser로 해도 가능
	}
}
