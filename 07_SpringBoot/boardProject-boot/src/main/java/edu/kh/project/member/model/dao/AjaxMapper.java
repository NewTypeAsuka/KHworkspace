package edu.kh.project.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {

	// 이름으로 조회
	String selectNickname(String email);
	
	// 닉네임으로 전화번호 조회
	String selectMemberTel(String nickname);
	
	// 이메일 중복 검사
	int checkEmail(String email);
	
	// 닉네임 중복 검사
	int checkNickname(String nickname);
	
	// 이메일로 회원 정보 조회
	Member selectMember(String email);
	
	// 멤버 목록 조회
	List<Member> selectMemberList(String input);
}
