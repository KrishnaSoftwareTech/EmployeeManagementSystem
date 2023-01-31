package com.EmployeeManagmentSystem.Rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.EmployeeCentralizedSchemas;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeCentralizedSchemasRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.EmployeeCentralizedSchemaServiceInterface;

/**
 * @author krishnakumar
 * http://localhost:8080/api/service/EmployeeSchema/14898912 
 *
 */
// Get 
@RestController
@RequestMapping("api/service/")
public class EmployeeCentralizedSchemasController {
//	@Autowired
//	private EmployeeCentralizedSchemasRepository empSchema;
	
	@Autowired
	private EmployeeCentralizedSchemaServiceInterface empSchema;
	
	@GetMapping("EmployeeSchema/{sapid}")
	public ResponseEntity<List<Object>> getSchema(@PathVariable Long  sapid) {
	//	EmployeeCentralizedSchemas employeeSchema = 
				List<Object> allSchema = empSchema.getAllSchema(sapid);
//				.findById(sapid)
//		.orElseThrow(() ->new ResourceNotFoundException("Employee Not Found " + sapid)); //.orElse( throw new Em)
		return  ResponseEntity.ok().body(allSchema);
		
	}
}
