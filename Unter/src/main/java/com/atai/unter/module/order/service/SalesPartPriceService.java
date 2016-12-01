package com.atai.unter.module.order.service;

import com.atai.unter.generic.interfaces.Service;
import com.atai.unter.module.order.model.SalesPartPrice;
import com.atai.unter.module.order.model.SalesPartPriceKey;

public interface SalesPartPriceService extends Service<SalesPartPrice>{
	public SalesPartPrice getSalesPartPriceById(SalesPartPriceKey id);
	public void removeSalesPartPrice(SalesPartPriceKey id);
}
