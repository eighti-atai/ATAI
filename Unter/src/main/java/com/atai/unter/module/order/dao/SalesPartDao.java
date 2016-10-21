package com.atai.unter.module.order.dao;

import java.util.List;
import com.atai.unter.module.order.model.SalesPart;

public interface SalesPartDao {
	public void addSalesPart(SalesPart salesPart);
	public void updateSalesPart(SalesPart salesPart);
	public List<SalesPart> listSalesPart();
	public SalesPart getSalesPartById(String salesPartId);
	public SalesPart getSalesPartByObjid(String objid);
	public void removeSalesPart(String salesPartId);
}
