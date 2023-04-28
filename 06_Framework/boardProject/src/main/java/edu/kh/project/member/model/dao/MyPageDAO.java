package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // 저장소(DB)와 관련된 클래스 + Bean 등록 (IOC, 스프링이 객체 관리)
public class MyPageDAO {
	
				// 등록된 bean 중 타입이 SqlSessionTemplate으로 일치하는 Bean을 주입(DI)
	@Autowired	// -> root-context.xml에 <bean> 작성
	private SqlSessionTemplate sqlSession;

	/**
	 * 회원 정보 수정
	 * @param updateMember
	 * @return result
	 */
	public int updateInfo(Member updateMember) {
		
		
		return sqlSession.update("myPageMapper.updateInfo", updateMember);
	}
}
