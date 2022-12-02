package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

public class AdharInformation {

	@Id
	private Long sapid;
	@Column(name="Employee_Name")
	private String name;
	private String phoneNumber;
	@NonNull
	private Long AdharNumber;
	private String Gender;
	
}
