package com.library.employee.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
 
@Entity
@Data
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empcode;
	private String name;
	private Integer age;
	private String section;
	private String jobtitle;
	private String gender;
	private String email;
	private String mobile; 
	private String address;
	private String idnumber;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Loan> loanList;
}
