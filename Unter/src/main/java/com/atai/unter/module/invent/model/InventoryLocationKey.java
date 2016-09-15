package com.atai.unter.module.invent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryLocationKey implements Serializable {
	@Column(name = "site_id")
	private String siteId;
	@Column(name = "inv_location_id")
	private String invLocationId;
	
	public String getSiteId() {
		return siteId;
	}
	public String getInvLocationId() {
		return invLocationId;
	}
}
