package com.library.member.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.member.Entity.Book;
import com.library.member.Repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book, Model model) { 
		bookRepository.save(book); 
		return "redirect:/bookManagementDashboard";
	}
	
	@DeleteMapping("/books/{id}")
	@ResponseBody
	public Boolean deleteBook(@PathVariable Long id , Model model) {  
		if(bookRepository.existsById(id)) {
			bookRepository.deleteById(id);  
			return Boolean.TRUE;
		} 
		return Boolean.FALSE;
	} 
	
}
