package com.atai.unter.module.enterprise.dao;

import java.util.List;

import com.atai.unter.module.enterprise.model.Address;

public interface AddressDao {

	public void addAddress(Address address);
	public void updateAddress(Address address);
	public List<Address> listAddresses();
	public Address getAddressById(int addressId);
	public void removeAddress(int addressId);
}
