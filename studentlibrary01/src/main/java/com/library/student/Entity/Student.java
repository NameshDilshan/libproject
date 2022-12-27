package com.library.student.Entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
 
@Entity
@Data
public class Student {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regno;
	private String name;
	private Integer age;
	private String grade;
	private String classname;
	private String gender;
	private String email;
	private String mobile; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Issue> issueList;
}
