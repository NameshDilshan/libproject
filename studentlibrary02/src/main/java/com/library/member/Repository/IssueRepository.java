/**
 * 
 */
package com.library.member.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.member.Entity.Issue;


public interface IssueRepository extends JpaRepository<Issue, Long>{

	@Query(value = "SELECT * FROM issue WHERE issued_date BETWEEN (:start) AND (:end) AND book_id LIKE (:bookId) AND member_regno LIKE (:memberid) " , nativeQuery = true)
	List<Issue> findIssuesByBookIdAndMemberIdAndIssuedDateRange(String start, String end, String bookId, String memberid);

}
