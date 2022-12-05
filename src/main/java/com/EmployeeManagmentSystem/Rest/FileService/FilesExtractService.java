package com.EmployeeManagmentSystem.Rest.FileService;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//Importing Apache POI classes
//import org.apache.tika.metadata.Metadata;
//import org.apache.tika.parser.ParseContext;
//import org.apache.tika.parser.pdf.PDFParser;
//import org.apache.tika.sax.BodyContentHandler;

/**
 * @author krishnakumar
 *
 */
@Service
public class FilesExtractService implements FilesExtractServiceInterface {
//	private String fileName;
//	
//	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//            .path("/downloadFile/")
//            .path(fileName)
//            .toUriString();
	
	private static final Logger logger=LoggerFactory.getLogger(FilesExtractService.class);
	
	private static final String Adharcard = "adharcard"; 
	

	@Override
	public void ExtractFile(MultipartFile file) {
		if(file.getOriginalFilename().contains(".pdf")) {
			uploadPdfFile(file);
		}
		else if (file.getOriginalFilename().contains(".doc")) {
			uploadDocumentFile(file);
		}
		else {
		//	throw new duplicateFile();
		}
		
	}

	private void uploadPdfFile(MultipartFile file) {
		if(file.getName().equalsIgnoreCase(Adharcard)) {
			// Extract it and store details
			  AdharFileInformation(file);
		}
		else if (file.getName().equalsIgnoreCase("")) {
			
		}
		else if (file.getName().equalsIgnoreCase("")) {
			
		}
		
	}
	
	private void uploadDocumentFile(MultipartFile file) {
		if(file.getName().equalsIgnoreCase(Adharcard)) {
			// Extract it and store details
			  AdharFileInformation(file);
		}
		else if (file.getName().equalsIgnoreCase("")) {
			
		}
		else if (file.getName().equalsIgnoreCase("")) {
			
		}
	}

	public boolean AdharFileInformation(MultipartFile file){

		return true;
		
	}



}
