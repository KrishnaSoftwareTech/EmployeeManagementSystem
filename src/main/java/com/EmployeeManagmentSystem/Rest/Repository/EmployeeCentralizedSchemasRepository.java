package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagmentSystem.Rest.Controller.EmployeeCentralizedSchemasController;
import com.EmployeeManagmentSystem.Rest.Model.EmployeeCentralizedSchemas;

/**
 * @author krishnakumar
 *
 */
public interface EmployeeCentralizedSchemasRepository extends JpaRepository<EmployeeCentralizedSchemas, Long> {

}
