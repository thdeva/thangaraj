package com.training.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.hcl.hmtp.application.server.entity.ApplicationCompany;
import com.hcl.hmtp.common.server.entity.EditableEntity;
import com.hcl.hmtp.common.server.entity.MultiTenantEntity;
import com.hcl.hmtp.common.server.entity.PlatformEntity;
import com.hcl.hmtp.common.server.entity.metadata.Bean;
import com.hcl.hmtp.common.server.entity.metadata.ChildRelation;
import com.hcl.hmtp.common.server.entity.util.GMTDate;
import com.training.entities.StudentMarks;
import com.raja.pas.beans.StudentBean;

@Entity
@Bean(clazz=StudentBean.class)
public class Student implements MultiTenantEntity, EditableEntity,com.hcl.hmtp.common.server.entity.Entity{
	@Id
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
	@Column(name="NAME")
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="BATCH")
	String batch;
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	@ManyToOne
	ApplicationCompany company;
	public ApplicationCompany getCompany() {
		return company;
	}

	public void setCompany(ApplicationCompany company) {
		this.company = company;
	}

	@Override
	public String getOwnerPropertyName() {
		// TODO Auto-generated method stub
		return "company";
	}

	
	
	
	@JoinColumn(name="STUDENTMARKS")
	@OneToMany(cascade=CascadeType.ALL)
	@ChildRelation
	Set<StudentMarks> studentMarks= new HashSet<StudentMarks>();

	public Set<StudentMarks> getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(Set<StudentMarks> studentMarks) {
		this.studentMarks = studentMarks;
	}
	
	
	@AttributeOverrides({@AttributeOverride(name = "date",column= @Column(name= "MODIFIEDDATE" ))})
	@Embedded
	private GMTDate modifiedDate;

	@AttributeOverrides({@AttributeOverride(name = "date",column= @Column(name= "CREATEDATE" ))})
	@Embedded
	private GMTDate createDate;

	@Column(name = "EDITEDBY")
	private String editedBy;
	
	
	@Override
	public String getEditedBy() {
		return editedBy;
	}

	@Override
	public void setEditedBy(final String paramEditedBy) {
		editedBy = paramEditedBy;
	}

	@Override
	public GMTDate getCreateDate() {
		return createDate;
	}

	@Override
	public void setCreateDate(final GMTDate paramCreateDate) {
		createDate = paramCreateDate;
	}

	@Override
	public GMTDate getModifiedDate() {
		return modifiedDate;
	}

	@Override
	public void setModifiedDate(final GMTDate paramModifiedDate) {
		modifiedDate = paramModifiedDate;
	}


}
