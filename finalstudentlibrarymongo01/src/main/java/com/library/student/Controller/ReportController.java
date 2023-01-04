//package com.library.student.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.library.student.Repository.IssueRepository;
//import com.library.student.dto.IssueDto;
//
//@RestController	
//public class ReportController {
//
//	@Autowired
//	private IssueRepository issueRepository;
//	
//	@PostMapping("/findIssuesByBookIdAndStudentIdAndIssuedDateRange")
//	public List<IssueDto> getFindIssuesByBookIdAndStudentIdAndIssuedDateRange(
//			@RequestParam(name = "start", required = false, defaultValue = "1996-12-15") String start,
//			@RequestParam(name = "end", required = false, defaultValue = "2996-12-15") String end,
//			@RequestParam(name = "book", required = false, defaultValue = "%") String bookId,
//			@RequestParam(name = "student", required = false, defaultValue = "%") String studentId
//			){ 
//		System.out.println("start : "+ start+ " end : "+ end + " bookId : "+ bookId + " studentId : "+ studentId);
//		return issueRepository.findReportDetails(start, end, bookId, studentId);
//	}
//}
