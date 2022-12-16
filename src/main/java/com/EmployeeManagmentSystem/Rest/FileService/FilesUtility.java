package com.EmployeeManagmentSystem.Rest.FileService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.DataProcessingException;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.AdharInformation;
import com.EmployeeManagmentSystem.Rest.Model.Employee;
import com.EmployeeManagmentSystem.Rest.Model.StoreAdharByteData;
import com.EmployeeManagmentSystem.Rest.Repository.AdharInformationRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeRepository;
import com.EmployeeManagmentSystem.Rest.Repository.StoreAdharByteDataRepository;

/**
 * @author krishnakumar
 * Service 2
 */
@Service
public class FilesUtility {
	 public static final String path="/Users/krishnakumar/Documents/store/adapters";
	@Autowired
	private AdharInformationRepository adharRepo;
	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private StoreAdharByteDataRepository byteDataRepo;
	
	public AdharInformation adharInfoAsText(Long sapId, String adharFileInformation) throws SQLException {
		AdharInformation addAdharInformation = null;
		//create file and write date to it 
		 File myAdharFile = processesAdharFileData(sapId,adharFileInformation);
		 storingByteData(sapId, myAdharFile);
	    try {
			Set<Object> adharData= getAdharInformation(myAdharFile);
			 addAdharInformation = addAdharInformation(sapId,adharData);
		} catch (IOException e) {
			e.printStackTrace();}
	    return addAdharInformation;
	    }

	private void storingByteData(Long sapId, File myAdharFile) {
		//storing as  byte array
		 Path filePath = myAdharFile.toPath(); //.getPath();
		 try {
			byte[] readAllLines = Files.readAllBytes(filePath);
			System.err.println(readAllLines);
			//obj 
			StoreAdharByteData storeFileData=new StoreAdharByteData();
			storeFileData.setAdharData(readAllLines);
			storeFileData.setSapid(sapId);
			StoreAdharByteData save = byteDataRepo.save(storeFileData);
			System.out.println(save);
		} catch (IOException exp) {
			throw new DataProcessingException(exp.getLocalizedMessage());
		}
	}

	private AdharInformation addAdharInformation(Long sapId, Set<Object> adharData) {
		AdharInformation adharEntity=new AdharInformation();
		Employee employee = employeeRepo.findById(sapId).orElseThrow(() -> 
  			    new ResourceNotFoundException("Employee with " +sapId+" Not Found"));
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		adharEntity.setSapid(sapId);
		adharEntity.setName(firstName+" "+lastName);
		adharData.stream().forEach(s-> {
			if(s.toString().length() ==10) {
					System.out.println(s.toString().length());
					 adharEntity.setPhoneNumber(s.toString());
			}
			else if(s.toString().length() == 6 || s.toString().length() ==4) {
				adharEntity.setGender(s.toString());
			}
			else if(s.toString() ==null) {
				adharEntity.setGender("Male");
			}
			else {
					long adharNumber = ((Long)s).longValue();
					System.out.println(adharNumber);
					adharEntity.setAdharNumber(adharNumber);
			}
		});
		AdharInformation save = adharRepo.save(adharEntity);
		return save;
	}


	private Set<Object> getAdharInformation(File myAdharFile) throws IOException {
		Set<Object> adharData=new HashSet<Object>();
		Matcher matcher = null;
		FileInputStream fstream = null;
		BufferedReader br;
		try {
		 fstream = new FileInputStream(myAdharFile);
		 br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		Long adharNumber = null; 
		String phoneNumber = null;
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
			 String adharNumberRegex= "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
			 String phoneNumberRegex="[789][0-9]{9}";
			// get adhar number
			   adharNumber = getAdharNumber(matcher,strLine,adharNumberRegex);
			   if(adharNumber !=null ) {  adharData.add(adharNumber);}
			// get phoneNumber
			   phoneNumber = getPhoneNumber(matcher,strLine,phoneNumberRegex);
			   if(phoneNumber !=null) { adharData.add(phoneNumber); }
			//   if(strLine.equalsIgnoreCase("FEMALE")) { adharData.add("Female");  }
			   if(strLine.contains("FEMALE")) {
				   System.err.println(strLine);
				   adharData.add("Female");  }
//			   if(strLine.contains("MALE")) {
//				  for (Object object : adharData) {
//					if(object.toString().contains("FEMALE")) { }
//					else {adharData.add("MALE");}
//				}
//			   }
			}
		}catch (Exception e) {
			throw  new DataProcessingException(e.getMessage()) ;}
		finally {
			fstream.close();}
		return adharData;
	}
 private String getPhoneNumber(Matcher matcher, String strLine, String phoneNumberRegex) {
	 Pattern p = Pattern.compile(phoneNumberRegex);
     matcher = p.matcher(strLine);
    boolean matches = matcher.matches();
    if(!matches) {
    	return null;
    }else {
     	System.out.println(strLine);
    	return strLine;}
}
	private Long getAdharNumber(Matcher matcher, String strLine, String adharNumberRegex) {
		Pattern p = Pattern.compile(adharNumberRegex);
        matcher = p.matcher(strLine);
       boolean matches = matcher.matches();
       if(!matches) {
    		return null;
       }
       else {
    	   System.out.println(strLine);
    	   String replaceAll = strLine.replaceAll(" ", "");
          long AdharNumber=Long.valueOf(replaceAll);
       	return AdharNumber;
       }
    }
	private File processesAdharFileData(Long sapId, String adharFileInformation) {
		boolean NewFile = false;
		 BufferedWriter storeData = null;
	      File myAdharFile = new File(path+sapId);
	      //create file
	      if(!myAdharFile.exists()) {
	    	   try {
				NewFile = myAdharFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();}}
        //write adhar info
         if(NewFile) {
        	try {
        	 storeData=new BufferedWriter(new FileWriter(myAdharFile));
        	 storeData.write(adharFileInformation);
        	 }catch (IOException e) {
				e.getMessage();}
        	 finally {
        		 try {
					storeData.close();
				} catch (IOException e) {
					e.printStackTrace();}}
        	}
		return myAdharFile; }
	
	
}
