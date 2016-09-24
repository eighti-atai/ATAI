package com.atai.unter.module.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales_part_tab")
public class SalesPart {

	@Id
	@Column(name = "sales_part_id")
	private String salesPartId;
	@Column(name = "description")
	private String description;
	@Column(name = "inv_part_id")
	private String invPartNo;
	@Column(name = "inv_conversion_factor")
	private String invConversionFactor;
	@Column(name = "uom")
	private String uom;
	@Column(name = "price_category")
	private String priceCategory;
	@Column(name = "general_category")
	private String generalCategory;
	
	public String getsalesPartId() {
		return this.salesPartId;
	}
	public void setsalesPartId(String salesPartId) {
		this.salesPartId = salesPartId;
	}
	public String getdescription() {
		return this.description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public String getInvPartNo() {
		return this.invPartNo;
	}
	public void setInvPartNo(String invPartNo) {
		this.invPartNo = invPartNo;
	}
	public String getInvConversionFactor() {
		return invConversionFactor;
	}
	public void setInvConversionFactor(String invConversionFactor) {
		this.invConversionFactor = invConversionFactor;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getPriceCategory() {
		return priceCategory;
	}
	public void setPriceCategory(String priceCategory) {
		this.priceCategory = priceCategory;
	}
	public String getGeneralCategory() {
		return generalCategory;
	}
	public void setGeneralCategory(String generalCategory) {
		this.generalCategory = generalCategory;
	}
	
}
