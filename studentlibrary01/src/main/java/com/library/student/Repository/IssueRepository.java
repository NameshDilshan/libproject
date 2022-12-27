/**
 * 
 */
package com.library.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.student.Entity.Issue;


public interface IssueRepository extends JpaRepository<Issue, Long>{

	@Query(value = "SELECT * FROM issue WHERE issued_date BETWEEN (:start) AND (:end) AND book_id LIKE (:bookId) AND student_regno LIKE (:studentid) " , nativeQuery = true)
	List<Issue> findIssuesByBookIdAndStudentIdAndIssuedDateRange(String start, String end, String bookId, String studentid);

}
