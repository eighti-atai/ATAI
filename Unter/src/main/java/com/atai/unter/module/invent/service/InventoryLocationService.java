package com.atai.unter.module.invent.service;

import java.util.List;

import com.atai.unter.generic.interfaces.Service;
import com.atai.unter.module.invent.model.InventoryLocation;
import com.atai.unter.module.invent.model.InventoryLocationKey;

public interface InventoryLocationService extends Service<InventoryLocation>{

	public InventoryLocation getInventoryLocationById(InventoryLocationKey invLocationId);
	public void removeInventoryLocation(InventoryLocationKey invLocationId);
	public InventoryLocation getInventoryLocationByObjid(String objid);
	public List<InventoryLocation> executeSelectQuery(InventoryLocation invLocation);
}
