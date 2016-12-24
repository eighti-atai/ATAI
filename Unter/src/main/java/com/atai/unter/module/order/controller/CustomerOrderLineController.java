package com.atai.unter.module.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.generic.controller.AbstractController;
import com.atai.unter.module.order.model.CustomerOrderLine;
import com.atai.unter.module.order.model.CustomerOrderLineKey;
import com.atai.unter.module.order.service.CustomerOrderLineService;
@RestController
public class CustomerOrderLineController extends AbstractController<CustomerOrderLineKey, CustomerOrderLine> {

	private final String initUrl = "/CustomerOrderLines";
	private final String url = "/CustomerOrderLine";
	
	@Autowired
	public CustomerOrderLineController(CustomerOrderLineService service) {
		super(service, CustomerOrderLineKey.class, "CustomerOrderLines");
	}

	@Override
	@GetMapping(value = initUrl)
	public ModelAndView init(Model model) {
		// TODO Auto-generated method stub
		return super.init(model);
	}

	@Override
	@GetMapping(value = url)
	public ResponseEntity<List<CustomerOrderLine>> list() {
		// TODO Auto-generated method stub
		return super.list();
	}

	@Override
	@PostMapping(value = url)
	public ResponseEntity<Void> add(@RequestBody CustomerOrderLine object) {
		// TODO Auto-generated method stub
		object.getCustomerOrder().setObjid(object.getCustomerOrder().toString());
		object.getCustomerOrder().setUserId(1);
		return super.add(object);
	}

	@Override
	@PutMapping(value = url)
	public ResponseEntity<CustomerOrderLine> modify(@RequestBody CustomerOrderLine newObject) {
		// TODO Auto-generated method stub
		return super.modify(newObject);
	}

	@Override
	@DeleteMapping(value = "/CustomerOrderLine/{objid:.+}")
	public ResponseEntity<CustomerOrderLine> delete(@PathVariable("objid") String objid) {
		// TODO Auto-generated method stub
		return super.delete(objid);
	}

	@Override
	@PostMapping(value = "/CustomerOrderLine/Search")
	public ResponseEntity<List<CustomerOrderLine>> search(@RequestBody CustomerOrderLine object) {
		// TODO Auto-generated method stub
		return super.search(object);
	}

	
}
