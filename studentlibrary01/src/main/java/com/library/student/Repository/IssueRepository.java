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

import com.library.student.Entity.Issue;
import com.library.student.datasource.Database;
import com.library.student.dto.IssueDto;


//public interface IssueRepository extends JpaRepository<Issue, Long>{
@Component
public class IssueRepository{
//	@Query(value = "SELECT * FROM issue WHERE issued_date BETWEEN (:start) AND (:end) AND issue_id LIKE (:issueId) AND student_regno LIKE (:studentid) " , nativeQuery = true)
//	List<Issue> findIssuesByIssueIdAndStudentIdAndIssuedDateRange(String start, String end, String issueId, String studentid);

	public List<IssueDto> findAll() {
		String sql = " SELECT " + 
				"   i.*, student.name AS student_name, book.title AS book_name " + 
				" FROM " + 
				"	issue AS i " + 
				"        INNER JOIN " + 
				"    student ON i.student_regno = student.regno " + 
				"        INNER JOIN " + 
				"    book ON i.book_id = book.id; ";
		Database database = new Database();
		Connection conn = database.getConnection();
		Statement statement;
		List<IssueDto> issueList = new ArrayList<IssueDto>();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				IssueDto issue = new IssueDto();
				issue.setId(result.getLong(1));
				issue.setIssued_date(result.getString("issued_date"));
				issue.setDue_date(result.getString("due_date"));
				issue.setReturned_date(result.getString("returned_date"));
				issue.setFine(result.getString("fine"));
				issue.setStudent_regno(result.getString("student_regno"));
				issue.setStudent_name(result.getString("student_name"));
				issue.setBook_id(result.getString("book_id"));
				issue.setBook_name(result.getString("book_name")); 
				issueList.add(issue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return issueList;
	}
	
	
	public void save(Issue issue) {
		try {
			Database database = new Database();
			Connection conn = database.getConnection();
			String sql = "INSERT INTO issue  ( `issued_date`, `due_date`, `returned_date`, `fine`, `student_regno`, `book_id`) VALUES ( ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, issue.getIssued_date());
			statement.setString(2, issue.getDue_date());
			statement.setString(3, issue.getReturned_date());
			statement.setString(4, issue.getFine());
			statement.setString(5, issue.getStudent_regno());
			statement.setString(6, issue.getBook_id());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new Issue inserted successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Issue issue) { 
		try {
			String sql = "UPDATE issue SET issued_date=?, due_date=?, returned_date=? , fine=?, student_regno=?, book_id=? WHERE id=?";
			Database database = new Database();
			Connection conn = database.getConnection();
			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, issue.getIssued_date());
			statement.setString(2, issue.getDue_date());
			statement.setString(3, issue.getReturned_date());
			statement.setString(4, issue.getFine());
			statement.setString(5, issue.getStudent_regno());
			statement.setString(6, issue.getBook_id());
			statement.setLong(7, issue.getId());
			
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing issue was updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	
	public boolean existsById(Long id) {
		String sql = "SELECT * FROM issue where id = "+id+"";
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
			String sql = "DELETE FROM issue WHERE id=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id); 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Issue Deleted successfully!");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	public List<IssueDto> findReportDetails(String start, String end, String issueId, String studentid) {
		String sql = " SELECT i.*, student.name AS student_name, book.title AS book_name " + 
				" FROM issue AS i " + 
				"        INNER JOIN " + 
				"    student ON i.student_regno = student.regno " + 
				"        INNER JOIN " + 
				"    book ON i.book_id = book.id " +
				" WHERE issued_date BETWEEN '"+start+"' AND '"+end+"' AND i.id LIKE '"+issueId+"' AND student_regno LIKE '"+studentid+"' ; ";
		Database database = new Database();
		Connection conn = database.getConnection();
		Statement statement;
		List<IssueDto> issueList = new ArrayList<IssueDto>();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				IssueDto issue = new IssueDto();
				issue.setId(result.getLong(1));
				issue.setIssued_date(result.getString("issued_date"));
				issue.setDue_date(result.getString("due_date"));
				issue.setReturned_date(result.getString("returned_date"));
				issue.setFine(result.getString("fine"));
				issue.setStudent_regno(result.getString("student_regno"));
				issue.setStudent_name(result.getString("student_name"));
				issue.setBook_id(result.getString("book_id"));
				issue.setBook_name(result.getString("book_name")); 
				issueList.add(issue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return issueList;
	}
	
}
