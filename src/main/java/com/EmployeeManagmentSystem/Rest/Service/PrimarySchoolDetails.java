package com.EmployeeManagmentSystem.Rest.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Model.EducationDetails;
import com.EmployeeManagmentSystem.Rest.Model.PrimarySchool;
import com.EmployeeManagmentSystem.Rest.Repository.PrimarySchoolRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.PrimarySchoolDetailsInterf;

/**
 * @author krishnakumar
 *
 */
@Service
public class PrimarySchoolDetails implements PrimarySchoolDetailsInterf{
	private static final  Logger Logs=LoggerFactory.getLogger(PrimarySchoolDetails.class);
	
	@Autowired
	private PrimarySchoolRepository schoolRepository;

	@Override
	public PrimarySchool addSchoolInformation(PrimarySchool school) {
		PrimarySchool addSchoolInfo;
		try {
			/*
			 * String country = school.getCountry(); int percentage =
			 * school.getPercentage(); String schoolBoard = school.getSchoolBoard(); String
			 * schoolUniversityName = school.getSchoolUniversityName(); Long school_Id =
			 * school.getSchool_Id(); EducationDetails sapID2 = school.getSapID();
			 */
		 addSchoolInfo = schoolRepository.save(school);
		}catch (InternalServerException error) {
			Logs.error("Unable to Add School Details Information " +school);
			throw new InternalServerException("Unable to Add School Details " + school);
		}
		return addSchoolInfo;
	}

}
