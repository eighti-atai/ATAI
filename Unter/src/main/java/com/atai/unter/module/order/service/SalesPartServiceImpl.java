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
		// TODO Auto-generated method stub
		
	}

	public List<SalesPart> listSalesPart() {
		// TODO Auto-generated method stub
		return null;
	}

	public SalesPart getSalesPartById(String SalesPartNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeSalesPart(String SalesPartNo) {
		// TODO Auto-generated method stub
		
	}

}
