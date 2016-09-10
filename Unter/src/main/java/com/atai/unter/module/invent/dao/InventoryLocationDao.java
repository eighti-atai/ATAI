package com.atai.unter.module.invent.dao;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.invent.model.InventoryLocation;
import com.atai.unter.module.invent.model.InventoryLocationKey;

public interface InventoryLocationDao extends DataAcccessObject<InventoryLocation>{

	public InventoryLocation getSiteById(InventoryLocationKey invLocationId);

	public void removeInventoryLocation(InventoryLocationKey invLocationId);
}
