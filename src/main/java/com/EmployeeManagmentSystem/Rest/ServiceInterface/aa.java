package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import java.util.Optional;

import com.EmployeeManagmentSystem.Rest.Model.AdharInformation;
import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;

/**
 * @author krishnakumar
 *
 */
public class aa extends AdharInformation implements bb ,BankDetailsInterface {

	@Override
	public void m1() {
	}

	/**
	 * 
	 */
	public aa() {
		super();
	}

	@Override
	public String toString() {
		return "aa [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public Optional<EmpBankDetails> getBankDetails(Long sapid) {
		return null;
	}

	@Override
	public EmpBankDetails saveBankInfo(EmpBankDetails bankInfo, Long employeeId) {
		return null;
	}

	@Override
	public EmpBankDetails updateBankInfo(EmpBankDetails bankInfo, Long employeeId) {
		return null;
	}

	@Override
	public void deleteBankDetails(Long sapId) {
	}
	
}
class dd extends cc  {
	//father extanding his parents
	public Object property() {
		System.out.println("father property");
		return null;
	}
}
class ff extends dd{
	//son extanding his parents 
	@Override
	public
	 String 
	 property() 
	{
		System
		.out
		.println
		("father property took by child");
		return null;
	}
}
