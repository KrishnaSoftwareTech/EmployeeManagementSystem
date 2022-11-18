package com.EmployeeManagmentSystem.Rest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Model.Graduation;
import com.EmployeeManagmentSystem.Rest.Repository.GraduationDetailsRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.GraduationDetailsInterface;

/**
 * @author krishnakumar
 *
 */
@Service
public class GraduationDetailsService implements GraduationDetailsInterface{

	@Autowired
	private GraduationDetailsRepository graduationRepository;
	@Override
	public Graduation addGraduationInfo(Graduation graduation) {
		Graduation addGraduationInfo ;
		try {
		 addGraduationInfo = graduationRepository.save(graduation);
		}
		catch (InternalServerException error) {
			throw new InternalServerException("Unable to Add GraduationDetails of Employee" +graduation.getSapID());
		}
		return addGraduationInfo;
	}

}
