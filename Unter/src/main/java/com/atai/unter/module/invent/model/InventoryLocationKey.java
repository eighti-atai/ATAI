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
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public void setInvLocationId(String invLocationId) {
		this.invLocationId = invLocationId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invLocationId == null) ? 0 : invLocationId.hashCode());
		result = prime * result + ((siteId == null) ? 0 : siteId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryLocationKey other = (InventoryLocationKey) obj;
		if (invLocationId == null) {
			if (other.invLocationId != null)
				return false;
		} else if (!invLocationId.equals(other.invLocationId))
			return false;
		if (siteId == null) {
			if (other.siteId != null)
				return false;
		} else if (!siteId.equals(other.siteId))
			return false;
		return true;
	}
	
	
}
