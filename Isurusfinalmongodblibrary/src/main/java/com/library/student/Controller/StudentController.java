/**
 * 
 */
package com.library.student.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.student.Entity.Student;
import com.library.student.Repository.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/saveStudent")
	public String saveGuest(@ModelAttribute("student") Student student, Model model) {
		if(studentRepository.existsById(student.getRegno())) {
			studentRepository.update(student);
		}else {
			studentRepository.save(student);
		}
		return "redirect:/studentManagementDashboard";
	}
	
	@DeleteMapping("/students/{id}")
	@ResponseBody
	public Boolean deleteStudent(@PathVariable Long id , Model model) {  
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return Boolean.TRUE;
		} 
		return Boolean.FALSE;
	} 
	
}
