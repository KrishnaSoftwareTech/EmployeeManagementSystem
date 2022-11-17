package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="BranchDetails")
public class EmpCompanyBranchDetails {

	@Id
//	@GeneratedValue
	private Long sapid;
	private String BranchName;
	private String BranchAddress;
//	@ManyToOne(targetEntity=Employee.class, cascade = CascadeType.MERGE ,fetch=FetchType.LAZY)
//	@JoinColumn(name="HeadOfDepartment_id",referencedColumnName = "sapID")
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

	public Long getSapid() {
		return sapid;
	}

	public void setSapid(Long sapid) {
		this.sapid = sapid;
	}

	public Long gethead_of_department_id() {
		return BranchHead_Id;
	}

	public void sethead_of_department_id(Long branchHead_Id) {
		BranchHead_Id = branchHead_Id;
	}

	
}
