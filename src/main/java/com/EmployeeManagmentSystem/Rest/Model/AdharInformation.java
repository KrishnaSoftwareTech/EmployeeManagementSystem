package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

/**
 * @author krishnakumar
 *  
 */
public class AdharInformation {

	@Id
	private Long sapid;
	@Column(name="Employee_Name")
	private String name;
	private String phoneNumber;
	@NonNull
	private Long AdharNumber;
	private String Gender;
	
	public AdharInformation(){
		super();
	}

	/**
	 * @param sapid
	 * @param name
	 * @param phoneNumber
	 * @param adharNumber
	 * @param gender
	 */
	public AdharInformation(Long sapid, String name, String phoneNumber, Long adharNumber, String gender) {
		super();
		this.sapid = sapid;
		this.name = name;
		this.phoneNumber = phoneNumber;
		AdharNumber = adharNumber;
		Gender = gender;
	}

	public Long getSapid() {
		return sapid;
	}

	public void setSapid(Long sapid) {
		this.sapid = sapid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getAdharNumber() {
		return AdharNumber;
	}

	public void setAdharNumber(Long adharNumber) {
		AdharNumber = adharNumber;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
	@Override
	public String toString() {
		return "AdharInformation [sapid=" + sapid + ", name=" + name + ", phoneNumber=" + phoneNumber + ", AdharNumber="
				+ AdharNumber + ", Gender=" + Gender + "]";
	}
	
}
