package com.spring.hellospring.model.vo;



public class Employee {
	private String empNo, empName, email;
	private Department dept;
	

public Employee() {
	// TODO Auto-generated constructor stub
}

public Employee(String empNo, String empName, String email, Department dept) {
	super();
	this.empNo = empNo;
	this.empName = empName;
	this.email = email;
	this.dept = dept;
}

public String getEmpNo() {
	return empNo;
}

public void setEmpNo(String empNo) {
	this.empNo = empNo;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Department getDept() {
	return dept;
}

public void setDept(Department dept) {
	this.dept = dept;
}

@Override
public String toString() {
	return "Employee [empNo=" + empNo + ", empName=" + empName + ", email=" + email + ", dept=" + dept + "]";
}


}
	
	
	
