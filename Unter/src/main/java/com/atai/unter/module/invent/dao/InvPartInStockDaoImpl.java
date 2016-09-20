package com.atai.unter.module.invent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.invent.model.InvPartInStock;

@Repository
public class InvPartInStockDaoImpl implements InvPartInStockDao{

	SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addData(InvPartInStock p) {
		Session session  = sessionFactory.getCurrentSession();
		session.persist(p);
	}

	public void updateData(InvPartInStock p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
		
	}

	public List<InvPartInStock> listData() {
		Session session = sessionFactory.getCurrentSession();
		List<InvPartInStock> invPartCost = session.createQuery("from InvPartInStock").list();
		return invPartCost;
	}

	public InvPartInStock getInvPartInStockById(InvPartInStock.InvPartInStockKey invPartCostId) {
		Session session = sessionFactory.getCurrentSession();
		return session.load(InvPartInStock.class, invPartCostId);
	}

	public void removeInvPartInStock(InvPartInStock.InvPartInStockKey invPartCostId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.load(InvPartInStock.class, invPartCostId));
		
	}

	
}
