package com.atai.unter.module.invent.service;

import java.util.List;

import com.atai.unter.generic.interfaces.Service;
import com.atai.unter.module.invent.model.InventoryPartCost;
import com.atai.unter.module.invent.model.InventoryPartCostKey;

public interface InventoryPartCostService extends Service<InventoryPartCost>{

	public InventoryPartCost getInventoryPartCostById(InventoryPartCostKey invPartCostId);

	public void removeInventoryPartCost(InventoryPartCostKey invPartCostId);
	
	public InventoryPartCost getInventoryPartCostByObjid(String objid);
	
	public List<InventoryPartCost> executeSelectQuery(InventoryPartCost inventoryPartCost);
}
