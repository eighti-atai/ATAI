package com.atai.unter.module.invent.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "site_tab")
public class Site {

	@Id
	@Column(name = "site_id")
	private String siteId;
	
	@Column(name = "address_id")
	private int addressId;
	
	@Column(name = "phone_no_1")
	private int phoneNo1;
	
	@Column(name = "phone_no_2")
	private int phoneNo2;
	
	@OneToMany(mappedBy = "site")
	private Set<InventoryLocation> invLocations;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(int phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public int getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(int phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public Set<InventoryLocation> getInvLocations() {
		return invLocations;
	}
	
	
}
