package com.imcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.imcs.model.Department;
import com.imcs.util.ConnectionFactory;

public class DeptDaoImpl implements DepartmentDao {
	Department department;
	@Autowired
	DataSource dataSourceDriverManager;
	public DataSource getDataSourceDriverManager() {
		return dataSourceDriverManager;
	}

	public void setDataSourceDriverManager(DataSource dataSourceDriverManager) {
		this.dataSourceDriverManager = dataSourceDriverManager;
	}

	@Override
	public Department getDepartment(int deptNo) {
		// TODO Auto-generated method stub
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con.prepareStatement("select * from dept where dnum = ?")) {
			stmt.setInt(1, deptNo);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				department = new Department(deptNo, rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> deptList = new ArrayList<>();
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con.prepareStatement("select * from dept")) {
			// TODO Auto-generated method stub
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				department = new Department(rs.getInt(1), rs.getString(2));
				deptList.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Entered to getAllDepartments"+deptList);
		return deptList;
	}

}
