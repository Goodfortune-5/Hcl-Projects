package com.ap.ApSpringbootCaseStudy.services;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ap.ApSpringbootCaseStudy.entities.Report;
import com.ap.ApSpringbootCaseStudy.repository.ReportRepository;
 
 
@Service
public class ReportServiceImpl implements ReportService{
 
	@Autowired
	ReportRepository reportRepository;
 
	@Override
	public List<Report> getAllReports() {
		return reportRepository.findAll();
	}
 
	@Override
	public Report getReportById(long id) {
		return reportRepository.findById(id).get();
	}
 
	@Override
	public Report createReport(Report report) {
		return reportRepository.save(report);
	}
 
	@Override
	public Report updateReport(Report report) {
		return reportRepository.save(report);
	}
}
 