/**
 * 
 */
package com.library.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.employee.Entity.Book;
import com.library.employee.Entity.Emp;
import com.library.employee.Entity.Loan;
import com.library.employee.Repository.BookRepo;
import com.library.employee.Repository.EmpRepo;
import com.library.employee.Repository.LoanRepo;

@Controller
public class ResourceController {

	@Autowired
	private BookRepo bookRepo; 
	@Autowired
	private EmpRepo empRepo; 
	@Autowired
	private LoanRepo loanRepo;
	
	@GetMapping("/")
	public String getMainDashboard(Model model) { 
		model.addAttribute("employeeCount", empRepo.count());
		model.addAttribute("bookCount", bookRepo.count());
		return "index.jsp";
	}
	
	@GetMapping("/book")
	public String book(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("bookList", bookRepo.findAll());
		return "book.jsp";
	}
	
	@GetMapping("/employee")
	public String employee(Model model) {
		model.addAttribute("employee", new Emp());
		model.addAttribute("employeeList", empRepo.findAll());
		return "employee.jsp";
	}
	
	@GetMapping("/loan")
	public String loan(Model model) {
		model.addAttribute("loan", new Loan());
		model.addAttribute("loanList", loanRepo.findAll());
		model.addAttribute("books", bookRepo.findAll());
		model.addAttribute("employees", empRepo.findAll());
		return "loan.jsp";
	}
	
	@GetMapping("/return")
	public String returnBook(Model model) {
		model.addAttribute("loan", new Loan());
		model.addAttribute("loanList", loanRepo.findAll());
		model.addAttribute("books", bookRepo.findAll());
		model.addAttribute("employees", empRepo.findAll());
		return "return.jsp";
	}
	
	
//	@GetMapping("/returnBookManagementDashboard")
//	public String getReturnBookManagementDashboard(Model model) {
//		model.addAttribute("loan", new Loan());
//		model.addAttribute("loanList", loanRepo.findAll());
//		model.addAttribute("books", bookRepo.findAll());
//		model.addAttribute("employees", empRepo.findAll());
//		return "returnBookManagementDashboard.jsp";
//	}
	
	@GetMapping("/bookLoanReport")
	public String getBookLoanReport(Model model) { 
		model.addAttribute("books", bookRepo.findAll());
		model.addAttribute("employees", empRepo.findAll());
		return "reports/bookLoanReport.jsp";
	}
	
	@GetMapping("/employeeFineReport")
	public String getEmpFineReport(Model model) { 
		model.addAttribute("books", bookRepo.findAll());
		model.addAttribute("employees", empRepo.findAll());
		return "reports/employeeFineReport.jsp";
	}
	
}
