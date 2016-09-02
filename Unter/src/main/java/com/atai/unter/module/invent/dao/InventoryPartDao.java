package com.atai.unter.module.invent.dao;

import java.util.List;
import com.atai.unter.module.invent.model.*;

public interface InventoryPartDao {
	public void addInventoryPart(InventoryPart invPart);
	public void updateInventoryPart(InventoryPart invPart);
	public List<InventoryPart> listInventoryParts();
	public InventoryPart getInventoryPartByNo(String sPartNo);
	public void removeInventoryPart(String sPartNo);
}
