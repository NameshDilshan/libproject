/**
 * 
 */
package com.library.student.dto;

import lombok.Data;

/**
 * @date 28 Dec 2022
 * @Project studentlibrary01
 * @user namesh_001543
 */
@Data
public class IssueDto {

	private Long id;
	private String issued_date;
	private String due_date;
	private String returned_date;
	private String fine;
	private String student_regno;
	private String student_name;
	private String book_id;
	private String book_name;
}
