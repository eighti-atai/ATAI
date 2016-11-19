package com.atai.unter.module.enterprise.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.enterprise.model.Site;
import com.atai.unter.module.order.model.SalesPart;

@Repository
public class SiteDaoImpl implements SiteDao
{
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addData(Site p) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(p);
	}

	public void updateData(Site p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
		
	}

	public List<Site> listData() {
		Session session = sessionFactory.getCurrentSession();
		List<Site> sites = session.createQuery("from Site").list();
		return sites;
	}

	public Site getSiteById(String siteId) {
		Session session = sessionFactory.getCurrentSession();
		Site site = session.get(Site.class, new String(siteId));
		return site;
	}

	public void removeSite(String siteId) {
		Session session = sessionFactory.getCurrentSession();
		Site site = session.load(Site.class, new String(siteId));
		if (site != null){
			session.delete(site);
		}
	}
	
	public Site getSiteByObjid(String objid) {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Site> siteList = session.createQuery("from Site where objid = '" + objid+"'").list();
		Site site = siteList.get(0);
		
		return site;
	}
	
}
