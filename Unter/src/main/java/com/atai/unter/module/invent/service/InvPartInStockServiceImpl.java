package com.atai.unter.module.invent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.invent.dao.InvPartInStockDao;
import com.atai.unter.module.invent.model.InvPartInStock;

@Service
public class InvPartInStockServiceImpl implements InvPartInStockService{
	
	InvPartInStockDao invPartInStockDao;

	@Autowired
	public void setInvPartInStock(InvPartInStockDao invPartInStockDao) {
		this.invPartInStockDao = invPartInStockDao;
	}

	@Transactional
	public void addData(InvPartInStock p) {
		p.setObjid(p.toString());
		invPartInStockDao.addData(p);
		
	}

	@Transactional
	public void updateData(InvPartInStock p) {
		invPartInStockDao.updateData(p);
		
	}

	@Transactional(readOnly = true)
	public List<InvPartInStock> listData() {
		return invPartInStockDao.listData();
	}

	@Transactional(readOnly = true)
	public InvPartInStock getInvPartInStockById(InvPartInStock.InvPartInStockKey invPartCostId) {
		return invPartInStockDao.getInvPartInStockById(invPartCostId);
	}

	@Transactional
	public void removeInvPartInStock(InvPartInStock.InvPartInStockKey invPartCostId) {
		invPartInStockDao.removeInvPartInStock(invPartCostId);
	}

	@Transactional(readOnly = true)
	public List<InvPartInStock> executeSelectQuery(InvPartInStock invPartInStock) {
		return invPartInStockDao.executeSelectQuery(invPartInStock);
	}

	@Transactional(readOnly = true)
	public InvPartInStock getByObjid(String objid) {
		return invPartInStockDao.getByObjid(objid);
	}
}
