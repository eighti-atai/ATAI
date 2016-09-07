package com.atai.unter.module.invent.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.atai.unter.generic.interfaces.DataAcccessObject;

@Repository
public class SiteDaoImpl implements DataAcccessObject<Site>{

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

	public Site getDataById(String siteId) {
		Session session = sessionFactory.getCurrentSession();
		Site site = session.load(Site.class, new String(siteId));
		return site;
	}

	public void removeData(String siteId) {
		Session session = sessionFactory.getCurrentSession();
		Site site = session.load(Site.class, new String(siteId));
		if (site != null){
			session.delete(site);
		}
	}

}