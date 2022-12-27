package com.library.member.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.member.Entity.Issue;
import com.library.member.Repository.IssueRepository;

@RestController	
public class ReportController {

	@Autowired
	private IssueRepository issueRepository;
	
	@PostMapping("/findIssuesByBookIdAndMemberIdAndIssuedDateRange")
	public List<Issue> getFindIssuesByBookIdAndMemberIdAndIssuedDateRange(
			@RequestParam(name = "start", required = false, defaultValue = "1996-12-15") String start,
			@RequestParam(name = "end", required = false, defaultValue = "2996-12-15") String end,
			@RequestParam(name = "book", required = false, defaultValue = "%") String bookId,
			@RequestParam(name = "member", required = false, defaultValue = "%") String memberId
			){ 
		return issueRepository.findIssuesByBookIdAndMemberIdAndIssuedDateRange(start, end, bookId, memberId);
	}
}
