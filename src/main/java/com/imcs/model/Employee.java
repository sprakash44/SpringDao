package com.imcs.model;

import java.util.Date;

public class Employee {

	private int id;
	private int deptId;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private float salary;
	private int salaryGrade;
	// private String name;
	// private int age;

	// private String deptName;

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", deptId=" + deptId + ", dateOfBirth=" + dateOfBirth + ", dateOfJoining="
				+ dateOfJoining + ", salary=" + salary + ", salaryGrade=" + salaryGrade + "]";
	}

	public Employee(int id, int deptId, Date dateOfBirth, Date dateOfJoining, float salary, int salaryGrade) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.salary = salary;
		this.salaryGrade = salaryGrade;
	}

	/*
	 * public int getAge() { return age; }
	 * 
	 * public void setAge(int age) { this.age = age; }
	 */

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	/*
	 * public String getDeptName() { return deptName; }
	 * 
	 * public void setDeptName(String deptName) { this.deptName = deptName; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 */

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getSalaryGrade() {
		return salaryGrade;
	}

	public void setSalaryGrade(int salaryGrade) {
		this.salaryGrade = salaryGrade;
	}

}