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
}
