package com.atai.unter.module.invent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory_part_tab")
public class InventoryPart {
	
	@Id
	@Column(name="inv_part_no")
	private String invPartNo;
	
	private String description;
	
	private String uom;
	
	@Column(name="reorder_level")
	private double reorderLevel;
	
	@Column(name="safety_stock_level")
	private double safetyStockLevel;
	
	public String getInvPartNo() {
		return this.invPartNo;
	}
	public void setInvPartNo(String invPartNo) {
		this.invPartNo = invPartNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public double getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(double reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public double getSafetyStockLevel() {
		return safetyStockLevel;
	}
	public void setSafetyStockLevel(double safetyStockLevel) {
		this.safetyStockLevel = safetyStockLevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((invPartNo == null) ? 0 : invPartNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reorderLevel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(safetyStockLevel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
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
		InventoryPart other = (InventoryPart) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (invPartNo == null) {
			if (other.invPartNo != null)
				return false;
		} else if (!invPartNo.equals(other.invPartNo))
			return false;
		if (Double.doubleToLongBits(reorderLevel) != Double.doubleToLongBits(other.reorderLevel))
			return false;
		if (Double.doubleToLongBits(safetyStockLevel) != Double.doubleToLongBits(other.safetyStockLevel))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		return true;
	}
	
	
}
