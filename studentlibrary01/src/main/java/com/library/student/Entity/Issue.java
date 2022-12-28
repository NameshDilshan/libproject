package com.library.student.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String issued_date;
	private String due_date;
	private String returned_date;
	private String fine;
	
	private String student_regno;
	private String book_id;
	
//	@ManyToOne
//	private Book book;
	
//	@ManyToOne
//	private Student student;
}
