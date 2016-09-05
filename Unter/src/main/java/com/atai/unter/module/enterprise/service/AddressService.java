package com.atai.unter.module.enterprise.service;

import java.util.List;

import com.atai.unter.module.enterprise.model.Address;

public interface AddressService {

	public void addService(Address a);
	public void updateAddress(Address a);
	public List<Address> listAddresses();
	public Address getAddressById(int id);
	public void removeAddress(int id);
}
