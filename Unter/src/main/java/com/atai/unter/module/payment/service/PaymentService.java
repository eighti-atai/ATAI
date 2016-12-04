package com.atai.unter.module.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atai.unter.generic.service.AbstractService;
import com.atai.unter.module.payment.dao.PaymentDao;
import com.atai.unter.module.payment.model.Payment;

@Service
public class PaymentService extends AbstractService<Integer, Payment>{

	@Autowired
	public PaymentService(PaymentDao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}
	
}
