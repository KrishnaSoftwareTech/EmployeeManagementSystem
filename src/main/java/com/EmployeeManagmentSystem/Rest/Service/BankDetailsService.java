package com.EmployeeManagmentSystem.Rest.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Repository.EmpBankDetailsRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.BankDetailsInterface;

/**
 * @author krishnakumar
 *
 */
@Service
public class BankDetailsService  implements BankDetailsInterface{
	private static final Logger log=LoggerFactory.getLogger(BankDetailsService.class);

	@Autowired
	private EmpBankDetailsRepository empBankDetails;
	
	@Override
	public Optional<EmpBankDetails> getBankDetails(Long sapid) {
		Optional<EmpBankDetails> findById = empBankDetails.findById(sapid);
		System.err.println(findById);
		log.info("BankDetails By Employee Id");
		return findById;
	}

}
