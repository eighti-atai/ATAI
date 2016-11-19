package com.atai.unter.module.enterprise.service;

import java.util.List;

import com.atai.unter.module.enterprise.model.Site;
import com.atai.unter.module.order.model.SalesPart;

public interface SiteService {

	public void addSite(Site site);
	public void updateSite(Site site);
	public List<Site> listSites();
	public Site getSiteById(String siteId);
	public void removeSite(String siteId);
	public Site getSiteByObjid(String objid);
}
