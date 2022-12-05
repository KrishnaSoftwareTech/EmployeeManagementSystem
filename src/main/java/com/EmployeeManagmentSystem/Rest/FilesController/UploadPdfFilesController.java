package com.EmployeeManagmentSystem.Rest.FilesController;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.FileService.FilesExtractServiceInterface;

/**
 * @author krishnakumar
 *  "/Employees/{sapid}/EmployeeInfo/BankDetails"
 */
@RestController
@RequestMapping("api/service/")
public class UploadPdfFilesController {
	
    //   bank details , educationDetails (marksMemo,)  ,  -- bankpassbook.doc ,pdf 
    //   For personal details -- form or pdf \
    //  AdharCard -- sapid, name ,sex, adhar_number
    //  Pan Card -- sapid,PAN number , name 
	//  resume upload ,profiles , certifications 
	//  Get - paySlips  based on month  
     /**
  	 * @param firstName
  	 * @param lastName
  	 * @param middleName
  	 * @param maritualStatus
  	 * @param gender
  	 * @param nationality
  	 * @param countryOfBirth
  	 * @param stateOfBirth
  	 * @param citizen
  	 * @param dateOfBirth
  	 * @param familyDetails
  	 */
	
	@Autowired
	private FilesExtractServiceInterface filesService;
	
	@PostMapping("/Employee/{sapid}/uploadFile")
	public ResponseEntity<Object> uploadFiles(@PathVariable Long sapid,@RequestParam("file") MultipartFile file) {
		try{
			String originalFilename = file.getOriginalFilename();
			filesService.ExtractFile(file);
			String message = "Uploaded the file successfully: " + file.getOriginalFilename();
		    return ResponseEntity.status(HttpStatus.OK).body(message);
		}catch (Exception e) {
			 String message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
		
		
	}
	
	@PostMapping("/uploadMultipleFiles")
    public ResponseEntity<List<Object>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        
         return null;
    }
     
}
