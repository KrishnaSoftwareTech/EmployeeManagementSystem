package com.EmployeeManagmentSystem.Rest.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Model.EducationDetails;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.EducationDetailsInterface;

/**
 * @author krishnakumar
 * @Url api/service/Employees/{sapId}/EmployeeInfo/EducationDetails
 */
@RestController
@RequestMapping("api/service/")
public class EducationDetailsController {
	
	@Autowired
	private EducationDetailsInterface educationInfo;

	@GetMapping("/Employees/{sapId}/EmployeeInfo/EducationDetails")
	public EducationDetails getEducationDetails(@PathVariable Long sapId) throws InternalServerException {
		Optional<EducationDetails> employeeEducationInfo = educationInfo.getEmployeeEducationInfo(sapId);
		return employeeEducationInfo.get();
	}
	@PostMapping("/Employees/{sapId}/EmployeeInfo/EducationDetails")
	public EducationDetails addEducationDetails(@PathVariable Long sapId,@RequestBody EducationDetails educationDetails) {
		EducationDetails addEmployeeEducationinfo = educationInfo.addEmployeeEducationinfo(sapId,educationDetails);
		return addEmployeeEducationinfo;
	}
	@PutMapping("/Employees/{sapId}/EmployeeInfo/EducationDetails")
	public EducationDetails updateEducationDetails(@PathVariable Long sapId,@RequestBody EducationDetails educationDetails) {
		educationInfo.updateEducationInfo(sapId,educationDetails);
		return null;
	}
	@DeleteMapping("/Employees/{sapId}/EmployeeInfo/EducationDetails")
	public ResponseEntity<HttpStatus> deleteEducationDetails(@PathVariable Long sapId) {
		educationInfo.deleteEducationInfo(sapId);
		return null;
	}
	
	///
//	{
//	    "sapId": 51913559,
//	    "intermedite": {
//	        "interBoard": "IE-AP",
//	        "interUniversityName": "Sri Vivekananda Junior College",
//	        "interPercentage": 84,
//	        "country": "India"
//	    },
//	    "graduation": {
//	        "graduationUniversityName": "St.Mark Educational Institutions",
//	        "graduationBoard": "JNTU-Anantapur",
//	        "graduationpercentage": 78,
//	        "country": "India"
//	    },
//	    "school": {
//	        "percentage": 72,
//	        "schoolBoard": "SSC-AP",
//	        "schoolUniversityName": "Sri Ushodaya E/M School",
//	        "country": "India"
//	    }
//	}
}
