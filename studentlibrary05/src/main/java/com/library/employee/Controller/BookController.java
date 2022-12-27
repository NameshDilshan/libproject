package com.library.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.employee.Entity.Book;
import com.library.employee.Repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/saveBookObject")
	public String saveBookObject(@ModelAttribute("book") Book book, Model model) { 
		bookRepository.save(book); 
		return "redirect:/bookManagementDashboard";
	}
	
	@DeleteMapping("/books/{id}")
	@ResponseBody
	public Boolean deleteBooks(@PathVariable Long id , Model model) {  
		if(bookRepository.existsById(id)) {
			bookRepository.deleteById(id);  
			return Boolean.TRUE;
		} 
		return Boolean.FALSE;
	} 
	
}
