package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagmentSystem.Rest.Model.EmpHRCompensation;

/**
 * @author krishnakumar
 *
 */
public interface EmployeeCompensationRepository extends JpaRepository<EmpHRCompensation, Long>{

}
