package com.library.student.Entity;
import lombok.Data;
 
//@Entity
@Data
public class Student {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regno;
	private String name;
	private Integer age;
	private String grade;
	private String classname;
	private String gender;
	private String email;
	private String mobile; 
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Issue> issueList;
}
