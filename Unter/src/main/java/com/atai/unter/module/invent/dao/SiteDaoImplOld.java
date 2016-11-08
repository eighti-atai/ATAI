package com.atai.unter.module.invent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.invent.model.Site;

public class SiteDaoImpl implements SiteDao
{
	private SessionFactory sessionFactory;
	
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
	
}
