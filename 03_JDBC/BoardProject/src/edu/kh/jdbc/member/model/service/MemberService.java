package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	/**
	 * 회원 목록 조회 서비스
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectMemberList() throws Exception {
		
		Connection conn = getConnection();
		List<Member> memberList = dao.selectMemberList(conn);
		close(conn);
		return memberList;
	}

	/**
	 * 회원 정보 수정 서비스
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(String memberName, String memberGender, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		int result = dao.updateMember(conn, memberName, memberGender, memberNo);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	/**
	 * 비밀번호 변경 서비스
	 * @param oldPassword
	 * @param newPassword
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updatePassword(String oldPassword, String newPassword, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		int result = dao.updatePassword(conn, oldPassword, newPassword, memberNo);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	/**
	 * 보안코드 생성 서비스
	 * @return code
	 */
	public String createSecurityCode() {
		
		StringBuffer code = new StringBuffer(); // StringBuffer: 가변성이 있음
		Random ran = new Random(); // 난수 생성 객체
		
		for(int i=0; i<6; i++) {
			int x = ran.nextInt(10); // 0 시아 10 미만 정수
			code.append(x); // StringBuffer 마지막 부분에 추가
		}
 		return code.toString(); // StringBuffer -> String으로 변환해서 반환
	}

	
	/**
	 * 회원 탈퇴 서비스
	 * @param currPassword
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int unregister(String currPassword, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		int result = dao.unregister(conn, currPassword, memberNo);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
