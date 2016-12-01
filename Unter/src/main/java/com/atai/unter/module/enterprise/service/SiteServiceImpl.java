package com.atai.unter.module.enterprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.enterprise.dao.SiteDao;
import com.atai.unter.module.enterprise.model.Site;
import com.atai.unter.module.order.model.SalesPart;

@Service
public class SiteServiceImpl implements SiteService{
	private SiteDao siteDao;
	
	
	@Autowired
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	@Transactional
	public void addData(Site site) {
		site.setObjid(site.toString());
		siteDao.addData(site);
	}

	@Transactional
	public void updateData(Site site) {
		siteDao.updateData(site);
		
	}

	@Transactional(readOnly = true)
	public List<Site> listData() {
		return siteDao.listData();
	}

	@Transactional(readOnly = true)
	public Site getSiteById(String siteId) {
		return siteDao.getSiteById(siteId);
	}

	@Transactional
	public void removeSite(String siteId) {
		siteDao.removeSite(siteId);
		
	}

	@Transactional(readOnly = true)
	public Site getByObjid(String objid) {
		return siteDao.getByObjid(objid);
	}

	@Transactional(readOnly = true)
	public List<Site> executeSelectQuery(Site site) {
		return siteDao.executeSelectQuery(site);
	}
	
}
