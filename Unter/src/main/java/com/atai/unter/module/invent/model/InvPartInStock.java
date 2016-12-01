package com.atai.unter.module.invent.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inv_part_in_stock_tab")
public class InvPartInStock implements Serializable{
	
	@EmbeddedId
	InvPartInStockKey id;
	
	@Column(name = "stock_qty")
	private int stockQuantity;
	
	private String objid;
		
	public String getObjid() {
		return objid;
	}
	public void setObjid(String objid) {
		this.objid = objid;
	}


	@ManyToOne//(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name = "site_id", referencedColumnName = "site_id", insertable = false, updatable = false),
		@JoinColumn(name = "inv_location_id", referencedColumnName = "inv_location_id", insertable = false, updatable = false)
	})
	private InventoryLocation invLocation;
	
	@ManyToOne//(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name = "site_id", referencedColumnName = "site_id", insertable = false, updatable = false),
		@JoinColumn(name = "inv_part_no", referencedColumnName = "inv_part_no", insertable = false, updatable = false),
		@JoinColumn(name = "inv_part_cost_no", referencedColumnName = "inv_part_cost_no", insertable = false, updatable = false)
	})
	private InventoryPartCost invPartCost;
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public InvPartInStockKey getId() {
		return id;
	}
	public void setId(InvPartInStockKey id) {
		this.id = id;
	}
	public void setId(String invPartNo, int invPartCostNo, String siteId, String invLocationId)
	{
		id.setInvPartNo(invPartNo);
		id.setInvPartCostNo(invPartCostNo);
		id.setSiteId(siteId);
		id.setInvLocationId(invLocationId);
	}
	public InventoryLocation getInvLocation() {
		return invLocation;
	}
	public void setInvLocation(InventoryLocation invLocation) {
		this.invLocation = invLocation;
	}
	public InventoryPartCost getInvPartCost() {
		return invPartCost;
	}
	public void setInvPartCost(InventoryPartCost invPartCost) {
		this.invPartCost = invPartCost;
	}


	@Embeddable
	public static class InvPartInStockKey implements Serializable
	{
		@Column(name = "inv_part_no")
		private String invPartNo;
		@Column(name = "inv_part_cost_no")
		private int invPartCostNo;
		@Column(name = "site_id")
		private String siteId;
		@Column(name = "inv_location_id")
		private String invLocationId;
		
		public InvPartInStockKey() {
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
		public String getSiteId() {
			return siteId;
		}
		public void setSiteId(String siteId) {
			this.siteId = siteId;
		}
		public String getInvLocationId() {
			return invLocationId;
		}
		public void setInvLocationId(String invLocationId) {
			this.invLocationId = invLocationId;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((invLocationId == null) ? 0 : invLocationId.hashCode());
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
			InvPartInStockKey other = (InvPartInStockKey) obj;
			if (invLocationId == null) {
				if (other.invLocationId != null)
					return false;
			} else if (!invLocationId.equals(other.invLocationId))
				return false;
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
}
