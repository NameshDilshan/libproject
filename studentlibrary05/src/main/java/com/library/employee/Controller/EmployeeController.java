package com.library.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.employee.Entity.Employee;
import com.library.employee.Repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/saveEmployeeObject")
	public String saveEmployeeObject(@ModelAttribute("emplyee") Employee employee, Model model) { 
		employeeRepository.save(employee); 
		return "redirect:/employeeManagementDashboard";
	}
	
	@DeleteMapping("/employees/{id}")
	@ResponseBody
	public Boolean deleteEmployee(@PathVariable Long id , Model model) {  
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);  
			return Boolean.TRUE;
		} 
		return Boolean.FALSE;
	} 
	
}
