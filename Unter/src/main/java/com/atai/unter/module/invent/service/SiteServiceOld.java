package com.atai.unter.module.invent.service;

import java.util.List;

import com.atai.unter.module.invent.model.SiteOld;

public interface SiteServiceOld {

	public void addSite(SiteOld site);
	public void updateSite(SiteOld site);
	public List<SiteOld> listSites();
	public SiteOld getSiteById(String siteId);
	public void removeSite(String siteId);
}
