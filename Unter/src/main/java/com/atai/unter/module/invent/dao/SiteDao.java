package com.atai.unter.module.invent.dao;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.invent.model.Site;

public interface SiteDao extends DataAcccessObject<Site> {

	public Site getSiteById(String siteId);

	public void removeSite(String siteId);
}
