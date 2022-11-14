package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;

/**
 * @author krishnakumar
 *
 */
public interface BankDetailsInterface {

	public Optional<EmpBankDetails> getBankDetails(Long sapid);

	public EmpBankDetails saveBankInfo(EmpBankDetails bankInfo, Long employeeId);

	public EmpBankDetails updateBankInfo(EmpBankDetails bankInfo, Long employeeId);

	public void deleteBankDetails(Long sapId);

}
