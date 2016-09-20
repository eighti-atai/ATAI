package com.atai.unter.module.invent.dao;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.invent.model.InvPartInStock;

public interface InvPartInStockDao extends DataAcccessObject<InvPartInStock>{

	public InvPartInStock getInvPartInStockById(InvPartInStock.InvPartInStockKey invPartCostId);

	public void removeInvPartInStock(InvPartInStock.InvPartInStockKey invPartCostId);
	
}
