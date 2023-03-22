package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	/**
	 * 1. 재직 중인 사원 전체 조회 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectAll() throws SQLException {
		
		Connection conn = getConnection();
		List<Emp> empList = dao.selectAll(conn);
		close(conn);
		
		return empList;
	}

	/**
	 * 2. 퇴직한 사원 전체 조회 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetiredAll() throws SQLException {

		Connection conn = getConnection();
		List<Emp> empList = dao.selectRetiredAll(conn);
		close(conn);
		
		return empList;
	}


	/**
	 * 3. 사번이 일치하는 사원 조회 서비스
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectOne(int input) throws SQLException {
		
		Connection conn = getConnection();
		Emp emp = dao.selectOne(conn, input);
		close(conn);
		
		return emp;
	}

	/**
	 * 4. 사원 정보 추가 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int insertEmployee(Emp emp) throws SQLException {
		
		Connection conn = getConnection();
		int result = dao.insertEmployee(conn, emp);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	/**
	 * 5. 사원 정보 수정 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmployee(Emp emp) throws SQLException {
		
		Connection conn = getConnection();
		int result = dao.updateEmployee(conn, emp);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	/**
	 * 6. 사원 정보 삭제 서비스
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int deleteEmployee(int input) throws SQLException {
		
		Connection conn = getConnection();
		int result = dao.deleteEmployee(conn, input);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	/**
	 * 7. 사번이 일치하는 사원 퇴직 처리 서비스
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int retireEmployee(int input) throws SQLException {
		
		Connection conn = getConnection();
		int result = dao.retireEmployee(conn, input);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
}
