/**
 * 
 */
package com.library.employee.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.library.employee.Entity.Loan;
import com.library.employee.database.Db;
import com.library.employee.dto.LoanDto;

//public interface LoanRepository extends JpaRepository<Loan, Long>{
@Component
public class LoanRepo {

//		@Query(value = "SELECT * FROM loan WHERE loand_date BETWEEN (:start) AND (:end) AND book_id LIKE (:bookId) AND employee_regno LIKE (:employeeid) " , nativeQuery = true)
//		List<Loan> findLoansByBookIdAndEmployeeIdAndLoandDateRange(String start, String end, String bookId, String employeeid);

	public List<LoanDto> findAll() {
		String sql = " SELECT i.*, emp.name AS employeename, book.title AS bookname FROM loan AS i "
				+ " INNER JOIN emp ON i.empnumber = emp.empcode INNER JOIN book ON i.bookid = book.isbn; ";
		Db db = new Db();
		Connection conn = db.getConnection();
		Statement statement;
		List<LoanDto> loanList = new ArrayList<LoanDto>();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				LoanDto loan = new LoanDto();
				loan.setId(result.getLong("id"));
				loan.setLoandate(result.getString("loandate"));
				loan.setDuedate(result.getString("duedate"));
				loan.setReturneddate(result.getString("returneddate"));
				loan.setFine(result.getString("fine"));
				loan.setEmployeeno(result.getString("empnumber"));
				loan.setEmployeename(result.getString("employeename"));
				loan.setBookid(result.getString("bookid"));
				loan.setBookname(result.getString("bookname"));
				loanList.add(loan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loanList;
	}

	public void save(Loan loan) {
		try {
			Db db = new Db();
			Connection conn = db.getConnection();
			String sql = "INSERT INTO loan  ( `loandate`, `duedate`, `returneddate`, `fine`, `empnumber`, `bookid`) VALUES ( ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, loan.getLoandate());
			statement.setString(2, loan.getDuedate());
			statement.setString(3, loan.getReturneddate());
			statement.setString(4, loan.getFine());
			statement.setString(5, loan.getEmpnumber());
			statement.setString(6, loan.getBookid());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new Loan inserted successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Loan loan) {
		try {
			String sql = "UPDATE loan SET loandate=?, duedate=?, returneddate=? , fine=?, empnumber=?, bookid=? WHERE id=?";
			Db db = new Db();
			Connection conn = db.getConnection();
			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			statement.setString(1, loan.getLoandate());
			statement.setString(2, loan.getDuedate());
			statement.setString(3, loan.getReturneddate());
			statement.setString(4, loan.getFine());
			statement.setString(5, loan.getEmpnumber());
			statement.setString(6, loan.getBookid());
			statement.setLong(7, loan.getId());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing loan was updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean existsById(Long id) {
		String sql = "SELECT * FROM loan where id = " + id + "";
		Db db = new Db();
		Connection conn = db.getConnection();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (result.getString(1).isEmpty()) {
					return false;
				} else {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public LoanDto findById(Long id) {
		String sql = "SELECT * FROM loan where id = " + id + " LIMIT 1 ";
		Db db = new Db();
		Connection conn = db.getConnection();
		Statement statement;
		LoanDto loan = new LoanDto();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				loan.setId(result.getLong("id"));
				loan.setLoandate(result.getString("loandate"));
				loan.setDuedate(result.getString("duedate"));
				loan.setReturneddate(result.getString("returneddate"));
				loan.setFine(result.getString("fine"));
				loan.setEmployeeno(result.getString("empnumber"));
				loan.setEmployeename(result.getString("employeename"));
				loan.setBookid(result.getString("bookid"));
				loan.setBookname(result.getString("bookname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loan;
	}

	public void deleteById(Long id) {
		try {
			Db db = new Db();
			Connection conn = db.getConnection();
			String sql = "DELETE FROM loan WHERE id=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Loan Deleted successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<LoanDto> getReportSearchData(String start, String end, String bookId, String employeeid) {
		String sql = " SELECT i.*, emp.name AS employeename, book.title AS bookname FROM loan AS i "
				+ " INNER JOIN emp ON i.empnumber = emp.empcode INNER JOIN book ON i.bookid = book.isbn " 
				+ " WHERE loandate BETWEEN '" + start + "' AND '" + end
				+ "' AND i.bookid LIKE '" + bookId + "' AND empnumber LIKE '" + employeeid + "' ; ";
		Db db = new Db();
		Connection conn = db.getConnection();
		Statement statement;
		List<LoanDto> loanList = new ArrayList<LoanDto>();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				LoanDto loan = new LoanDto();
				loan.setId(result.getLong("id"));
				loan.setLoandate(result.getString("loandate"));
				loan.setDuedate(result.getString("duedate"));
				loan.setReturneddate(result.getString("returneddate"));
				loan.setFine(result.getString("fine"));
				loan.setEmployeeno(result.getString("empnumber"));
				loan.setEmployeename(result.getString("employeename"));
				loan.setBookid(result.getString("bookid"));
				loan.setBookname(result.getString("bookname"));
				loanList.add(loan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loanList;
	}

//	public List<LoanDto> getReportDetailsByDateAndBookEmployeeIds(String start, String end, String bookid, String employeeid) {
//		String sql = " SELECT i.*, employee.nicname AS employeename, book.title AS bookname FROM loan AS i "
//				+ "   INNER JOIN employee ON i.employeeno = employee.regno " + "	INNER JOIN book ON i.bookid = book.id "
//				+ " WHERE loandate BETWEEN '" + start + "' AND '" + end + "' AND i.bookid LIKE '" + bookid
//				+ "' AND employeeno LIKE '" + employeeid + "' ; ";
//		Db db = new Db();
//		Connection conn = db.getConnection();
//		Statement statement;
//		List<LoanDto> loanList = new ArrayList<LoanDto>();
//		try {
//			statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//			while (result.next()) {
//				LoanDto loan = new LoanDto();
//				loan.setId(result.getLong("id"));
//				loan.setLoandate(result.getString("loandate"));
//				loan.setDuedate(result.getString("duedate"));
//				loan.setReturndate(result.getString("returndate"));
//				loan.setFine(result.getString("fine"));
//				loan.setEmployeeno(result.getString("employeeno"));
//				loan.setEmployeename(result.getString("employeename"));
//				loan.setBookid(result.getString("bookid"));
//				loan.setBookname(result.getString("bookname"));
//				loanList.add(loan);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return loanList;
//	}

}
