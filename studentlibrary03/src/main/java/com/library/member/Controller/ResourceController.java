/**
 * 
 */
package com.library.member.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.member.Entity.Book;
import com.library.member.Entity.Issue;
import com.library.member.Entity.Member;
import com.library.member.Repository.BookRepository;
import com.library.member.Repository.IssueRepository;
import com.library.member.Repository.MemberRepository;

@Controller
public class ResourceController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
	@GetMapping("/")
	public String getMainDashboard(Model model) { 
		model.addAttribute("memberCount", memberRepository.count());
		model.addAttribute("bookCount", bookRepository.count());
		return "index.jsp";
	}
	
	@GetMapping("/bookManagementDashboard")
	public String getBookManagementDashboard(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("bookList", bookRepository.findAll());
		return "bookManagementDashboard.jsp";
	}
	
	@GetMapping("/memberManagementDashboard")
	public String getMemberManagementDashboard(Model model) {
		model.addAttribute("member", new Member());
		model.addAttribute("memberList", memberRepository.findAll());
		return "memberManagementDashboard.jsp";
	}
	
	@GetMapping("/issueManagementDashboard")
	public String getIssueManagementDashboard(Model model) {
		model.addAttribute("issue", new Issue());
		model.addAttribute("issueList", issueRepository.findAll());
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("members", memberRepository.findAll());
		return "issueManagementDashboard.jsp";
	}
	
//	@GetMapping("/returnBookManagementDashboard")
//	public String getReturnBookManagementDashboard(Model model) {
//		model.addAttribute("issue", new Issue());
//		model.addAttribute("issueList", issueRepository.findAll());
//		model.addAttribute("books", bookRepository.findAll());
//		model.addAttribute("members", memberRepository.findAll());
//		return "returnBookManagementDashboard.jsp";
//	}
	
	@GetMapping("/bookLoanReport")
	public String getBookLoanReport(Model model) { 
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("members", memberRepository.findAll());
		return "reports/bookLoanReport.jsp";
	}
	
	@GetMapping("/memberFineReport")
	public String getMemberFineReport(Model model) { 
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("members", memberRepository.findAll());
		return "reports/memberFineReport.jsp";
	}
	
}
