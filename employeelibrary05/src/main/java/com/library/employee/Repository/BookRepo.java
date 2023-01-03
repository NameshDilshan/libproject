package com.library.employee.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.library.employee.Entity.Book;
import com.library.employee.database.Db;

//public interface BookRepository extends JpaRepository<Book, Long>{
@Component
public class BookRepo {

	public List<Book> findAll() {
		String sql = "SELECT * FROM book";
		Db db = new Db();
		Connection conn = db.getConnection();
		Statement statement;
		List<Book> bookList = new ArrayList<Book>();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) { 
				Book book= new Book();
				book.setIsbn(result.getLong("isbn"));
				book.setTitle(result.getString("title"));
				book.setAuthorname(result.getString("authorname"));
				book.setYear(result.getInt("year"));
				book.setEdition(result.getString("edition"));
				book.setCategory(result.getString("category"));
				book.setPrice(result.getString("price"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	public void save(Book book) {
		try {
			Db db = new Db();
			Connection conn = db.getConnection();
			String sql = "INSERT INTO book  (`isbn`, `title`, `authorname`, `year`, `edition`, `category`, `price` ) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, book.getIsbn());
			statement.setString(2, book.getTitle());
			statement.setString(3, book.getAuthorname());
			statement.setInt(4, book.getYear());
			statement.setString(5, book.getEdition());
			statement.setString(6, book.getCategory());
			statement.setString(7, book.getPrice());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new Book inserted successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Book book) { 
		try {
			String sql = "UPDATE book SET title=?, authorname=?, year=? , edition=?, category=?, price=? WHERE isbn=?";
			Db db = new Db();
			Connection conn = db.getConnection();
			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthorname());
			statement.setInt(3, book.getYear());
			statement.setString(4, book.getEdition());
			statement.setString(5, book.getCategory());
			statement.setString(6, book.getPrice());  
			statement.setLong(7, book.getIsbn());  
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing book was updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	public boolean existsById(Long isbn) {
		String sql = "SELECT * FROM book where isbn = "+isbn+"";
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
	
	public void deleteById(Long id) {
		try { 
			Db db = new Db();
			Connection conn = db.getConnection();
			String sql = "DELETE FROM book WHERE isbn=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id); 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Book Deleted successfully!");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}

	public String count() {
		String sql = "SELECT count(*) FROM book ";
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
