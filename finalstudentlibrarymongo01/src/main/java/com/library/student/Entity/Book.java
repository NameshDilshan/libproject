package com.library.student.Entity;

import lombok.Data;

//@Entity
@Data
public class Book {

//	@Id
	private Long id;

	private String title;
	private String description;
	private Integer year;
	private String edition;
	private String category;
	private String price;

//	@JsonIgnore
//	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Issue> issueList;

}
