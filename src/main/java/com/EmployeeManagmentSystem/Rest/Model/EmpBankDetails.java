package com.EmployeeManagmentSystem.Rest.Model;


public class EmpBankDetails {

	private  Long   BankAccountNumber;
	private String BankName;
	private String BankBranch;
	private String BankBranchAddress;
	/**
	 * @param bankAccountNumber
	 * @param bankName
	 * @param bankBranch
	 * @param bankBranchAddress
	 */
	public EmpBankDetails(Long bankAccountNumber, String bankName, String bankBranch, String bankBranchAddress) {
		super();
		BankAccountNumber = bankAccountNumber;
		BankName = bankName;
		BankBranch = bankBranch;
		BankBranchAddress = bankBranchAddress;
	}
	public EmpBankDetails() {
		super();
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
	
	
	
}
