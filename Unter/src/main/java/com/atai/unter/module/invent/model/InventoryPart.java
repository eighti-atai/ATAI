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
	
	private String objid;
	
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
	public String getObjid() {
		return objid;
	}
	public void setObjid(String objid) {
		this.objid = objid;
	}
}
