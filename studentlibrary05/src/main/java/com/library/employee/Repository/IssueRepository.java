package com.library.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.employee.Entity.Issue;


public interface IssueRepository extends JpaRepository<Issue, Long>{

	@Query(value = "SELECT * FROM issue WHERE issued_date BETWEEN (:start) AND (:end) AND book_id LIKE (:bookId) AND employee_code LIKE (:employeeid) " , nativeQuery = true)
	List<Issue> findIssuesByBookIdAndEmployeeIdAndIssuedDateRange(String start, String end, String bookId, String employeeid);

}
