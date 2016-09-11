package com.raja.pas.beans;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.hcl.hmtp.application.server.entity.ApplicationCompany;
import com.training.entities.StudentMarks;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StudentBean.class)

public class StudentBean_ {

	public static volatile SingularAttribute<StudentBean, String> name;
	public static volatile SingularAttribute<StudentBean, Long> id;
	public static volatile SingularAttribute<StudentBean, String> batch;
	
	public static volatile SingularAttribute<StudentBean, String> editedBy;
	public static volatile SingularAttribute<StudentBean, Date> createDate;
	public static volatile SingularAttribute<StudentBean, Date> modifiedDate;
	
	
	
	
	public static volatile SetAttribute<StudentBean, ApplicationCompany> company;
	public static volatile SetAttribute<StudentBean, StudentMarksBean> studentMarks;
	
}
