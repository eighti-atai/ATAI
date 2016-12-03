package com.atai.unter.module.enterprise.controller;

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
import com.atai.unter.module.enterprise.model.Customer;
import com.atai.unter.module.enterprise.service.CustomerService;

@RestController
public class CustomerController extends AbstractController<String, Customer>{
	
	private final String initUrl = "/customers";
	private final String url = "/Customer";
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		super(customerService, String.class, "customers");
		// TODO Auto-generated constructor stub
	}

	@Override
	@GetMapping(value = initUrl)
	public ModelAndView init(Model model) {
		// TODO Auto-generated method stub
		return super.init(model);
	}

	@Override
	@GetMapping(value = url)
	public ResponseEntity<List<Customer>> list() {
		// TODO Auto-generated method stub
		return super.list();
	}

	@Override
	@PostMapping(value = url)
	public ResponseEntity<Void> add(@RequestBody Customer object) {
		// TODO Auto-generated method stub
		return super.add(object);
	}

	
	@Override
	@PutMapping(value = url)
	public ResponseEntity<Customer> modify(@RequestBody Customer newObject) {
		// TODO Auto-generated method stub
		return super.modify(newObject);
	}

	@Override
	@DeleteMapping(value = "/Customer/{objid:.+}")
	public ResponseEntity<Customer> delete(@PathVariable("objid") String objid) {
		// TODO Auto-generated method stub
		return super.delete(objid);
	}

	@Override
	@PostMapping(value = "/Customer/Search")
	public ResponseEntity<List<Customer>> search(@RequestBody Customer object) {
		// TODO Auto-generated method stub
		return super.search(object);
	}
}
