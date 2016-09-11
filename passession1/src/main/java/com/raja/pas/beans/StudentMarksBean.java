package com.raja.pas.beans;

import com.hcl.hmtp.common.client.beans.Bean;

public class StudentMarksBean extends Bean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3181226085984925105L;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		getChangeSummary().addNewChangedAttribute("id");
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
		getChangeSummary().addNewChangedAttribute("subject");
	}
	public Long getMarks() {
		return marks;
	}
	public void setMarks(long marks) {
		this.marks = marks;
		getChangeSummary().addNewChangedAttribute("marks");
	}
	long id;
	String subject;
	long marks;
	@Override
	public String[] getRelations() {
		// TODO Auto-generated method stub
		return new String[] {};
	}

}
