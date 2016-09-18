package com.atai.unter.module.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales_part_tab")
public class SalesPart {

	@Id
	@Column(name = "sales_part_no")
	//@GeneratedValue(strategy=)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String salesPartNo;
	@Column(name = "description")
	private String discription;
	@Column(name = "inv_part_no")
	private String invPartNo;
	
	public String getSalesPartNo() {
		return this.salesPartNo;
	}
	public void setSalesPartNo(String salesPartNo) {
		this.salesPartNo = salesPartNo;
	}
	public String getDiscription() {
		return this.discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getInvPartNo() {
		return this.invPartNo;
	}
	public void setInvPartNo(String invPartNo) {
		this.invPartNo = invPartNo;
	}
	
}
