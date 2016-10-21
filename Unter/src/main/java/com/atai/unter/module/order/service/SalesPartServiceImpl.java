package com.atai.unter.module.order.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.order.dao.SalesPartDao;
import com.atai.unter.module.order.model.SalesPart;

@Service
public class SalesPartServiceImpl implements SalesPartService {

	private SalesPartDao salesPartDao;
	public void setSalesPartDao(SalesPartDao salesPartDao) {
		this.salesPartDao = salesPartDao;
	}
	@Transactional
	public void addSalesPart(SalesPart s) {
		s.setObjid(s.toString());
		salesPartDao.addSalesPart(s);
	}

	@Transactional
	public void updateSalesPart(SalesPart s) {
		salesPartDao.updateSalesPart(s);
		
	}

	@Transactional(readOnly = true)
	public List<SalesPart> listSalesPart() {
		return salesPartDao.listSalesPart();
	}

	@Transactional(readOnly = true)
	public SalesPart getSalesPartById(String salesPartId) {
		return salesPartDao.getSalesPartById(salesPartId);
	}

	@Transactional
	public void removeSalesPart(String salesPartId) {
		salesPartDao.removeSalesPart(salesPartId);
	}
	
	@Transactional(readOnly = true)
	public SalesPart getSalesPartByObjid(String objid) {
		System.out.println("@@@@@@@@@@@@@ 01");
		return salesPartDao.getSalesPartByObjid(objid);
	}

}
