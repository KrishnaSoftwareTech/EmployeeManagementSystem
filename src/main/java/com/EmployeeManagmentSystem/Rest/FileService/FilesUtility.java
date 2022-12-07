package com.EmployeeManagmentSystem.Rest.FileService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.DataProcessingException;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.AdharInformation;
import com.EmployeeManagmentSystem.Rest.Model.Employee;
import com.EmployeeManagmentSystem.Rest.Repository.AdharInformationRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeRepository;

/**
 * @author krishnakumar
 * Service 2
 */
@Service
public class FilesUtility {
	
	@Autowired
	private AdharInformationRepository adharRepo;
	@Autowired
	private EmployeeRepository employeeRepo;
//	@Autowired
//	private AdharInformation adharEntity;
	
	public void adharInfoAsText(Long sapId, String adharFileInformation) {
		//create file and write date to it 
		 File myAdharFile = processesAdharFileData(adharFileInformation);
	    try {
			List<String> adharData= getAdharInformation(myAdharFile);
			addAdharInformation(sapId,adharData);
		} catch (IOException e) {
			e.printStackTrace();}
	    }

	private void addAdharInformation(Long sapId, List<String> adharData) {
//		Long adharNumber;
//		String phoneNumber;
		AdharInformation adharEntity=new AdharInformation();
		  Employee employee = employeeRepo.findById(sapId).orElseThrow( 
  			    () -> 
  			    new ResourceNotFoundException("Employee with " +sapId+" Not Found")
                   );
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		adharEntity.setName(firstName+" "+lastName);
		adharData.stream().forEach(s-> {
			
								if(s.length()==14) {
									System.out.println(s.length());
									Long adharNumber=Long.valueOf(s);
									adharEntity.setAdharNumber(adharNumber);
								}
								else {
									System.out.println(s.length());
									String phoneNumber=s;
									adharEntity.setPhoneNumber(phoneNumber);
								}
							});
		adharEntity.setSapid(sapId);
		AdharInformation save = adharRepo.save(adharEntity);
	}

	private File processesAdharFileData(String adharFileInformation) {
		boolean NewFile = false;
		 BufferedWriter storeData = null;
		 String path="/Users/krishnakumar/Documents/store/adapters";
	      File myAdharFile = new File(path+"123");
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
		return myAdharFile;
	}

	private List<String> getAdharInformation(File myAdharFile) throws IOException {
		List<String> adharData=new ArrayList<String>();
		Matcher matcher = null;
		FileInputStream fstream = null;
		BufferedReader br;
		try {
		 fstream = new FileInputStream(myAdharFile);
		 br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		String adharNumber = null; 
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
			}
//		  if(adharNumber !=null ) {  adharData.add(adharNumber);}
//		  if(phoneNumber !=null) { adharData.add(phoneNumber); }
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
    if(matches) {
    	System.out.println(strLine);
    	return strLine;
    }
	return null;
	}
	private String getAdharNumber(Matcher matcher, String strLine, String adharNumberRegex) {
		Pattern p = Pattern.compile(adharNumberRegex);
        matcher = p.matcher(strLine);
       boolean matches = matcher.matches();
       if(matches) {
    	   System.out.println(strLine);
       //	Long AdharNumber=Long.parseLong(strLine);
       	return strLine;
       }
	return null;
	}
}
