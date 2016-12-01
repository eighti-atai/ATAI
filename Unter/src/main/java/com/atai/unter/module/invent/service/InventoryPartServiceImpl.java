package com.atai.unter.module.invent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.invent.dao.InventoryPartDao;
import com.atai.unter.module.invent.model.InventoryPart;
import com.atai.unter.module.invent.model.InventoryPartKey;

@Service
public class InventoryPartServiceImpl implements InventoryPartService {

	@Autowired
	private InventoryPartDao  invPartDao;
	
	/*public void setInvPartDao(InventoryPartDao invPartDao) {
		this.invPartDao = invPartDao;
	}*/

	@Transactional
	public void addData(InventoryPart invPart) {
		invPart.setObjid(invPart.toString());
		this.invPartDao.addData(invPart);
	}

	@Transactional
	public void updateData(InventoryPart invPart) {
		invPartDao.updateData(invPart);
	}

	@Transactional
	public List<InventoryPart> listData() {
		return this.invPartDao.listData();
	}

	@Transactional
	public InventoryPart getInventoryPartByNo(String invPartNo) {
		//return this.invPartDao.getInventoryPartByNo(invPartNo);
		//return new InventoryPart();
		return null;
	}

	public void removeInventoryPart(InventoryPartKey invPartId) {
		invPartDao.remove(invPartId);
	}
	
	@Transactional(readOnly = true)
	public List<InventoryPart> executeSelectQuery(InventoryPart inventoryPart) {
		return invPartDao.executeSelectQuery(inventoryPart);
	}

	@Transactional(readOnly = true)
	public InventoryPart getByObjid(String objid) {
		return invPartDao.getByObjid(objid);
	}
}
