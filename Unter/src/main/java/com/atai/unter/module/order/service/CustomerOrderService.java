package com.atai.unter.module.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atai.unter.generic.service.AbstractService;
import com.atai.unter.module.order.dao.CustomerOrderDao;
import com.atai.unter.module.order.model.CustomerOrder;

@Service
public class CustomerOrderService extends AbstractService<String, CustomerOrder>{

	@Autowired
	public CustomerOrderService(CustomerOrderDao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

}
