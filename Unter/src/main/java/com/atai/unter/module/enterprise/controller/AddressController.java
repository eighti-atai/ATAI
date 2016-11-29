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

import com.atai.unter.module.enterprise.model.Address;
import com.atai.unter.module.enterprise.service.AddressService;

@RestController
public class AddressController {
		
	private AddressService addressService;

	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping(value = "/addresses")
	public ModelAndView listAddress(Model model)
	{
		return new ModelAndView("addresses");
	}
	

	@GetMapping(value = "/Address")
	public ResponseEntity<List<Address>> listAddresses()
	{
		List<Address> locations = this.addressService.listAddresses();
		return new ResponseEntity<List<Address>>(locations, HttpStatus.OK);
	}
	
	@PostMapping(value = "/Address")
	public ResponseEntity<Void> addAddress(@RequestBody Address address){
	
		System.out.println("Address object will be added");
		this.addressService.addService(address);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/Address")
	ResponseEntity<Address> modifyAddress(@RequestBody Address newAddress)
	{
		Address oldAddress = addressService.getAddressByObjid(newAddress.getObjid());
		newAddress.setAddressId(oldAddress.getAddressId());
		addressService.updateAddress(newAddress);
		return new ResponseEntity<Address>(newAddress, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/Address/{objid:.+}")
	public ResponseEntity<Address> deleteAddress(@PathVariable("objid") String objid) {
        System.out.println("Fetching & Deleting Address with id " + objid);
  
        Address address = addressService.getAddressByObjid(objid);
        if (address == null) {
            System.out.println("Unable to delete. Sales Part with id " + objid + " not found");
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
  
        addressService.removeAddress(address.getAddressId());
        return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
    }
	
	@PostMapping(value = "/Address/Search")
	ResponseEntity<List<Address>> searchAddress(@RequestBody Address address)
	{
		List<Address> invLocations = this.addressService.executeSelectQuery(address);
		return new ResponseEntity<List<Address>>(invLocations, HttpStatus.OK);
	}
}
