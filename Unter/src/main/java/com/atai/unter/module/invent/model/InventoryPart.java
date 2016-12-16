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
	
	private String uomId;
	
	private String objid;

	@ManyToOne
	@JoinColumn(name = "site_id", referencedColumnName = "site_id", insertable = false, updatable = false)
	private Site site;

	@ManyToOne
	@JoinColumn(name="uom_id", referencedColumnName="uom_id", insertable=false, updatable=false)
	private UoM uoM;
	
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
	public String getUomId() {
		return uomId;
	}
	public void setUomId(String uom) {
		this.uomId = uom;
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
	public InventoryPartKey getId() {
		return id;
	}
	public void setId(InventoryPartKey id) {
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
	public UoM getUoM() {
		return uoM;
	}
	public void setUoM(UoM uoM) {
		this.uoM = uoM;
	}
}
