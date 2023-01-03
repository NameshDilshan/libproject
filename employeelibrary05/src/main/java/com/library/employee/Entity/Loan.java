package com.library.employee.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String loandate;
	private String duedate;
	private String returneddate;
	private String fine;
	
	private String empnumber;
	private String bookid;
	
//	@ManyToOne
//	private Book book;
	
//	@ManyToOne
//	private Employee employee;
}
