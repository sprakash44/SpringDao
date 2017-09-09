package com.imcs.dao;

import java.util.List;

import javax.sql.DataSource;

import com.imcs.model.Employee;

public interface EmployeeDao {
	//setDataSourceDriverManager(DataSource dataSourceDriverManager);
	List<Employee> getEmployeeWithDeptNo(int deptNo);

	Employee getEmployee(int empId);

	boolean deleteEmployee(int empId);

	boolean updateEmployee(int empno,Employee emp);

	int addEmployee(Employee emp);

}
