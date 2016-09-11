package com.training.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hcl.hmtp.common.server.entity.metadata.Bean;
import com.raja.pas.beans.StudentMarksBean;

@Bean(clazz=StudentMarksBean.class)
@Entity
public class StudentMarks implements com.hcl.hmtp.common.server.entity.Entity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4815853361785078490L;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(long paramId) {
		// TODO Auto-generated method stub
		this.id=paramId;
		
	}
	
	@Column(name="SUBJECT")
	String subject;
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getMark() {
		return mark;
	}

	public void setMark(long mark) {
		this.mark = mark;
	}

	@Column(name="MARK")
	long mark;

}
