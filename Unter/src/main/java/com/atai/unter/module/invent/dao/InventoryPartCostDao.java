package com.atai.unter.module.invent.dao;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.invent.model.InventoryPartCost;
import com.atai.unter.module.invent.model.InventoryPartCostKey;

public interface InventoryPartCostDao extends DataAcccessObject<InventoryPartCost>{

	public InventoryPartCost getInventoryPartCostById(InventoryPartCostKey invPartCostId);

	public void removeInventoryPartCost(InventoryPartCostKey invPartCostId);
}
