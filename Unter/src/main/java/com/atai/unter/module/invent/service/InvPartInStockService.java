package com.atai.unter.module.invent.service;

import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.generic.interfaces.Service;
import com.atai.unter.module.invent.model.InvPartInStock;

public interface InvPartInStockService extends Service<InvPartInStock>{

	@Transactional(readOnly = true)
	public InvPartInStock getInvPartInStockById(InvPartInStock.InvPartInStockKey invPartCostId);

	@Transactional
	public void removeInvPartInStock(InvPartInStock.InvPartInStockKey invPartCostId);
}
