package com.atai.unter.module.invent.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.invent.dao.SiteDaoOld;
import com.atai.unter.module.invent.model.SiteOld;


public class SiteServiceImplOld implements SiteServiceOld{
	private SiteDaoOld siteDao;
	
	

	public void setSiteDao(SiteDaoOld siteDao) {
		this.siteDao = siteDao;
	}

	@Transactional
	public void addSite(SiteOld site) {
		site.setObjid(site.toString());
		siteDao.addData(site);
	}

	@Transactional
	public void updateSite(SiteOld site) {
		siteDao.updateData(site);
		
	}

	@Transactional(readOnly = true)
	public List<SiteOld> listSites() {
		return siteDao.listData();
	}

	@Transactional(readOnly = true)
	public SiteOld getSiteById(String siteId) {
		return siteDao.getSiteById(siteId);
	}

	@Transactional
	public void removeSite(String siteId) {
		siteDao.removeSite(siteId);
		
	}

	
}
