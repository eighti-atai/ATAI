package com.atai.unter.module.invent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atai.unter.generic.service.AbstractService;
import com.atai.unter.module.invent.dao.UoMDao;
import com.atai.unter.module.invent.model.UoM;

@Service
public class UoMService extends AbstractService<String, UoM>{

	@Autowired
	public UoMService(UoMDao uoMDao){
		super(uoMDao);
	}
}
