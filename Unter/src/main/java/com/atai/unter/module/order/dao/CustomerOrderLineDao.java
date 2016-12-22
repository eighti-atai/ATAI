package com.atai.unter.module.order.dao;

import org.springframework.stereotype.Repository;

import com.atai.unter.generic.dao.AbstractDao;
import com.atai.unter.module.order.model.CustomerOrderLine;
import com.atai.unter.module.order.model.CustomerOrderLineKey;

@Repository
public class CustomerOrderLineDao extends AbstractDao<CustomerOrderLineKey, CustomerOrderLine> {

}
