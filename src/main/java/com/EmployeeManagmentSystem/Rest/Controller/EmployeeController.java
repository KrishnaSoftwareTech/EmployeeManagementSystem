package com.EmployeeManagmentSystem.Rest.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagmentSystem.Rest.Model.Employee;
import com.EmployeeManagmentSystem.Rest.Service.EmployeeService;

/**
 * @author krishnakumar
 * http://localhost:8080/api/service/
 * 
 */
@RestController
@RequestMapping("/api/service")
public class EmployeeController {

	private static final  Logger log=LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService emp;{
		System.out.println("Instance Block");
	}
	
	@GetMapping("/Employees")  
	public List<Employee> getAll(){
		return emp.getEmployees();
	}
	
	@GetMapping("/Employees/{Sapid}")
	public Employee getEmployeeById(@PathVariable Long Sapid) {
		return emp.getEmpoloyeeById(Sapid);
	
	}
	
	@PostMapping("/Employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return emp.addEmployee(employee);
	}
	@PostMapping("/Employees/list/")
	public List<Employee> addEmployees(@RequestBody List<Employee> employee) {
		return emp.addAllEmployees(employee);
	}
	@PutMapping("/Employees/{Sapid}")
	public Employee updateEmployee(@PathVariable Long Sapid,@RequestBody Employee employee){
		return emp.updateEmployeeByid(Sapid,employee);
	}
	@DeleteMapping("/Employees/{id}")
	public Object deleteEmployee(@PathVariable Long id) {
		return emp.deleteEmployeeByid(id);
	}
}
