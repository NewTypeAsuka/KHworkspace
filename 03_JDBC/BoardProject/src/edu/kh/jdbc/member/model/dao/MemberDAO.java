package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MemberDAO {

	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// XML에 작성된 SQL을 읽어와 저장할 객체 참조 변수
	private Properties prop;
	
	public MemberDAO() { // 기본 생성자로 객체 생성 시 XML 읽어오기
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
		} catch(Exception e) {
			
		}
	}

	/**
	 * 회원 목록 조회 결과 반환 메서드
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn) throws Exception {
		
		List<Member> memberList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectMemberList");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String memberId = rs.getString(1);
				String memberName = rs.getString(2);
				String memberGender = rs.getString(3);
				
				Member member = new Member(memberId, memberName, memberGender);
				memberList.add(member);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return memberList;
	}

	/**
	 * 회원 정보 수정 결과 반환 메서드
	 * @param conn
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, String memberName, 
			String memberGender, int memberNo) throws Exception {

		int result = 0;
		
		try {
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberGender);
			pstmt.setInt(3, memberNo);
			result = pstmt.executeUpdate();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	/**
	 * 비밀번호 변경 결과 반환 메서드
	 * @param conn
	 * @param oldPassword
	 * @param newPassword
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updatePassword(Connection conn, String oldPassword, 
			String newPassword, int memberNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updatePassword");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, memberNo);
			pstmt.setString(3, oldPassword);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 회원 탈퇴 결과 반환 메서드
	 * @param currPassword
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int unregister(Connection conn, String currPassword, int memberNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("unregister");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, currPassword);
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
