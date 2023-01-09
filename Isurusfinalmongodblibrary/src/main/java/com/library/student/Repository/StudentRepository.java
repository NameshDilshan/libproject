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

import com.library.student.Entity.Student;
import com.library.student.datasource.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Component
public class StudentRepository{
	
	public List<Student> findAll() { 
		List<Student> studentList = new ArrayList<Student>();
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("student"); 
			FindIterable<Document> documents = collection.find();
			for(Document document : documents) {
				Student student= new Student();
				student.setRegno(document.getLong("regno"));
				student.setName(document.getString("name"));
				student.setAge(document.getInteger("age"));
				student.setGrade(document.getString("grade"));
				student.setClassname(document.getString("classname"));
				student.setGender(document.getString("gender"));
				student.setEmail(document.getString("email"));
				student.setMobile(document.getString("mobile"));
				studentList.add(student);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return studentList;
	} 
	
	public void save(Student student) {
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("student");
			Document document = new Document()
	                .append("regno", student.getRegno())
	                .append("name", student.getName())
	                .append("age", student.getAge())
	                .append("grade", student.getGrade())
	                .append("classname", student.getClassname())
	                .append("gender", student.getGender())
	                .append("email", student.getEmail())
	                .append("mobile", student.getMobile());
			collection.insertOne(document); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public void update(Student student) { 
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("student");
			collection.updateOne(
		                eq("regno", student.getRegno()),
		                combine(
		                		set("name", student.getName()), 
		                		set("age", student.getAge()),
		                		set("grade", student.getGrade()), 
		                		set("classname", student.getClassname()),
		                		set("gender", student.getGender()), 
		                		set("email", student.getEmail()),
		                		set("mobile", student.getMobile()) 
		                		)
		                ); 
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}

	public boolean existsById(Long regno) { 
		try {
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("student");
			FindIterable<Document> documents = collection.find(eq("regno", regno));
			for(Document document : documents) { 
				if(document.getLong("regno") != null) {
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

	public void deleteById(Long regno) {
		try { 
			Database database = new Database();
			MongoDatabase mongoDatabase = database.getCollection();
			MongoCollection<Document> collection = mongoDatabase.getCollection("student");
			collection.deleteOne(eq("regno", regno)); 
		} catch (Exception e) {
			e.printStackTrace();
		}   
	} 
}