package com.atai.unter.module.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atai.unter.generic.service.AbstractService;
import com.atai.unter.module.order.dao.CustomerOrderLineDao;
import com.atai.unter.module.order.model.CustomerOrderLine;
import com.atai.unter.module.order.model.CustomerOrderLineKey;

@Service
public class CustomerOrderLineService extends AbstractService<CustomerOrderLineKey, CustomerOrderLine> {

	@Autowired
	public CustomerOrderLineService(CustomerOrderLineDao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
