package com.fsd.donormicroservices.payload;

public class DonorDto 
{
	   private long id;
	  private String donorname;
	  private String donoremail;
	  private long donordonation;
	  private long projectCode;
	  private String project_name;
	  private String project_description;
	  private String projectplace;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDonorname() {
		return donorname;
	}
	public void setDonorname(String donorname) {
		this.donorname = donorname;
	}
	public String getDonoremail() {
		return donoremail;
	}
	public void setDonoremail(String donoremail) {
		this.donoremail = donoremail;
	}
	public long getDonordonation() {
		return donordonation;
	}
	public void setDonordonation(long donordonation) {
		this.donordonation = donordonation;
	}
	public long getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(long projectCode) {
		this.projectCode = projectCode;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_description() {
		return project_description;
	}
	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}
	public String getProjectplace() {
		return projectplace;
	}
	public void setProjectplace(String projectplace) {
		this.projectplace = projectplace;
	}
     
}
