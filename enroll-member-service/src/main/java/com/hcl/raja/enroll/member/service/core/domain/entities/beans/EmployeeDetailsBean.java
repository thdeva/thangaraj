package com.hcl.raja.enroll.member.service.core.domain.entities.beans;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.hcl.hmtp.application.client.beans.ApplicationCompanyBean;
import com.hcl.hmtp.application.server.entity.ApplicationCompany;
import com.hcl.hmtp.common.client.beans.Bean;
import com.hcl.hmtp.common.server.entity.metadata.ChildRelation;
import com.hcl.raja.enroll.member.service.core.domain.entities.EmployerDetails;

public class EmployeeDetailsBean extends Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7980959698236563650L;
	private final String EMPLOYEEDETAILS_COMPANY = "EMPLOYEEDETAILS-COMPANY";
	private final String EMPLOYEEDETAILS_EMPLOYERDETAILS = "EMPLOYEEDETAILS-EMPLOYERDETAILS";

	@Override
	public String[] getRelations() {
		// TODO Auto-generated method stub
		return new String[] { EMPLOYEEDETAILS_COMPANY,
				EMPLOYEEDETAILS_EMPLOYERDETAILS };
	}

	private long id;

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(long paramId) {
		// TODO Auto-generated method stub
		this.id = paramId;
		getChangeSummary().addNewChangedAttribute("id");
	}

	private String editedBy;

	public String getEditedBy() {
		// TODO Auto-generated method stub
		return editedBy;
	}

	public void setEditedBy(String paramEditedBy) {
		// TODO Auto-generated method stub
		this.editedBy = paramEditedBy;
		getChangeSummary().addNewChangedAttribute("editedBy");

	}

	private Date createDate;

	public Date getCreateDate() {
		// TODO Auto-generated method stub
		return createDate;
	}

	public void setCreateDate(Date paramCreateDate) {
		// TODO Auto-generated method stub
		this.createDate = paramCreateDate;
		getChangeSummary().addNewChangedAttribute("createDate");
	}

	private Date modifiedDate;

	public Date getModifiedDate() {
		// TODO Auto-generated method stub
		return modifiedDate;
	}

	public void setModifiedDate(Date paramModifiedDate) {
		// TODO Auto-generated method stub
		this.modifiedDate = paramModifiedDate;
		getChangeSummary().addNewChangedAttribute("modifiedDate");
	}

	private ApplicationCompanyBean company;

	public ApplicationCompanyBean getCompany() {
		return company;
	}

	public void setCompany(ApplicationCompanyBean company) {
		this.company = company;
		getChangeSummary().setNewRelation(EMPLOYEEDETAILS_COMPANY, company);
	}

	private EmployerDetailsBean employerDetails;

	public EmployerDetailsBean getEmployerDetails() {
		return employerDetails;
	}

	public void setEmployerDetails(EmployerDetailsBean employerDetails) {
		this.employerDetails = employerDetails;
		getChangeSummary().addNewChangedAttribute("employerDetails");
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
		getChangeSummary().addNewChangedAttribute("occupation");
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
		getChangeSummary().addNewChangedAttribute("department");
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
		getChangeSummary().addNewChangedAttribute("jobTitle");
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
		getChangeSummary().addNewChangedAttribute("employmentType");
	}

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
		getChangeSummary().addNewChangedAttribute("employmentDate");
	}

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
		getChangeSummary().addNewChangedAttribute("employeeNumber");
	}

	public long getPersalNumber() {
		return persalNumber;
	}

	public void setPersalNumber(long persalNumber) {
		this.persalNumber = persalNumber;
		getChangeSummary().addNewChangedAttribute("persalNumber");
	}

	public long getGrossMonthlyIncome() {
		return grossMonthlyIncome;
	}

	public void setGrossMonthlyIncome(long grossMonthlyIncome) {
		this.grossMonthlyIncome = grossMonthlyIncome;
		getChangeSummary().addNewChangedAttribute("grossMonthlyNumber");
	}

	public long getTaxReferenceNumber() {
		return taxReferenceNumber;
	}

	public void setTaxReferenceNumber(long taxReferenceNumber) {
		this.taxReferenceNumber = taxReferenceNumber;
		getChangeSummary().addNewChangedAttribute("taxReferenceNumber");
	}

	public long getContributionCode() {
		return contributionCode;
	}

	public void setContributionCode(long contributionCode) {
		this.contributionCode = contributionCode;
		getChangeSummary().addNewChangedAttribute("contributionCode");
	}

	public String getContributionMode() {
		return contributionMode;
	}

	public void setContributionMode(String contributionMode) {
		this.contributionMode = contributionMode;
		getChangeSummary().addNewChangedAttribute("contributionMode");
	}

	public long getTotalContribution() {
		return totalContribution;
	}

	public void setTotalContribution(long totalContribution) {
		this.totalContribution = totalContribution;
		getChangeSummary().addNewChangedAttribute("totalContribution");
	}

	public String getContributionShareMode() {
		return contributionShareMode;
	}

	public void setContributionShareMode(String contributionShareMode) {
		this.contributionShareMode = contributionShareMode;
		getChangeSummary().addNewChangedAttribute("contributionShareMode");
	}

	public long getContributionShare() {
		return contributionShare;
	}

	public void setContributionShare(long contributionShare) {
		this.contributionShare = contributionShare;
		getChangeSummary().addNewChangedAttribute("contributionShare");
	}

	public String getMemberShareMode() {
		return memberShareMode;
	}

	public void setMemberShareMode(String memberShareMode) {
		this.memberShareMode = memberShareMode;
		getChangeSummary().addNewChangedAttribute("memberShareMode");
	}

	public long getMemberShare() {
		return memberShare;
	}

	public void setMemberShare(long memberShare) {
		this.memberShare = memberShare;
		getChangeSummary().addNewChangedAttribute("memberShare");
	}

	public String getCompanyShareMode() {
		return companyShareMode;
	}

	public void setCompanyShareMode(String companyShareMode) {
		this.companyShareMode = companyShareMode;
		getChangeSummary().addNewChangedAttribute("companyShareMode");
	}

	public long getCompanyShare() {
		return companyShare;
	}

	public void setCompanyShare(long companyShare) {
		this.companyShare = companyShare;
		getChangeSummary().addNewChangedAttribute("companyShare");
	}

	public String getPensionerShareMode() {
		return pensionerShareMode;
	}

	public void setPensionerShareMode(String pensionerShareMode) {
		this.pensionerShareMode = pensionerShareMode;
		getChangeSummary().addNewChangedAttribute("pensionerShareMode");
	}

	public long getPensionerShare() {
		return pensionerShare;
	}

	public void setPensionerShare(long pensionerShare) {
		this.pensionerShare = pensionerShare;
		getChangeSummary().addNewChangedAttribute("pensionerShare");
	}

	public Date getBenefitDate() {
		return benefitDate;
	}

	public void setBenefitDate(Date benefitDate) {
		this.benefitDate = benefitDate;
		getChangeSummary().addNewChangedAttribute("benefitDate");
	}

	public long getlJP() {
		return lJP;
	}

	public void setlJP(long lJP) {
		this.lJP = lJP;
		getChangeSummary().addNewChangedAttribute("lJP");
	}

	private String occupation;
	private String department;
	private String jobTitle;
	private String employmentType;
	private Date employmentDate;
	private long employeeNumber;
	private long persalNumber;
	private long grossMonthlyIncome;
	private long taxReferenceNumber;
	private long contributionCode;
	private String contributionMode;
	private long totalContribution;
	private String contributionShareMode;
	private long contributionShare;
	private String memberShareMode;
	private long memberShare;
	private String companyShareMode;
	private long companyShare;
	private String pensionerShareMode;
	private long pensionerShare;
	private Date benefitDate;
	private long lJP;

}
