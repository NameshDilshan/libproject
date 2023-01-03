package com.library.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.employee.Repository.LoanRepo;
import com.library.employee.dto.LoanDto;

@RestController	
public class ReportController {

	@Autowired
	private LoanRepo loanRepo;
	
	@PostMapping("/getReportSearchData")
	public List<LoanDto> getReportSearchData(
			@RequestParam(name = "start", required = false, defaultValue = "1996-12-15") String start,
			@RequestParam(name = "end", required = false, defaultValue = "2996-12-15") String end,
			@RequestParam(name = "book", required = false, defaultValue = "%") String bookId,
			@RequestParam(name = "employee", required = false, defaultValue = "%") String employeeId
			){ 
		return loanRepo.getReportSearchData(start, end, bookId, employeeId);
	}
}
