package com.atai.unter.module.order.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.invent.model.InventoryPartCost;
import com.atai.unter.module.order.model.SalesPart;
import com.atai.unter.module.order.model.SalesPartPrice;
import com.atai.unter.module.order.model.SalesPartPriceKey;

@Repository
public class SalesPartPriceDaoImpl implements SalesPartPriceDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addData(SalesPartPrice p) {	
		Session session = sessionFactory.getCurrentSession();
		session.persist(p);		
	}

	public void updateData(SalesPartPrice p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
	}

	public List<SalesPartPrice> listData() {
		Session session = sessionFactory.getCurrentSession();
		List<SalesPartPrice> salesPartPrice = session.createQuery("from SalesPartPrice").list();
		return salesPartPrice;
	}

	public SalesPartPrice getSalesPartPrice(SalesPartPriceKey id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(SalesPartPrice.class, id);
	}

	public void removeSalesPartPrice(SalesPartPriceKey id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.load(SalesPartPrice.class, id));
	}

}
