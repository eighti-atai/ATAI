package com.atai.unter.module.invent.dao;

import java.util.List;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.invent.model.InventoryPartCost;
import com.atai.unter.module.invent.model.InventoryPartCostKey;

public interface InventoryPartCostDao extends DataAcccessObject<InventoryPartCost>{

	public InventoryPartCost getInventoryPartCostById(InventoryPartCostKey invPartCostId);

	public void removeInventoryPartCost(InventoryPartCostKey invPartCostId);
	
	public InventoryPartCost getInventoryPartCostByObjid(String objid);
	
	public List<InventoryPartCost> executeSelectQuery(InventoryPartCost inventoryPartCost);
}
