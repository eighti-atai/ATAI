package com.atai.unter.module.invent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.unter.module.invent.dao.InventoryLocationDao;
import com.atai.unter.module.invent.model.InventoryLocation;
import com.atai.unter.module.invent.model.InventoryLocationKey;

@Service
public class InventoryLocationServiceImpl implements InventoryLocationService{

	private InventoryLocationDao invLocationDao;
	
	@Autowired
	public void setInvLocationDao(InventoryLocationDao invLocationDao) {
		this.invLocationDao = invLocationDao;
	}

	@Transactional
	public void addData(InventoryLocation p) {
		p.setObjid(p.toString());
		invLocationDao.addData(p);
	}

	@Transactional
	public void updateData(InventoryLocation p) {
		invLocationDao.updateData(p);
	}

	@Transactional(readOnly = true)
	public List<InventoryLocation> listData() {
		return invLocationDao.listData();
	}

	@Transactional(readOnly = true)
	public InventoryLocation getInventoryLocationById(InventoryLocationKey invLocationId) {
		return invLocationDao.getInventoryLocationById(invLocationId);
	}

	@Transactional
	public void removeInventoryLocation(InventoryLocationKey invLocationId) {
		invLocationDao.removeInventoryLocation(invLocationId);
	}
	
	@Transactional(readOnly = true)
	public InventoryLocation getByObjid(String objid) {
		return invLocationDao.getByObjid(objid);
	}

	@Transactional(readOnly = true)
	public List<InventoryLocation> executeSelectQuery(InventoryLocation invLocation) {
		return invLocationDao.executeSelectQuery(invLocation);
	}

}
