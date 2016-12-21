package com.atai.unter.module.order.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerOrderLineKey implements Serializable {

	@Column(name = "customer_order_id")
	private String customerOrderId;
	@Column(name = "co_line_no")
	private int coLineNo;
	public String getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public int getCoLineNo() {
		return coLineNo;
	}
	public void setCoLineNo(int coLineNo) {
		this.coLineNo = coLineNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coLineNo;
		result = prime * result + ((customerOrderId == null) ? 0 : customerOrderId.hashCode());
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
		CustomerOrderLineKey other = (CustomerOrderLineKey) obj;
		if (coLineNo != other.coLineNo)
			return false;
		if (customerOrderId == null) {
			if (other.customerOrderId != null)
				return false;
		} else if (!customerOrderId.equals(other.customerOrderId))
			return false;
		return true;
	}
	
	
}
