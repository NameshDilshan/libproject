package com.library.employee.dto;

import lombok.Data;

@Data
public class LoanDto {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String loandate;
	private String duedate;
	private String returneddate;
	private String fine;
	
	private String employeeno;
	private String employeename;
	private String bookid;
	private String bookname;
	
	
}
