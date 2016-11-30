package com.atai.unter.module.invent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.atai.unter.generic.dao.AbstractDao;
import com.atai.unter.module.invent.model.InventoryLocation;
import com.atai.unter.module.invent.model.InventoryLocationKey;
import com.atai.unter.module.invent.model.InventoryPart;
import com.atai.unter.module.invent.model.InventoryPartKey;

public class InventoryPartDaoImpl extends AbstractDao<InventoryPartKey, InventoryPart> implements InventoryPartDao {

	private SessionFactory sessionFactory;
	
	public void addData(InventoryPart p) {
		Session session  = sessionFactory.getCurrentSession();
		session.persist(p);

	}

	public void updateData(InventoryPart p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
	}

	public List<InventoryPart> listData() {
		Session session = sessionFactory.getCurrentSession();
		List<InventoryPart> invParts = session.createQuery("from InventoryPart").list();
		return invParts;
	}

	public InventoryPart getInventoryPartById(InventoryPartKey invPartId) {
		Session session = sessionFactory.getCurrentSession();
		InventoryPart invPart = session.load(InventoryPart.class, invPartId);
		return invPart;
	}

	public void remove(InventoryPartKey invPartId) {
		Session session = sessionFactory.getCurrentSession();
		InventoryPart invPart = session.load(InventoryPart.class, invPartId);
		if (invPart != null)
		{
			session.delete(invPart);
		}
	}

	public InventoryPart getInventoryPartByObjid(String objid) {
		Session session = this.sessionFactory.getCurrentSession();	
		List<InventoryPart> invPartList = session.createQuery("from InventoryPart where objid = '" + objid+"'").list();
		InventoryPart invPart = invPartList.get(0);
		
		return invPart;
	}

	public void removeInventoryPart(InventoryPartKey invPartId) {
		Session session = sessionFactory.getCurrentSession();
		InventoryPart invPart = session.load(InventoryPart.class, invPartId);
		if (invPart != null)
		{
			session.delete(invPart);
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
