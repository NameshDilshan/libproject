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
public class Member {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empcode;
	private String name;
	private Integer age;
	private String department;
	private String designation;
	private String gender;
	private String email;
	private String mobile; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Issue> issueList;
}
