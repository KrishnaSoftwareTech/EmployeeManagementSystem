package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import java.util.Optional;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;

/**
 * @author krishnakumar
 *
 */
public interface BankDetailsInterface {

	public Optional<EmpBankDetails> getBankDetails(Long sapid);

}
