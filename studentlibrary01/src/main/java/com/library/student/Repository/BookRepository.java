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

import com.library.student.Entity.Book;
import com.library.student.datasource.Database;

//public interface BookRepository extends JpaRepository<Book, Long>{
@Component
public class BookRepository {

	public List<Book> findAll() {
		String sql = "SELECT * FROM book";
		Database database = new Database();
		Connection conn = database.getConnection();
		Statement statement;
		List<Book> bookList = new ArrayList<Book>();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				System.out.println(result);
				Book book= new Book();
				book.setId(result.getLong(1));
				book.setCategory(result.getString(2));
				book.setDescription(result.getString(3));
				book.setEdition(result.getString(4));
				book.setPrice(result.getString(5));
				book.setTitle(result.getString(6));
				book.setYear(result.getInt(7));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	public void save(Book book) {
		try {
			Database database = new Database();
			Connection conn = database.getConnection();
			String sql = "INSERT INTO book  (`id`, `category`, `description`, `edition`, `price`, `title`, `year` ) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, book.getId());
			statement.setString(2, book.getCategory());
			statement.setString(3, book.getDescription());
			statement.setString(4, book.getEdition());
			statement.setString(5, book.getPrice());
			statement.setString(6, book.getTitle());
			statement.setInt(7, book.getYear());
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
			String sql = "UPDATE book SET category=?, description=?, edition=? , price=?, title=?, year=? WHERE id=?";
			Database database = new Database();
			Connection conn = database.getConnection();
			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			statement.setString(1, book.getCategory());
			statement.setString(2, book.getDescription());
			statement.setString(3, book.getEdition());
			statement.setString(4, book.getPrice());
			statement.setString(5, book.getTitle());
			statement.setInt(6, book.getYear());  
			statement.setLong(7, book.getId());  
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing book was updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	public boolean existsById(Long id) {
		String sql = "SELECT * FROM book where id = "+id+"";
		Database database = new Database();
		Connection conn = database.getConnection();
		Statement statement;
		System.out.println(id);
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
			String sql = "DELETE FROM book WHERE id=?";
			 
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

}