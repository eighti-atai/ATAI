package com.atai.unter.module.enterprise.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.enterprise.dao.AddressDao;
import com.atai.unter.module.enterprise.model.Address;
import com.atai.unter.module.enterprise.model.Site;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressDao addressDao;
	
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Transactional
	public void addService(Address address) {
		addressDao.addAddress(address);

	}

	@Transactional
	public void updateAddress(Address address) {
		addressDao.updateAddress(address);

	}

	@Transactional(readOnly = true)
	public List<Address> listAddresses() {
		return addressDao.listAddresses();
	}

	@Transactional(readOnly = true)
	public Address getAddressById(int addressId) {
		return addressDao.getAddressById(addressId);
	}

	@Transactional
	public void removeAddress(int addressId) {
		addressDao.removeAddress(addressId);

	}
	
	@Transactional(readOnly = true)
	public Address getAddressByObjid(String objid) {
		return addressDao.getAddressByObjid(objid);
	}

	@Transactional(readOnly = true)
	public List<Address> executeSelectQuery(Address address) {
		return addressDao.executeSelectQuery(address);
	}

}
