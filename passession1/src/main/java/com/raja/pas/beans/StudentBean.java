package com.raja.pas.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hcl.hmtp.application.client.beans.ApplicationCompanyBean;
import com.hcl.hmtp.common.client.beans.Bean;

public class StudentBean extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3453569450738864795L;

	public static final String STUDENT_MARKS="STUDENT-STUDENTMARKS";
	public static final String STUDENT_COMPANY="STUDENT-APPLICATIONCOMPANY";
	long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		getChangeSummary().addNewChangedAttribute("id");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		getChangeSummary().addNewChangedAttribute("name");
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
		getChangeSummary().addNewChangedAttribute("batch");
	}
	
	public ApplicationCompanyBean getCompany() {
		return company;
	}
	public void setCompany(ApplicationCompanyBean company) {
		this.company = company;
		getChangeSummary().setNewRelation(STUDENT_COMPANY, company);
	}
	public Set<StudentMarksBean> getStudentMarks() {
		return studentMarks;
	}
	public void addStudentMarks(StudentMarksBean marks) {
		this.studentMarks.add( marks);
		getChangeSummary().setNewRelation(STUDENT_MARKS,marks);
	}
	public void setStudentMarks(Set<StudentMarksBean> marks) {
		this.studentMarks= marks;
	}
	String name;
	String batch;
	/*String editedBy;
	String createdBy;
	Date createdDate;
	Date modifiedDate;*/
	ApplicationCompanyBean company;
	Set<StudentMarksBean> studentMarks=new HashSet<StudentMarksBean>();
	@Override
	public String[] getRelations() {
		// TODO Auto-generated method stub
		return new String[] {STUDENT_MARKS,STUDENT_COMPANY};
	}
	
	private String editedBy;

	private Date modifiedDate;

	private Date createDate;
	
	
	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
		changeSummary.addNewChangedAttribute("editedBy");
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		changeSummary.addNewChangedAttribute("modifiedDate");
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		changeSummary.addNewChangedAttribute("createDate");
	}

}
