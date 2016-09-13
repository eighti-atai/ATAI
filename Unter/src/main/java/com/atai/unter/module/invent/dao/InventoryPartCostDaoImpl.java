package com.atai.unter.module.invent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.invent.model.InventoryPartCost;
import com.atai.unter.module.invent.model.InventoryPartCostKey;

@Repository
public class InventoryPartCostDaoImpl implements InventoryPartCostDao{

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
		session.delete(session.load(InventoryPartCost.class, invPartCostId));
	}

	
}
