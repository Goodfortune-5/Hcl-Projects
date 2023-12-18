package com.ap.ApSpringbootCaseStudy.entities;
 
import javax.persistence.Column;
 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
 
 
import javax.persistence.Table;
 
import com.sun.istack.NotNull;
 
import javax.persistence.Entity;
 
 
@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @NotNull
    @Column(name = "batchid")
    public int batchid;

 
    @Column(name = "facultyid")
    public int facultyid;
	@NotNull
    @Column(name = "feedback")
    public String feedback;
 
	
	public Report() {
	}

	public Report(long id,  int batchid, int facultyid,
			String feedback) {
		super();
		this.id = id;
		this.batchid = batchid;
		this.facultyid = facultyid;
		this.feedback = feedback;
	}
 
 
	public long getId() {
		return id;
	}
 
	public int getBatchid() {
		return batchid;
	}
 
	public int getFacultyid() {
		return facultyid;
	}
 
	public String getFeedback() {
		return feedback;
	}
 
	public void setId(long id) {
		this.id = id;
	}
 
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
 
	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}
 
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}		
 
}