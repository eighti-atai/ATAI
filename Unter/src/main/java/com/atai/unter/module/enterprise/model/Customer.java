package com.atai.unter.module.enterprise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.atai.unter.generic.interfaces.Model;

import com.atai.unter.generic.interfaces.Model;

@Entity
@Table(name = "customer_tab")
public class Customer implements Model<String>{
	@Id
	@Column(name = "customer_id")
	private String customerId;
	
	public String getId() {
		return getCustomerId();
	}

	public void setId(String id) {
		setCustomerId(id);
	}

	@Column(name = "customer_name")
	private String customerName;
	
	private String nic;
	
	@Column(name = "address_id")
	private int addressId;
	
	@Column(name = "phone_no_1")
	private String phoneNo1;
	
	@Column(name = "phone_no_2")
	private String phoneNo2;
	
	private String objid;

	@OneToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", insertable = false, updatable = false)
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public String getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}
}
