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
import com.library.employee.Repository.BookRepo;

@Controller
public class BookController {

	@Autowired
	private BookRepo bookRepo;
	
	@PostMapping("/bookSave")
	public String bookSave(@ModelAttribute("book") Book book, Model model) { 
		if(bookRepo.existsById(book.getIsbn())) {
			bookRepo.update(book);
		}else {
			bookRepo.save(book);
		} 
		return "redirect:/book";
	}
	
	@DeleteMapping("/books/{id}")
	@ResponseBody
	public Boolean bookDelete(@PathVariable Long id , Model model) {  
		if(bookRepo.existsById(id)) {
			bookRepo.deleteById(id);  
			return Boolean.TRUE;
		} 
		return Boolean.FALSE;
	} 
	
}
