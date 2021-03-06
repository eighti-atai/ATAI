package com.atai.unter.module.invent.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class InventoryPartCostKey implements Serializable {

	@Column(name = "site_id")
	private String siteId;
	
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@Column(name  ="inv_part_no")
	private String invPartNo;
	
	@Column(name = "inv_part_cost_no")
	private int invPartCostNo;

	public InventoryPartCostKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getInvPartNo() {
		return invPartNo;
	}

	public void setInvPartNo(String invPartNo) {
		this.invPartNo = invPartNo;
	}

	public int getInvPartCostNo() {
		return invPartCostNo;
	}

	public void setInvPartCostNo(int invPartCostNo) {
		this.invPartCostNo = invPartCostNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + invPartCostNo;
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
		InventoryPartCostKey other = (InventoryPartCostKey) obj;
		if (invPartCostNo != other.invPartCostNo)
			return false;
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
