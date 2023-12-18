package com.ap.ApSpringbootCaseStudy.services;
 
import java.util.List;
 
import com.ap.ApSpringbootCaseStudy.entities.Report;
 
public interface ReportService {

 
	 public List<Report> getAllReports();
	 public Report getReportById(long id);
	 public Report  createReport(Report report);
	 public Report  updateReport(Report report);
 
 
}