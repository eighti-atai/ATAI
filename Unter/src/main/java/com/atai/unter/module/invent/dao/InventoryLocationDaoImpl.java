package com.atai.unter.module.invent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.invent.model.InventoryLocation;
import com.atai.unter.module.invent.model.InventoryLocationKey;

@Repository
public class InventoryLocationDaoImpl implements InventoryLocationDao{

	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addData(InventoryLocation p) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(p);
	}

	public void updateData(InventoryLocation p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
	}

	public List<InventoryLocation> listData() {
		Session session = sessionFactory.getCurrentSession();
		List<InventoryLocation> locations = session.createQuery("from InventoryLocation").list();
		return locations;
	}

	public InventoryLocation getInventoryLocationById(InventoryLocationKey invLocationId) {
		Session session = sessionFactory.getCurrentSession();
		InventoryLocation invLocation = session.load(InventoryLocation.class, invLocationId);
		return invLocation;
	}

	public void removeInventoryLocation(InventoryLocationKey invLocationId) {
		Session session = sessionFactory.getCurrentSession();
		InventoryLocation invLocation = session.load(InventoryLocation.class, invLocationId);
		if (invLocation != null)
		{
			session.delete(invLocation);
		}
	}

}
