package com.atai.unter.module.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atai.unter.module.order.dao.SalesPartPriceDao;
import com.atai.unter.module.order.model.SalesPartPrice;
import com.atai.unter.module.order.model.SalesPartPriceKey;

@Service
public class SalesPartPriceServiceImpl implements SalesPartPriceService{

	private SalesPartPriceDao salesPartPriceDao;
	
	@Autowired
	public void setSalesPartPriceDao(SalesPartPriceDao salesPartPriceDao) {
		this.salesPartPriceDao = salesPartPriceDao;
	}

	@Transactional
	public void addData(SalesPartPrice p) {
		p.setObjid(p.toString());
		salesPartPriceDao.addData(p);
	}

	@Transactional
	public void updateData(SalesPartPrice p) {
		salesPartPriceDao.updateData(p);
	}

	@Transactional(readOnly = true)
	public List<SalesPartPrice> listData() {
		return salesPartPriceDao.listData();
	}

	@Transactional(readOnly = true)
	public SalesPartPrice getSalesPartPriceById(SalesPartPriceKey id) {
		return salesPartPriceDao.getSalesPartPrice(id);
	}

	@Transactional
	public void removeSalesPartPrice(SalesPartPriceKey id) {
		salesPartPriceDao.removeSalesPartPrice(id);
	}

}
