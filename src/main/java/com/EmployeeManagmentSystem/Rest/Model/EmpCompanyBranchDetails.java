package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Embeddable
public class EmpCompanyBranchDetails {

	@javax.persistence.Id
	private Long sapid;
	private String BranchName;
	private String BranchAddress;
	@ManyToOne(targetEntity=Employee.class, cascade = CascadeType.ALL)
	@JoinColumn(name="HeadOfDepartment_id",referencedColumnName = "sapID")
	private Long  BranchHead_Id;
	
	public EmpCompanyBranchDetails() {
		
	}

	/**
	 * @param branchName
	 * @param branchAddress
	 * @param branchHead
	 */
	public EmpCompanyBranchDetails(String branchName, String branchAddress, Long BranchHeadId) {
		super();
		BranchName = branchName;
		BranchAddress = branchAddress;
		BranchHead_Id=BranchHeadId;
	}

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}

	public String getBranchAddress() {
		return BranchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		BranchAddress = branchAddress;
	}

	public Long getBranchHead() {
		return BranchHead_Id;
	}

	public void setBranchHead(Long branchHead) {
		BranchHead_Id = branchHead;
	}
	
	
}
