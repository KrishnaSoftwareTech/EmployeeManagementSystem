package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.EmployeeManagmentSystem.Rest.Model.*;

/**
 * @author krishnakumar
 *
 */
//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
