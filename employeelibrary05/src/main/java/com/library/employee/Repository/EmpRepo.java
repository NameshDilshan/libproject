package com.library.employee.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.library.employee.Entity.Emp;
import com.library.employee.database.Db;

//public interface EmpRepository extends JpaRepository<Emp, Long>{
@Component
public class EmpRepo{

	public List<Emp> findAll() {
		String sql = "SELECT * FROM emp";
		Db db = new Db();
		Connection conn = db.getConnection();
		Statement statement;
		List<Emp> employeeList = new ArrayList<Emp>();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) { 
				Emp employee= new Emp();
				employee.setEmpcode(result.getLong("empcode"));
				employee.setName(result.getString("name"));
				employee.setAge(result.getInt("age"));
				employee.setSection(result.getString("section"));
				employee.setJobtitle(result.getString("jobtitle"));
				employee.setGender(result.getString("gender"));
				employee.setEmail(result.getString("email"));
				employee.setMobile(result.getString("mobile"));  
				employee.setAddress(result.getString("address"));  
				employee.setIdnumber(result.getString("idnumber"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public void save(Emp employee) {
		try {
			Db db = new Db();
			Connection conn = db.getConnection();
			String sql = "INSERT INTO emp  (`empcode`,`name`,`age`,`section`,`jobtitle`,`gender`,`email`,`mobile`, `address`,`idnumber` ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, employee.getEmpcode());
			statement.setString(2, employee.getName());
			statement.setInt(3, employee.getAge());
			statement.setString(4, employee.getSection());
			statement.setString(5, employee.getJobtitle());
			statement.setString(6, employee.getGender()); 
			statement.setString(7, employee.getEmail());
			statement.setString(8, employee.getMobile());
			statement.setString(9, employee.getAddress());
			statement.setString(10, employee.getIdnumber());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new Emp inserted successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Emp employee) { 
		try {
			String sql = "UPDATE emp SET name=?, age=?, section=? , jobtitle=?, gender=?, email=?, mobile=?, address=?, idnumber=? WHERE empcode=?";
			Db db = new Db();
			Connection conn = db.getConnection();
			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			statement.setString(1, employee.getName());
			statement.setInt(2, employee.getAge());
			statement.setString(3, employee.getSection());
			statement.setString(4, employee.getJobtitle());
			statement.setString(5, employee.getGender());
			statement.setString(6, employee.getEmail());  
			statement.setString(7, employee.getMobile());
			statement.setString(8, employee.getAddress());
			statement.setString(9, employee.getIdnumber());  
			statement.setLong(10, employee.getEmpcode()); 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing emp was updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	public boolean existsById(Long empcode) {
		String sql = "SELECT * FROM emp where empcode = "+empcode+"";
		Db db = new Db();
		Connection conn = db.getConnection();
		Statement statement; 
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if(result.getString(1).isEmpty()) {
					return false;
				}else {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} 
	
	public void deleteById(Long empcode) {
		try { 
			Db db = new Db();
			Connection conn = db.getConnection();
			String sql = "DELETE FROM emp WHERE empcode=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, empcode); 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Emp Deleted successfully!");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	public String count() {
		String sql = "SELECT count(*) FROM emp ";
		Db db = new Db();
		Connection conn = db.getConnection();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if(result.getString("count(*)").isEmpty()) {
					return result.getString("count(*)");
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}

}
