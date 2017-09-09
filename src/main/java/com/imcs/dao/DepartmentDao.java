package com.imcs.dao;

import java.util.List;

import com.imcs.model.Department;

public interface DepartmentDao {

	Department getDepartment(int deptNo);

	List<Department> getAllDepartments();

}
