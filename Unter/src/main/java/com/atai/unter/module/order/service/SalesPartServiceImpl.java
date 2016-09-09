package com.atai.unter.module.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atai.unter.module.order.dao.SalesPartDao;
import com.atai.unter.module.order.model.SalesPart;

@Service
public class SalesPartServiceImpl implements SalesPartService {

	private SalesPartDao salesPartDao;
	public void setSalesPartDao(SalesPartDao salesPartDao) {
		this.salesPartDao = salesPartDao;
	}

	public void addSalesPart(SalesPart s) {
		salesPartDao.addSalesPart(s);
		
	}

	public void updateSalesPart(SalesPart s) {
		salesPartDao.updateSalesPart(s);
		
	}

	public List<SalesPart> listSalesPart() {
		return salesPartDao.listSalesPart();
	}

	public SalesPart getSalesPartById(String SalesPartNo) {
		return salesPartDao.getSalesPartById(SalesPartNo);
	}

	public void removeSalesPart(String SalesPartNo) {
		salesPartDao.removeSalesPart(SalesPartNo);
	}

}
