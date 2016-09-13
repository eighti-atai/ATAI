package com.atai.unter.module.invent.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryPartCostKey implements Serializable {

	@Column(name = "inv_part_no")
	private String invPartNo;
	
	@Column(name = "inv_part_cost_no")
	private int invPartCostNo;
	
}
