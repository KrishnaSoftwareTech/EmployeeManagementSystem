package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author krishnakumar
 *
 */
@Entity
@Table(name="AdharData")
public class StoreAdharByteData {
	@Id
	private Long sapid;
	
	private byte[] adharData;

	public StoreAdharByteData() {
	}

	/**
	 * @param sapid
	 * @param adharData
	 */
	public StoreAdharByteData(Long sapid, byte[] adharData) {
		super();
		this.sapid = sapid;
		this.adharData = adharData;
	}

	public Long getSapid() {
		return sapid;
	}

	public void setSapid(Long sapid) {
		this.sapid = sapid;
	}

	public byte[] getAdharData() {
		return adharData;
	}

	public void setAdharData(byte[] adharData) {
		this.adharData = adharData;
	}

	
	

}
