package com.atai.unter.module.order.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.atai.unter.module.order.model.SalesPart;


@Repository
public class SalesPartDaoImpl implements SalesPartDao  {
private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addSalesPart(SalesPart salesPart) {
		Session session =  sessionFactory.getCurrentSession();
		session.persist(salesPart);
	}

	public void updateSalesPart(SalesPart salesPart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(salesPart);
	}

	public List<SalesPart> listSalesPart() {
		Session session = sessionFactory.getCurrentSession();
		//List<SalesPart> salesPartList = null;// = Collection.checkedList ( session.createQuery("from sales_part_tab"),SalesPart.c);
		List<SalesPart> salesPartList = session.createQuery("from SalesPart").list();
		return salesPartList;
		//return null;
	}

	public SalesPart getSalesPartById(String salesPartId) {
		Session session = this.sessionFactory.getCurrentSession();		
		SalesPart salesPart = session.get(SalesPart.class, new String(salesPartId));
		return salesPart;
	}

	public void removeSalesPart(String salesPartId) {
		Session session = this.sessionFactory.getCurrentSession();	
		SalesPart salesPart = (SalesPart) session.load(SalesPart.class, new String(salesPartId));
		if(null != salesPart){
			session.delete(salesPart);
		}
	}
}
