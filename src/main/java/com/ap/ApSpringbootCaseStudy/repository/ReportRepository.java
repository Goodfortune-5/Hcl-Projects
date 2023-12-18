package com.ap.ApSpringbootCaseStudy.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.ap.ApSpringbootCaseStudy.entities.Report;
 
 
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

 
}