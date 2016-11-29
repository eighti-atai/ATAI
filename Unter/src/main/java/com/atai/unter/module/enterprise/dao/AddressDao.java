package com.atai.unter.module.enterprise.dao;

import java.util.List;

import com.atai.unter.module.enterprise.model.Address;
import com.atai.unter.module.enterprise.model.Site;

public interface AddressDao {

	public void addAddress(Address address);
	public void updateAddress(Address address);
	public List<Address> listAddresses();
	public Address getAddressById(int addressId);
	public void removeAddress(int addressId);
	public Address getAddressByObjid(String objid);
	public List<Address> executeSelectQuery(Address address);
}
