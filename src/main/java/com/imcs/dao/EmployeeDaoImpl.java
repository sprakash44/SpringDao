package com.imcs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.imcs.model.Employee;
import com.imcs.util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	DataSource dataSourceDriverManager;

	public void setDataSourceDriverManager(DataSource dataSourceDriverManager) {
		this.dataSourceDriverManager = dataSourceDriverManager;
	}

	// final static Logger logger=Logger.getLogger(EmployeeDaoImpl.class);
	public List<Employee> getEmployeeWithDeptNo(int deptNo) {
		// logger.info("get employees by age for dept"+deptNo);
		List<Employee> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = ConnectionFactory.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement("select * from emptable where deptno=?")) {
			ps.setInt(1, deptNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5),
						rs.getInt(6)));
			}

		} catch (Exception ex) {
			// logger.error(ex.getMessage());
		}
		return list;
	}

	@Override
	public Employee getEmployee(int empno) {
		ResultSet rs = null;
		Employee e = null;
		try (Connection conn = ConnectionFactory.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement("select * from emptable where empno=?")) {
			ps.setInt(1, empno);
			rs = ps.executeQuery();
			while (rs.next()) {
				e = new Employee(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5),
						rs.getInt(6));
			}

		} catch (Exception ex) {
			// logger.error(ex.getMessage());
		}
		return e;
	}

	@Override
	public boolean deleteEmployee(int empno) {
		int updCount = 0;
		try (Connection conn = ConnectionFactory.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement("delete from emptable where empno=?")) {
			ps.setInt(1, empno);
			updCount = ps.executeUpdate();
		} catch (Exception ex) {
			// logger.error(ex.getMessage());
		}
		return updCount > 0 ? true : false;
	}

	@Override
	public boolean updateEmployee(int empno,Employee emp) {
		int updCount = 0;
		try (Connection conn = ConnectionFactory.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement(
						"update emptable set deptno=?,DOB=?,DOJ=?,salary=?,salgrade=? where empno=?")) {
			System.out.println("hai im in update");
			ps.setInt(1, emp.getDeptId());
			ps.setDate(2, new Date(emp.getDateOfBirth().getTime()));
			ps.setDate(3, new Date(emp.getDateOfJoining().getTime()));
			ps.setFloat(4, emp.getSalary());
			ps.setInt(5, emp.getSalaryGrade());
			ps.setInt(6, empno);
			updCount = ps.executeUpdate();
		} catch (Exception ex) {
			// logger.error(ex.getMessage());
		}
		return updCount > 0 ? true : false;
	}

	@Override
	public int addEmployee(Employee emp) {
		int addCount = 0;
		int id = 0;
		try (Connection conn = ConnectionFactory.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement("insert into emptable values(?,?,?,?,?,?)")) {
			id = getNextEmpId();
			ps.setInt(1, id);
			ps.setInt(2, emp.getDeptId());
			ps.setDate(3, new Date(emp.getDateOfBirth().getTime()));
			ps.setDate(4, new Date(emp.getDateOfJoining().getTime()));
			ps.setFloat(5, emp.getSalary());
			ps.setInt(6, emp.getSalaryGrade());

			addCount = ps.executeUpdate();
		} catch (Exception ex) {
			// logger.error(ex.getMessage());
		}
		return addCount > 0 ? id : 0;
	}

	private int getNextEmpId() {
		int empId = 0;
		try (Connection conn = ConnectionFactory.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement("select max(empno) from emptable")) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				empId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// logger.error(e.getMessage());
		}
		return empId + 1;
	}

}
