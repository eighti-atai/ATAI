package com.atai.unter.module.invent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.invent.dao.InventoryPartCostDao;
import com.atai.unter.module.invent.model.InventoryPartCost;
import com.atai.unter.module.invent.model.InventoryPartCostKey;

@Service
public class InventoryPartCostServiceImpl implements InventoryPartCostService{

	InventoryPartCostDao inventoryPartCostDao;

	@Autowired
	public void setInventoryPartCostDao(InventoryPartCostDao inventoryPartCostDao) {
		this.inventoryPartCostDao = inventoryPartCostDao;
	}

	@Transactional
	public void addData(InventoryPartCost p) {
		inventoryPartCostDao.addData(p);
		
	}

	@Transactional
	public void updateData(InventoryPartCost p) {
		inventoryPartCostDao.updateData(p);
	}

	@Transactional(readOnly = true)
	public List<InventoryPartCost> listData() {
		return inventoryPartCostDao.listData();
	}

	@Transactional(readOnly = true)
	public InventoryPartCost getInventoryPartCostById(InventoryPartCostKey invPartCostId) {
		return inventoryPartCostDao.getInventoryPartCostById(invPartCostId);
	}

	@Transactional
	public void removeInventoryPartCost(InventoryPartCostKey invPartCostId) {
		inventoryPartCostDao.removeInventoryPartCost(invPartCostId);
	}
	
	
}
