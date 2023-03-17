package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.kh.jdbc.dto.Employee1;

// DAO(Data Access Object): 데이터에 접근하기 위한 객체
// == DB 연결 역할 객체
public class SelectDepartmentTitleDAO {

	/** 부서명으로 사원 조회
	 * @param departmentTitle
	 * @return empList
	 */
	public List<Employee1> select(String departmentTitle) {
		
		// 조회 결과를 저장하고 반환할 때 사용할 List 생성
		List<Employee1> empList = new ArrayList<>();
		
		// 1단계: JDBC 객체 참조 변수 선언
		Connection conn = null; // 통로
		Statement stmt = null; // 컨테이너
		ResultSet rs = null; // 내용물
		
		// 2단계: 참조 변수에 알맞은 객체 대입
		try {
			// 메모리에 드라이버 객체 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";
			String user = "kh_lsj";
			String pw = "oracle";
			
			// Connection 생성
			conn = DriverManager.getConnection(type+ip+port+dbName, user, pw);
			
			
			// SQL 생성
			String condition = null;
			
			if(departmentTitle.equals("null")) {
				condition = "WHERE DEPT_TITLE IS NULL ";
			}else {
				condition = "WHERE DEPT_TITLE = '" + departmentTitle + "'";
			}
			
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE "
						+"FROM EMPLOYEE "
						+"LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
						+ condition
						+" ORDER BY EMP_ID";
			
			// Statement 생성
			stmt = conn.createStatement();
			
			// Select 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 3단계: SQL 수행 결과로 받환받은 ResultSet을
			//        첫번째 행부터 1행씩 접근하여 컬럼 값을 얻어와 출력
			while(rs.next()) {
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				int salary = rs.getInt(3);
				String title = rs.getString(4);
				
				// 조회된 컬럼 값을 Employee1 객체에 저장
				Employee1 emp = new Employee1(empId, empName, salary, title);
				
				// 컬럼 값이 저장된 객체를 empList에 추가
				empList.add(emp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4단계: 사용한 JDBC 객체 자원 반환
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return empList; // 조회 결과가 담긴 empList 반환
	}
}
