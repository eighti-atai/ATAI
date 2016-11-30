package com.atai.unter.module.invent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atai.unter.generic.dao.AbstractDao;
import com.atai.unter.module.invent.model.InventoryPartCost;
import com.atai.unter.module.invent.model.InventoryPartCostKey;

@Repository
public class InventoryPartCostDaoImpl  extends AbstractDao<InventoryPartCostKey, InventoryPartCost> implements InventoryPartCostDao{

	SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addData(InventoryPartCost p) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(p);
	}

	public void updateData(InventoryPartCost p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
	}

	public List<InventoryPartCost> listData() {
		Session session = sessionFactory.getCurrentSession();
		List<InventoryPartCost> invPartCosts = session.createQuery("from InventoryPartCost").list();
		return invPartCosts;
	}

	public InventoryPartCost getInventoryPartCostById(InventoryPartCostKey invPartCostId) {
		Session session  = sessionFactory.getCurrentSession();
		return session.load(InventoryPartCost.class, invPartCostId);
	}

	public void removeInventoryPartCost(InventoryPartCostKey invPartCostId) {
		Session session = sessionFactory.getCurrentSession();
		InventoryPartCost invPartCost = session.load(InventoryPartCost.class, invPartCostId);
		if (invPartCost != null)
		{
			session.delete(invPartCost);
		}
	}

	public InventoryPartCost getInventoryPartCostByObjid(String objid) {
		Session session = this.sessionFactory.getCurrentSession();	
		List<InventoryPartCost> invPartCostList = session.createQuery("from InventoryPartCost where objid = '" + objid+"'").list();
		InventoryPartCost invPartCost = invPartCostList.get(0);
		
		return invPartCost;
	}

	
}
