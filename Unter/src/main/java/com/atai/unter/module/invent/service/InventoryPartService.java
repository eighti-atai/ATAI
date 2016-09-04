package com.atai.unter.module.invent.service;

import java.util.List;

import com.atai.unter.module.invent.model.InventoryPart;

public interface InventoryPartService {
	
	public void addInventoryPart(InventoryPart invPart);
	public void updateInventoryPart(InventoryPart invPart);
	public List<InventoryPart> listInventoryParts();
	public InventoryPart getInventoryPartByNo(String invPartNo);
	public void removeInventoryPart(String invPartNo);

}
