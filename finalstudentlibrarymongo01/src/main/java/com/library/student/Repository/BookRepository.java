package com.library.student.Repository;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.library.student.Entity.Book;
import com.library.student.datasource.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase; 

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

@Component
public class BookRepository {

	public List<Book> findAll() { 
		List<Book> bookList = new ArrayList<Book>();
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("book"); 
			FindIterable<Document> documents = collection.find();
			for(Document document : documents) {
				Book book= new Book();
				book.setId(document.getLong("id"));
				book.setCategory(document.getString("category"));
				book.setDescription(document.getString("description"));
				book.setEdition(document.getString("edition"));
				book.setPrice(document.getString("price"));
				book.setTitle(document.getString("title"));
				book.setYear(document.getInteger("year"));
				bookList.add(book);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return bookList;
	}

	public void save(Book book) {
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("book");
			Document document = new Document()
	                .append("id", book.getId())
	                .append("category", book.getCategory())
	                .append("description", book.getDescription())
	                .append("edition", book.getEdition())
	                .append("price", book.getPrice())
	                .append("title", book.getTitle())
	                .append("year", book.getYear());
			collection.insertOne(document); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Book book) { 
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("book");
			collection.updateOne(
		                eq("id", book.getId()),
		                combine(
		                		set("category", book.getCategory()), 
		                		set("description", book.getDescription()),
		                		set("edition", book.getEdition()), 
		                		set("price", book.getPrice()),
		                		set("title", book.getTitle()), 
		                		set("year", book.getYear()) 
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
			MongoCollection<Document> collection = mongoDatabase.getCollection("book");
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
			MongoCollection<Document> collection = mongoDatabase.getCollection("book");
			collection.deleteOne(eq("id", id)); 
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}

}