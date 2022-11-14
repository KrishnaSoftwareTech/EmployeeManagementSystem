package com.EmployeeManagmentSystem.Rest.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.BadRequestException;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Model.Employee;
import com.EmployeeManagmentSystem.Rest.Repository.EmpBankDetailsRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeRepository;
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
	
	@Autowired
	private  EmployeeRepository employeeRepo;
	
	@Override
	public Optional<EmpBankDetails> getBankDetails(Long sapid) {
		Optional<EmpBankDetails> detailsById = empBankDetails.findById(sapid) ;
		 if(getEmployeeBySapid(sapid).getId().equals(sapid) &&  detailsById.isPresent()) {
					      log.info("Employee Bank Details -> { }"+detailsById);
						 return detailsById;
					 }
				else {
					 log.info("Employee Not Found -> { } ResourceNotFoundException");
					throw new ResourceNotFoundException("Bank Details Not Found for Employee : " + sapid);
					}
			}
	
		@Override
		public EmpBankDetails saveBankInfo(EmpBankDetails bankInfo, Long employeeId) {
		    if(getEmployeeBySapid(employeeId).getId().equals(employeeId)) {
				 if(validBankDetails(bankInfo)) {
					bankInfo.setSapId(employeeId);
					EmpBankDetails saveBankInfo= empBankDetails.save(bankInfo);
					return saveBankInfo;
				 }
				 else {
					 throw new BadRequestException(" Bad Request ");
				 }
			}
			else {
			throw new BadRequestException("Employee Not Found with "+ employeeId);
			}
		}
		public EmpBankDetails updateBankInfo(EmpBankDetails bankInfo, Long employeeId) {
			 if(getEmployeeBySapid(employeeId).getId().equals(employeeId)) {
					 if(validBankDetails(bankInfo)) {
						 //get
						 EmpBankDetails getBankDetails = empBankDetails.findById(employeeId)
								 .orElseThrow( () -> new ResourceNotFoundException("Bank Details  Not Found for " +employeeId));
						 //set
						 getBankDetails.setBankAccountNumber(bankInfo.getBankAccountNumber());
						 getBankDetails.setBankBranch(bankInfo.getBankBranch());
						 getBankDetails.setBankBranchAddress(bankInfo.getBankBranchAddress());
						 getBankDetails.setBankName(bankInfo.getBankName());
						EmpBankDetails updateBankInfo= empBankDetails.save(getBankDetails);
						return updateBankInfo;
					 }
					 else {
						 throw new BadRequestException(" Bad Request ");
					 }
				}
				else {
				throw new BadRequestException("Employee Not Found with "+ employeeId);
				}
			}
	     public void deleteBankDetails(Long sapId){
	    	//get
			 EmpBankDetails getBankDetails = empBankDetails.findById(sapId)
					 .orElseThrow( () -> new ResourceNotFoundException("Bank Details  Not Found for " +sapId));
	    	 // empBankDetails.deleteById(sapId);
	    	 if(getBankDetails.getSapId().equals(sapId)) {
	    		 empBankDetails.deleteById(sapId);
	    	 }
    	}
		
		private boolean validBankDetails(EmpBankDetails bankInfo) {
			Long bankAccountNumber = bankInfo.getBankAccountNumber();
			//bankAccountNumber.
			 if(bankAccountNumber== null || bankAccountNumber == 0 && isValidAcoountNumber(bankAccountNumber)){
					throw new BadRequestException("Bad Request ->Bank Account Number  is Invalid ");
				}
				else if (bankInfo.getBankName().isEmpty() && bankInfo.getBankName().isBlank()) {
					throw new BadRequestException("Bad Request -> BankName is Invalid or Not be Null");
				}
			else	
			   return true;
		}
		

		
		//validations
	   private boolean isValidAcoountNumber(Long bankAccountNumber) {
		  int totalDigits = 0;
		  while(bankAccountNumber!= 0) {
			  bankAccountNumber=bankAccountNumber/10;
			  totalDigits++;
		  }
		  if(totalDigits <10) {
			  throw new BadRequestException("Bank Acocunt Number is Invalid ");
		  }
		  else {
		 return false;
		   }
		}

	 private Employee getEmployeeBySapid(Long sapId) {
			//Optional<Employee> getEmployee = employeeRepo.findById(sap);
			Employee getEmployee = employeeRepo.findById(sapId)
					.orElseThrow( () -> new ResourceNotFoundException(" Employee Not Found "+sapId));
			return getEmployee; 
			
		}
}
