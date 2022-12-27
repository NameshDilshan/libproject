package com.library.member.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Book {

	@Id
	private Long id;

	private String title;
	private String description;
	private Integer year;
	private String edition;
	private String category;
	private String price;

	@JsonIgnore
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Issue> issueList;

}
