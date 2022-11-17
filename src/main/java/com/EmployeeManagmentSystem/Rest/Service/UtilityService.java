package com.EmployeeManagmentSystem.Rest.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Model.Employee;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeRepository;

/**
 * @author krishnakumar
 *
 */
@Service
public class UtilityService {

	@Autowired
	private EmployeeRepository empRepository;
	
	public boolean checkEmployeeBySapId(Long sapId) {
		Optional<Employee> emp = empRepository.findById(sapId);
		if(emp.isEmpty()) {
			return false;
		}
		//boolean checkEmployee = emp.get().getId().equals(sapId);
		return true;
	}
	
	public Optional<Employee> checkEmployee(Long sapId) {
		Optional<Employee> emp = empRepository.findById(sapId);
		if(emp.isEmpty()) {
			return null;
		}
		//boolean checkEmployee = emp.get().getId().equals(sapId);
		return emp;
	}
}
