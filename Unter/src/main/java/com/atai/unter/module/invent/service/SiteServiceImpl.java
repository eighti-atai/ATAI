package com.atai.unter.module.invent.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.invent.dao.SiteDao;
import com.atai.unter.module.invent.model.Site;

@Service
public class SiteServiceImpl implements SiteService{
	private SiteDao siteDao;

	@Transactional
	public void addSite(Site site) {
		
		siteDao.addData(site);
	}

	@Transactional
	public void updateSite(Site site) {
		siteDao.updateData(site);
		
	}

	@Transactional(readOnly = true)
	public List<Site> listSites() {
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

	
}
