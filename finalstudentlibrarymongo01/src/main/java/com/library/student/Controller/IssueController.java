///**
// * 
// */
//package com.library.student.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.library.student.Entity.Issue;
//import com.library.student.Repository.IssueRepository;
//
//@Controller
//public class IssueController {
//
//	@Autowired
//	private IssueRepository issueRepository;
//	
//	@PostMapping("/saveIssue")
//	public String saveGuest(@ModelAttribute("issue") Issue issue, Model model) { 
//		System.out.println("Save Issue Triggered");
//		if(issueRepository.existsById(issue.getId())) {
//			issueRepository.update(issue);
//		}else {
//			issueRepository.save(issue);
//		}
////		issueRepository.save(issue); 
////		if(issue.getFine() ==  null ) {
////			return "redirect:/issueManagementDashboard";
////		}
//		return "redirect:/issueManagementDashboard"; 
//	}
//	
//	@DeleteMapping("/issues/{id}")
//	@ResponseBody
//	public Boolean deleteIssue(@PathVariable Long id , Model model) {  
//		if(issueRepository.existsById(id)) {
//			issueRepository.deleteById(id); 
//			System.out.println(" Issue Deleted Successfully  ID : "+ id);
//			return Boolean.TRUE;
//		} 
//		return Boolean.FALSE;
//	} 
//	
//}
