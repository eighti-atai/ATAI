package com.atai.unter.module.invent.dao;

import java.util.List;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.invent.model.InventoryPart;
import com.atai.unter.module.invent.model.InventoryPartKey;

public interface InventoryPartDao extends DataAcccessObject<InventoryPart>{

	public InventoryPart getInventoryPartById(InventoryPartKey invPartId);
	public void remove(InventoryPartKey invPartId);
}
