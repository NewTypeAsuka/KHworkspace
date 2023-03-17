package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {
		
	public List<Employee2> select(String inputJobName) {
			
		List<Employee2> empList = new ArrayList<>();
		
		// 1단계
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// 2단계
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "kh_lsj";
			String pw = "oracle";
			
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
				
			String sql = "SELECT NVL(DEPT_TITLE, '부서없음') AS TITLE, JOB_NAME, EMP_NAME, EMAIL "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ "LEFT JOIN JOB USING (JOB_CODE) "
					+ "WHERE JOB_NAME = '" + inputJobName + "'"
					+ " ORDER BY EMP_NAME";
				
			rs = stmt.executeQuery(sql);
				
			// 3단계
			while(rs.next()) {
				String deptTitle = rs.getString("TITLE"); // 별칭으로 불러와도 상관 없음
				String jobName = rs.getString(2);
				String empName = rs.getString(3);
				String email = rs.getString(4);
				
				Employee2 emp = new Employee2(deptTitle, jobName, empName, email);
				
				empList.add(emp);
			}
				
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			// 4단계
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}
}
