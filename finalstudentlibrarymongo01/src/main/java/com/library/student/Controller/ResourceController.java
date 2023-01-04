/**
 * 
 */
package com.library.student.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.student.Entity.Book;
import com.library.student.Entity.Issue;
import com.library.student.Entity.Student;
import com.library.student.Repository.BookRepository;
import com.library.student.Repository.IssueRepository;
import com.library.student.Repository.StudentRepository;

@Controller
public class ResourceController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
	@GetMapping("/")
	public String getMainDashboard(Model model) { 
		return "redirect:bookManagementDashboard";
	}
	
	@GetMapping("/bookManagementDashboard")
	public String getBookManagementDashboard(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("bookList", bookRepository.findAll());
		return "bookManagementDashboard.jsp";
	}
	
	@GetMapping("/studentManagementDashboard")
	public String getStudentManagementDashboard(Model model) {
		model.addAttribute("student", new Student());
//		model.addAttribute("studentList", studentRepository.findAll());
		return "studentManagementDashboard.jsp";
	}
	
	@GetMapping("/issueManagementDashboard")
	public String getIssueManagementDashboard(Model model) {
		model.addAttribute("issue", new Issue());
//		model.addAttribute("issueList", issueRepository.findAll());
//		model.addAttribute("books", bookRepository.findAll());
//		model.addAttribute("students", studentRepository.findAll());
		return "issueManagementDashboard.jsp";
	} 
	
	@GetMapping("/bookLoanReport")
	public String getBookLoanReport(Model model) { 
//		model.addAttribute("books", bookRepository.findAll());
//		model.addAttribute("students", studentRepository.findAll());
		return "reports/bookLoanReport.jsp";
	}
	
	@GetMapping("/studentFineReport")
	public String getStudentFineReport(Model model) { 
//		model.addAttribute("books", bookRepository.findAll());
//		model.addAttribute("students", studentRepository.findAll());
		return "reports/studentFineReport.jsp";
	}
	
}
