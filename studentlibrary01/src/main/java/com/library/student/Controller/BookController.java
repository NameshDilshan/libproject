package com.library.student.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.student.Entity.Book;
import com.library.student.Repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book, Model model) { 
		System.out.println("Save Book Triggered");
		if(bookRepository.existsById(book.getId())) {
			bookRepository.update(book);
		}else {
			bookRepository.save(book);
		}
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
