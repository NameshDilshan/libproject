/**
 * 
 */
package com.library.student.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.library.student.Entity.Student;
import com.library.student.datasource.Database;


//public interface StudentRepository extends JpaRepository<Student, Long>{
@Component
public class StudentRepository{
	
	public List<Student> findAll() {
		String sql = "SELECT * FROM student";
		Database database = new Database();
		Connection conn = database.getConnection();
		Statement statement;
		List<Student> studentList = new ArrayList<Student>();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				Student student= new Student();
				student.setRegno(result.getLong("regno"));
				student.setName(result.getString("name"));
				student.setAge(result.getInt("age"));
				student.setGrade(result.getString("grade"));
				student.setClassname(result.getString("classname"));
				student.setGender(result.getString("gender"));
				student.setEmail(result.getString("email"));
				student.setMobile(result.getString("mobile"));
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public void save(Student student) {
		try {
			Database database = new Database();
			Connection conn = database.getConnection();
			String sql = "INSERT INTO student  (`regno`, `name`, `age`, `grade`, `classname`, `gender`, `email` , `mobile` ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, student.getRegno());
			statement.setString(2, student.getName());
			statement.setInt(3, student.getAge());
			statement.setString(4, student.getGrade());
			statement.setString(5, student.getClassname());
			statement.setString(6, student.getGender());
			statement.setString(7, student.getEmail());
			statement.setString(8, student.getMobile());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new Student inserted successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Student student) { 
		try {
			String sql = "UPDATE student SET name=?, age=?, grade=? , classname=?, gender=?, email=?, mobile=? WHERE regno=?";
			Database database = new Database();
			Connection conn = database.getConnection();
			PreparedStatement statement;
			statement = conn.prepareStatement(sql); 
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
			statement.setString(3, student.getGrade());
			statement.setString(4, student.getClassname());
			statement.setString(5, student.getGender());
			statement.setString(6, student.getEmail());
			statement.setString(7, student.getMobile());
			statement.setLong(8, student.getRegno());  
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing student was updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	public boolean existsById(Long regno) {
		String sql = "SELECT * FROM student where regno = "+regno+"";
		Database database = new Database();
		Connection conn = database.getConnection();
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
	
	public void deleteById(Long id) {
		try { 
			Database database = new Database();
			Connection conn = database.getConnection();
			String sql = "DELETE FROM student WHERE id=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id); 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Student Deleted successfully!");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
}
