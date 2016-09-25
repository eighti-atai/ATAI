package com.atai.unter.module.order.service;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.order.model.SalesPartPrice;
import com.atai.unter.module.order.model.SalesPartPriceKey;

public interface SalesPartPriceService extends DataAcccessObject<SalesPartPrice>{
	public SalesPartPrice getSalesPartPriceById(SalesPartPriceKey salesPartPriceId);
	public void removeSalesPartPrice(SalesPartPriceKey salesPartPriceId);
}
