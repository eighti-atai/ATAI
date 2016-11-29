package com.atai.unter.module.enterprise.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.atai.unter.generic.dao.AbstractDao;
import com.atai.unter.module.enterprise.model.Address;
import com.atai.unter.module.enterprise.model.Site;

@Repository
public class AddressDaoImpl extends AbstractDao<String, Address> implements AddressDao {

	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(address);
	}

	public void updateAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.update(address);

	}

	public List<Address> listAddresses() {
		Session session = sessionFactory.getCurrentSession();
		List<Address> addresses = session.createQuery("from Address").list();
		return addresses;
	}

	public Address getAddressById(int addressId) {
		Session session  = sessionFactory.getCurrentSession();
		Address address = session.load(Address.class, new Integer(addressId));
		return address;
	}

	public void removeAddress(int addressId) {
		Session session = sessionFactory.getCurrentSession();
		Address address = session.load(Address.class, new Integer(addressId));
		if (address != null)
		{
			session.delete(address);
		}

	}
	
	public Address getAddressByObjid(String objid) {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Address> addressList = session.createQuery("from Address where objid = '" + objid+"'").list();
		Address address = addressList.get(0);
		
		return address;
	}

}
