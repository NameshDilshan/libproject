/**
 * 
 */
package com.library.member.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.member.Entity.Member;
import com.library.member.Repository.MemberRepository;

@Controller
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;
	
	@PostMapping("/saveMemberObject")
	public String saveMemberObject(@ModelAttribute("member") Member member, Model model) { 
		memberRepository.save(member); 
		return "redirect:/memberManagementDashboard";
	}
	
	@DeleteMapping("/members/{id}")
	@ResponseBody
	public Boolean deleteMember(@PathVariable Long id , Model model) {  
		if(memberRepository.existsById(id)) {
			memberRepository.deleteById(id);  
			return Boolean.TRUE;
		} 
		return Boolean.FALSE;
	} 
	
}
