package com.atai.unter.module.order.service;

import java.util.List;

import com.atai.unter.module.order.model.SalesPart;
	
public interface SalesPartService{
	public void addSalesPart(SalesPart s);
	public void updateSalesPart(SalesPart s);
	public List<SalesPart> listSalesPart();
	public SalesPart getSalesPartById(String SalesPartNo);
	public void removeSalesPart(String SalesPartNo);
	}
