package com.atai.unter.module.invent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.invent.model.SiteOld;

public class SiteDaoImplOld implements SiteDaoOld
{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addData(SiteOld p) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(p);
	}

	public void updateData(SiteOld p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
		
	}

	public List<SiteOld> listData() {
		Session session = sessionFactory.getCurrentSession();
		List<SiteOld> sites = session.createQuery("from Site").list();
		return sites;
	}

	public SiteOld getSiteById(String siteId) {
		Session session = sessionFactory.getCurrentSession();
		SiteOld site = session.get(SiteOld.class, new String(siteId));
		return site;
	}

	public void removeSite(String siteId) {
		Session session = sessionFactory.getCurrentSession();
		SiteOld site = session.load(SiteOld.class, new String(siteId));
		if (site != null){
			session.delete(site);
		}
	}
	
}