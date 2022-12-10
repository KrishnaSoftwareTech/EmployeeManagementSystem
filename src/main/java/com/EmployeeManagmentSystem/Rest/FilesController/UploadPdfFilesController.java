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
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.FileService.FilesExtractServiceInterface;
import com.EmployeeManagmentSystem.Rest.Model.AdharInformation;

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
	
	@PostMapping("/Employee/{sapId}/uploadFile")
	public ResponseEntity<AdharInformation> uploadFiles(@PathVariable Long sapId,@RequestParam("file") MultipartFile file) {
		try{
		//	String originalFilename = file.getOriginalFilename();
			AdharInformation extractFile = filesService.ExtractFile(sapId,file);
		//	String message = "Uploaded the file successfully: " + file.getOriginalFilename();
		  //  return ResponseEntity.ok(extractFile);  //  .status(HttpStatus.OK).body(extractFile);
			return new ResponseEntity<AdharInformation>(extractFile, HttpStatus.CREATED);
		}catch (Exception e) {
		//	 String message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		      return new ResponseEntity<AdharInformation>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@PostMapping("/uploadMultipleFiles")
    public ResponseEntity<List<Object>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        
         return null;
    }
     
}
