package com.atai.unter.module.invent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atai.unter.module.invent.model.InventoryLocation;
import com.atai.unter.module.invent.model.InventoryPartCost;
import com.atai.unter.module.invent.service.InventoryPartCostService;

@Controller
public class InventoryPartCostController {

	InventoryPartCostService invPartCostService;

	@Autowired
	public void setInvPartCostService(InventoryPartCostService invPartCostService) {
		this.invPartCostService = invPartCostService;
	}
	
	@RequestMapping(value = "/invPartCost", method=RequestMethod.GET)
	public String listSites(Model model)
	{
		model.addAttribute("invPartCost", new InventoryPartCost());
		model.addAttribute("listInventoryPartCosts", this.invPartCostService.listData());
		return "invPartCosts";
	}
	
	@RequestMapping(value = "/invPartCost/add")
	public String addInvPartCost(@ModelAttribute("invPartCost") InventoryPartCost invPartCost){
		this.invPartCostService.addData(invPartCost);
				
		return "redirect:/invPartCost";
	}
}
