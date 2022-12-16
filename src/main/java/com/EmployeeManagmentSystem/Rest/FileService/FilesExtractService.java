package com.EmployeeManagmentSystem.Rest.FileService;

import java.sql.SQLException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.EmployeeManagmentSystem.Rest.Exception.DataProcessingException;
import com.EmployeeManagmentSystem.Rest.Exception.FileNotSupported;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.AdharInformation;
import com.EmployeeManagmentSystem.Rest.Model.StoreAdharByteData;
import com.EmployeeManagmentSystem.Rest.Repository.StoreAdharByteDataRepository;


/**
 * @author krishnakumar
 * service 1
 */
@Service
public class FilesExtractService implements FilesExtractServiceInterface {
//	private String fileName;
//	
//	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//            .path("/downloadFile/")
//            .path(fileName)
//            .toUriString();
	
	@Autowired
	private StoreAdharByteDataRepository byteDataRepo;
	
	private static final Logger logger=LoggerFactory.getLogger(FilesExtractService.class);
	
	private static final String Adharcard = "adharcard.pdf"; 
	
	@Autowired
	private FilesUtility utilityServices;

	@Override
	public AdharInformation ExtractFile(Long sapId,MultipartFile file) {
		AdharInformation uploadPdfFile = null;
		if(file.getOriginalFilename().contains(".pdf")) {
			try {
			 uploadPdfFile = uploadPdfFile(sapId,file);
			}catch (Exception e) {
			throw new InternalError("unable to process request --> " +e.getMessage());
			}
		}
		else if (file.getOriginalFilename().contains(".doc")) {
			uploadDocumentFile(file);
		}
		else {
		throw new FileNotSupported("File Not Support : "+ file.getOriginalFilename());
		}
		return  uploadPdfFile;
		}

	
	private AdharInformation uploadPdfFile(Long sapId, MultipartFile file) throws SQLException {
		 AdharInformation adharInfoAsText = null;
		String fileName = file.getOriginalFilename();
		if(fileName.equalsIgnoreCase(Adharcard) || fileName.contains(Adharcard)) {
			// Extract it 
			  String adharFileInformation = pdfFileExtarcter(file);
			   adharInfoAsText = utilityServices.adharInfoAsText(sapId,adharFileInformation);
		    }
		else if (file.getName().equalsIgnoreCase("")) {
			
		}
		else if (file.getName().equalsIgnoreCase("")) {
			
		}
		return adharInfoAsText;
		
	}
	
	//pdfExtarct
	public String pdfFileExtarcter(final MultipartFile multipartFile) {
	        String text;
	        try (final PDDocument document = PDDocument.load(multipartFile.getInputStream())) {
	            final PDFTextStripper pdfStripper = new PDFTextStripper();
	            text = pdfStripper.getText(document);
	        } catch (final Exception ex) {
	            logger.error("Error parsing PDF", ex);
	            text = "Error parsing PDF";
	        }
	        System.err.println(text);
	       return text;
	}
		private void uploadDocumentFile(MultipartFile file) {
			if(file.getName().equalsIgnoreCase(Adharcard)) {
				// Extract it and store details
			}
			else if (file.getName().equalsIgnoreCase("")) {
			}
			else if (file.getName().equalsIgnoreCase("")) {
			}
		}
		@Override
		public StoreAdharByteData getByteData(Long sapid) {
			StoreAdharByteData byteData;
			try {
			 byteData = byteDataRepo.findById(sapid)
					.orElseThrow(()->new ResourceNotFoundException("Employee With SapId NotFound " +sapid));
			}catch (Exception e) {
			throw new DataProcessingException(e.getMessage());
			}
			return byteData;
			
		}
	}
