/**
 * 
 */
package com.library.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.employee.Entity.Book;
import com.library.employee.Entity.Employee;
import com.library.employee.Entity.Issue;
import com.library.employee.Repository.BookRepository;
import com.library.employee.Repository.EmployeeRepository;
import com.library.employee.Repository.IssueRepository;

@Controller
public class ResourceController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
	@GetMapping("/")
	public String getMainDashboard(Model model) { 
		model.addAttribute("employeeCount", employeeRepository.count());
		model.addAttribute("bookCount", bookRepository.count());
		return "index.jsp";
	}
	
	@GetMapping("/bookManagementDashboard")
	public String getBookManagementDashboard(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("bookList", bookRepository.findAll());
		return "bookManagementDashboard.jsp";
	}
	
	@GetMapping("/employeeManagementDashboard")
	public String getEmployeeManagementDashboard(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", employeeRepository.findAll());
		return "employeeManagementDashboard.jsp";
	}
	
	@GetMapping("/issueManagementDashboard")
	public String getIssueManagementDashboard(Model model) {
		model.addAttribute("issue", new Issue());
		model.addAttribute("issueList", issueRepository.findAll());
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("employees", employeeRepository.findAll());
		return "issueManagementDashboard.jsp";
	}
	
//	@GetMapping("/returnBookManagementDashboard")
//	public String getReturnBookManagementDashboard(Model model) {
//		model.addAttribute("issue", new Issue());
//		model.addAttribute("issueList", issueRepository.findAll());
//		model.addAttribute("books", bookRepository.findAll());
//		model.addAttribute("employees", employeeRepository.findAll());
//		return "returnBookManagementDashboard.jsp";
//	}
	
	@GetMapping("/bookLoanReport")
	public String getBookLoanReport(Model model) { 
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("employees", employeeRepository.findAll());
		return "reports/bookLoanReport.jsp";
	}
	
	@GetMapping("/employeeFineReport")
	public String getEmployeeFineReport(Model model) { 
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("employees", employeeRepository.findAll());
		return "reports/employeeFineReport.jsp";
	}
	
}
