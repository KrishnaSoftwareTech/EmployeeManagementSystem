package com.EmployeeManagmentSystem.Rest.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Controller.EmployeeController;
import com.EmployeeManagmentSystem.Rest.Exception.AlreadyExitsException;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.Employee;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeRepository;

/**
 * @author krishnakumar
 *
 */
@Service
public class EmployeeService {
	
	private static final  Logger log=LoggerFactory.getLogger(EmployeeService.class);
       @Autowired
	    private EmployeeRepository emp;
       //get All
       public List<Employee> getEmployees(){
    	   List<Employee> allEmp = emp.findAll();
		   return allEmp;
    	   }
       //get by id
       public Employee getEmpoloyeeById(Long sapId) {
    	   Employee employee = emp.findById(sapId).orElseThrow( 
    			    () -> 
    			    new ResourceNotFoundException("Employee with " +sapId+" Not Found")
                     );
    	   return employee;
       }

       //add Employee
		public Employee addEmployee(Employee employee) {
			Optional<Employee> findEmp = emp.findById(employee.getId()); //.orElseThrow(() -> new BadRequestException("Employee Already Exits : "+employee));
		   // System.err.println(" ++++++++++++ "+findEmp+" +++++++++++++++");
			if(!findEmp.isPresent()) {
				return emp.save(employee);
			}
			else {
				log.error("Employee already Exixts {} ",employee.getId());
				throw new AlreadyExitsException(" Employee Already Exits with " + employee.getId());}
			}

		//Add List of Employees
		public List<Employee> addAllEmployees(List<Employee> employee) {
			boolean empty = employee.isEmpty();
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			if(!empty) {
				employee.forEach(each-> {
					//Employee each;
					Long sapID = each.getId();
					Optional<Employee> user = emp.findById(sapID);
					boolean present = user.isPresent();
					if(!present) {
					   Employee save2 = emp.save(each);
					   listOfEmployees.add(save2);
					}
					else {
						log.error(" Employee Already Exits {}",sapID);
						throw new AlreadyExitsException(" Employee Already Exits "+ sapID);
					}
				});
			}
			return listOfEmployees;
		}

		//Update By id
		public Employee updateEmployeeByid(Long sapid, Employee employeeDetails) {
		    
		//get
			Employee getEmp = emp.findById(sapid).orElseThrow( () -> new ResourceNotFoundException(sapid+" : Employee Not Found"));
		//update	
			getEmp.setDesignation(employeeDetails.getDesignation());
			getEmp.setFirstName(employeeDetails.getFirstName());
			getEmp.setId(sapid);
			getEmp.setLastName(employeeDetails.getLastName());
			getEmp.setSalary(employeeDetails.getSalary());
			getEmp.setStartDate(employeeDetails.getStartDate());
			getEmp.setLocation(employeeDetails.getLocation());
			Employee updatedEmployee = emp.save(getEmp);
	        log.warn("Employeee Updated { }",sapid);
		   return updatedEmployee;
		}

		//Delete
		public ResponseEntity<Optional<Employee>> deleteEmployeeByid(Long id) {
			Optional<Employee> getEmp = emp.findById(id); 
			if(!getEmp.isPresent()) {
				throw new ResourceNotFoundException(id+" - Employee Not Found");
			}else {
				 emp.deleteById(id);
			}
		  return ResponseEntity.ok(null);
		}
}
