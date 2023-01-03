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

import com.library.employee.Entity.Emp;
import com.library.employee.Repository.EmpRepo;

@Controller
public class EmpController {

	@Autowired
	private EmpRepo empRepo;
	
	@PostMapping("/empSave")
	public String empSave(@ModelAttribute("employee") Emp emp, Model model) {  
		if(empRepo.existsById(emp.getEmpcode())) {
			empRepo.update(emp);
		}else {
			empRepo.save(emp); 	
		} 
		return "redirect:/employee";
	}
	
	@DeleteMapping("/employees/{id}")
	@ResponseBody
	public Boolean empDelete(@PathVariable Long id , Model model) {  
		if(empRepo.existsById(id)) {
			empRepo.deleteById(id);  
			return Boolean.TRUE;
		} 
		return Boolean.FALSE;
	} 
	
}
