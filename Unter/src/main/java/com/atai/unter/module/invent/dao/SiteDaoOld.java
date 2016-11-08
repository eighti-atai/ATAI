package com.atai.unter.module.invent.dao;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.invent.model.SiteOld;

public interface SiteDaoOld extends DataAcccessObject<SiteOld> {

	public SiteOld getSiteById(String siteId);

	public void removeSite(String siteId);
}
