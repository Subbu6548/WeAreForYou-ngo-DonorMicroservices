package com.fsd.donormicroservices.payload;





public class Project {
	
	    private long id;

	    private long projectCode;

	    private String project_name;
	 
	    private String project_desc;
	
	    private String projectplace;

	    private String projectdate;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
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
		public String getProject_desc() {
			return project_desc;
		}
		public void setProject_desc(String project_desc) {
			this.project_desc = project_desc;
		}
		public String getProjectplace() {
			return projectplace;
		}
		public void setProjectplace(String projectplace) {
			this.projectplace = projectplace;
		}
		public String getProjectdate() {
			return projectdate;
		}
		public void setProjectdate(String projectdate) {
			this.projectdate = projectdate;
		}
		public Project(long id, long projectCode, String project_name, String project_desc, String projectplace,
				String projectdate) {
			super();
			this.id = id;
			this.projectCode = projectCode;
			this.project_name = project_name;
			this.project_desc = project_desc;
			this.projectplace = projectplace;
			this.projectdate = projectdate;
		}
		public Project() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    
	    
}

