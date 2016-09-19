package com.atai.unter.module.invent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atai.unter.module.invent.model.InventoryLocation;
import com.atai.unter.module.invent.model.InventoryLocationKey;
import com.atai.unter.module.invent.model.Site;
import com.atai.unter.module.invent.service.InventoryLocationService;
import com.atai.unter.module.invent.service.SiteService;
import com.atai.unter.module.invent.service.SiteServiceImpl;

@Controller
public class InventoryLocationController {
	private InventoryLocationService invLocationService;

	@Autowired
	public void setInvLocationService(InventoryLocationService invLocationService) {
		this.invLocationService = invLocationService;
	}
	
	@GetMapping(value = "/invlocations")
	public String listSites(Model model)
	{
		model.addAttribute("inventorylocation", new InventoryLocation());
		model.addAttribute("listInventoryLocations", this.invLocationService.listData());
		return "inventorylocations";
	}
	

	@PostMapping(value = "/invlocations/add")
	public String addInventoryLocation(@ModelAttribute("inventorylocation") InventoryLocation invLocation, 
										@RequestParam("id.siteId") String siteId, @RequestParam("id.invLocationId") String invLocationId){
		invLocation.setId(siteId, invLocationId);
		this.invLocationService.addData(invLocation);
				
		return "redirect:/invlocations";
	}
}
