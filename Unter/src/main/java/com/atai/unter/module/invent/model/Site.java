package com.atai.unter.module.invent.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.atai.unter.module.enterprise.model.Address;

@Entity
@Table(name = "site_tab")
public class Site implements Serializable{

	@Id
	@Column(name = "site_id")
	@Size(min = 2, max = 10)
	private String siteId;
	
	@Column(name = "address_id")
	private int addressId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id",insertable = false, updatable = false)
	private Address address;
	
	@Column(name = "phone_no_1")
	private int phoneNo1;
	
	@Column(name = "phone_no_2")
	private int phoneNo2;
	
	private String objid;
	
	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setInvLocations(Set<InventoryLocation> invLocations) {
		this.invLocations = invLocations;
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
