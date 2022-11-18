package com.EmployeeManagmentSystem.Rest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Model.Intermediate;
import com.EmployeeManagmentSystem.Rest.Repository.IntermediateRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.IntermediateDetailsInterface;

/**
 * @author krishnakumar
 *
 */
@Service
public class IntermediateDetailsService implements IntermediateDetailsInterface {
	
	
	@Autowired
	private IntermediateRepository IntermediateRepository; 

	@Override
	public Intermediate addIntermediateInfo(Intermediate intermedite) {
		Intermediate addIntermediateInfo ;
		try {
			 addIntermediateInfo = IntermediateRepository.save(intermedite);
		}catch (Exception e) {
			throw new InternalServerException("Unavle to add Intermediate Details of " +intermedite.getSapID());
		}
		return addIntermediateInfo;
	}

}
