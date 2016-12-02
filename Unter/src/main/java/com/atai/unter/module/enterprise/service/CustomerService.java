package com.atai.unter.module.enterprise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atai.unter.generic.service.AbstractService;
import com.atai.unter.module.enterprise.dao.CustomerDao;
import com.atai.unter.module.enterprise.model.Customer;

@Service
public class CustomerService extends AbstractService<String, Customer>{

	@Autowired
	public CustomerService(CustomerDao customerDao)
	{
		super(customerDao);
	}
}
