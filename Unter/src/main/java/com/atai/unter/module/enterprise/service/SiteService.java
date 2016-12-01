package com.atai.unter.module.enterprise.service;

import com.atai.unter.generic.interfaces.Service;
import com.atai.unter.module.enterprise.model.Site;

public interface SiteService extends Service<Site>{

	public Site getSiteById(String siteId);
	public void removeSite(String siteId);
}
