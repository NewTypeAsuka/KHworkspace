package edu.kh.project.member.model.service;

public interface AjaxService {

	/**
	 * 이메일로 닉네임 조회
	 * @param email
	 * @return nickname
	 */
	String selectNickname(String email);

	/**
	 * 닉네임으로 전화번호 조회
	 * @param nickname
	 * @return tel
	 */
	String selectMemberTel(String nickname);

	/**
	 * 이메일 중복 확인
	 * @param email
	 * @return count(1/0)
	 */
	int checkEmail(String email);

	/**
	 * 닉네임 중복 확인
	 * @param nickname
	 * @return count(1/0)
	 */
	int checkNickname(String nickname);

}
