package com.atai.unter.module.invent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atai.unter.module.invent.model.InventoryLocation;
import com.atai.unter.module.invent.service.InventoryLocationService;

@Controller
public class InventoryLocationController {
	private InventoryLocationService invLocationService;

	@Autowired
	public void setInvLocationService(InventoryLocationService invLocationService) {
		this.invLocationService = invLocationService;
	}
	
	@RequestMapping(value = "/invlocations", method=RequestMethod.GET)
	public String listSites(Model model)
	{
		model.addAttribute("inventorylocation", new InventoryLocation());
		model.addAttribute("listSites", this.invLocationService.listData());
		return "inventorylocations";
	}
	
	@RequestMapping(value = "/invlocations/add")
	public String addPerson(@ModelAttribute("inventorylocation") InventoryLocation invLocation){
		this.invLocationService.addData(invLocation);
				
		return "redirect:/inventorylocations";
	}
}
