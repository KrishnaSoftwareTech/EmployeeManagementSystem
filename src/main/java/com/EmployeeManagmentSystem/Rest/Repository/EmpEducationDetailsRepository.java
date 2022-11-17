package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeManagmentSystem.Rest.Model.EducationDetails;
/**
 * @author krishnakumar
 *
 */
//@Repository
public interface EmpEducationDetailsRepository extends JpaRepository<EducationDetails, Long> {

	//public EducationDetails findBySapid(Long sapid);
}
