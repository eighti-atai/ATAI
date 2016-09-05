package com.atai.unter.module.enterprise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atai.unter.module.enterprise.service.AddressService;
import com.atai.unter.module.invent.model.InventoryPart;

@Controller
public class AddressController {
		
	private AddressService addressService;

	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@RequestMapping(value="/addresses", method=RequestMethod.GET)
	public String listPersons(Model model)
	{
		model.addAttribute("address", new InventoryPart());
		model.addAttribute("listaddresses", this.addressService.listAddresses());
		return "addresses";
	}
}
