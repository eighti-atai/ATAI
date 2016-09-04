package com.atai.unter.module.invent.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.invent.dao.InventoryPartDao;
import com.atai.unter.module.invent.model.InventoryPart;

@Service
public class InventoryPartServiceImpl implements InventoryPartService {

	private InventoryPartDao  invPartDao;
	
	public void setInvPartDao(InventoryPartDao invPartDao) {
		this.invPartDao = invPartDao;
	}

	@Transactional
	public void addInventoryPart(InventoryPart invPart) {
		this.invPartDao.addInventoryPart(invPart);
	}

	public void updateInventoryPart(InventoryPart invPart) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public List<InventoryPart> listInventoryParts() {
		return this.invPartDao.listInventoryParts();
	}

	public InventoryPart getInventoryPartByNo(String invPartNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeInventoryPart(String invPartNo) {
		// TODO Auto-generated method stub

	}

}
