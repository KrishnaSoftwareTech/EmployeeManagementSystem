package com.EmployeeManagmentSystem.Rest.Model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author krishnakumar
 *
 */
@Entity
public class Employee {

	@Id
	private Long sapID;
    @Column(nullable = false, length=32)
	private String firstName;
    @Column(nullable = false,length=16)
	private String  lastName;
    @Column(nullable = false)
	private Double Salary;
    private Date startDate;
	@Column(nullable = false)
	private String Location; 
	private String Designation;
    
	/**
	 * 
	 */
	public Employee() {
		super();
	}

	/**
	 * Constructer
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param salary
	 * @param startDate
	 * @param location
	 * @param designation
	 */
	public Employee(Long id, String firstName, String lastName, Double salary, Date startDate, String location,
			String designation) {
		super();
		this.sapID = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Salary = salary;
		this.startDate = startDate;
		Location = location;
		Designation = designation;
	}
	
	@Override
	public String toString() {
		return "Employee [sapID=" + sapID + ", firstName=" + firstName + ", lastName=" + lastName + ", Salary=" + Salary
				+ ", startDate=" + startDate + ", Location=" + Location + ", Designation=" + Designation + "]";
	}

	/**
	 * @Getters 
	 * @Setters
	 */
	public Long getId() {
		return sapID;
	}
	public void setId(Long id) {
		this.sapID = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getSalary() {
		return Salary;
	}
	public void setSalary(Double salary) {
		Salary = salary;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
}
