package edu.kh.jsp.student.model.dto;

public class Student {
	private String studentNo;
	private String studentName;
	private String studentAddress;
	private String departmentName;
	
	public Student() {}
	
	public Student(String studentNo, String studentName, String studentAddress, String departmentName) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.departmentName = departmentName;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", departmentName=" + departmentName + "]";
	}
}
