package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * 1. 재직 중인 사원 전체 조회 결과 반환 메서드
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectAll(Connection conn) throws SQLException {
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, PHONE, EMAIL\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "LEFT JOIN JOB USING (JOB_CODE)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "ORDER BY JOB_CODE ASC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				
				Emp emp = new Emp();
				emp.setEmpId(Integer.parseInt(empId));
				emp.setEmpName(empName);
				emp.setDepartmentTitle(departmentTitle);
				emp.setJobName(jobName);
				emp.setPhone(phone);
				emp.setEmail(email);
				
				empList.add(emp);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}

	/**
	 * 2. 퇴직한 사원 전체 조회 결과 반환 메서드
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetiredAll(Connection conn) throws SQLException {

		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, PHONE, EMAIL, ENT_DATE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY ENT_DATE ASC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDate = rs.getString(5);
				
				Emp emp = new Emp();
				emp.setEmpId(Integer.parseInt(empId));
				emp.setEmpName(empName);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setEntDate(entDate);
				
				empList.add(emp);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}

	/**
	 * 3. 사번이 일치하는 사원 조회 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectOne(Connection conn, int input) throws SQLException {
		
		Emp emp = null;
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL, HIRE_DATE, ENT_YN\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "LEFT JOIN JOB USING (JOB_CODE)\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				Date hireDate = rs.getDate(8);
				String entYN = rs.getString(9);
				
				emp = new Emp();
				emp.setEmpId(Integer.parseInt(empId));
				emp.setEmpName(empName);
				emp.setDepartmentTitle(departmentTitle);
				emp.setJobName(jobName);
				emp.setSalary(salary);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setHireDate(hireDate);
				emp.setEntYN(entYN);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return emp;
	}

	/**
	 * 4. 사원 정보 추가 결과 반환 메서드
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int insertEmployee(Connection conn, Emp emp) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = "INSERT INTO EMPLOYEE\r\n"
					+ "VALUES (SEQ_EMP_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 5. 사원 정보 수정 결과 반환 메서드
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmployee(Connection conn, Emp emp) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = "UPDATE EMPLOYEE\r\n"
					+ "SET EMAIL = ?,\r\n"
					+ "PHONE = ?,\r\n"
					+ "SALARY = ?,\r\n"
					+ "BONUS = ?\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 6. 사원 정보 삭제 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int deleteEmployee(Connection conn, int input) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = "DELETE FROM EMPLOYEE\r\n"
					+ "WHERE EMP_ID = " + input;
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} finally {
			close(stmt);
		}
		return result;
	}

	/**
	 * 7. 사번이 일치하는 사원 퇴직 처리 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int retireEmployee(Connection conn, int input) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = "UPDATE EMPLOYEE\r\n"
					+ "SET ENT_YN = 'Y', ENT_DATE = SYSDATE\r\n"
					+ "WHERE EMP_ID = " + input;
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} finally {
			close(stmt);
		}
		return result;
	}
}
