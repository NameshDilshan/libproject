/**
 * 
 */
package com.library.student.Repository;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.library.student.Entity.Issue;
import com.library.student.datasource.Database;
import com.library.student.dto.IssueDto;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Component
public class IssueRepository{ 
	

	public List<IssueDto> findAll() { 
		List<IssueDto> issueList = new ArrayList<IssueDto>();
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("issue"); 
			FindIterable<Document> documents = collection.find();
			for(Document document : documents) { 
				IssueDto issue = new IssueDto();
				issue.setId(document.getLong(1));
				issue.setIssued_date(document.getString("issued_date"));
				issue.setDue_date(document.getString("due_date"));
				issue.setReturned_date(document.getString("returned_date"));
				issue.setFine(document.getString("fine"));
				issue.setStudent_regno(document.getString("student_regno"));
				issue.setStudent_name(document.getString("student_name"));
				issue.setBook_id(document.getString("book_id"));
				issue.setBook_name(document.getString("book_name")); 
				issueList.add(issue);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return issueList;
	} 
	

//	public List<> findAll() {
//		String sql = " SELECT " + 
//				"   i.*, student.name AS student_name, book.title AS book_name " + 
//				" FROM " + 
//				"	issue AS i " + 
//				"        INNER JOIN " + 
//				"    student ON i.student_regno = student.regno " + 
//				"        INNER JOIN " + 
//				"    book ON i.book_id = book.id; ";
//		Database database = new Database();
//		Connection conn = database.getConnection();
//		Statement statement;
//		
//		try {
//			statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//			while (result.next()) {
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return issueList;
//	}
	
	public void save(Issue issue) {
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("issue");
			Document document = new Document()
	                .append("id", issue.getId())
	                .append("issued_date", issue.getIssued_date())
	                .append("due_date", issue.getDue_date())
	                .append("returned_date", issue.getReturned_date())
	                .append("fine", issue.getFine())
	                .append("student_regno", issue.getStudent_regno())
	                .append("book_id", issue.getBook_id());
			collection.insertOne(document); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public void update(Issue issue) { 
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("issue");
			collection.updateOne(
		                eq("id", issue.getId()),
		                combine(
		                		set("issued_date", issue.getIssued_date()), 
		                		set("due_date", issue.getDue_date()),
		                		set("returned_date", issue.getReturned_date()), 
		                		set("fine", issue.getFine()),
		                		set("student_regno", issue.getStudent_regno()), 
		                		set("book_id", issue.getBook_id())
		                		)
		                ); 
		} catch (Exception e) {
			e.printStackTrace();
		}   
	} 
	
	public boolean existsById(Long id) { 
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("issue");
			FindIterable<Document> documents = collection.find(eq("id", id));
			for(Document document : documents) { 
				if(document.getLong("id") != null) {
					return true;
				}else {
					return false;
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	} 
	
	public void deleteById(Long id) {
		try { 
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("issue");
			collection.deleteOne(eq("id", id)); 
		} catch (Exception e) {
			e.printStackTrace();
		}   
	} 
	
//	public List<IssueDto> findReportDetails(String start, String end, String issueId, String studentid) {
//		String sql = " SELECT i.*, student.name AS student_name, book.title AS book_name " + 
//				" FROM issue AS i " + 
//				"        INNER JOIN " + 
//				"    student ON i.student_regno = student.regno " + 
//				"        INNER JOIN " + 
//				"    book ON i.book_id = book.id " +
//				" WHERE issued_date BETWEEN '"+start+"' AND '"+end+"' AND i.id LIKE '"+issueId+"' AND student_regno LIKE '"+studentid+"' ; ";
//		Database database = new Database();
//		Connection conn = database.getConnection();
//		Statement statement;
//		List<IssueDto> issueList = new ArrayList<IssueDto>();
//		try {
//			statement = conn.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//			while (result.next()) {
//				IssueDto issue = new IssueDto();
//				issue.setId(result.getLong(1));
//				issue.setIssued_date(result.getString("issued_date"));
//				issue.setDue_date(result.getString("due_date"));
//				issue.setReturned_date(result.getString("returned_date"));
//				issue.setFine(result.getString("fine"));
//				issue.setStudent_regno(result.getString("student_regno"));
//				issue.setStudent_name(result.getString("student_name"));
//				issue.setBook_id(result.getString("book_id"));
//				issue.setBook_name(result.getString("book_name")); 
//				issueList.add(issue);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return issueList;
//	}
	
}
