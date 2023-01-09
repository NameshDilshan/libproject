package com.library.student.Entity;

import lombok.Data;

//@Entity
@Data
public class Issue {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String issued_date;
	private String due_date;
	private String returned_date;
	private String fine;
	private String student_regno;
	private String book_id;
}
