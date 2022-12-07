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

import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.DataProcessingException;

/**
 * @author krishnakumar
 *
 */
@Service
public class FilesUtility {

	public void adharInfoAsText(String adharFileInformation) {
		//create file and write date to it 
		 File myAdharFile = processesAdharFileData(adharFileInformation);
	    try {
			List<String> AdharNumber = isValidAdharNumber(myAdharFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	private List<String> isValidAdharNumber(File myAdharFile) throws IOException {
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
			// get phoneNumber
			   phoneNumber = getPhoneNumber(matcher,strLine,phoneNumberRegex);
			
			  }
		  if(adharNumber !=null  )
			  adharData.add(phoneNumber);
			  adharData.add(phoneNumber);
		}catch (Exception e) {
			throw  new DataProcessingException(e.getMessage()) ;}
		finally {
			fstream.close();}
		return null;
	}
 private String getPhoneNumber(Matcher matcher, String strLine, String phoneNumberRegex) {
	 Pattern p = Pattern.compile(phoneNumberRegex);
     matcher = p.matcher(strLine);
    boolean matches = matcher.matches();
    if(matches) {
    	return strLine;
    }
	return null;
	}
	private String getAdharNumber(Matcher matcher, String strLine, String adharNumberRegex) {
		Pattern p = Pattern.compile(adharNumberRegex);
        matcher = p.matcher(strLine);
       boolean matches = matcher.matches();
       if(matches) {
       //	Long AdharNumber=Long.parseLong(strLine);
       	return strLine;
       }
	return null;
	}
}
