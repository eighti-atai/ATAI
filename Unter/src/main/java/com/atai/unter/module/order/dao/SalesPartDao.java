package com.atai.unter.module.order.dao;

import java.util.List;

import com.atai.unter.module.order.model.SalesPart;

public interface SalesPartDao {
	public void addSalesPart(SalesPart p);
	public void updateSalesPart(SalesPart p);
	public List<SalesPart> listSalesPart();
	public SalesPart getSalesPartById(String SalesPartNo);
	public void removeSalesPart(String SalesPartNo);
}
