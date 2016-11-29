package com.atai.unter.module.enterprise.service;

import java.util.List;

import com.atai.unter.module.enterprise.model.Address;
import com.atai.unter.module.enterprise.model.Site;

public interface AddressService {

	public void addService(Address a);
	public void updateAddress(Address a);
	public List<Address> listAddresses();
	public Address getAddressById(int id);
	public void removeAddress(int id);
	public Address getAddressByObjid(String objid);
	public List<Address> executeSelectQuery(Address site);
}
