package com.ap.ApSpringbootCaseStudy.controllers;
 
import java.util.List;
 
import javax.validation.Valid;
import javax.validation.constraints.Max;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.ap.ApSpringbootCaseStudy.entities.Report;
import com.ap.ApSpringbootCaseStudy.services.ReportService;
 
 
@RestController
@RequestMapping("/academyportal")
@Validated
public class ReportController {

 
	@Autowired
	ReportService reportService;
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/reports")
	public ResponseEntity<List<Report>> getAllReports(){
		List<Report> reportList=reportService.getAllReports();
		if(reportList.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else
			return new ResponseEntity<>(reportList,HttpStatus.OK);
	}
 
	  @GetMapping("/reports/{id}")
	  public ResponseEntity<Report> getReportById(@PathVariable("id")  long id) {
		 Report report=reportService.getReportById(id);
		  if(report!=null) 
			  return new ResponseEntity<>(report,HttpStatus.OK);
		  else
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);		 		  
	  }
 
	  @PostMapping("/reports")
	  public ResponseEntity<Report> createReport(@RequestBody @Valid Report report) {
		  Report reports=reportService.createReport(report);
		  return new ResponseEntity<>(reports,HttpStatus.OK);
	  }
 
	  @PutMapping("/reports/{id}")
	  public ResponseEntity<Report> updateReport(@PathVariable("id") long id, @RequestBody @Valid Report report) {
		  Report reportExist=reportService.getReportById(id);
		  if(reportExist!=null) {
			  reportExist.setBatchid(report.getBatchid());
			  reportExist.setFacultyid(report.getFacultyid());
	          reportExist.setFeedback(report.getFeedback());
		      Report updateReport=reportService.updateReport(reportExist);
		      return new ResponseEntity<>(updateReport,HttpStatus.OK);
			  }
		  else
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}