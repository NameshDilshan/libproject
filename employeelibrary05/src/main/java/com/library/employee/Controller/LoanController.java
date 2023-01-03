/**
 * 
 */
package com.library.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.employee.Entity.Loan;
import com.library.employee.Repository.LoanRepo;

@Controller
public class LoanController {

	@Autowired
	private LoanRepo loanRepo;
	
	@PostMapping("/loanSave")
	public String loanSave(@ModelAttribute("loan") Loan loan, Model model) { 
		if(loanRepo.existsById(loan.getId())) {
			loanRepo.update(loan);
		}else {
			loanRepo.save(loan);
		}
		if(!loan.getReturneddate().isEmpty()) {
			return "redirect:/return";
		}
		return "redirect:/loan"; 
	}
	
	@DeleteMapping("/loans/{id}")
	@ResponseBody
	public Boolean deleteLoan(@PathVariable Long id , Model model) {  
		if(loanRepo.existsById(id)) {
			loanRepo.deleteById(id); 
			System.out.println(" Loan Deleted Successfully  ID : "+ id);
			return Boolean.TRUE;
		} 
		return Boolean.FALSE;
	} 
	
}
