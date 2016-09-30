package com.atai.unter.module.order.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.atai.unter.module.invent.model.InventoryPartCostKey;

@Entity
@Table(name = "sales_part_price_tab")
public class SalesPartPrice {

	@EmbeddedId
	private SalesPartPriceKey id ;
		
	@Column( name = "inv_part_id")
	String invPartId;
	
	@Column(name = "inv_part_cost_no")
	String invPartCostNo;
	
	private String objid;
	
	@ManyToOne
	@JoinColumn(name = "sales_part_id" , updatable = false, insertable = false)
	SalesPart salesPart;

	public SalesPartPriceKey getId() {
		return id;
	}

	public void setId(SalesPartPriceKey id) {
		this.id = id;
	}

	public String getInvPartId() {
		return invPartId;
	}

	public void setInvPartId(String invPartId) {
		this.invPartId = invPartId;
	}

	public String getInvPartCostNo() {
		return invPartCostNo;
	}

	public void setInvPartCostNo(String invPartCostNo) {
		this.invPartCostNo = invPartCostNo;
	}

	public SalesPart getSalesPart() {
		return salesPart;
	}

	public void setSalesPart(SalesPart salesPart) {
		this.salesPart = salesPart;
	}
	
	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}
}
