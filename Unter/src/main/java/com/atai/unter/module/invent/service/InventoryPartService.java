package com.atai.unter.module.invent.service;

import java.util.List;

import com.atai.unter.generic.interfaces.Service;
import com.atai.unter.module.invent.model.InventoryPart;
import com.atai.unter.module.invent.model.InventoryPartKey;

public interface InventoryPartService extends Service<InventoryPart>{
	
	public InventoryPart getInventoryPartByNo(String invPartNo);
	public void removeInventoryPart(InventoryPartKey invPartId);
}
