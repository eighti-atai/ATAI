package com.atai.unter.module.invent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.atai.unter.module.enterprise.model.Site;

@Entity
@Table(name="inventory_part_tab")
public class InventoryPart {
	
	@Id
	private InventoryPartKey id;
	
	private String description;
	
	private String uom;

	@ManyToOne
	@JoinColumn(name = "site_id", referencedColumnName = "site_id", insertable = false, updatable = false)
	private Site site;
	
	private String objid;
	
	@Column(name="reorder_level")
	private double reorderLevel;
	
	@Column(name="safety_stock_level")
	private double safetyStockLevel;
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
	private InventoryPartKey getId() {
		return id;
	}
	private void setId(InventoryPartKey id) {
		this.id = id;
	}

	public void setId(String siteId, String invPartNo)
	{
		this.id.setSiteId(siteId);
		this.id.setInvPartNo(invPartNo);
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
}
