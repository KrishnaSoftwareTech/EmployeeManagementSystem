package com.EmployeeManagmentSystem.Rest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Model.FamilyDetails;

/**
 * @author krishnakumar
 *
 */
public interface EmpFamilyDetailsRepository extends JpaRepository<FamilyDetails, Long> {

	@Query(value = "SELECT * FROM emp_family_Details WHERE personal_details_sap_id=?1", nativeQuery = true)
	public List<FamilyDetails> findBySapId(Long personal_details_sap_id);

}
