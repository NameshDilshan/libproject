package com.library.employee.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Book {

	@Id
	private Long isbn;

	private String title; 
	private String authorname;
	private Integer year;
	private String edition;
	private String category;
	private String price;

//	@JsonIgnore
//	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Loan> loanList;

}
