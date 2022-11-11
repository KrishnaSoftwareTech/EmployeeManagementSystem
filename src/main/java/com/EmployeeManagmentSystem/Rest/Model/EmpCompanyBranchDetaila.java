package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class EmpCompanyBranchDetaila {

	@javax.persistence.Id
	private Long Id;
	private String BranchName;
	private String BranchAddress;
	private String  BranchHead;
	
	public EmpCompanyBranchDetaila() {
		
	}

	/**
	 * @param branchName
	 * @param branchAddress
	 * @param branchHead
	 */
	public EmpCompanyBranchDetaila(String branchName, String branchAddress, String branchHead) {
		super();
		BranchName = branchName;
		BranchAddress = branchAddress;
		BranchHead = branchHead;
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

	public String getBranchHead() {
		return BranchHead;
	}

	public void setBranchHead(String branchHead) {
		BranchHead = branchHead;
	}
	
	
}
