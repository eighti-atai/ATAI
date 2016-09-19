package com.atai.unter.module.invent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_location_tab")
public class InventoryLocation {
	@Id
	private InventoryLocationKey id;
	
	@Column(name = "inv_location_type")
	private String invLocationType;

	@ManyToOne
	@JoinColumn(name = "site_id", referencedColumnName = "site_id", insertable = false, updatable = false)
	private Site site;

	public InventoryLocationKey getId() {
		return id;
	}

	public void setId(InventoryLocationKey id) {
		this.id = id;
	}

	public void setId(String siteId, String invLocationId)
	{
		this.id.setSiteId(siteId);
		this.id.setInvLocationId(invLocationId);
	}
	public String getInvLocationType() {
		return invLocationType;
	}

	public void setInvLocationType(String invLocationType) {
		this.invLocationType = invLocationType;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	
}
