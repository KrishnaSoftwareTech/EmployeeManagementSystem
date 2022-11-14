package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="BankDetails")
public class EmpBankDetails {

	@Id
	private Long SapId;
	private  Long  BankAccountNumber;
	private String BankName;
	private String BankBranch;
	private String BankBranchAddress;
	/**
	 * @param bankAccountNumber
	 * @param bankName
	 * @param bankBranch
	 * @param bankBranchAddress
	 */
	public EmpBankDetails(Long sapId,Long bankAccountNumber, String bankName, String bankBranch, String bankBranchAddress) {
		super();
		SapId=sapId;
		BankAccountNumber = bankAccountNumber;
		BankName = bankName;
		BankBranch = bankBranch;
		BankBranchAddress = bankBranchAddress;
	}
	public EmpBankDetails() {
		super();
	}
	public Long getSapId() {
		return SapId;
	}
	public void setSapId(Long sapId) {
		SapId=sapId;
	}
	public Long getBankAccountNumber() {
		return BankAccountNumber;
	}
	public void setBankAccountNumber(Long bankAccountNumber) {
		BankAccountNumber = bankAccountNumber;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getBankBranch() {
		return BankBranch;
	}
	public void setBankBranch(String bankBranch) {
		BankBranch = bankBranch;
	}
	public String getBankBranchAddress() {
		return BankBranchAddress;
	}
	public void setBankBranchAddress(String bankBranchAddress) {
		BankBranchAddress = bankBranchAddress;
	}
	@Override
	public String toString() {
		return "EmpBankDetails [SapId=" + SapId + ", BankAccountNumber=" + BankAccountNumber + ", BankName=" + BankName
				+ ", BankBranch=" + BankBranch + ", BankBranchAddress=" + BankBranchAddress + "]";
	}
	
	
	
}
