package com.atai.unter.module.order.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.atai.unter.generic.interfaces.Model;

@Entity
@Table(name = "customer_order_line_tab")
public class CustomerOrderLine implements Model<CustomerOrderLineKey>{

	@EmbeddedId
	private CustomerOrderLineKey id;
	@Column(name = "sales_qty")
	private int salesQty;
	@Column(name = "discount")
	private BigDecimal discount;
	@Column(name = "amount")
	private BigDecimal amount;
	@Column(name = "sales_part_id")
	private String salesPartId;
	@Column(name = "sales_part_price_no")
	private int salesPartPriceNo;
	@Column(name = "objid")
	private String objid;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_order_id", referencedColumnName = "customer_order_id", insertable = false, updatable = false)
	private CustomerOrder customerOrder;
	
	/*@OneToOne
	@JoinColumn(name = "sales_part_id", referencedColumnName = "sales_part_id", insertable = false, updatable = false)
	private SalesPart salesPart;
	
	@OneToOne
	@JoinColumns({
	@JoinColumn(name = "sales_part_id", referencedColumnName = "sales_part_id", insertable = false, updatable = false)})
	private SalesPartPrice salePartPrice;*/
	
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	public CustomerOrderLineKey getId() {
		return id;
	}
	public void setId(CustomerOrderLineKey id) {
		this.id = id;
	}
	public int getSalesQty() {
		return salesQty;
	}
	public void setSalesQty(int salesQty) {
		this.salesQty = salesQty;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getSalesPartId() {
		return salesPartId;
	}
	public void setSalesPartId(String salesPartId) {
		this.salesPartId = salesPartId;
	}
	public int getSalesPartPriceNo() {
		return salesPartPriceNo;
	}
	public void setSalesPartPriceNo(int salesPartPriceNo) {
		this.salesPartPriceNo = salesPartPriceNo;
	}
	public String getObjid() {
		return objid;
	}
	public void setObjid(String objid) {
		this.objid = objid;
	}
//	public CustomerOrder getCustomerOrder() {
//		return customerOrder;
//	}
//	public void setCustomerOrder(CustomerOrder customerOrder) {
//		this.customerOrder = customerOrder;
//	}
	/*public SalesPart getSalesPart() {
		return salesPart;
	}
	public void setSalesPart(SalesPart salesPart) {
		this.salesPart = salesPart;
	}
	public SalesPartPrice getSalePartPrice() {
		return salePartPrice;
	}
	public void setSalePartPrice(SalesPartPrice salePartPrice) {
		this.salePartPrice = salePartPrice;
	}*/

}
