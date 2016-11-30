package com.atai.unter.module.invent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryPartKey implements Serializable {

	@Column(name = "site_id")
	private String siteId;

	@Column(name="inv_part_no")
	private String invPartNo;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getInvPartNo() {
		return invPartNo;
	}

	public void setInvPartNo(String invPartNo) {
		this.invPartNo = invPartNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invPartNo == null) ? 0 : invPartNo.hashCode());
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
		InventoryPartKey other = (InventoryPartKey) obj;
		if (invPartNo == null) {
			if (other.invPartNo != null)
				return false;
		} else if (!invPartNo.equals(other.invPartNo))
			return false;
		if (siteId == null) {
			if (other.siteId != null)
				return false;
		} else if (!siteId.equals(other.siteId))
			return false;
		return true;
	}
}
