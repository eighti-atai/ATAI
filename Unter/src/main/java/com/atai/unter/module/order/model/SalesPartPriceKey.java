package com.atai.unter.module.order.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.atai.unter.module.invent.model.InventoryPartCostKey;

@Embeddable
public class SalesPartPriceKey implements Serializable {

	@Column(name = "sales_part_id")
	private String salesPartId;
	
	@Column(name = "sales_part_price_no")
	private int salesPartPriceNo;
	
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

	public SalesPartPriceKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + salesPartPriceNo;
		result = prime * result + ((salesPartId == null) ? 0 : salesPartId.hashCode());
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
		SalesPartPriceKey other = (SalesPartPriceKey) obj;
		if (salesPartPriceNo != other.salesPartPriceNo)
			return false;
		if (salesPartId == null) {
			if (other.salesPartId != null)
				return false;
		} else if (!salesPartId.equals(other.salesPartId))
			return false;
		return true;
	}
}
