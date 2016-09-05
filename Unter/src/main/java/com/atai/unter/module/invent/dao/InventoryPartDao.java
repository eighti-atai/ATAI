package com.atai.unter.module.invent.dao;

import java.util.List;
import com.atai.unter.module.invent.model.InventoryPart;

public interface InventoryPartDao {
	public void addInventoryPart(InventoryPart invPart);
	public void updateInventoryPart(InventoryPart invPart);
	public List<InventoryPart> listInventoryParts();
	public InventoryPart getInventoryPartByNo(String invPartNo);
	public void removeInventoryPart(String invPartNo);
}
