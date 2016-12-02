package com.atai.unter.module.enterprise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.atai.unter.module.enterprise.model.Customer;
import com.atai.unter.module.enterprise.service.CustomerService;

@RestController
public class CustomerController {
	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping(value = "/customers")
	public ModelAndView listLocation(Model model)
	{
		return new ModelAndView("customers");
	}
	
	@GetMapping(value = "/Customer")
	public ResponseEntity<List<Customer>> listCustomers()
	{
		List<Customer> customers = this.customerService.list();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@PostMapping(value = "/Customer")
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer){
	
		System.out.println("Customer object will be added");
		this.customerService.persist(customer);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/Customer")
	ResponseEntity<Customer> modifyCustomer(@RequestBody Customer newCustomer)
	{
		Customer oldCustomer = customerService.getByObjid(newCustomer.getObjid());
		newCustomer.setCustomerId(oldCustomer.getCustomerId());
		customerService.update(newCustomer);
		return new ResponseEntity<Customer>(newCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/Customer/{objid:.+}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("objid") String objid) {
        System.out.println("Fetching & Deleting Customer with id " + objid);
  
        Customer customer = customerService.getByObjid(objid);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + objid + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
  
        customerService.delete(customer.getCustomerId());
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
	
	@PostMapping(value = "/Customer/Search")
	ResponseEntity<List<Customer>> searchCustomer(@RequestBody Customer customer)
	{
		List<Customer> customers = this.customerService.executeSelectQuery(customer);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
}
