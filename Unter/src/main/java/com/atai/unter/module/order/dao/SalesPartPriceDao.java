package com.atai.unter.module.order.dao;

import com.atai.unter.generic.interfaces.DataAcccessObject;
import com.atai.unter.module.order.model.SalesPartPrice;
import com.atai.unter.module.order.model.SalesPartPriceKey;

public interface SalesPartPriceDao extends DataAcccessObject<SalesPartPrice>{
	
	public SalesPartPrice getSalesPartPrice(SalesPartPriceKey id);

	public void removeSalesPartPrice(SalesPartPriceKey id);

}
