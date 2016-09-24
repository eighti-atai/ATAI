package com.atai.unter.module.invent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.invent.model.InventoryPart;

@Repository
public class InventoryPartDaoImpl implements InventoryPartDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addInventoryPart(InventoryPart invPart) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(invPart);
	}

	public void updateInventoryPart(InventoryPart invPart) {
		// TODO Auto-generated method stub

	}

	public List<InventoryPart> listInventoryParts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<InventoryPart> invPartList = session.createQuery("from InventoryPart").list();
		return invPartList;
	}

	public InventoryPart getInventoryPartByNo(String invPartNo) {
		Session session = this.sessionFactory.getCurrentSession();
		// do not use load https://www.mkyong.com/hibernate/different-between-session-get-and-session-load/
		InventoryPart invPart2 = (InventoryPart)session.get(InventoryPart.class, new String(invPartNo));
		return invPart2;
	}

	public void removeInventoryPart(String sPartNo) {
		// TODO Auto-generated method stub

	}

}
