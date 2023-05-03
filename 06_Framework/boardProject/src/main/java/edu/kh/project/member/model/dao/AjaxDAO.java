package edu.kh.project.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // DB 연결 의미 + bean 등록 (IOC)
public class AjaxDAO {

	@Autowired // bean 중에서 타입이 같은 객체를 DI
	private SqlSessionTemplate sqlSession;

	public String selectNickname(String email) {
		return sqlSession.selectOne("ajaxMapper.selectNickname", email);
	}

	public String selectMemberTel(String nickname) {
		return sqlSession.selectOne("ajaxMapper.selectMemberTel", nickname);
	}

	public int checkEmail(String email) {
		return sqlSession.selectOne("ajaxMapper.checkEmail", email);
	}

	public int checkNickname(String nickname) {
		return sqlSession.selectOne("ajaxMapper.checkNickname", nickname);
	}

	public Member selectMember(String email) {
		return sqlSession.selectOne("ajaxMapper.selectMember", email);
	}

	public List<Member> selectMemberList(String input) {
		return sqlSession.selectList("ajaxMapper.selectMemberList", input);
	}

}