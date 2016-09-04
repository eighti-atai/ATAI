package com.atai.unter.module.order.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class SalesPart {

	@Id
	@Column(name = "sales_part_no")
	private String SalesPartNo;
	@Column(name = "discription")
	private String Discription;
	@Column(name = "inv_part_no")
	private String InvPartNo;
	
	public String getSalesPartNo() {
		return SalesPartNo;
	}
	public void setSalesPartNo(String salesPartNo) {
		SalesPartNo = salesPartNo;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
	public String getInvPartNo() {
		return InvPartNo;
	}
	public void setInvPartNo(String invPartNo) {
		InvPartNo = invPartNo;
	}
	
}
