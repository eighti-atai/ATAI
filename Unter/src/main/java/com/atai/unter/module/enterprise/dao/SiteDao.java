package com.atai.unter.module.enterprise.dao;

import java.util.List;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.enterprise.model.Site;

public interface SiteDao extends DataAcccessObject<Site> {

	public Site getSiteById(String siteId);

	public void removeSite(String siteId);
	
}
