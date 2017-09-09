package com.imcs.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.imcs.dao.DepartmentDao;
import com.imcs.dao.DeptDaoImpl;
import com.imcs.dao.EmployeeDao;
import com.imcs.dao.EmployeeDaoImpl;
import com.imcs.util.DaoConstants;

@Configuration
public class BeanConfig {

	@Bean
	public EmployeeDaoImpl getEmployeeDao() throws SQLException {
		EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
		employeeDao.setDataSourceDriverManager(dataSource());
		return employeeDao;
	}

	@Bean
	public DeptDaoImpl getDepartmentDao() throws SQLException {
		DeptDaoImpl deptDaoImpl = new DeptDaoImpl();
		deptDaoImpl.setDataSourceDriverManager(dataSource());
		return deptDaoImpl;
	}

	@Bean
	public DataSource dataSource() throws SQLException {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(DaoConstants.DAO_DRIVER);
		ds.setUsername(DaoConstants.DAO_UNAME);
		ds.setPassword(DaoConstants.DAO_PASSWORD);
		ds.setUrl(DaoConstants.DAO_URL);
		return ds;
	}

}
