package com.atai.unter.module.order.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.order.model.SalesPart;
//import com.mysql.cj.mysqlx.protobuf.MysqlxCrud.Collection;

@Repository
public class SalesPartDaoImpl implements SalesPartDao  {
private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addSalesPart(SalesPart p) {
		Session session =  sessionFactory.getCurrentSession();
		session.persist(p);
	}

	public void updateSalesPart(SalesPart p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
	}

	public List<SalesPart> listSalesPart() {
		//Session session = sessionFactory.getCurrentSession();
		List<SalesPart> salesPartList = null;// = Collection.checkedList ( session.createQuery("from sales_part_tab"),SalesPart.c);
		return salesPartList;
		//return null;
	}

	public SalesPart getSalesPartById(String SalesPartNo) {
		Session session = this.sessionFactory.getCurrentSession();		
		SalesPart p = (SalesPart) session.load(SalesPart.class, new String(SalesPartNo));
		return p;
	}

	public void removeSalesPart(String SalesPartNo) {
		Session session = this.sessionFactory.getCurrentSession();	
		SalesPart p = (SalesPart) session.load(SalesPart.class, new String(SalesPartNo));
		if(null != p){
			session.delete(p);
		}
	}
}
