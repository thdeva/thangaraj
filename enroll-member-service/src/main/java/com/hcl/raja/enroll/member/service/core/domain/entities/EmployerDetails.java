package com.hcl.raja.enroll.member.service.core.domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.hcl.hmtp.application.server.entity.ApplicationCompany;
import com.hcl.hmtp.common.server.entity.EditableEntity;
import com.hcl.hmtp.common.server.entity.Entity;
import com.hcl.hmtp.common.server.entity.MultiTenantEntity;
import com.hcl.hmtp.common.server.entity.metadata.Bean;
import com.hcl.hmtp.common.server.entity.metadata.ChildRelation;
import com.hcl.hmtp.common.server.entity.util.GMTDate;
import com.hcl.raja.enroll.member.service.core.domain.entities.beans.EmployerDetailsBean;

@javax.persistence.Entity
@Bean(clazz = EmployerDetailsBean.class)
public class EmployerDetails implements EditableEntity, Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9063400393983655873L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(long paramId) {
		// TODO Auto-generated method stub
		this.id = paramId;
	}

	private String editedBy;

	@Override
	public String getEditedBy() {
		// TODO Auto-generated method stub
		return editedBy;
	}

	@Override
	public void setEditedBy(String paramEditedBy) {
		// TODO Auto-generated method stub
		this.editedBy = paramEditedBy;

	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "date", column = @Column(name = "CREATE_DATE")) })
	private GMTDate createDate;

	@Override
	public GMTDate getCreateDate() {
		// TODO Auto-generated method stub
		return createDate;
	}

	@Override
	public void setCreateDate(GMTDate paramCreateDate) {
		// TODO Auto-generated method stub
		this.createDate = paramCreateDate;

	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "date", column = @Column(name = "MODIFIED_DATE")) })
	private GMTDate modifiedDate;

	@Override
	public GMTDate getModifiedDate() {
		// TODO Auto-generated method stub
		return modifiedDate;
	}

	@Override
	public void setModifiedDate(GMTDate paramModifiedDate) {
		// TODO Auto-generated method stub
		this.modifiedDate = paramModifiedDate;
	}

	private String employerName;

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getCompanyTytpe() {
		return companyTytpe;
	}

	public void setCompanyTytpe(String companyTytpe) {
		this.companyTytpe = companyTytpe;
	}

	public long getCompanyRegistrationNumber() {
		return companyRegistrationNumber;
	}

	public void setCompanyRegistrationNumber(long companyRegistrationNumber) {
		this.companyRegistrationNumber = companyRegistrationNumber;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyInformation() {
		return companyInformation;
	}

	public void setCompanyInformation(String companyInformation) {
		this.companyInformation = companyInformation;
	}

	public String getCompanyTaxStatus() {
		return companyTaxStatus;
	}

	public void setCompanyTaxStatus(String companyTaxStatus) {
		this.companyTaxStatus = companyTaxStatus;
	}

	public String getPayPointCode() {
		return payPointCode;
	}

	public void setPayPointCode(String payPointCode) {
		this.payPointCode = payPointCode;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public long getPhoneNUmber() {
		return phoneNUmber;
	}

	public void setPhoneNUmber(long phoneNUmber) {
		this.phoneNUmber = phoneNUmber;
	}

	public long getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(long faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String geteMailId() {
		return eMailId;
	}

	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}

	private String companyTytpe;
	private long companyRegistrationNumber;
	private String companyCode;
	private String companyInformation;
	private String companyTaxStatus;
	private String payPointCode;
	private String contactPerson;
	private long phoneNUmber;
	private long faxNumber;
	private String eMailId;
}
